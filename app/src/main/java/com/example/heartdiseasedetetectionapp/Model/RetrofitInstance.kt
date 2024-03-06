package com.example.heartdiseasedetetectionapp.Model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    const val BASE_URL = "https://heart-416313.el.r.appspot.com/"

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiInterface by lazy{
        retrofit.create(ApiInterface::class.java)
    }
}