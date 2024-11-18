package com.example.estoquetoc

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.estoquetoc.componentes.BottomBarApp

@Composable
fun PlanosUI(navController: NavController) {
    // Tela principal com espaçamento e alinhamento
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // Título no topo
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
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(16.dp)
        )
        Spacer(modifier = Modifier.padding(40.dp))
        // Lista de planos (área rolável)
        LazyColumn(
            modifier = Modifier
                .weight(1f) // Permite que a lista ocupe o espaço restante
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp), // Espaçamento entre itens
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(getPlanos()) { plano ->
                PlanoCard(plano)
            }
        }

        // Barra inferior fixada no final da tela
        BottomBarApp(navController = navController)
    }
}


data class Plano(val nome: String, val preco: String, val recursos: List<String>, val imagemResId: Int)

fun getPlanos(): List<Plano> {
    return listOf(
        Plano(
            "Gold", "\n1° Mês Gratuito \n\nA partir do seguindo mês no valor de \n\nR$ 49,90/mês\n",
            listOf(
                "Gerenciamento de Estoque Completo",
                "Cadastro de Produto opr Codigo de Barras",
                "Relatórios Avançados", "Suporte Prioritário",
                "Suporte 24/7",
                "Usuários Ilimitados"
            ),
            R.drawable.estrela
        )
    )
}

@Composable
fun PlanoCard(plano: Plano) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clickable { /* Lógica de compra ou detalhes do plano */ }
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
        ) {
            Text(
                text = plano.nome,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = plano.preco,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            plano.recursos.forEach { recurso ->
                Text(
                    text = "- $recurso",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }

            Button(
                onClick = { /* Lógica para a compra */ },
                colors = ButtonDefaults.buttonColors(Color(0xFFE0A000)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Text(text = "APROVEITE AGORA", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlanosScreenPreview() {
    val navController = rememberNavController() // Criação de um NavController válido
    PlanosUI(navController = navController)
}