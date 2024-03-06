package com.example.heartdiseasedetetectionapp.Model

data class RequestDataClass(
    val age: Int,
    val sex: Int,
    val cp: Int,
    val trestbps: Int,
    val chol: Int,
    val fbs: Int,
    val restecg: Int,
    val thalach: Int,
    val exang: Int,
    val oldpeak: Float,
    val slope: Int,
    val ca: Int,
    val thal: Int
)
