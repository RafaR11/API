package com.top.webservice

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import java.nio.file.attribute.PosixFileAttributeView

interface ApiService {
    @Headers("Content-type: application/json")
    @GET("heroes")
    fun find(): Call<MutableList<Data>>
    @POST("heroes")
    fun post(@Body addhero: Data): Call<Data>

}