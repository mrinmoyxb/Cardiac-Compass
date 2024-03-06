package com.example.heartdiseasedetetectionapp.Model

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://heart-416313.el.r.appspot.com/"

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiInterface by lazy{
        retrofit.create(ApiInterface::class.java)
    }
}

class MainViewModel: ViewModel(){

}

fun getData(): MutableState<String> {

    var prediction: MutableState<String> = mutableStateOf("")

    val userPost = RequestDataClass(0,0,0,0,0,0,0, 0,0,0.0f,0, 0,0)
    val call = RetrofitInstance.apiInterface.predict(userPost)

    call.enqueue(object : Callback<ResponseDataClass?> {
        override fun onResponse(
            call: Call<ResponseDataClass?>,
            response: Response<ResponseDataClass?>
        ) {
            if (response.isSuccessful) {
                prediction.value = response.body()?.target.toString()
            } else {
                prediction.value = "Not available"
            }
        }

        override fun onFailure(call: Call<ResponseDataClass?>, t: Throwable) {
            TODO("Not yet implemented")
        }
    })
    return prediction
}

@Preview(showBackground = true)
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Demo(){
    var response  = remember{mutableStateOf("Testing")}

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(response.value, fontSize = 90.sp, color = Color.Black, fontWeight = FontWeight.Bold)
        Button(onClick = { response = getData() }) {
            Text("Click Here")
        }
    }
}

