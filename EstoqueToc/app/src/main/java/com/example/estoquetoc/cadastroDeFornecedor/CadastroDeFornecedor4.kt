package com.example.estoquetoc.cadastroDeFornecedor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.estoquetoc.R

class CadastroDeFornecedor4 {

    @Composable
    fun FornecedoresScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Header()
            Content()
            Spacer(modifier = Modifier.weight(1f))
            BottomNavigation()
        }
    }

    @Composable
    fun Header() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFD974C))
                .padding(horizontal = 16.dp, vertical = 10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.back_icon),
                        contentDescription = "Back",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Fornecedores",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.adicionar_icon),
                    contentDescription = "Menu",
                    modifier = Modifier.size(24.dp)
                )
            }
            SearchBar()
        }
    }

    @Composable
    fun SearchBar() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .background(Color(0xADF1F5F4), RoundedCornerShape(4.dp))
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.buscar_icon),
                contentDescription = "Search",
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Buscar Fornecedor",
                color = Color(0x57000000),
                fontSize = 14.sp
            )
        }
    }

    @Composable
    fun Content() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.nenhum_registro_encontrado),
                contentDescription = "Content Image",
                modifier = Modifier.size(250.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Nenhum registro encontrado",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }

    @Composable
    fun BottomNavigation() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF262626))
                .padding(7.dp, 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BottomNavigationItem(
                icon = R.drawable.home_icon,
                text = "Início",
                isSelected = false
            )
            BottomNavigationItem(
                icon = R.drawable.add_icon,
                text = "Cadastros",
                isSelected = true
            )
            BottomNavigationItem(
                icon = R.drawable.gestao_icon,
                text = "Gestão",
                isSelected = false
            )
            BottomNavigationItem(
                icon = R.drawable.ajuste_icon,
                text = "Ajustes",
                isSelected = false
            )
        }
    }

    @Composable
    fun BottomNavigationItem(icon: Int, text: String, isSelected: Boolean) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = text,
                modifier = Modifier.size(30.dp)
            )
            Text(
                text = text,
                color = if (isSelected) Color(0xFFFFA726) else Color.White,
                fontSize = 14.sp,
                fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun FornecedoresScreenPreview() {
        FornecedoresScreen()
    }
}
