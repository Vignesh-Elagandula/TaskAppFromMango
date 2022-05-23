package com.example.taskappfrommango.common.api

import com.example.taskappfrommango.BuildConfig
import retrofit2.Response

open class BaseClient {
    protected suspend fun <T> getResult(request: suspend () -> Response<T>) : Resource<T> {
        try {
            val response = request()
            return if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    Resource.success(body)
                } else {
                    Resource.error("Server response error")
                }
            }else {
                Resource.error("${response.code()} ${response.message()}")
            }
        } catch (e: Exception) {
            val errorMessage = e.message ?: e.toString()
            return if (BuildConfig.DEBUG) {
                Resource.error("Network call failed with message $errorMessage")
            } else {
                Resource.error("Check your internet connection!")
            }
        }
    }
}