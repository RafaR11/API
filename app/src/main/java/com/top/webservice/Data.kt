package com.top.webservice

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("id")
    val id: String?,
    @SerializedName("nombre")
    val nombre:String,

    )