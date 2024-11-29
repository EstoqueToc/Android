package com.example.estoquetoc

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController? = null) {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var senhaVisivel by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background2),
            contentDescription = "Imagem de Fundo com círculos",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(16.dp)
                .background(Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Cabeçalho
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 36.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_semfundo),
                    contentDescription = "Logo Estoquetoc",
                    modifier = Modifier.size(56.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Estoquetoc",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }

            // Texto de boas-vindas
            Text(
                text = "Olá,",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 38.dp)
            )

            Text(
                text = "Entre com sua conta.",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 8.dp, bottom = 16.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Campo de email
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Campo de senha
            OutlinedTextField(
                value = senha,
                onValueChange = { senha = it },
                label = { Text("Senha") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = if (senhaVisivel) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { senhaVisivel = !senhaVisivel }) {
                        Icon(
                            imageVector = if (senhaVisivel) Icons.Filled.CheckCircle else Icons.Filled.Clear,
                            contentDescription = "Alternar visibilidade da senha"
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextButton(onClick = {
                navController?.navigate("CadastroUsuarioScreen")
            }) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color(0xFF262626))) {
                            append("Esqueci minha senha")
                        }
                    }
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Botão Entrar
            Button(
                onClick = {
                    if (email.isEmpty() || senha.isEmpty()) {
                        errorMessage = "Preencha todos os campos"
                    } else {
                        navController?.navigate("faturamento")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .testTag("botaoEntrar"),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF6F00)
                )
            ) {
                Text("Entrar", color = Color.White)
            }

            // Exibição de mensagem de erro
            if (errorMessage.isNotEmpty()) {
                Snackbar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .testTag("snackbarErro"),
                    message = errorMessage
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            // Botão para criar conta
            TextButton(onClick = { navController?.navigate("cadastro_usuario") }) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color(0xFF262626))) {
                            append("Não possui Conta?")
                        }
                        append(" ")
                        withStyle(
                            style = SpanStyle(
                                color = Color(0xFFFF6F00),
                                textDecoration = TextDecoration.Underline,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append("Clique aqui para criar uma agora.")
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun Snackbar(modifier: Modifier = Modifier, message: String, action: (() -> Unit)? = null) {
    androidx.compose.material3.Snackbar(
        action = {
            action?.let {
                TextButton(onClick = it) {
                    Text(text = "OK", color = Color.White)
                }
            }
        },
        containerColor = Color(0xFF333333),
        modifier = modifier
    ) {
        Text(message, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}

