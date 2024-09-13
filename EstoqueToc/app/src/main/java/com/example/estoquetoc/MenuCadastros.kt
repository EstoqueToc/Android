package com.example.estoquetoc

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.estoquetoc.componentes.BottomBarApp
import com.example.estoquetoc.componentes.CardComponetizado
import com.example.estoquetoc.componentes.TopBarApp

@Composable
fun MenuCadastros(navController: NavController) {
    Column {
        TopBarApp(
            FirstImage = R.drawable.back_icon,
            FirstImageDescription ="Voltar",
            SecondImage = R.drawable.edit_icon ,
            SecondImageDescription = "Editar",
            Titulo = "Cadastros"
        ) {
            navController.navigate("produto_screen")
        }
        Conteudo(navController = navController)
    }

}

@Composable
fun Conteudo( navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),

                ) {
                Spacer(modifier = Modifier.size(8.dp))
                CardComponetizado(
                    icon = R.drawable.funcionario,
                    DescIcon = "Funcionário",
                    DescriptionProduct = "Funcionários",
                    QtdEmEstoque = "Cadastre seus funcionários para gerenciar seus acessos."
                ) {
                    navController.navigate("funcionarios")
                }
                CardComponetizado(
                    icon = R.drawable.produto,
                    DescIcon = "Produtos",
                    DescriptionProduct = "Produtos",
                    QtdEmEstoque = "Cadastre seus produtos para controle do seu estoque.",
                    onClick = { navController.navigate("produto_screen") }
                )
                CardComponetizado(
                    icon = R.drawable.fornecedor,
                    DescIcon = "Fornecedores",
                    DescriptionProduct = "Fornecedores",
                    QtdEmEstoque = "Cadastre seus fornecedores para uma melhor gestão."
                ) {
                    navController.navigate("Fornecedores")
                }
                CardComponetizado(
                    icon = R.drawable.categoria,
                    DescIcon = "Categorias",
                    DescriptionProduct = "Categorias",
                    QtdEmEstoque = "Cadastre categorias para facilitar a visualização dos seus produtos."
                ) {
                    navController.navigate("Fornecedores")
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
            BottomBarApp(navController = navController)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MenuCadastroPreview() {
    val navController = rememberNavController()
    MenuCadastros(navController)
}