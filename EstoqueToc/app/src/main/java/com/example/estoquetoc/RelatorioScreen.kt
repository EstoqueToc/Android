package com.example.estoquetoc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.estoquetoc.componentes.BottomBarApp


@Composable
fun RelatorioScreen(navController: NavController? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)) // Cor de fundo similar à da imagem
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Header
        HeaderRelatorio()


        Card(
            modifier = Modifier.fillMaxWidth(),
           // backgroundColor = Color(0xFFF7F7F7)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text("PATRIMÔNIO EM ESTOQUE", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(8.dp))

                RowInfo(title = "Quantidade em estoque", value = "120", description = "Quantidade total de itens do estoque")
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                RowInfo(title = "Custo total", value = "R\$80000,00", description = "Custo total de produtos em estoque")
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                RowInfo(title = "Produtos Perdidos", value = "35", description = "Quantidade total de itens perdidos")
            }
        }

        // Estoque Card
        Card(
            modifier = Modifier.fillMaxWidth(),
           // backgroundColor = Color(0xFFF7F7F7)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text("ESTOQUE", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ColumnInfo(title = "Estoque mínimo", value = "0")
                    ColumnInfo(title = "Estoque negativo", value = "0")
                }
            }
        }
        BottomBarApp(navController = navController!!)
    }
}

@Composable
fun HeaderRelatorio() {
    // Simulando um gradiente de fundo
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(
                Brush.horizontalGradient(
                    colors = listOf(Color(0xFFFFA726), Color(0xFFFFCC80))
                )
            )
    ) {
        Text(
            text = "Relatórios",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun RowInfo(title: String, value: String, description: String) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(title, fontWeight = FontWeight.Bold)
            Text(value, fontWeight = FontWeight.Bold)
        }
        Text(description, fontSize = 12.sp, color = Color.Gray)

    }
}

@Composable
fun ColumnInfo(title: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = value, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text(text = title, fontSize = 12.sp, color = Color.Gray)
    }
}

@Preview(showBackground = true)
@Composable
fun RelatorioScreenPreview() {
    RelatorioScreen()
}
