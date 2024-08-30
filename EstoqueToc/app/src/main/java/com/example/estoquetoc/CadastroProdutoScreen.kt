package com.example.estoquetoc

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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
        TopBarApp()
        FormFuncionario()
        BottomBarApp()
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
    var visivel by remember { mutableStateOf(false) }

    val context = LocalContext.current

    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Input(value = nomeProduto, onValueChange = { nomeProduto = it }, label = "nome", text = "Nome")
        Spacer(modifier = Modifier.size(16.dp))

        Input(value = descricaoProduto, onValueChange = { descricaoProduto = it }, label = "descricao", text = "Descrição")
        Spacer(modifier = Modifier.size(16.dp))

        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = dataValidade,
                onValueChange = { input ->
                    try {
                        val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                        format.isLenient = false // Não permite datas inválidas como "32/01/2024"
                        format.parse(input) // Tenta converter o input para uma data
                        dataValidade = input // Se a conversão for bem-sucedida, atualiza o estado
                    } catch (e: Exception) {
                        Toast.makeText(
                            context,
                            "Por favor, insira uma data válida no formato dd/MM/yyyy",
                            Toast.LENGTH_SHORT
                        ).show()
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

        Input(value = unidadeMedida, onValueChange = { unidadeMedida = it }, label = "unidadeMedida", text = "Unidade de Medida")
        Spacer(modifier = Modifier.size(16.dp))

        Input(value = qtdEntrada, onValueChange = { qtdEntrada = it }, label = "qtdEntrada", text = "Quantidade de Entrada")
        Spacer(modifier = Modifier.size(16.dp))

        Input(value = precoCompra, onValueChange = { precoCompra = it }, label = "precoCompra", text = "Preço de Compra")
        Spacer(modifier = Modifier.size(16.dp))

        Input(value = precoVenda, onValueChange = { precoVenda = it }, label = "precoVenda", text = "Preço de Venda")
        Spacer(modifier = Modifier.size(16.dp))

        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Input(value = categoria, onValueChange = { categoria = it }, label = "categoria", text = "Categoria")
            Button(
                shape = CircleShape,
                onClick = { visivel = !visivel },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Image(
                    painter = painterResource(id = if (visivel) R.drawable.show_arrow_icon else R.drawable.hide_arrow_icon),
                    contentDescription = if (visivel) "Mostrar" else "Esconder",
                    modifier = Modifier
                        .size(20.dp)
                        .background(Color.Transparent)
                )
            }
        }

        AnimatedVisibility(
            visible = visivel,
            enter = fadeIn(tween(300)),
            exit = fadeOut(tween(300))
        ) {
            Text("Conteúdo Adicional", modifier = Modifier.padding(8.dp))
        }

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
