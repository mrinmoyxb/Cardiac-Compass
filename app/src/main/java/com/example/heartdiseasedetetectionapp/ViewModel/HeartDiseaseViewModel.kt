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

    var sex = MutableStateFlow<Int>(-1) // done
    var _sex: StateFlow<Int> = sex

    var cp = MutableStateFlow<Int>(-1) // done
    var _cp: StateFlow<Int> = cp

    var trestbps = MutableStateFlow<Int>(0) // done
    var _trestbps: StateFlow<Int> = trestbps

    var chol = MutableStateFlow<Int>(0) // done
    var _chol: StateFlow<Int> = chol

    var fbs = MutableStateFlow<Int>(-1) //done
    var _fbs: StateFlow<Int> = fbs

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

    // result
    var responseValue = MutableStateFlow<String>("Generating Result")
    var _responseValue: StateFlow<String> = responseValue

    var serverCode = MutableStateFlow<String>("Waiting for server response")
    var _servercode: StateFlow<String> = serverCode

    fun postResponse() {
        viewModelScope.launch {
            val response = RetrofitInstance.apiInterface
                .predictDisease(age.value, sex.value, cp.value, trestbps.value, chol.value, fbs.value, restecg.value, thalach.value, exang.value, oldpeak.value, slope.value, ca.value, thal.value)

            if (response.isSuccessful) {
                responseValue.value = response.body()?.targetValue ?: "No data"
                serverCode.value = response.code().toString()
            } else {
                serverCode.value = response.code().toString()
            }
        }
    }

    fun resetButton(){
        age.value = 0
        sex.value = -1
        cp.value = -1
        trestbps.value = 0
        chol.value = 0
        fbs.value = -1
        restecg.value = -1
        thalach.value = 0
        exang.value = -1
        oldpeak.value = 0.0f
        slope.value = -1
        ca.value = 0
        thal.value = -1
        responseValue.value = "Generating Result"
        serverCode.value = "Waiting for server response"
    }

}