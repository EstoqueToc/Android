package com.example.estoquetoc

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


//@Preview
@Composable
fun ProdutoScreen(navController: NavController) {
    Column(
        Modifier.fillMaxSize()
    ) {
        TopBarApp()
        Spacer(modifier = Modifier.size(30.dp))
        Produtos(
            icon = R.drawable.box_icon,
            DescIcon = "Box",
            DesccriptionProduct = "Produto XX",
            DesccriptionProduct2 = "Quantidade: 008",
            enable = true,
            valor = "R$ 25,00",
            onClick = {navController.navigate("cadastro_produto")}
        )
    }
}


