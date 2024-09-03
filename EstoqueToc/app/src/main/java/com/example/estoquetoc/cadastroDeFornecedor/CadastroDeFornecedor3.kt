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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.estoquetoc.R

class CadastroDeFornecedor3 {

    @Composable
    fun FornecedorList() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            TopBarFornecedores()
            SearchBar()
            FornecedorItem("Raquel Guimarães", "Empresa XPTO")
            CustomDivider()
            FornecedorItem("Arthur", "Empresa ABC")
            CustomDivider()
            Spacer(modifier = Modifier.weight(1f))
            BottomNavigation()
        }
    }

    @Composable
    fun TopBarFornecedores() {
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
                    text = "Fornecedores",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                )
            }
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
                text = "Buscar Fornecedor",
                color = Color(0x57000000),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }

    @Composable
    fun FornecedorItem(name: String, companyName: String) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.usuario),
                contentDescription = "Supplier Avatar",
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
                    text = companyName,
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
    fun FornecedorListPreview() {
        FornecedorList()
    }
}
