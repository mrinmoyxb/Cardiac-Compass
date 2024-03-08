package com.example.heartdiseasedetetectionapp.Model

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {
    @POST("predict")
    suspend fun detectHeartCondition(@Body request: RequestDataClass): Call<ResponseDataClass>

}