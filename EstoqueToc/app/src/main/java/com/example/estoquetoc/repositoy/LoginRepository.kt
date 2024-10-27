package com.example.estoquetoc.repositoy

import com.example.estoquetoc.service.LoginResponse
import retrofit2.Response

interface LoginRepository {
    suspend fun obterCredentials(
        email: String,
        senha: String
    ): Response<LoginResponse>
}