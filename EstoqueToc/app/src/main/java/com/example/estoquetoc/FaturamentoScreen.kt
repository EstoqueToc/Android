package com.example.estoquetoc

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.estoquetoc.componentes.BottomBarApp

@Composable
fun FaturamentoScreen(navController: NavController? = null) {
    // Verifique se navController é nulo
    if (navController == null) {
        Log.e("Navigation", "NavController is null!")
        return
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF3F3F3))
                .verticalScroll(rememberScrollState()), // Habilita a rolagem
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FaturamentoMesSection()
            Spacer(modifier = Modifier.height(24.dp))
            FerramentasExclusivasSection(navController)
            Spacer(modifier = Modifier.height(24.dp))
            PrecisaDeAjudaSection(navController)

            // Adiciona o espaçamento para o botão "Obter Ajuda"
            Spacer(modifier = Modifier.height(80.dp)) // Espaço para o botão não ficar colado na borda
        }

        // Agora o botão está dentro da coluna e pode rolar com ela
        Button(
            onClick = { navController?.navigate("AjudaScreen") },
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .align(Alignment.BottomCenter), // Alinha o botão no final da tela
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7D00))
        ) {
            Text(
                text = "OBTER AJUDA",
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                fontSize = 16.sp
            )
        }

        // Navegação com BottomBar
        navController.let {
            Box(modifier = Modifier.align(Alignment.BottomCenter)) {
                BottomBarApp(navController = it)
            }
        }
    }
}



@Composable
fun FaturamentoMesSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFD07D))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.perfil),
                    contentDescription = "Imagem de perfil",
                    modifier = Modifier.size(16.dp),
                    colorFilter = ColorFilter.tint(Color(0xFFFFFFFF))
                )
                Spacer(modifier = Modifier.width(300.dp))
                Image(
                    painter = painterResource(id = R.drawable.notificacao),
                    contentDescription = "Imagem de notificação",
                    modifier = Modifier.size(16.dp)
                )
            }
            Text(
                text = "FATURAMENTO DO MÊS",
                fontWeight = FontWeight.Bold,
                color = Color(0xFFE7670A),
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
            Text(
                text = "R$ 9.343,67",
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFFFFFF),
                fontSize = 24.sp,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = "em vendas concluídas",
                fontWeight = FontWeight.Light,
                color = Color(0xFFE7670A),
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun FerramentasExclusivasSection(navController: NavController? = null) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .background(Color(0xFFFFE4B5), shape = RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.maoestrelas),
                contentDescription = "Imagem de uma mão com estrelas",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(
                    text = "Com o EE Gold, você tem acesso a",
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFB37C00),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Justify
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "ferramentas exclusivas que fazem",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFB37C00),
                    fontSize = 12.sp,
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "a diferença.",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFB37C00),
                    fontSize = 12.sp,
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Conheça nossos planos!",
                    fontWeight = FontWeight.Light,
                    color = Color(0xFFB37C00),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Justify,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.clickable(onClick = {
                        try {
                            navController?.navigate("planos")
                        } catch (e: Exception) {
                            Log.e("Erro na navegação", "Erro ao tentar navegar: ${e.message}")
                        }
                    })
                )
            }

            }

        }
    }


@Composable
fun PrecisaDeAjudaSection(navController: NavController? = null) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "PRECISA DE AJUDA?",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            painter = painterResource(id = R.drawable.ajuda),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth(0.9f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Se você ficou com alguma dúvida sobre o aplicativo, entre em contato com nosso suporte.",
                fontWeight = FontWeight.Normal,
                color = Color(0xFF262626),
                fontSize = 14.sp,
                textAlign = TextAlign.Justify
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController?.navigate("ajuda") },
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier.fillMaxWidth(0.9f),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7D00))
        ) {
            Text(
                text = "OBTER AJUDA",
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FaturamentoScreenPreview() {
    val navController = rememberNavController()
    FaturamentoScreen(navController = navController)
}
