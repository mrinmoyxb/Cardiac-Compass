package com.example.heartdiseasedetetectionapp.Model

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {
//    @GET("predict")
//    suspend fun getTarget(): Call<ResponseDataClass>
    @POST("predict")
    fun predict(@Body dataModel: RequestDataClass): Call<ResponseDataClass>

}