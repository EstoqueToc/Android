package com.example.estoquetoc

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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

        Conteudo(navController = navController)
    }

}

@Composable
fun Conteudo( navController: NavController, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Box(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            TopBarApp(
                FirstImage = R.drawable.back_icon,
                FirstImageDescription ="Voltar",
                Titulo = "Cadastros",
                onFirstClickImage = {navController.navigate("faturamento")}
            )
        }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 120.dp,
                        bottom = 70.dp,
                        start = 10.dp,
                        end = 10.dp
                    )
                    .verticalScroll(rememberScrollState())
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
                    onClick = { navController.navigate("produtos_screen") }
                )
                CardComponetizado(
                    icon = R.drawable.fornecedor,
                    DescIcon = "Fornecedores",
                    DescriptionProduct = "Fornecedores",
                    QtdEmEstoque = "Cadastre seus fornecedores para uma melhor gestão."
                ) {
                    navController.navigate("fornecedores")
                }
                CardComponetizado(
                    icon = R.drawable.categoria,
                    DescIcon = "Categorias",
                    DescriptionProduct = "Categorias",
                    QtdEmEstoque = "Cadastre categorias para facilitar a visualização dos seus produtos."
                ) {
                    navController.navigate("categorias")
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

        Box(modifier = Modifier.align(Alignment.BottomCenter)){
            BottomBarApp(
                navController = navController
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuCadastroPreview() {
    val navController = rememberNavController()
    MenuCadastros(navController)
}