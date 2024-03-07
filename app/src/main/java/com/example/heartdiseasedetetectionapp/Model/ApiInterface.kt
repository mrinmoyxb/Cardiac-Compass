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
//    @GET("predict")
//    suspend fun getTarget(): Call<ResponseDataClass>
//    @POST("predict")
//    fun predict(
//        @Field("age") age: Int,
//        @Field("sex") sex: Int,
//        @Field("cp") cp: Int,
//        @Field("trestbps") trestbps: Int,
//        @Field("chol") chol: Int,
//        @Field("fbs") fbs: Int,
//        @Field("restecg") restecg: Int,
//        @Field("thalach") thalach: Int,
//        @Field("exang") exang: Int,
//        @Field("oldpeak") oldpeak: Float,
//        @Field("slope") slope: Int,
//        @Field("ca") ca: Int,
//        @Field("thal") thal: Int
//    ): Call<ResponseDataClass>


}