package com.example.estoquetoc.service

import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface FuncionarioService {

    @POST("usuarios/cadastro")
    suspend fun cadastrarFuncionario(
        @Body funcionarioRequest : FuncionarioRequest
    )
            : Response<FuncionarioResponse>
}

data class FuncionarioRequest (
    @SerializedName("nome")
    val nome: String,

    @SerializedName("cpf")
    val cpf: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("senha")
    val senha: String,

    @SerializedName("dataNascimento")
    val dataNascimento: String,

    @SerializedName("funcao")
    val funcao: String,

    @SerializedName("empresa")
    val empresa: EmpresaUsuario,

    @SerializedName("acesso")
    val acesso: Int = 1,

    @SerializedName("ativo")
    val ativo: Int = 1
)

data class EmpresaUsuario (
    @SerializedName("id")
    val id: Long = 2
)
data class FuncionarioResponse (
    val id : Long,
    val nome : String,
    val cpf : String,
    val email : String,
    val senha : String,
    val dataNascimento : String,
    val funcao : String,
    val empresa : EmpresaUsuario,
    val acesso : Int,
    val ativo : Int
)

/*
{
  "nome": "string",
  "cpf": "string",
  "email": "string",
  "senha": "strings",
  "dataNascimento": "2024-10-27",
  "funcao": "string",
  "empresa": {
    "id": 0,
    }
  },
  "acesso": 0,
  "ativo": 0
 */