package com.example.heartdiseasedetetectionapp.Model

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MyViewModel: ViewModel() {
    var result = MutableStateFlow("XXX")

    fun RetrofitFunc(i: Int, i1: Int, i2: Int, i3: Int, i4: Int,
        i5: Int, i6: Int, i7: Int, i8: Int, fl: Float, i9: Int, i10: Int,
        i11: Int
    ) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://heart-416313.el.r.appspot.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ApiInterface::class.java)

        viewModelScope.launch {
            val parameters = RequestDataClass(52, 1, 3, 152, 298, 1, 1, 178, 0, 1.2f, 1, 0, 3)
            val response = service.detectHeartCondition(parameters)
            if (response.isExecuted) {
                val r = response
                result.value = r.toString()
            } else {
                result.value = "Error"
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DemoDisplayFunc() {
    val context = LocalContext.current
    val viewModel = MyViewModel()
    val result by viewModel.result.collectAsState("XXX")
    Column(modifier = Modifier.fillMaxSize()) {
        Text(result, fontSize = 32.sp, color = Color.Black)
        Button(onClick = {
            viewModel.RetrofitFunc(52, 1, 3, 152, 298, 1, 1, 178, 0, 1.2f, 1, 0, 3)
            Toast.makeText(context, "button clicked", Toast.LENGTH_SHORT).show()
        }) {
            Text("Click here")
        }

    }
}