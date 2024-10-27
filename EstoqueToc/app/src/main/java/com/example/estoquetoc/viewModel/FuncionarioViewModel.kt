package com.example.estoquetoc.viewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.estoquetoc.Rest
import com.example.estoquetoc.obterToken
import com.example.estoquetoc.repositoy.FuncionarioRepository
import com.example.estoquetoc.service.EmpresaUsuario
import com.example.estoquetoc.service.FuncionarioRequest
import com.example.estoquetoc.service.FuncionarioService
import com.google.gson.Gson
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class FuncionarioViewModel(
    private val repository: FuncionarioRepository
): ViewModel() {

    fun cadastrarFuncionario(
        context: Context,
        nome: String,
        cpf: String,
        email: String,
        senha: String,
        dataNascimento: String,
        funcao: String,
        ativo: Int,
        acesso: Int,
        empresa: EmpresaUsuario,
        onResult: (Boolean) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val token = obterToken(context).first()
                val retrofit = Rest.createApiService(token)
                val serviceFuncionario = retrofit.create(FuncionarioService::class.java)

                val request = FuncionarioRequest(
                    nome,
                    cpf,
                    email,
                    senha,
                    dataNascimento,
                    funcao,
                    empresa,
                    acesso,
                    ativo
                )

                // Log the request body
                Log.d("FuncionarioViewModel", "Request Body: ${Gson().toJson(request)}")

                val response = serviceFuncionario.cadastrarFuncionario(request)

                if (response.isSuccessful) {
                    onResult(true)
                } else {
                    Log.e(
                        "FuncionarioViewModel",
                        "Failed to register employee: ${response.errorBody()?.string()}"
                    )
                    onResult(false)
                }
            } catch (e: Exception) {
                Log.e("FuncionarioViewModel", "Failed to register employee", e)
                onResult(false)
            }
        }
    }
}