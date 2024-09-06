package com.example.estoquetoc

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.estoquetoc.ui.theme.EstoqueTocTheme

class TelaCadastroFuncionarios {

    @Composable
    fun CadastroFuncionarioScreen() {
        var employeeName by remember { mutableStateOf("") }
        var employeeRole by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            // UI Components here
            // EmployeeForm(employeeName, employeeRole, onEmployeeNameChange, onEmployeeRoleChange, onSaveClick)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun CadastroFuncionarioScreenPreview() {
        EstoqueTocTheme {
            CadastroFuncionarioScreen()
        }
    }

}