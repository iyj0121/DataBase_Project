package com.example.planner.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    var networkService: RetrofitService
    val URL = "http://192.168.0.101:8080/"
    private val client: OkHttpClient
    init {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY}
        client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
//            .addInterceptor(HeaderInterceptor())
            .connectTimeout(30, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }
//
//    class HeaderInterceptor : Interceptor {
//        override fun intercept(chain: Interceptor.Chain): Response = chain.run {
//            proceed(
//                request()
//                    .newBuilder()
//                    .build()
//            )
//        }
//    }

    val retrofit: Retrofit
        get() = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    init {
        networkService = retrofit.create(RetrofitService::class.java)
    }
}