package com.example.estoquetoc

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.estoquetoc.componentes.Produto
import com.example.estoquetoc.componentes.ProdutoViewModel

@Composable
fun ProdutoScreen(
    navController: NavHostController,
    produtoViewModel: ProdutoViewModel = viewModel()
) {
    val listaProdutos by remember { mutableStateOf(produtoViewModel.listaProduto) }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        TopBarApp(
            FirstImage = R.drawable.back_icon,
            "Voltar",
            SecondImage = R.drawable.edit_icon,
            "Editar",
            Titulo = "Produtos",
            onClick = { navController.navigate("cadastro_produto") }
        )

        Spacer(modifier = Modifier.size(30.dp))

        listaProdutos.forEach { produto ->
            ProdutoItem(produto = produto, onClick = {
                navController.navigate("cadastro_produto")
            })
            Spacer(modifier = Modifier.size(16.dp))
        }

        BottomBarApp(navController = navController)
    }
}

@Composable
fun ProdutoItem(produto: Produto, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(16.dp)
            .clickable { onClick() }
    ) {
        Text(text = "Nome: ${produto.nomeProduto}", color = Color.Black)
        Text(text = "Descrição: ${produto.descricaoProduto}", color = Color.Black)
        Text(text = "Data de Validade: ${produto.dataValidade}", color = Color.Black)
        Text(text = "Unidade de Medida: ${produto.unidadeMedida}", color = Color.Black)
        Text(text = "Quantidade de Entrada: ${produto.qtdEntrada}", color = Color.Black)
        Text(text = "Preço de Compra: ${produto.precoCompra}", color = Color.Black)
        Text(text = "Preço de Venda: ${produto.precoVenda}", color = Color.Black)
        Text(text = "Categoria: ${produto.categoria}", color = Color.Black)
    }
}
