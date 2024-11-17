package com.example.estoquetoc

import android.content.Context
import com.example.estoquetoc.service.FornecedorService
import com.example.estoquetoc.service.FuncionarioService
import com.example.estoquetoc.service.LoginService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Rest {

    val baseUrl = "http://10.0.2.2/api/"

    private val api by lazy {
        Retrofit.Builder()
            .client(cliente)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun createApiService(token: String): Retrofit {
        return Retrofit.Builder()
            .client(createClientWithToken(token))
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val service by lazy {
        api.create(LoginService::class.java)
    }

    val serviceFuncionario by lazy {
        api.create(FuncionarioService::class.java)
    }

    val serviceFornecedor by lazy {
        api.create(FornecedorService::class.java)
    }

    private val cliente by lazy {
        OkHttpClient.Builder()
            .addInterceptor(ApiInteceptor())
            .build()
    }

    fun createClientWithToken(token: String): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(ApiInterceptor(token))
            .build()
    }


    fun logginInteceptor() : HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    class ApiInteceptor: Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val oldRequest = chain.request()
            val newRequest = Request.Builder()
                .url(oldRequest.url)
                .method(oldRequest.method, oldRequest.body)
                .build()
            return chain.proceed(newRequest)
        }
    }

    class ApiInterceptor(private val token: String) : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest = chain.request()
            val newRequest = originalRequest.newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .build()
            return chain.proceed(newRequest)
        }
    }
}