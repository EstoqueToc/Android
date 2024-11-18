package com.example.estoquetoc

import com.example.wetinmob.domain.service.VagaService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Rest {

    private val client by lazy{
        OkHttpClient
            .Builder()
            .addInterceptor(logginInterceptor())
            .build()
    }

    val api by lazy {
        Retrofit
            .Builder()
            .client(client)
            .baseUrl(
                BuildConfig.API_BASE_URL
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun logginInterceptor() : HttpLoggingInterceptor {

        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

}