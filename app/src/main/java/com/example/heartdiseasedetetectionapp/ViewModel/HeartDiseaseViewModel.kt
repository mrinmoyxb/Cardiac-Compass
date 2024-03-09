package com.example.heartdiseasedetetectionapp.ViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HeartDiseaseViewModel: ViewModel() {

    var age = MutableStateFlow<Int>(-1)
    var _age: StateFlow<Int> = age

    var sex = MutableStateFlow<Int>(-1)
    var _sex: StateFlow<Int> = sex

    var cp = MutableStateFlow<Int>(-1)
    var _cp: StateFlow<Int> = cp

    var trestbps = MutableStateFlow<Int>(0)
    var _trestbps: StateFlow<Int> = trestbps

    var chol = MutableStateFlow<Int>(0)
    var _chol: StateFlow<Int> = chol

    var fbsValue = MutableStateFlow<Int>(-1)
    var _fbsValue: StateFlow<Int> = fbsValue

    var restecg = MutableStateFlow<Int>(0)
    var _restecg: StateFlow<Int> = restecg

    var thalach = MutableStateFlow<Int>(0)
    var _thalach: StateFlow<Int> = thalach

    var exang = MutableStateFlow<Int>(-1)
    var _exang: StateFlow<Int> = exang

    var oldpeak = MutableStateFlow<Float>(0.0f)
    var _oldpeak: StateFlow<Float> = oldpeak

    var slope = MutableStateFlow<Int>(0)
    var _slope: StateFlow<Int> = slope

    var ca = MutableStateFlow<Int>(0)
    var _ca: StateFlow<Int> = ca

    var thal = MutableStateFlow<Int>(0)
    var _thal: StateFlow<Int> = thal


}