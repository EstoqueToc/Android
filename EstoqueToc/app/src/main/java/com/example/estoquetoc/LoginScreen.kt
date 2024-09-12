package com.example.estoquetoc

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.estoquetoc.ui.theme.EstoqueTocTheme

//@Preview
@Composable
fun LoginScreen(
    navController: NavHostController? = null,
    modifier: Modifier = Modifier)  {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var loginMessage by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFEAAC47))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally)
                .background(
                    Color.Transparent,
                    shape = RoundedCornerShape(16.dp)
                ),
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(10.dp)
                )
                .clip(RoundedCornerShape(16.dp)) // Garantir que o conteúdo interno siga o arredondamento
                .background(Color.White)
        ) {
            TextField(
                value = username,
                onValueChange = { username = it },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Green,
                ),
                label = {
                    Text("Digite seu e-mail")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White
                    )
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(10.dp)
                )
                .clip(RoundedCornerShape(16.dp)) // Garantir que o conteúdo interno siga o arredondamento
                .background(Color.White)
        ) {
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Digite sua senha") },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White
                    ),
                visualTransformation = PasswordVisualTransformation()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (username == "" && password == "") {
                    loginMessage = "Login realizado"
                    navController?.navigate("faturamento")
                } else {
                    loginMessage = "E-mail ou senha inválido(s)"
                }
            },
            modifier = Modifier
                .width(150.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Entrar")
        }

        Spacer(modifier = Modifier.height(4.dp))
        ForgotPasswordLink()

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = loginMessage)
    }
}

@Composable
fun ForgotPasswordLink() {
    var isHovered by remember { mutableStateOf(false) }

    Text(
        text = "Esqueci a senha",
        color = Color.Blue,
        style = TextStyle(
            fontWeight = FontWeight.Light,
            textDecoration = if (isHovered) TextDecoration.Underline else TextDecoration.None
        ),
        modifier = Modifier
            .clickable {
                // redireciona para tela de cadastro
            }
            .padding(8.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isHovered = true
                        tryAwaitRelease()
                        isHovered = false
                    }
                )
            }
    )
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    EstoqueTocTheme {
        LoginScreen()
    }
}
