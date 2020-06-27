package com.app.newstestapp.api

import com.app.newstestapp.model.News
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET(TOP_HEADLINES)
    fun requestTopHeadlines(
        @Query(PARAM_API_KEY) apiKey: String,
        @Query(PARAM_COUNTRY) country: String
    ): Single<News>

    @GET(EVERYTHING)
    fun requestTopNewsContent(
        @Query(PARAM_API_KEY) apiKey: String,
        @Query(PARAM_SEARCH) searchKey: String
    ): Single<News>
}