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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.estoquetoc.R
import com.example.estoquetoc.TopBarApp

class CadastroDeFornecedor1 {
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
                text = "Novo Fornecedor",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Salvar",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
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
            FormFieldFornecedor(label = "Razão Social")
            Spacer(modifier = Modifier.height(32.dp))
            FormFieldFornecedor(label = "Nome Fantasia")
            Spacer(modifier = Modifier.height(32.dp))
            FormFieldFornecedor(label = "CNPJ")
            Spacer(modifier = Modifier.height(32.dp))
            FormFieldFornecedor(label = "Email")
            Spacer(modifier = Modifier.height(32.dp))
            FormFieldFornecedor(label = "Telefone")
        }
    }

    @Composable
    fun FormFieldFornecedor(label: String) {
        Text(
            text = label,
            color = Color.Black,
            fontSize = 18.sp
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(Color(0xFFF1F5F4))
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
            BottomNavigationItem(icon = R.drawable.home_icon, label = "Início")
            BottomNavigationItem(icon = R.drawable.add_icon, label = "Cadastros")
            BottomNavigationItem(icon = R.drawable.gestao_icon, label = "Gestão")
            BottomNavigationItem(icon = R.drawable.ajuste_icon, label = "Ajustes")
        }
    }

    @Composable
    fun BottomNavigationItem(icon: Int, label: String) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = icon),
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
