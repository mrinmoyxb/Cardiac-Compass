package com.example.heartdiseasedetetectionapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.heartdiseasedetetectionapp.Model.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HeartDiseaseViewModel: ViewModel() {

    var age = MutableStateFlow<Int>(0)
    var _age: StateFlow<Int> = age

    var sex = MutableStateFlow<Int>(-1)
    var _sex: StateFlow<Int> = sex

    var cp = MutableStateFlow<Int>(-1) // done
    var _cp: StateFlow<Int> = cp

    var trestbps = MutableStateFlow<Int>(0) // done
    var _trestbps: StateFlow<Int> = trestbps

    var chol = MutableStateFlow<Int>(0) // done
    var _chol: StateFlow<Int> = chol

    var fbsValue = MutableStateFlow<Int>(-1) //done
    var _fbsValue: StateFlow<Int> = fbsValue

    var restecg = MutableStateFlow<Int>(-1) // done
    var _restecg: StateFlow<Int> = restecg

    var thalach = MutableStateFlow<Int>(0) // done
    var _thalach: StateFlow<Int> = thalach

    var exang = MutableStateFlow<Int>(-1) // done
    var _exang: StateFlow<Int> = exang

    var oldpeak = MutableStateFlow<Float>(0.0f) // done
    var _oldpeak: StateFlow<Float> = oldpeak

    var slope = MutableStateFlow<Int>(-1) // done
    var _slope: StateFlow<Int> = slope

    var ca = MutableStateFlow<Int>(0) // done
    var _ca: StateFlow<Int> = ca

    var thal = MutableStateFlow<Int>(-1) // done
    var _thal: StateFlow<Int> = thal

    var responseValue = MutableStateFlow<String>("")
    var _responseValue: StateFlow<String> = responseValue

    var serverCode = MutableStateFlow<String>("")
    var _servercode: StateFlow<String> = serverCode

    fun postResponse(age: Int, sex: Int, cp: Int, trestbps: Int, chol: Int, fbs: Int,
                     restecg: Int, thalach: Int, exang: Int, oldpeak: Float, slope: Int,
                     ca: Int, thal: Int) {
        viewModelScope.launch {
            val response = RetrofitInstance.apiInterface
                .predictDisease(age, sex, cp, trestbps, chol, fbs, restecg, thalach, exang, oldpeak, slope, ca, thal)

            if (response.isSuccessful) {
                responseValue.value = response.body()?.targetValue ?: "No data"
            } else {
                serverCode.value = response.code().toString()
            }
        }
    }

}