package com.example.taskappfrommango.common.repository

import android.content.ContentValues
import android.util.Log
import com.example.taskappfrommango.common.api.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

open class BaseRepo {

    protected suspend fun <T> makeRequest(
        networkCall: suspend () -> Resource<T>
    ) = flow<Resource<T>> {
        emit(Resource.loading())
        val response = networkCall.invoke()
        when (response.status) {
            Resource.Status.SUCCESS -> {
                if (response.data != null)
                    emit(Resource.success(response.data))
                else
                    emit(Resource.error("Something Went Wrong"))
            }
            Resource.Status.ERROR -> {
                Log.d(ContentValues.TAG, "makeRequest: Error ${response.message}")
                emit(Resource.error("Something Went Wrong"))
            }
            else -> {}
        }
    }.flowOn(Dispatchers.IO)

}