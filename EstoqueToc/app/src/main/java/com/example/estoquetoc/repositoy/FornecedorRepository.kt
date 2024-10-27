package com.example.estoquetoc.repositoy

import com.example.estoquetoc.service.EmpresaTemFornecedorResponse
import com.example.estoquetoc.service.FornecedorResponse
import com.example.estoquetoc.service.Logradouro
import retrofit2.Response

interface FornecedorRepository {
    suspend fun cadastrarFornecedor(
        nome: String,
        email: String,
        senha: String,
        cnpj: String,
        telefone: String,
        ativo: Int,
        Logradouro: Logradouro
    ): Response<FornecedorResponse>

    suspend fun cadastrarEmpresaTemFornecedor(
        idEmpresa: Long,
        idFornecedor: Long
    ): Response<EmpresaTemFornecedorResponse>
}