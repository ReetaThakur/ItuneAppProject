package com.reeta.ituneappproject.response

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {

    val BASE_URL=" https://itunes.apple.com"
    fun getRetrofit()= Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun getApiService() = getRetrofit().create(ApiCall::class.java)
}