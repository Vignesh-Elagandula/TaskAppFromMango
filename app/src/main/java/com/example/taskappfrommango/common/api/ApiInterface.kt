package com.example.taskappfrommango.common.api

import com.example.taskappfrommango.common.model.CareerList
import com.example.taskappfrommango.common.model.CountryList
import com.example.taskappfrommango.common.model.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {

    @POST("student/study-abroad-country-list-mobile/")
    suspend fun getListOfCountries(
        @Body body: RequestBody
    ) : Response<List<CountryList>>

    @POST("portal/trending-career/")
    suspend fun getListOfCareer(
        @Body body: RequestBody
    ) : Response<List<CareerList>>

}