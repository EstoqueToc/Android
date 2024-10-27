package com.example.estoquetoc.viewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.estoquetoc.BuildConfig
import com.example.estoquetoc.Rest
import com.example.estoquetoc.obterToken
import com.example.estoquetoc.repositoy.FornecedorRepository
import com.example.estoquetoc.service.EmpresaTemFornecedorRequest
import com.example.estoquetoc.service.FornecedorRequest
import com.example.estoquetoc.service.FornecedorService
import com.example.estoquetoc.service.Logradouro
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class FornecedorViewModel(
    private val repository: FornecedorRepository
): ViewModel() {

    fun cadastrarFornecedor(
        context: Context,
        nomeFantasia : String,
        razaoSocial : String,
        telefone : String,
        email : String,
        cnpj : String,
        Logradouro: Logradouro,
        onResult: (Boolean) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val token = obterToken(context).first()
                val retrofit = Rest.createApiService(token)
                val serviceFuncionario = retrofit.create(FornecedorService::class.java)

                val response = serviceFuncionario.cadastrarFornecedores(
                    FornecedorRequest(
                        nomeFantasia,
                        razaoSocial,
                        telefone,
                        email,
                        cnpj,
                        1,
                        Logradouro
                    )
                )

                if (response.isSuccessful) {
                    serviceFuncionario.cadastrarEmpresaTemFornecedor(
                        EmpresaTemFornecedorRequest(
                            2,
                            response.body()?.id!!

                        )
                    )
                    onResult(true)
                } else {
                    Log.e("FornecedorViewModel", "Failed to register supplier: ${response.errorBody()?.string()}")
                    onResult(false)
                }


            } catch (e: Exception) {
                Log.e("FornecedorViewModel", "Exception during supplier registration", e)
                onResult(false)
            }
        }
    }
}