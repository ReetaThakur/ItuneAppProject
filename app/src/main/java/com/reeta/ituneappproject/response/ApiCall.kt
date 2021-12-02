package com.reeta.ituneappproject.response

import retrofit2.http.GET
import retrofit2.http.Query


interface ApiCall {

    @GET("search")
    suspend  fun getInstance(@Query("term") term:String,
    @Query("entity") entity:String):ResponseDTO


}