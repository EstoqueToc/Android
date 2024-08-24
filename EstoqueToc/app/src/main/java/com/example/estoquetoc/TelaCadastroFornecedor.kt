package com.example.estoquetoc

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.estoquetoc.ui.theme.EstoqueTocTheme

class TelaCadastroFornecedor {

    @Composable
    fun CadastroFornecedorScreen() {
        var supplierName by remember { mutableStateOf("") }
        var supplierEmail by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            // UI Components here
            // SupplierForm(supplierName, supplierEmail, onSupplierNameChange, onSupplierEmailChange, onSaveClick)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun CadastroFornecedorScreenPreview() {
        EstoqueTocTheme {
            CadastroFornecedorScreen()
        }
    }

}