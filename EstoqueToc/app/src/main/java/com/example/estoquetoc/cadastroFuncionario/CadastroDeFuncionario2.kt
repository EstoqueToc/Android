package com.example.estoquetoc.cadastroFuncionario

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
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

@Composable
fun NewEmployeeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopBarNovoFuncionario()
        EmployeeFormNovoFuncionario(Modifier.weight(1f))
        BottomNavigationNovoFuncionario()
    }
}

@Composable
fun TopBarNovoFuncionario() {
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
            text = "Novo Funcionário",
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
fun EmployeeFormNovoFuncionario(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 22.dp)
    ) {
        FormFieldNovoFuncionario(label = "Nome")
        Spacer(modifier = Modifier.height(32.dp))
        FormFieldNovoFuncionario(label = "CPF")
        Spacer(modifier = Modifier.height(32.dp))
        FormFieldNovoFuncionario(label = "Data de Nascimento")
        Spacer(modifier = Modifier.height(32.dp))
        FormFieldNovoFuncionario(label = "Email")
        Spacer(modifier = Modifier.height(32.dp))
        FormFieldNovoFuncionario(label = "Senha")
        Spacer(modifier = Modifier.height(32.dp))
        FormFieldNovoFuncionario(label = "Função")
    }
}

@Composable
fun FormFieldNovoFuncionario(label: String) {
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
fun BottomNavigationNovoFuncionario() {
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
fun BottomNavigationItemNovoFuncionario(icon: Int, label: String) {
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
fun NewEmployeeScreenPreview() {
    NewEmployeeScreen()
}
