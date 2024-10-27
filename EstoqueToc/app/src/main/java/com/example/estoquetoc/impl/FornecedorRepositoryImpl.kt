package com.example.estoquetoc.impl

import com.example.estoquetoc.repositoy.FornecedorRepository
import com.example.estoquetoc.service.EmpresaTemFornecedorRequest
import com.example.estoquetoc.service.EmpresaTemFornecedorResponse
import com.example.estoquetoc.service.FornecedorRequest
import com.example.estoquetoc.service.FornecedorResponse
import com.example.estoquetoc.service.FornecedorService
import com.example.estoquetoc.service.Logradouro
import retrofit2.Response

class FornecedorRepositoryImpl(
    private val service: FornecedorService
): FornecedorRepository {
    override suspend fun cadastrarFornecedor(
        nome: String,
        email: String,
        senha: String,
        cnpj: String,
        telefone: String,
        ativo: Int,
        Logradouro: Logradouro
    ): Response<FornecedorResponse> {
        return service.cadastrarFornecedores(FornecedorRequest(nome, email, senha, cnpj, telefone, ativo, Logradouro))
    }

    override suspend fun cadastrarEmpresaTemFornecedor(
        idEmpresa: Long,
        idFornecedor: Long
    ): Response<EmpresaTemFornecedorResponse> {
        return service.cadastrarEmpresaTemFornecedor(EmpresaTemFornecedorRequest(idEmpresa, idFornecedor))
    }
}