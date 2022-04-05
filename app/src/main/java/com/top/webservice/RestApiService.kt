package com.top.webservice

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiService {
    fun addUser(userData: Data, onResult: (Data?) -> Unit){
        val retrofit = ServiceGenerator.buildService(ApiService::class.java)
        retrofit.post(userData).enqueue(
            object : Callback<Data> {
                override fun onFailure(call: Call<Data>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<Data>, response: Response<Data>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }
}