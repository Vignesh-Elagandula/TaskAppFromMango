package com.example.taskappfrommango.common.model

import com.example.taskappfrommango.common.constants.Constants
import com.google.gson.annotations.SerializedName

data class RequestBody(
    @SerializedName("tokenKey") val tokenKey: String = Constants.TOKEN_KEY
)