package com.example.estoquetoc

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.estoquetoc.componentes.BottomBarApp
import com.example.estoquetoc.componentes.CompButton
import com.example.estoquetoc.componentes.InputFormulario
import com.example.estoquetoc.componentes.TopBarApp


@Composable
fun Usuario(navController: NavController,modifier: Modifier = Modifier) {
    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var funcao by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            TopBarApp(
                FirstImage = R.drawable.back_icon,
                FirstImageDescription = "Voltar",
                SecondImage = R.drawable.usuario,
                SecondImageDescription = "Salvar",
                Titulo = "Usuário",
                onFirstClickImage = {navController.navigate("ajustes")},
                onSecondClickImage = {navController.navigate("")}
            )
            Column(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
            ) {
                Spacer(modifier = Modifier.size(20.dp))
                Row {
                    Image(modifier = Modifier.size(70.dp),
                        painter = painterResource(id = R.drawable.usuario),
                        contentDescription = "Usuario"
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(text = nome, color = Color.Black, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.size(16.dp))
                InputFormulario(value = nome, onValueChange = { nome = it }, labelText = "Nome")
                Spacer(modifier = Modifier.size(8.dp))
                InputFormulario(value = email, onValueChange = { email = it }, labelText = "Email")
                Spacer(modifier = Modifier.size(8.dp))
                InputFormulario(value = funcao, onValueChange = { funcao = it }, labelText = "Função")

                Spacer(modifier = Modifier.size(20.dp))

                CompButton(
                    onClickAction = { navController.navigate("inicial_screen") },
                    text = "Deletar Conta",
                    icon = R.drawable.delete_icon,
                    descIcon = "Deletar",
                    true
                )
            }
        }

        BottomBarApp(
            navController = navController
        )
        
    }
}

@Preview(showBackground = true)
@Composable
private fun preview() {
    var navController = rememberNavController()
    Usuario(navController = navController)
}