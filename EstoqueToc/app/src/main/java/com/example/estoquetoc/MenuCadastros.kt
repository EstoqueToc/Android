package com.example.estoquetoc

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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

@Composable
fun MenuCadastros(navController: NavController? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
           // .clip(RoundedCornerShape(topStart = 14.dp, topEnd = 14.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFEAAC47))
                .padding(16.dp)
        ) {
            Text(
                text = "Cadastros",
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
            CadastroItem(
                iconId = R.drawable.produto,
                title = "Produtos",
                description = "Cadastre seus produtos para controle do seu estoque."
            )
            Spacer(modifier = Modifier.height(2.dp))
            CadastroItem(
                iconId = R.drawable.funcionario, // Substitua pelo seu ícone
                title = "Funcionários",
                description = "Cadastre seus funcionários para gerenciar seus acessos."
            )
            Spacer(modifier = Modifier.height(2.dp)) // Espaço entre os itens
            CadastroItem(
                iconId = R.drawable.fornecedor, // Substitua pelo seu ícone
                title = "Fornecedores",
                description = "Cadastre seus fornecedores para uma melhor gestão."
            )
            Spacer(modifier = Modifier.height(2.dp)) // Espaço entre os itens
            CadastroItem(
                iconId = R.drawable.categoria, // Substitua pelo seu ícone
                title = "Categorias",
                description = "Cadastre categorias para facilitar a visualização dos seus produtos."
            )
            Spacer(modifier = Modifier.height(16.dp))
            BottomNavigation(navController)
        }
    }
}

@Composable
fun BottomNavigation(navController: NavController?) {
    // Implementação da navegação inferior
}

@Composable
fun CadastroItem(iconId: Int, title: String, description: String) {
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
                modifier = Modifier.size(48.dp)
                    .padding(3.dp),
                tint = Color(0xFFEAAC47)
            )
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
            }
        }
      //  BottomBarApp(navController = navController!!)
    }
}

@Preview(showBackground = true)
@Composable
fun MenuCadastroPreview() {
    MenuCadastros()
}