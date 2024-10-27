package com.example.estoquetoc.repositoy

import com.example.estoquetoc.service.EmpresaUsuario
import com.example.estoquetoc.service.FuncionarioResponse
import retrofit2.Response

interface FuncionarioRepository {

    suspend fun cadastrarFuncionario(
        nome: String,
        cpf: String,
        email: String,
        senha: String,
        dataNascimento: String,
        funcao: String,
        ativo: Int,
        acesso: Int,
        empresa: EmpresaUsuario
    ): Response<FuncionarioResponse>
}