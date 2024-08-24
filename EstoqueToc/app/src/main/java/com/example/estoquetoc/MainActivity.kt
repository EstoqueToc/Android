package com.example.estoquetoc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.estoquetoc.ui.theme.EstoqueTocTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EstoqueTocTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var loginMessage by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFEAAC47))
            .padding(16.dp),
            verticalArrangement = Arrangement.Center
    )
    {
        Spacer(modifier = Modifier.height(16.dp))
        Logo(
            modifier = Modifier.size(150.dp)
                .width(150.dp)
        ) {
            Text("LOGO.PNG")
        }
        Box(
            modifier = Modifier.fillMaxWidth()
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
                modifier = Modifier.fillMaxWidth()
                    .background(
                        color = Color.White
                    )
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier.fillMaxWidth()
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
                modifier = Modifier.fillMaxWidth()
                    .background(
                        color = Color.White
                    ),
                visualTransformation = PasswordVisualTransformation()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (username == "admin" && password == "admin") {
                    loginMessage = "Login realizado"
                } else {
                    loginMessage = "E-mail ou senha inválido(s)"
                }
            },
            modifier = Modifier.width(150.dp)
        ) {
            Text("Login")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = loginMessage)
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    EstoqueTocTheme {
        LoginScreen()
    }
}
