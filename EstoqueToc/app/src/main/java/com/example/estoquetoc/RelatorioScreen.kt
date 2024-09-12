package com.example.estoquetoc

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.estoquetoc.componentes.BottomBarApp

@Composable
fun RelatoriosScreen(navController: NavController? = null) {

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            HeaderRelatorio(navController)

            // Cartão de patrimônio
            Card(
                modifier = Modifier.fillMaxWidth()
                    .background(color = Color.Transparent),
                ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White, shape = RoundedCornerShape(4.dp))
                        .border(1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            "PATRIMÔNIO EM ESTOQUE",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        RowInfo(
                            title = "Quantidade em estoque",
                            value = "120",
                            description = "Quantidade total de itens do estoque"
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                        RowInfo(
                            title = "Custo total",
                            value = "R\$80000,00",
                            description = "Custo total de produtos em estoque"
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                        RowInfo(
                            title = "Produtos Perdidos",
                            value = "35",
                            description = "Quantidade total de itens perdidos"
                        )
                    }
                }
            }

            // Cartão de estoque
            Card(
                modifier = Modifier.fillMaxWidth()
                    .background(color = Color.Transparent),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White, shape = RoundedCornerShape(4.dp))
                        .border(1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                ){ Column(
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

            // Exibir BottomBarApp apenas se o navController não for nulo
            navController?.let {
                BottomBarApp(navController = it)
            }
        }
    }
}

@Composable
fun HeaderRelatorio(navController: NavController?) {
    // Simulando um gradiente de fundo
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(58.dp)
            .background(
                Brush.horizontalGradient(
                    colors = listOf(Color(0xFFFFA726), Color(0xFFFFCC80))
                )
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(54.dp)
            ) {
            // Ícone de voltar e texto "Voltar"
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable { navController?.navigate("AjusteScreen") }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.voltar),
                    contentDescription = "seta de voltar",
                    modifier = Modifier.size(80.dp),
                    colorFilter = ColorFilter.tint(Color.White)
                )
//                Text(
//                    text = "Voltar",
//                    color = Color.White,
//                    fontSize = 14.sp,
//                    fontWeight = FontWeight.Bold
//                )
            }

            // Título centralizado
            Text(
                text = "Relatórios",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
        // Exibir BottomBarApp apenas se o navController não for nulo
        navController?.let {
            BottomBarApp(navController = it)
        }

    }
}



@Composable
fun RowInfo(title: String, value: String, description: String) {

        Column {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                Text(title, fontWeight = FontWeight.Bold)
                Text(value, fontWeight = FontWeight.Bold)
            }
            Text(description, fontSize = 14.sp, color = Color.Gray)
        }
    }


@Composable
fun ColumnInfo(title: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = value, fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(4.dp))
        Text(text = title, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(4.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun RelatorsScreenPreview() {
    RelatoriosScreen()  // Para preview, navController é null
}
//@Preview(showBackground = true)
//@Composable
//fun RelatorsScreenPreview() {
//    RelatoriosScreen(navController = null)  // Para preview, navController é null
//}