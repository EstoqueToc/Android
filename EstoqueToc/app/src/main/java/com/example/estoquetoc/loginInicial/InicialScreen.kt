package com.example.estoquetoc.LoginInicial

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.estoquetoc.R

val poppins_black = FontFamily(
    Font(R.font.poppins_black)
)

@Composable
fun WelcomeScreen(
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFEFEFEF))
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(color = Color.Transparent)
                .verticalScroll(rememberScrollState())
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_semfundo), // Replace with your actual logo resource
                contentDescription = "Logo",
                modifier = Modifier
                    .size(150.dp)
                    .background(color = Color.Transparent),
                contentScale = ContentScale.Fit // Ajusta a escala da imagem
            )
            Text(
                text = "EstoqueToc",
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                color = Color.DarkGray
            )
        }
        Surface(
            shape = RoundedCornerShape(topStart = 64.dp, topEnd = 64.dp),
            color = Color(0xFFEAAC47),
            modifier = Modifier
                .weight(0.8f)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Bem-Vindo(a)!",
                    fontSize = 42.sp,
                    //fontFamily = poppins_black,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(top = 8.dp, bottom = 24.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Somos o TOC que faltava na sua vida.",
                            fontSize = 14.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black,
                            modifier = Modifier.padding(8.dp)
                        )

                        Spacer(modifier = Modifier.height(32.dp))

                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Button(
                                onClick = {
                                    navController.navigate("login")
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Black,
                                    contentColor = Color.White
                                ),
                                modifier = Modifier
                                    .padding(horizontal = 10.dp)
                                    .width(135.dp),
                            ) {
                                Text(text = "Entrar")
                            }
                            Button(
                                onClick = {
                                    navController.navigate("cadastro_usuario")
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White,
                                    contentColor = Color.Black
                                ),
                                modifier = Modifier
                                    .padding(horizontal = 10.dp)
                                    .width(150.dp),
                            ) {
                                Text(text = "Cadastrar")
                            }
                        }
                    }
                }
            }

        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun InicialScreen() {
//    EstoqueTocTheme {
//        WelcomeScreen(navController = )
//    }
//}
