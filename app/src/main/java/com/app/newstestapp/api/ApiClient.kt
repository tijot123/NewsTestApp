package com.app.newstestapp.api

import com.app.newstestapp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    private val httpClient by lazy {
        if (BuildConfig.DEBUG)
            loggingInterceptor.level =
                HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder().addInterceptor(
            loggingInterceptor
        )
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
    }
    private val client by lazy {
        httpClient.build()
    }

    private val loggingInterceptor: HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor()
    }

    private val retrofitInstance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
    }

    val apiInterface: ApiInterface by lazy {
        retrofitInstance.create(ApiInterface::class.java)
    }
}