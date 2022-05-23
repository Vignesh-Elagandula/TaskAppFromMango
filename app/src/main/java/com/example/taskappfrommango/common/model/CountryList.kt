package com.example.taskappfrommango.common.model

import com.google.gson.annotations.SerializedName

data class CountryList(
    @SerializedName("name") val name: String,
    @SerializedName("exam") val exam: Boolean,
    @SerializedName("college") val college: Boolean,
)
