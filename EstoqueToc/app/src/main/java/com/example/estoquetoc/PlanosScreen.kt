package com.example.estoquetoc

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PlanosUI(navController: NavController? = null) {
    // Lista de conteúdos para simular os itens que serão rolados
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
           .padding(4.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Primeiro item com o banner
        item {
            Text(
                text = "Escolha seu Plano Ideal",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                .background(
                        Brush.horizontalGradient(
                            listOf(Color(0xFFEAAC47), Color(0xFFEAAC58))
                        ),
                    shape = RoundedCornerShape(6.dp)
                )
                   .padding(16.dp)
            )
        }
        // Lista de planos
        items(getPlanos()) { plano ->
            PlanoCard(plano)
        }
    }
}

data class Plano(val nome: String, val preco: String, val recursos: List<String>, val imagemResId: Int)

fun getPlanos(): List<Plano> {
    return listOf(
        Plano(
            "Básico", "R$ 29,90/mês",
            listOf("Gerenciamento de Estoque Básico", "Relatórios Simples", "1 Usuário"),
            R.drawable.coracao
        ),
        Plano(
            "Intermediário", "R$ 49,90/mês",
            listOf("Gerenciamento de Estoque Completo", "Relatórios Avançados", "Suporte Prioritário", "3 Usuários"),
            R.drawable.estrela
        ),
        Plano(
            "Avançado", "R$ 99,90/mês",
            listOf("Integração com E-commerce", "Relatórios Detalhados", "Suporte 24/7", "Usuários Ilimitados"),
            R.drawable.diamante
        )
    )
}

@Composable
fun PlanoCard(plano: Plano) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .clickable { /* Lógica de compra ou detalhes do plano */ }
            .padding(4.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(8.dp)
        ) {
            Text(
                text = "OFERTA LIMITADA",
                fontWeight = FontWeight.Bold,
                color = Color(0xFFE0A000),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Row(
            modifier = Modifier
                .background(Color.White)
                .padding(6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = plano.imagemResId),
                contentDescription = "Imagem do plano ${plano.nome}",
                modifier = Modifier
                    .size(64.dp)
                    .padding(end = 20.dp)
            )

            // Nome e informações do plano
            Column(modifier = Modifier.weight(0.9f)) {
                Text(
                    text = plano.nome,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = plano.preco,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                plano.recursos.forEach { recurso ->
                    Text(
                        text = "- $recurso",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }
                Box(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Button(
                        onClick = { /* Lógica para a compra */ },
                        colors = ButtonDefaults.buttonColors(Color(0xFFE0A000)),
                        modifier = Modifier.fillMaxWidth(0.9f)
                            .padding(8.dp)
                    ) {
                        Text(text = "APROVEITE AGORA", color = Color.White)
                    }
                }
            }

        }

    }
}


@Preview(showBackground = true)
@Composable
fun PlanosScreenPreview() {
    PlanosUI()
}
