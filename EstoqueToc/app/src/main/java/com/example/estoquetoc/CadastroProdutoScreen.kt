package com.example.estoquetoc


import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.estoquetoc.componentes.Produto
import com.example.estoquetoc.componentes.ProdutoViewModel
import java.text.SimpleDateFormat
import java.util.Locale

//@Preview(showBackground = true)
@Composable
fun CadastroProdutoScreen(
    navController: NavHostController,
//    produtoViewModel: ProdutoViewModel = viewModel()
    Items: MutableList<Produto>
) {
    var nomeProduto by remember { mutableStateOf("") }
    var descricaoProduto by remember { mutableStateOf("") }
    var dataValidade by remember { mutableStateOf("") }
    var unidadeMedida by remember { mutableStateOf("") }
    var qtdEntrada by remember { mutableStateOf("") }
    var precoCompra by remember { mutableStateOf("") }
    var precoVenda by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf("") }
    var novoItem by remember { mutableStateOf("") }
    var popUpVisible by remember { mutableStateOf(false) }
    var listaVisible by remember { mutableStateOf(false) }
    var itemsList by remember { mutableStateOf(listOf<String>()) }

//    val produtos = produtoViewModel.listaProduto

    val context = LocalContext.current
    Column {
        TopBarApp(
            FirstImage = R.drawable.back_icon,
            "Voltar",
            SecondImage = R.drawable.lixeira_icon,
            "lixeira",
            Titulo = "Produtos",
            onClick = { navController.navigate("produtos_screen")}
        )
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Input(
                value = nomeProduto,
                onValueChange = { nomeProduto = it },
                labelText = "Nome"
            )
            Spacer(modifier = Modifier.size(16.dp))

            Input(
                value = descricaoProduto,
                onValueChange = { descricaoProduto = it },
                labelText = "Descrção"
            )
            Spacer(modifier = Modifier.size(16.dp))

            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = dataValidade,
                    onValueChange = { input ->
                        dataValidade = input
                        // Verificar se a data é válida e mostrar um Toast se não for
                        if (input.isNotEmpty()) {
                            try {
                                val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                                format.isLenient = false
                                format.parse(input)
                            } catch (e: Exception) {
                                Toast.makeText(
                                    context,
                                    "Por favor, insira uma data válida no formato dd/MM/yyyy",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    },
                    label = { Text(text = "Data de Validade") }
                )
                Image(
                    painter = painterResource(id = R.drawable.calendar_icon),
                    contentDescription = "Data de Validade",
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(30.dp)
                        .align(Alignment.CenterEnd)
                )
            }
            Spacer(modifier = Modifier.size(16.dp))

            Input(
                value = unidadeMedida,
                onValueChange = { unidadeMedida = it },
                labelText = "Unidade de Medida"
            )
            Spacer(modifier = Modifier.size(16.dp))

            Input(
                value = qtdEntrada,
                onValueChange = { qtdEntrada = it },
                labelText = "Quantidade de Entrada"
            )
            Spacer(modifier = Modifier.size(16.dp))

            Input(
                value = precoCompra,
                onValueChange = { precoCompra = it },
                labelText = "Preço de Compra"
            )
            Spacer(modifier = Modifier.size(16.dp))

            Input(
                value = precoVenda,
                onValueChange = { precoVenda = it },
                labelText = "Preço de Venda"
            )
            Spacer(modifier = Modifier.size(16.dp))

//         Seção para categoria
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = categoria,
                    onValueChange = { categoria = it },
                    label = { Text("Categoria") },
                    modifier = Modifier.fillMaxWidth()
                )
                Button(
                    onClick = { listaVisible = !listaVisible }, // Alterna a visibilidade da lista
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .clip(RoundedCornerShape(16.dp))
                ) {
                    Image(
                        painter = painterResource(
                            id = if (listaVisible) R.drawable.show_arrow_icon else R.drawable.hide_arrow_icon
                        ),
                        contentDescription = if (listaVisible) "Mostrar" else "Esconder",
                        modifier = Modifier
                            .size(20.dp)
                            .background(Color.Transparent)
                    )
                }
            }
            AnimatedVisibility(
                visible = listaVisible,
                enter = fadeIn(tween(500)),
                exit = fadeOut(tween(500))
            ) {
                Column(
                    Modifier.padding(16.dp)
                ) {
                    itemsList.forEach { item ->
                        Button(
                            onClick = { categoria = item },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp) // Adiciona um pouco de espaço entre os botões
                        ) {
                            Text(
                                text = item,
                                modifier = Modifier.padding(8.dp),
                                fontSize = 16.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.size(16.dp))
                    Button(onClick = {
                        popUpVisible = !popUpVisible
                    }) {
                        Text("Adicionar Nova Categoria")
                    }
                }
            }


            AnimatedVisibility(
                visible = popUpVisible,
                enter = fadeIn(tween(500)),
                exit = fadeOut(tween(500))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    OutlinedTextField(
                        value = novoItem,
                        onValueChange = { novoItem = it },
                        label = { Text("Nova Categoria") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(
                        modifier = Modifier.clip(RoundedCornerShape(16.dp)),
                        onClick = {
                            if (novoItem.isNotBlank()) {
                                itemsList = itemsList + novoItem
                                categoria = novoItem // Atualiza a categoria selecionada
                                novoItem = ""
                                popUpVisible = false
                            } else {
                                Toast.makeText(
                                    context,
                                    "Categoria não pode ser vazia",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }) {
                        Text(text = "Salvar")
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            CompButton(onClickAction = {
                if (nomeProduto.isNotBlank() && descricaoProduto.isNotBlank()) {
                    Toast.makeText(
                        context,
                        "Produto '$nomeProduto' salvo com sucesso!",
                        Toast.LENGTH_SHORT
                    ).show()
                    val novoProduto = Produto(
                        nomeProduto = nomeProduto,
                        descricaoProduto = descricaoProduto,
                        dataValidade = dataValidade,
                        unidadeMedida = unidadeMedida,
                        qtdEntrada = qtdEntrada,
                        precoCompra = precoCompra,
                        precoVenda = precoVenda,
                        categoria = categoria
                    )
                    Items.add(novoProduto)
                    //                    produtoViewModel.addProduto(novoProduto)
                    navController.navigate("produtos_screen")
                    // Limpar campos após o salvamento
                    nomeProduto = ""
                    descricaoProduto = ""
                    dataValidade = ""
                    unidadeMedida = ""
                    qtdEntrada = ""
                    precoCompra = ""
                    precoVenda = ""
                    categoria = ""
                } else {
                    Toast.makeText(
                        context,
                        "Por favor, preencha todos os campos.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }, text = "Salvar")

        }
        BottomBarApp(navController = navController)
    }
}

@Composable
fun Input(
    value: String,
    onValueChange: (String) -> Unit,
    labelText: String
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = labelText,
                textAlign = TextAlign.Start,
                fontSize = 14.sp
            )
        }
    )
}