package com.example.estoquetoc

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import java.text.SimpleDateFormat
import java.util.Locale


@Composable
fun CadastroProdutoScreen(navController: NavHostController) {
    Column {
       TopBarApp()
        FormFuncionario()
        BottomBarApp()
    }
}

@Composable
fun FormFuncionario() {
    var dataValidade by remember { mutableStateOf("") }

    val context = LocalContext.current

    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Input(label = "nome", text = "Nome")
        Spacer(modifier = Modifier.size(16.dp))
        Input(label = "descricao", text = "Descrição")
        Spacer(modifier = Modifier.size(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = CircleShape,
                value = dataValidade,
                onValueChange = { input ->
                    try {
                        val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                        format.isLenient = false // Não permite datas inválidas como "32/01/2024"
                        format.parse(input) // Tenta converter o input para uma data
                        dataValidade = input // Se a conversão for bem-sucedida, atualiza o estado
                    } catch (e: Exception) {
                        Toast.makeText(context, "Por favor, insira uma data válida no formato dd/MM/yyyy", Toast.LENGTH_SHORT).show()
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
                    .align(Alignment.CenterEnd) // Certifique-se de alinhar a imagem corretamente

            )
        }
        Spacer(modifier = Modifier.size(16.dp))
        Input(label = "unidadeMedida", text ="Unidade de Medida")
        Spacer(modifier = Modifier.size(16.dp))
        Input(label = "qtdEntrada", text = "Quantidade de Entrada")
        Spacer(modifier = Modifier.size(16.dp))
        Input(label = "precoCompra", text = "Preço de Compra")
    }
}

@Composable
fun Input(label: String, text: String) {
    var label by remember { mutableStateOf("") }
    OutlinedTextField(
        modifier =  Modifier
            .fillMaxWidth(),
        shape = CircleShape,
        value = label,
        onValueChange = {label=it},
        label = { Text(
            text = text ,
            textAlign = TextAlign.Unspecified,
            fontSize = 14.sp
        )}
    )
}