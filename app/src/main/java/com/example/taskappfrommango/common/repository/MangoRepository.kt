package com.example.taskappfrommango.common.repository

import com.example.taskappfrommango.common.api.ApiClient
import com.example.taskappfrommango.common.api.ApiInterface
import com.example.taskappfrommango.common.model.RequestBody
import javax.inject.Inject


class MangoRepository @Inject constructor(private val api: ApiClient): BaseRepo() {

    suspend fun getListOfCountries(map: RequestBody) = makeRequest(
        networkCall = { api.getSpinnerList(map) }
    )

    suspend fun getListOfCareer(map: RequestBody) = makeRequest(
        networkCall = { api.getCareerList(map) }
    )

}