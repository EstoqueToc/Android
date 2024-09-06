package com.example.estoquetoc

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RelatorioScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFF0F0F0)) // Cor de fundo clara
    ) {
        Text(
            text = "Relatórios",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Estatísticas
        Column(modifier = Modifier.fillMaxWidth()) {
            EstatisticaCard(title = "Quantidade Total em Estoque", value = "1200")
            Spacer(modifier = Modifier.height(8.dp))
            EstatisticaCard(title = "Custo Total dos Produtos em Estoque", value = "R$8000,00")
            Spacer(modifier = Modifier.height(8.dp))
            EstatisticaCard(title = "Produtos Perdidos em Estoque", value = "35")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Lista de Relatórios
        Text(
            text = "Relatórios Detalhados",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF00796B)
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Exemplo de uma lista de relatórios
        Column(modifier = Modifier.fillMaxWidth()) {
            RelatorioItem(title = "Relatório de Vendas", date = "01/09/2024")
            Spacer(modifier = Modifier.height(4.dp))
            RelatorioItem(title = "Relatório de Compras", date = "02/09/2024")
            Spacer(modifier = Modifier.height(4.dp))
            RelatorioItem(title = "Relatório de Inventário", date = "03/09/2024")
        }
    }
}

@Composable
fun EstatisticaCard(title: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = MaterialTheme.shapes.small)
            .padding(16.dp)
            .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small)
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = value,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun RelatorioItem(title: String, date: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White, shape = MaterialTheme.shapes.small)
            .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(start = 8.dp),
            fontSize = 16.sp
        )
        Text(
            text = date,
            modifier = Modifier.padding(end = 8.dp),
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RelatorioScreenPreview() {
    RelatorioScreen()
}
