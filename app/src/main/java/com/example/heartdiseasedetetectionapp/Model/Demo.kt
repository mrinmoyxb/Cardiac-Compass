package com.example.heartdiseasedetetectionapp.Model

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory






//val values = RequestDataClass(52, 1, 3, 152, 298, 1, 1, 178, 0, 1.2f, 1, 0, 3)
//val response = GlobalScope.launch {
//    try {
//        val result = service.detectHeartCondition(values)
//        // Handle the successful response with result.value
//    } catch (e: Exception) {
//        // Handle any exceptions that occur during the request
//    }
//}



class CalculationViewModel(private val service: ApiInterface) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    sealed class UiState {
        object Loading : UiState()
        object Error : UiState()
        data class Success(val result: String) : UiState()
    }

    //val values = RequestDataClass(52, 1, 3, 152, 298, 1, 1, 178, 0, 1.2f, 1, 0, 3)

    fun calculate(age: Int, sex: Int, cp: Int, trestbps: Int, chol: Int, fbs: Int, restecg: Int, thalach: Int, exang: Int, oldpeak: Float, slope: Int, ca: Int, thal: Int) {
        val values = RequestDataClass(age, sex, cp, trestbps, chol, fbs, restecg, thalach, exang, oldpeak, slope, ca, thal)
        //val values = RequestDataClass(52, 1, 3, 152, 298, 1, 1, 178, 0, 1.2f, 1, 0, 3)
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val result = service.detectHeartCondition(values)
                _uiState.value = UiState.Success(result.toString())
            } catch (e: Exception) {
                _uiState.value = UiState.Error
            }
        }
    }
}


@Composable
fun CalculationScreen(viewModel: CalculationViewModel) {
    val uiState = viewModel.uiState.collectAsState()

    var number1 by remember { mutableStateOf(0) }
    var number2 by remember { mutableStateOf(0) }

    Column {
        Button(onClick = { viewModel.calculate(52, 1, 3, 152, 298, 1, 1, 178, 0, 1.2f, 1, 0, 3) }) {
            Text("Calculate")
        }

        when (val state = uiState.value) {
            CalculationViewModel.UiState.Loading -> {
                CircularProgressIndicator()
            }
            CalculationViewModel.UiState.Error -> {
                Text("An error occurred", color = Color.Black, fontSize = 32.sp)
            }
            is CalculationViewModel.UiState.Success -> {
                Text("Result: ${state.result}", color = Color.Black, fontSize = 32.sp)
            }

            else -> {""}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Display(){
    val retrofit = Retrofit.Builder()
        .baseUrl("https://heart-416313.el.r.appspot.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
    val service = retrofit.create(ApiInterface::class.java)
    val viewModel = CalculationViewModel(service)
    CalculationScreen(viewModel)
}

}