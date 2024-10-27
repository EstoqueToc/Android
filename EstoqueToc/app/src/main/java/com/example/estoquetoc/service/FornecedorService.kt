package com.example.estoquetoc.service

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface FornecedorService {

    @POST("fornecedores")
    suspend fun cadastrarFornecedores(
        @Body fornecedorRequest : FornecedorRequest
    )
            : Response<FornecedorResponse>

    @POST("empresaTemFornecedor")
    suspend fun cadastrarEmpresaTemFornecedor(
        @Body empresaTemFornecedorRequest : EmpresaTemFornecedorRequest
    )
            : Response<EmpresaTemFornecedorResponse>
}

data class FornecedorRequest (
    val nomeFantasia : String,
    val razaoSocial : String,
    val telefone : String,
    val email : String,
    val cnpj : String,
    val ativo : Int,
    val logradouro : Logradouro
)

data class Logradouro (
    val ruaLogradouro : String,
    val numeroLogradouro : String,
    val cidadeLogradouro : String,
    val cepLogradouro : String,
    val id: Long = 1
)

data class FornecedorResponse (
    val id : Long,
    val nomeFantasia : String,
    val razaoSocial : String,
    val telefone : String,
    val email : String,
    val cnpj : String,
    val ativo : Int,
    val logradouro : Logradouro
)

data class EmpresaTemFornecedorRequest (
    val idEmpresa : Long = 2,
    val idFornecedor : Long
)

data class EmpresaTemFornecedorResponse (
    val idEmpresa : Long,
    val idFornecedor : Long
)

