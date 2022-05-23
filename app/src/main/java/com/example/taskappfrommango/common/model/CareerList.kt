package com.example.taskappfrommango.common.model

import com.google.gson.annotations.SerializedName

data class CareerList(
    @SerializedName("id") val id: Int,
    @SerializedName("careerDetail") val careerDetail: CareerDetails,
    @SerializedName("topCollegeList") val topCollegeList: List<TopColleges>,
    @SerializedName("topExamsList") val topExamsList: List<TopColleges>,
    @SerializedName("title") val title: String,
    @SerializedName("careerImage") val careerImage: String,
    @SerializedName("videoUrl") val videoUrl: String? = null,
    @SerializedName("timestamp") val timestamp: String,
    @SerializedName("utimestamp") val utimestamp: String,
    @SerializedName("track") val track: String,
    @SerializedName("utrack") val utrack: String,
    @SerializedName("status") val status: String,
    @SerializedName("career") val career: Int,
)

data class CareerDetails(
    @SerializedName("title") val title: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("careerImage") val careerImage: String,
    @SerializedName("image_url") val image_url: String,
    @SerializedName("image_url2") val image_url2: String,
)

data class TopColleges(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("image") val image: String? = null,
)