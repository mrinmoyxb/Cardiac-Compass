package com.example.heartdiseasedetetectionapp.Model

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("predict")
    suspend fun getTarget(): Call<ResponseDataClass>


}