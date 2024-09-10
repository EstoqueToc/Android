package com.example.estoquetoc.cadastroFuncionario

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.estoquetoc.R
import com.example.estoquetoc.ui.theme.Orange
import com.example.estoquetoc.ui.theme.StrongOrange
import com.example.estoquetoc.ui.theme.Yellow

class CadastroDeFuncionario4 {

    @Preview(showBackground = true)
    @Composable
    fun EmployeeSearch() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            TopBar()
            NoResultsFound()
            Spacer(modifier = Modifier.weight(1f))
            BottomNavigation()
        }
    }

    @Composable
    fun TopBar() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            StrongOrange, Orange, Orange, Yellow, Yellow, Yellow, Yellow
                        )
                    )
                )
                .padding(horizontal = 16.dp, vertical = 10.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.align(Alignment.CenterStart),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.back_icon),
                        contentDescription = "Back",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Voltar",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Text(
                    text = "Funcionários",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.align(Alignment.Center)
                )

                Image(
                    painter = painterResource(id = R.drawable.circle_black_icon),
                    contentDescription = "Add",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .size(24.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            SearchBar()
        }
    }

    @Composable
    fun SearchBar() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFE0CC), RoundedCornerShape(8.dp))
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.buscar_icon),
                contentDescription = "Search",
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Buscar Funcionário",
                color = Color(0x66A35C5C),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }

    @Composable
    fun NoResultsFound() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 37.5.dp, vertical = 37.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.team_spirit_cuate),
                contentDescription = "No Results Found",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Nenhum registro encontrado",
                color = Color.Gray,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }

    @Composable
    fun BottomNavigation() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF262626))
                .padding(horizontal = 30.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BottomNavigationItem("Início", R.drawable.home_icon)
            BottomNavigationItem("Cadastros", R.drawable.add_icon)
            BottomNavigationItem("Gestão", R.drawable.gestao_icon)
            BottomNavigationItem("Ajustes", R.drawable.ajuste_icon)
        }
    }

    @Composable
    fun BottomNavigationItem(label: String, iconResId: Int) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = label,
                modifier = Modifier.size(33.dp)
            )
            Text(
                text = label,
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun EmployeeSearchPreview() {
        EmployeeSearch()
    }
}
