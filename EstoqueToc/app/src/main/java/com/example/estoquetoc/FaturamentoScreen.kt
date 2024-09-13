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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.estoquetoc.componentes.BottomBarApp


@Composable
fun FaturamentoScreen(navController: NavController? = null) {
    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF3F3F3)),
            //.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            // verticalArrangement = Arrangement.Center
        ) {
            // Faturamento do Mês
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
                        Spacer(
                            modifier = Modifier.width(300.dp)
                        ) // Espaço entre as imagens
                        Image(
                            painter = painterResource(id = R.drawable.notificacao),
                            contentDescription = "Imagem de um sino",
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
                        text = "R\$7542,00",
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

            Spacer(modifier = Modifier.height(24.dp))

            // Ferramentas Exclusivas
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
                        contentDescription = "Imagem de uma mão segurando estrelas",
                        modifier = Modifier
                            .size(40.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
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
                            textAlign = TextAlign.Justify
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(id = R.drawable.seta_direita),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Color(0xFFFFFFFF)),
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Precisa de Ajuda?
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
                        text = "Se você ficou com alguma dúvida sobre o aplicativo entre em contato com nosso suporte.",
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF262626),
                        fontSize = 14.sp,
                        textAlign = TextAlign.Justify
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { /* Navegar para a tela de suporte */ },
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
                // Exibir BottomBarApp apenas se o navController não for nulo


            }
        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)){
            BottomBarApp(navController = navController!!)
        }
    }

}

//@Preview(showBackground = true)
//@Composable
//fun FaturamentoScreenPreview() {
//    FaturamentoScreen()
//}

@Preview(showBackground = true)
@Composable
fun FaturamentoScreenPreview() {
    FaturamentoScreen(navController = null)  // Para preview, navController é null
}