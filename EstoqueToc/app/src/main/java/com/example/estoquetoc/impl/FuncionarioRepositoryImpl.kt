package com.example.estoquetoc.impl

import com.example.estoquetoc.repositoy.FuncionarioRepository
import com.example.estoquetoc.service.EmpresaUsuario
import com.example.estoquetoc.service.FuncionarioRequest
import com.example.estoquetoc.service.FuncionarioResponse
import com.example.estoquetoc.service.FuncionarioService
import retrofit2.Response

class FuncionarioRepositoryImpl(
    private val service: FuncionarioService
): FuncionarioRepository {
    override suspend fun cadastrarFuncionario(
        nome: String,
        cpf: String,
        email: String,
        senha: String,
        dataNascimento: String,
        funcao: String,
        ativo: Int,
        acesso: Int,
        empresa: EmpresaUsuario
    ): Response<FuncionarioResponse> {
        return service.cadastrarFuncionario(FuncionarioRequest(
            nome, cpf, email, senha, dataNascimento, funcao, empresa, acesso, ativo
        ))
    }
}