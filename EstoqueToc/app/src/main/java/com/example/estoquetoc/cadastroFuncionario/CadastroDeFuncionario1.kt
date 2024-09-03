package com.example.estoquetoc.cadastroFuncionario

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditEmployeeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopBar()
        EditForm(Modifier.weight(1f))
        BottomNavigation()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
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
            text = "Editar Funcionário",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Image(
            painter = painterResource(id = R.drawable.edit_icon),
            contentDescription = "Edit",
            modifier = Modifier.size(24.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditForm(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 30.dp)
    ) {
        FormField(label = "Nome")
        Spacer(modifier = Modifier.height(30.dp))
        FormField(label = "CPF")
        Spacer(modifier = Modifier.height(30.dp))
        FormField(label = "Data de Nascimento", isDatePicker = true)
        Spacer(modifier = Modifier.height(30.dp))
        FormField(label = "Email")
        Spacer(modifier = Modifier.height(30.dp))
        FormField(label = "Senha", isPassword = true)
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { /* TODO: Handle save */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clip(RoundedCornerShape(8.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE7670A))
        ) {
            Text(
                text = "Salvar",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormField(label: String, isDatePicker: Boolean = false, isPassword: Boolean = false) {
    Text(
        text = label,
        color = Color.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium
    )
    OutlinedTextField(
        value = "",
        onValueChange = { /* TODO: Handle input change */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color(0xFFF1F5F4)
        ),
        trailingIcon = {
            if (isDatePicker) {
                Image(
                    painter = painterResource(id = R.drawable.calendar_icon),
                    contentDescription = "Select date",
                    modifier = Modifier.size(19.dp)
                )
            } else if (isPassword) {
                Image(
                    painter = painterResource(id = R.drawable.eye_icon),
                    contentDescription = "Toggle password visibility",
                    modifier = Modifier.size(19.dp)
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigation() {
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

@OptIn(ExperimentalMaterial3Api::class)
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
            fontSize = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EditEmployeeScreenPreview() {
    EditEmployeeScreen()
}
