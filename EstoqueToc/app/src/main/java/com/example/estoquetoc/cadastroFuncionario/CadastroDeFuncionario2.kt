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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.estoquetoc.R
import com.example.estoquetoc.ui.theme.Orange
import com.example.estoquetoc.ui.theme.StrongOrange
import com.example.estoquetoc.ui.theme.Yellow

@OptIn(ExperimentalMaterial3Api::class)
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarNovoFuncionario() {
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
            text = "Novo Funcionário",
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmployeeFormNovoFuncionario(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 22.dp, horizontal = 16.dp)
    ) {
        FormFieldNovoFuncionario(label = "Nome")
        Spacer(modifier = Modifier.height(32.dp))
        FormFieldNovoFuncionario(label = "CPF")
        Spacer(modifier = Modifier.height(32.dp))
        FormFieldNovoFuncionario(label = "Data de Nascimento", isDatePicker = true)
        Spacer(modifier = Modifier.height(32.dp))
        FormFieldNovoFuncionario(label = "Email")
        Spacer(modifier = Modifier.height(32.dp))
        FormFieldNovoFuncionario(label = "Senha", isPassword = true)
        Spacer(modifier = Modifier.height(32.dp))
        FormFieldNovoFuncionario(label = "Função")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormFieldNovoFuncionario(label: String, isDatePicker: Boolean = false, isPassword: Boolean = false) {
    Column(modifier = Modifier.padding(bottom = 8.dp)) {
        Text(
            text = label,
            color = Color.Black,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        OutlinedTextField(
            value = "",
            onValueChange = { /* TODO: Handle input change */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(3.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0xFFF1F5F4),
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent
            ),
            trailingIcon = {
                if (isDatePicker) {
                    Image(
                        painter = painterResource(id = R.drawable.calendario_icon),
                        contentDescription = "Selecionar Data",
                        modifier = Modifier.size(24.dp)
                    )
                } else if (isPassword) {
                    Image(
                        painter = painterResource(id = R.drawable.eye_transp_icon),
                        contentDescription = "Mostrar/Ocultar Senha",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        )
    }
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
        BottomNavigationItemNovoFuncionario("Início", R.drawable.home_icon)
        BottomNavigationItemNovoFuncionario("Cadastros", R.drawable.add_icon)
        BottomNavigationItemNovoFuncionario("Gestão", R.drawable.gestao_icon)
        BottomNavigationItemNovoFuncionario("Ajustes", R.drawable.ajuste_icon)
    }
}

@Composable
fun BottomNavigationItemNovoFuncionario(label: String, iconResId: Int) {
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
fun NewEmployeeScreenPreview() {
    NewEmployeeScreen()
}
