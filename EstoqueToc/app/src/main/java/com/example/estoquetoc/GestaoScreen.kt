package com.example.estoquetoc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.estoquetoc.componentes.BottomBarApp

@Composable
fun GestaoScreen(navController: NavController? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFEAAC47))
                .padding(16.dp)
        ) {
            Text(
                text = "Gestão",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GestaoItem(
                iconId = R.drawable.relatorioprodutos,
                title = "Consultar Estoque",
                description = ""
            )
            Spacer(modifier = Modifier.height(2.dp))
            GestaoItem(
                iconId = R.drawable.relatoriogeral,
                title = "Relatórios",
                description = ""
            )

            Spacer(modifier = Modifier.height(16.dp))
            Navigation(navController) // Chama a BottomBarApp
        }
    }
}

@Composable
fun Navigation(navController: NavController?) {
    // Implementa a BottomBarApp aqui
    navController?.let {
        BottomBarApp(navController = it)
    }
}

@Composable
fun GestaoItem(iconId: Int, title: String, description: String) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(8.dp)),
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 4.dp,
        color = Color.White
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = iconId),
                contentDescription = "Icone de $title",
                modifier = Modifier
                    .size(48.dp)
                    .padding(3.dp),
                tint = Color(0xFFEAAC47)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF6D4C41)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = description,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GestaoScreenPreview() {
    GestaoScreen(navController = null)  // Para preview, navController é null
}
