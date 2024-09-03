package com.example.estoquetoc.cadastroFuncionario

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.estoquetoc.R

class CadastroDeFuncionarios3 {

    @Composable
    fun EmployeeList() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            TopBarFuncionarios()
            SearchBar()
            EmployeeItem("Raquel Guimarães", "Função")
            CustomDivider()
            EmployeeItem("Arthur Ciliberti", "Função")
            CustomDivider()
            Spacer(modifier = Modifier.weight(1f))
            BottomNavigation()
        }
    }

    @Composable
    fun TopBarFuncionarios() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFD974C))
                .padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.back_icon),
                    contentDescription = "Back",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(9.dp))
                Text(
                    text = "Voltar",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Text(
                text = "Funcionários",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
            Image(
                painter = painterResource(id = R.drawable.adicionar_icon),
                contentDescription = "Add",
                modifier = Modifier.size(24.dp)
            )
        }
    }

    @Composable
    fun SearchBar() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .background(Color(0xFFF1F5F4), RoundedCornerShape(4.dp))
                .padding(8.dp),
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
                color = Color(0x57000000),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }

    @Composable
    fun EmployeeItem(name: String, role: String) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.usuario),
                contentDescription = "Employee Avatar",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = role,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Gray
                )
            }
        }
    }

    @Composable
    fun CustomDivider() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.Gray)
        )
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
    fun EmployeeListPreview() {
        EmployeeList()
    }
}
