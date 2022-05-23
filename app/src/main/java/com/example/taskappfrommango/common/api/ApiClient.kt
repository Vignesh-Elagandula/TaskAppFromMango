package com.example.taskappfrommango.common.api

import com.example.taskappfrommango.common.model.RequestBody

class ApiClient(private val apiServices: ApiInterface) : BaseClient() {

    suspend fun getSpinnerList(map: RequestBody) = getResult {
        apiServices.getListOfCountries(map)
    }

    suspend fun getCareerList(map: RequestBody) = getResult {
        apiServices.getListOfCareer(map)
    }

}