package com.example.estoquetoc

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.estoquetoc.ui.theme.EstoqueTocTheme

class TelaCadastroUsuario {

    @Composable
    fun CadastroUsuarioScreen() {
        var name by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            // UI Components here
            // UserForm(name, email, password, onNameChange, onEmailChange, onPasswordChange, onRegisterClick)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun CadastroUsuarioScreenPreview() {
        EstoqueTocTheme {
            CadastroUsuarioScreen()
        }
    }

}