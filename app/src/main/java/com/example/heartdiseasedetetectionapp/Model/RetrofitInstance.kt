package com.example.heartdiseasedetetectionapp.Model

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
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
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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

//    class MyViewModel : ViewModel() {
//
//        private val apiService = RetrofitInstance.apiInterface
//        private val resultLiveData = MutableStateFlow("1")
//        val _resultLiveData: StateFlow<String> = resultLiveData
//
//
//        fun detectHeartCondition(age: Int, sex: Int, cp: Int, trestbps: Int,
//                                         chol: Int, fbs: Int, restecg: Int, thalach: Int,
//                                         exang: Int, oldpeak: Float, slope: Int, ca: Int, thal: Int) {
//
//
//                val request = RequestDataClass(age, sex, cp, trestbps, chol, fbs,
//                    restecg, thalach, exang, oldpeak, slope, ca, thal)
//
//                val response = apiService.detectHeartCondition(request)
//                return if (response.isSuccessful) {
//                    resultLiveData.value = response.body()?.target.toString()
//                } else {
//                    resultLiveData.value = ""
//                }
//            }
//
//
//}
//@Preview(showBackground = true)
//@Composable
//fun Demo(){
//    val viewModel = viewModel<MyViewModel>()
//    var response by remember { mutableStateOf("1") }
//
//    LaunchedEffect(viewModel._resultLiveData) {
//        launch {
//            viewModel._resultLiveData.collect { newValue ->
//                response = newValue
//            }
//        }
//    }
//
//    Column(modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally){
//        Text(response, fontSize = 90.sp, color = Color.Black, fontWeight = FontWeight.Bold)
//        Button(onClick = { viewModel.detectHeartCondition(0, 0, 0, 0,0, 0, 0, 0, 0, 0.0f, 0, 0, 0)}) {
//            Text("Click Here")
//        }
//    }
//}

