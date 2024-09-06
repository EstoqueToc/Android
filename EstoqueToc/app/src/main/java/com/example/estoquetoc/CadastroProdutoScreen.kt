package com.example.estoquetoc


import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import java.text.SimpleDateFormat
import java.util.Locale

//@Preview(showBackground = true)
@Composable
fun CadastroProdutoScreen(
    navController: NavHostController
) {
    Column {
        TopBarApp()
        FormFuncionario()
        BottomBarApp()
    }
}

@Composable
fun FormFuncionario() {
    var novoItem by remember { mutableStateOf("") }
    var popUpVisible by remember { mutableStateOf(false) }
    var listaVisible by remember { mutableStateOf(false) }
    var itemsList by remember { mutableStateOf(listOf<String>()) }

    var nomeProduto by remember { mutableStateOf("") }
    var descricaoProduto by remember { mutableStateOf("") }
    var dataValidade by remember { mutableStateOf("") }
    var unidadeMedida by remember { mutableStateOf("") }
    var qtdEntrada by remember { mutableStateOf("") }
    var precoCompra by remember { mutableStateOf("") }
    var precoVenda by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf("") }

    val context = LocalContext.current

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

        // Seção para categoria
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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                LazyColumn {
                    items(itemsList) { item ->
                        Button(
                            onClick = { categoria = item },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = item,
                                modifier = Modifier.padding(8.dp),
                                fontSize = 16.sp
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))

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

//        Button(
//            onClick = {
//                if (nomeProduto.isNotBlank() && descricaoProduto.isNotBlank() && dataValidade.isNotBlank()
//                    && unidadeMedida.isNotBlank() && qtdEntrada.isNotBlank() && precoCompra.isNotBlank()
//                    && precoVenda.isNotBlank() && categoria.isNotBlank()
//                ) {
//                    Toast.makeText(
//                        context,
//                        "Produto '$nomeProduto' salvo com sucesso!",
//                        Toast.LENGTH_SHORT
//                    ).show()
//
//                    // Limpar campos após o salvamento
//                    nomeProduto = ""
//                    descricaoProduto = ""
//                    dataValidade = ""
//                    unidadeMedida = ""
//                    qtdEntrada = ""
//                    precoCompra = ""
//                    precoVenda = ""
//                    categoria = ""
//
//                } else {
//                    Toast.makeText(
//                        context,
//                        "Por favor, preencha todos os campos.",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            },
//            modifier = Modifier
//                .fillMaxWidth() // Define a largura e altura do botão para 100.dp, tornando-o quadrado
//                .padding(top = 16.dp),
//            shape = RoundedCornerShape(0.dp) // Mantém as bordas quadradas, sem arredondamento
//        ) {
//            Text(
//                text = "Salvar Produto",
//                fontSize = 16.sp,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp), // Adiciona um pouco de padding ao texto
//                textAlign = TextAlign.Center
//            )
//        }


        CompButton(onClickAction = {
            if (nomeProduto.isNotBlank() && descricaoProduto.isNotBlank() && dataValidade.isNotBlank()
                && unidadeMedida.isNotBlank() && qtdEntrada.isNotBlank() && precoCompra.isNotBlank()
                && precoVenda.isNotBlank() && categoria.isNotBlank()
            ) {
                Toast.makeText(
                    context,
                    "Produto '$nomeProduto' salvo com sucesso!",
                    Toast.LENGTH_SHORT
                ).show()

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
}


@Composable
fun ItemList(
    items: List<String>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(items) { item ->
            Text(
                text = item,
                modifier = Modifier.padding(8.dp),
                fontSize = 16.sp
            )
        }
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


@Preview(showBackground = true)
@Composable
fun Test() {
    var novoItem by remember { mutableStateOf("") }
    var popUpVisible by remember { mutableStateOf(false) }
    var listaVisible by remember { mutableStateOf(false) }
    var itemsList by remember { mutableStateOf(listOf<String>()) }

    var categoria by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Input(
                value = categoria,
                onValueChange = { categoria = it },
                labelText = "Categoria"
            )
            Button(
                shape = CircleShape,
                onClick = { listaVisible = !listaVisible }, // Toggle listaVisible
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.align(Alignment.CenterEnd)
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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                LazyColumn {
                    items(itemsList) { item ->
                        Text(
                            text = item,
                            modifier = Modifier.padding(8.dp),
                            fontSize = 16.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))

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
            Column {
                Input(
                    value = novoItem,
                    onValueChange = { novoItem = it },
                    labelText = "Nova Categoria"
                )
                Button(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .aspectRatio(1f),
                    onClick = {
                        itemsList = itemsList + novoItem
                        popUpVisible = false
                        categoria = novoItem
                        novoItem = ""
                    }) {
                    Text(text = "Salvar")
                }
            }
        }
    }
}
