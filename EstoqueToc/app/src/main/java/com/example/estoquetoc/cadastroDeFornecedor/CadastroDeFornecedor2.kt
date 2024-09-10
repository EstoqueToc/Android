package com.example.estoquetoc.cadastroDeFornecedor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
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

class CadastroDeFornecedor2 {

    @Composable
    fun FornecedorScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            TopBar()
            FornecedorForm(modifier = Modifier.weight(1f))
            BottomNavigation()
        }
    }

    @Composable
    fun TopBar() {
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
                text = "Fornecedor",
                color = Color.Black,
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.align(Alignment.Center)
            )

            Image(
                painter = painterResource(id = R.drawable.remove_black_icon),
                contentDescription = "Delete",
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .size(24.dp)
            )
        }
    }

    @Composable
    fun FornecedorForm(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 20.dp)
        ) {
            FormField(label = "Razão Social", value = "Raquel Guimarães")
            Spacer(modifier = Modifier.height(16.dp))
            FormField(label = "Nome Fantasia", value = "Empresa xpto")
            Spacer(modifier = Modifier.height(16.dp))
            FormField(label = "CNPJ", value = "76866732000120")
            Spacer(modifier = Modifier.height(16.dp))
            FormField(label = "Email", value = "raquel@gmail.com")
            Spacer(modifier = Modifier.height(16.dp))
            FormField(label = "Telefone", value = "119851160228")

            Spacer(modifier = Modifier.weight(1f))

            SaveButtonLarger()
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun FormField(label: String, value: String) {
        Column(modifier = Modifier.padding(bottom = 22.dp)) {
            Text(
                text = label,
                color = Color.Black,
                fontSize = 18.sp
            )
            OutlinedTextField(
                value = value,
                onValueChange = { /* TODO: Implement value change */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(3.dp)),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color(0xFFF1F5F4),
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                )
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

    @Composable
    fun SaveButtonLarger() {
        Button(
            onClick = { /* Handle button click */ },
            shape = RoundedCornerShape(3.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE7670A)),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Salvar",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun FornecedorScreenPreview() {
        FornecedorScreen()
    }
}
