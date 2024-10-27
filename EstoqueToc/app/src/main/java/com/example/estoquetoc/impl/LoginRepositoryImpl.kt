package com.example.estoquetoc.impl

import com.example.estoquetoc.repositoy.LoginRepository
import com.example.estoquetoc.service.LoginRequest
import com.example.estoquetoc.service.LoginResponse
import com.example.estoquetoc.service.LoginService
import retrofit2.Response

class LoginRepositoryImpl(
    private val service: LoginService
): LoginRepository {

    override suspend fun obterCredentials(
        email: String,
        senha: String
    ): Response<LoginResponse>{
        return service.fazerLogin(LoginRequest(email, senha))
    }
}