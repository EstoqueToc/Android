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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Locale


@Preview(showBackground = true)
@Composable
fun CadastroProdutoScreen() {
    Column {
//        TopBarApp()
//        FormFuncionario()
//        BottomBarApp()
        test()
    }
}

@Composable
fun FormFuncionario() {

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
        Input(value = nomeProduto, onValueChange = { nomeProduto = it }, label = "Nome", text = "Nome")
        Spacer(modifier = Modifier.size(16.dp))

        Input(value = descricaoProduto, onValueChange = { descricaoProduto = it }, label = "Descrição", text = "Descrição")
        Spacer(modifier = Modifier.size(16.dp))

        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = dataValidade,
                onValueChange = { input ->
                    dataValidade = input
                },
                label = { Text(text = "Data de Validade") }
            )
            if (dataValidade.isNotEmpty()) {
                try {
                    val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                    format.isLenient = false
                    format.parse(dataValidade)
                } catch (e: Exception) {
                    Toast.makeText(
                        context,
                        "Por favor, insira uma data válida no formato dd/MM/yyyy",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
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

        Input(value = unidadeMedida, onValueChange = { unidadeMedida = it }, label = "Unidade de Medida", text = "Unidade de Medida")
        Spacer(modifier = Modifier.size(16.dp))

        Input(value = qtdEntrada, onValueChange = { qtdEntrada = it }, label = "Quantidade de Entrada", text = "Quantidade de Entrada")
        Spacer(modifier = Modifier.size(16.dp))

        Input(value = precoCompra, onValueChange = { precoCompra = it }, label = "Preço de Compra", text = "Preço de Compra")
        Spacer(modifier = Modifier.size(16.dp))

        Input(value = precoVenda, onValueChange = { precoVenda = it }, label = "Preço de Venda", text = "Preço de Venda")
        Spacer(modifier = Modifier.size(16.dp))

//        Box(
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Input(value = categoria, onValueChange = { categoria = it }, label = "Categoria", text = "Categoria")
//            Button(
//                shape = CircleShape,
//                onClick = { listaVisible = !listaVisible },
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = Color.Transparent
//                ),
//                modifier = Modifier.align(Alignment.CenterEnd)
//            ) {
//                Image(
//                    painter = painterResource(
//                        id = if (listaVisible) R.drawable.show_arrow_icon else R.drawable.hide_arrow_icon
//                    ),
//                    contentDescription = if (listaVisible) "Mostrar" else "Esconder",
//                    modifier = Modifier
//                        .size(20.dp)
//                        .background(Color.Transparent)
//                )
//            }
//        }

        test()

        Button(
            onClick = {
                if (nomeProduto.isNotBlank() && descricaoProduto.isNotBlank() && dataValidade.isNotBlank()
                    && unidadeMedida.isNotBlank() && qtdEntrada.isNotBlank() && precoCompra.isNotBlank()
                    && precoVenda.isNotBlank() && categoria.isNotBlank()
                ) {
                    Toast.makeText(
                        context,
                        "Produto '$nomeProduto' salvo com sucesso!",
                        Toast.LENGTH_SHORT
                    ).show()

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
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(text = "Salvar Produto")
        }
    }
}

@Composable
fun Input(value: String, onValueChange: (String) -> Unit, label: String, text: String) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = text,
                textAlign = TextAlign.Start,
                fontSize = 14.sp
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun test(modifier: Modifier = Modifier) {

    var novoItem by remember { mutableStateOf("") }
    var popUpVisible by remember { mutableStateOf(false) }
    var listaVisible by remember { mutableStateOf(false) }
    var itemsList by remember { mutableStateOf(listOf<String>()) }

    var categoria by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Input(value = categoria, onValueChange = { categoria = it }, label = "Categoria", text = "Categoria")
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

        // Use AnimatedVisibility to control the visibility of the list
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
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = {
                    popUpVisible = !popUpVisible
                }) {
                    Text("Adicionar Nova Categoria")
                }

                // Another AnimatedVisibility for the popup
                AnimatedVisibility(
                    visible = popUpVisible,
                    enter = fadeIn(tween(500)),
                    exit = fadeOut(tween(500))
                ) {
                    Column {
                        Input(
                            value = novoItem,
                            onValueChange = { novoItem = it },
                            label = "Nova Categoria",
                            text = "Nova Categoria"
                        )
                        Button(onClick = {
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
    }
}