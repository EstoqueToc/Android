package com.example.estoquetoc

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.estoquetoc.atributosCadastro.ProdutoAtributo
import com.example.estoquetoc.componentes.BottomBarApp
import com.example.estoquetoc.componentes.CardComponetizado
import com.example.estoquetoc.componentes.TopBarApp

@Composable
fun ProdutoCadastrados(
    navController: NavHostController,
    Items: MutableList<ProdutoAtributo>
) {

    Box(
        Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            TopBarApp(
                FirstImage = R.drawable.back_icon,
                "Voltar",
                SecondImage = R.drawable.adicionar_icon,
                "Editar",
                Titulo = "Produtos",
                true,
                onFirstClickImage = { navController.navigate("menu") },
                onSecondClickImage = {navController.navigate("cadastro_produto")}
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
                .verticalScroll(rememberScrollState()),
            Arrangement.SpaceBetween
        ) {
            if (Items.isEmpty()) {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.no_item_founded),
                        contentDescription = "No Item Founded",
                        modifier = Modifier.size(500.dp)
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Nenhum Produto Cadastrado",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            } else {
                Items.forEach { produto ->
                    CardComponetizado(
                        icon = R.drawable.box_icon,
                        DescIcon = produto.nomeProduto,
                        DescriptionProduct = produto.descricaoProduto,
                        QtdEmEstoque = produto.qtdEntrada,
                        enable = true,
                        valor = produto.precoVenda,
                        onClick = {
                            navController.navigate("cadastro_produto")
                        }
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                }
            }
        }
        Box(
            Modifier.align(Alignment.BottomCenter)
        ) {
            BottomBarApp(
                navController = navController
            )
        }
    }
}
