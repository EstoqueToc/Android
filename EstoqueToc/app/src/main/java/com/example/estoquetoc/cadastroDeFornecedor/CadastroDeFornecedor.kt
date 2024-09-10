package com.example.estoquetoc.cadastroDeFornecedor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.estoquetoc.R
import com.example.estoquetoc.ui.theme.Orange
import com.example.estoquetoc.ui.theme.StrongOrange
import com.example.estoquetoc.ui.theme.Yellow

class CadastroDeFornecedor {

    @Composable
    fun NewSupplierScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            TopBarNovoFornecedor()
            SupplierForm(Modifier.weight(1f))
            BottomNavigationNovoFornecedor()
        }
    }

    @Composable
    fun TopBarNovoFornecedor() {
        Box(
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
            // Ícone de Voltar
            Row(
                modifier = Modifier.align(Alignment.CenterStart),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back_icon),
                    contentDescription = "Back",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(9.dp))
                Text(
                    text = "Voltar",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Text(
                text = "Novo Fornecedor",
                color = Color.Black,
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.align(Alignment.Center)
            )

            Text(
                text = "Salvar",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
    }

    @Composable
    fun SupplierForm(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 22.dp)
        ) {
            FormFieldFornecedor(label = "CEP")
            Spacer(modifier = Modifier.height(32.dp))
            FormFieldFornecedor(label = "Rua")
            Spacer(modifier = Modifier.height(32.dp))
            FormFieldFornecedor(label = "Número")
            Spacer(modifier = Modifier.height(32.dp))
            FormFieldFornecedor(label = "Cidade")
        }
    }

    @Composable
    fun FormFieldFornecedor(label: String) {
        Text(
            text = label,
            color = Color.Black,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(Color(0xFFF1F5F4))
                .padding(horizontal = 16.dp)
        )
    }

    @Composable
    fun BottomNavigationNovoFornecedor() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF262626))
                .padding(horizontal = 30.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BottomNavigationItemNovoFornecedor("Início", R.drawable.home_icon)
            BottomNavigationItemNovoFornecedor("Cadastros", R.drawable.add_icon)
            BottomNavigationItemNovoFornecedor("Gestão", R.drawable.gestao_icon)
            BottomNavigationItemNovoFornecedor("Ajustes", R.drawable.ajuste_icon)
        }
    }

    @Composable
    fun BottomNavigationItemNovoFornecedor(label: String, iconResId: Int) {
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
    fun NewSupplierScreenPreview() {
        NewSupplierScreen()
    }
}
