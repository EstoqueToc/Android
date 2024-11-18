package com.example.estoquetoc

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.estoquetoc.componentes.BottomBarApp

@Composable
fun AjudaScreen(navController: NavController? = null, context: Context? = null) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            color = Color(0xFFEAAC47)
        )
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row (
                modifier = Modifier.fillMaxWidth()
                    .padding(36.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ){
            Text(
                text = "Solicitar Suporte",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 24.sp,

            )
                Image(
                    painter = painterResource(id = R.drawable.icon_suporte),
                    contentDescription = "Fone de ouvido",
                    modifier = Modifier.size(36.dp),
                    colorFilter = ColorFilter.tint(Color(0xFFFFFFFF))

                )
           }
            // Nome
            var nomeState = remember { mutableStateOf("") }
            TextField(
                value = nomeState.value,
                onValueChange = { nomeState.value = it },
                label = { Text("Nome") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(24.dp))

            // E-mail
            var emailState = remember { mutableStateOf("") }
            TextField(
                value = emailState.value,
                onValueChange = { emailState.value = it },
                label = { Text("E-mail") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Descrição do problema
            var descricaoState = remember { mutableStateOf("") }
            TextField(
                value = descricaoState.value,
                onValueChange = { descricaoState.value = it },
                label = { Text("Descrição do Problema") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                maxLines = 5,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    Log.d("AjudaScreen", "Enviar e-mail com as informações.")
                })
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Botão de envio
            Button(
                onClick = {
                    // Aqui você pode implementar a lógica de envio de e-mail
                    Log.d("AjudaScreen", "Enviar e-mail com as informações: ${nomeState.value}, ${emailState.value}, ${descricaoState.value}")

                    // Exibir o Toast de sucesso
                    context?.let {
                        Toast.makeText(it, "Solicitação enviada com sucesso!", Toast.LENGTH_SHORT).show()
                    }

                    // Redirecionar para a tela inicial
                    navController?.navigate("faturamento")
                },
                shape = RoundedCornerShape(6.dp),
                modifier = Modifier.fillMaxWidth(0.9f),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7D00))
            ){
                Text(
                    text = "Enviar Solicitação",
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(14.dp)
                    )
            }
        }


        // Navegação com BottomBar
        navController?.let {
            Box(modifier = Modifier.align(Alignment.BottomCenter)) {
                BottomBarApp(navController = it)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AjudaScreenPreview() {
    AjudaScreen(navController = null)
}
