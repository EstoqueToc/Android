package com.example.estoquetoc

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.estoquetoc.componentes.Produto

@Composable
fun ProdutoScreen(
    navController: NavHostController,
//    produtoViewModel: ProdutoViewModel = viewModel()
    Items:MutableList<Produto>
) {

//    val listaProdutos by remember { mutableStateOf(produtoViewModel.listaProduto) }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState()),
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
        Column(
            modifier = Modifier.fillMaxSize(),
            Arrangement.SpaceBetween
        ) {
            if(Items.isEmpty()){
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.no_item_founded),
                        contentDescription = "No Item Founded",
                        modifier = Modifier.size(500.dp)
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Nenhum Registro encontrado",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            }else{
                Items.forEach{produto ->
                    Produtos(
                        icon = R.drawable.box_icon,
                        DescIcon = produto.nomeProduto,
                        DescriptionProduct = produto.descricaoProduto,
                        QtdEmEstoque =produto.qtdEntrada,
                        enable = true,
                        valor = produto.precoVenda,
                        onClick = {
                            navController.navigate("cadastro_produto")
                        }
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                }
            }
            BottomBarApp(navController = navController)
        }
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
