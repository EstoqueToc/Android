package com.example.estoquetoc

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun FaturamentoScreen(navController: NavController? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F3F3))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
       // verticalArrangement = Arrangement.Center
    ) {
        // Faturamento do Mês
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFD07D), shape = RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Column {
                Text(
                    text = "FATURAMENTO DO MÊS",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFB37C00),
                    fontSize = 16.sp
                )
                Text(
                    text = "R\$7542,00",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFB37C00),
                    fontSize = 24.sp
                )
                Text(
                    text = "em vendas concluídas",
                    fontWeight = FontWeight.Light,
                    color = Color(0xFFB37C00),
                    fontSize = 14.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Ferramentas Exclusivas
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFE4B5), shape = RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Row {
                Column {
                    Text(
                        text = "Com o EE Gold, você tem acesso a",
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFFB37C00),
                        fontSize = 14.sp
                    )
                    Text(
                        text = "ferramentas exclusivas que fazem a diferença.",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFB37C00),
                        fontSize = 14.sp
                    )
                    Text(
                        text = "Conheça nossos planos!",
                        fontWeight = FontWeight.Light,
                        color = Color(0xFFB37C00),
                        fontSize = 14.sp
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.setadireita),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Precisa de Ajuda?
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
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
                    .height(120.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Se você ficou com alguma dúvida sobre o aplicativo entre em contato com nosso suporte.",
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* Navegar para a tela de suporte */ },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7D00))
            ) {
                Text(
                    text = "OBTER AJUDA",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 16.sp
                )

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun FaturamentoScreenPreview() {
    FaturamentoScreen()
}
