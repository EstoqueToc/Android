package com.example.estoquetoc

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.platform.LocalContext
//import com.example.estoquetoc.viewModel.LoginState
import com.example.estoquetoc.viewModel.LoginViewModel
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController? = null) {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var senhaVisivel by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val viewModel = koinViewModel<LoginViewModel>()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background2),
            contentDescription = "Imagem de Fundo com círculos",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(16.dp)
                .background(Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
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
            Text(
                text = "Olá,",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 32.dp),
            )

            Text(
                text = "Entre com sua conta.",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 8.dp, bottom = 16.dp),
            )

            Spacer(modifier = Modifier.height(32.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = senha,
                onValueChange = { senha = it },
                label = { Text("Senha") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = if (senhaVisivel) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon = if (senhaVisivel) Icons.Default.Visibility else Icons.Default.VisibilityOff
                    IconButton(onClick = { senhaVisivel = !senhaVisivel }) {
                        Icon(
                            imageVector = icon,
                            contentDescription = "Toggle password visibility"
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                TextButton(
                    onClick = {
                        navController?.navigate("CadastroUsuarioScreen")
                    }
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color(0xFF262626))) {
                                append("Esqueci minha senha")
                            }
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {
                    if (senha.isEmpty() || email.isEmpty()) {
                        Toast.makeText(
                            context,
                            "Preencha todos os campos",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        viewModel.fazerLogin(context, email, senha) { success ->
                            if (success) {
                                navController?.navigate("faturamento")
                            } else {
                                Toast.makeText(
                                    context,
                                    "Login falhou",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6F00))
            ) {
                Text(
                    text = "Entrar",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(4.dp))
            TextButton(
                onClick = {
                    navController?.navigate("cadastro_usuario")
                }
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color(0xFFFF6F00))) {
                            append("Ainda não possui Conta. ")
                        }
                        withStyle(style = SpanStyle(color = Color(0xFF262626))) {
                            append("Clique aqui para criar uma agora.")
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
