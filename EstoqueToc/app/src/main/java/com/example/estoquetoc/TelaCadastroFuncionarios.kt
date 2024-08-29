package com.example.estoquetoc

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.estoquetoc.R // Substitua pelo seu pacote de recursos

@Composable
fun TelaCadastroFuncionarios() {
    val idState = remember { mutableStateOf("") }
    val produtoState = remember { mutableStateOf("") }
    val quantidadeState = remember { mutableStateOf("") }
    val precoState = remember { mutableStateOf("") }
    val statusState = remember { mutableStateOf("") }
    val descricaoState = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.usuario),
            contentDescription = "Foto do Funcionário",
            modifier = Modifier
                .size(120.dp)
                .border(
                    width = 2.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(60.dp)
                )
                .padding(4.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Cadastro de Funcionários",
            style = TextStyle(fontSize = 24.sp),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = idState.value,
            onValueChange = { idState.value = it },
            label = { Text("Id") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = produtoState.value,
            onValueChange = { produtoState.value = it },
            label = { Text("Produto") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )

        OutlinedTextField(
            value = quantidadeState.value,
            onValueChange = { quantidadeState.value = it },
            label = { Text("Quantidade") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )

        OutlinedTextField(
            value = precoState.value,
            onValueChange = { precoState.value = it },
            label = { Text("Preço") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )

        OutlinedTextField(
            value = statusState.value,
            onValueChange = { statusState.value = it },
            label = { Text("Status") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )

        OutlinedTextField(
            value = descricaoState.value,
            onValueChange = { descricaoState.value = it },
            label = { Text("Descrição") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp), // Ajuste a altura para garantir que ambos tenham a mesma altura
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Cancelar")
            }

            Spacer(modifier = Modifier.width(16.dp)) // Espaçamento entre os botões

            Button(
                onClick = {
                },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp), // Mesmo tamanho do outro botão
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Salvar")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TelaCadastroFuncionariosPreview() {
    TelaCadastroFuncionarios()
}
