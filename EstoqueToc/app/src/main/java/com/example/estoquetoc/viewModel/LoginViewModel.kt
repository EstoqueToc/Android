package com.example.estoquetoc.viewModel

import android.content.Context
import android.util.Log
import com.example.estoquetoc.repositoy.LoginRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.estoquetoc.Rest
import com.example.estoquetoc.salvarToken
import com.example.estoquetoc.service.LoginRequest
import com.example.estoquetoc.service.LoginResponse
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: LoginRepository
): ViewModel() {

    var data = mutableListOf<LoginResponse>()
        private set

    fun fazerLogin(context: Context, email: String, senha: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                val response = Rest.service.fazerLogin(
                    LoginRequest(email, senha)
                )
                val token = response.body()?.token ?: "VAZIO"
                Log.d("Login", "Response: ${response.code()}, Token: $token")

                if (response.isSuccessful && token != "VAZIO") {
                    salvarToken(context, token)
                    onResult(true)
                } else {
                    Log.e("Login", "Login falhou: ${response.errorBody()?.string()}")
                    onResult(false)
                }
            } catch (e: Exception) {
                Log.e("Login", "Erro ao fazer login", e)
                onResult(false)
            }
        }
    }
}