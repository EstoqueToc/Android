package com.example.estoquetoc.service

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("usuarios/login")
    suspend fun fazerLogin(
        @Body loginRequest : LoginRequest
    )
            : Response<LoginResponse>
}

data class LoginRequest (
    val email : String,
    val senha : String
)

data class LoginResponse (
    val token : String,
    val userId: Long,
    val nome: String,
    val email: String,
    val empresa: Empresa,
    val tipo: String,
    val acesso: Int
)

data class Empresa (
    val id: Long,
    val nomeEmpresa: String,
    val razaoSocial: String,
    val cnpj: String
)