//package com.example.heartdiseasedetetectionapp.TestModel
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.sp
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.example.heartdiseasedetetectionapp.Model.RetrofitInstance
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//
//class MyViewModels() : ViewModel() {
//    var responseData = MutableStateFlow("Response")
//    var _responseData: StateFlow<String> = responseData
//
//    val serverCode = MutableStateFlow("Code")
//    var _serverCode: StateFlow<String> = serverCode
//
//    var errorData = MutableStateFlow("error")
//    var _errorData: StateFlow<String> = errorData
//
//    fun postResponse(age: Int, sex: Int, cp: Int, trestbps: Int, chol: Int, fbs: Int,
//                     restecg: Int, thalach: Int, exang: Int, oldpeak: Float, slope: Int,
//                     ca: Int, thal: Int) {
//        viewModelScope.launch {
//            val response = RetrofitInstances.apiInterface
//                .predictDisease(age, sex, cp, trestbps, chol, fbs, restecg, thalach, exang, oldpeak, slope, ca, thal)
//
//            if (response.isSuccessful) {
//               responseData.value = response.body()?.targetValue ?: "No data"
//                serverCode.value = response.code().toString()
//            } else {
//                errorData.value = response.errorBody()?.toString()?:"Unknown error"
//                serverCode.value = response.code().toString()
//            }
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun MyComposable() {
//    val viewModel: MyViewModels = viewModel()
//    val response by viewModel.responseData.collectAsState()
//    val error by viewModel.errorData.collectAsState()
//    val server by viewModel.serverCode.collectAsState()
//
//    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally) {
//        Button(onClick = { viewModel.postResponse(64, 0, 2, 140, 313,
//            0, 1, 133, 0, 0.2f, 2, 0, 3) }) {
//            Text("Post Response")
//        }
//
//        Text(text = response, fontSize = 32.sp, color = Color.Black)
//        Text(text = error, fontSize = 32.sp, color = Color.Black)
//        Text(text = server, fontSize = 32.sp, color = Color.Black)
//    }
//}
