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
            text = "Editar Funcionário",
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

        SaveButtonLarger()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormField(label: String, isDatePicker: Boolean = false, isPassword: Boolean = false) {
    Text(
        text = label,
        color = Color.Black,
        fontSize = 18.sp,
    )
    OutlinedTextField(
        value = "",
        onValueChange = { /* TODO: Handle input change */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        shape = RoundedCornerShape(3.dp),
//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            containerColor = Color(0xFFF1F5F4),
//            unfocusedBorderColor = Color.Transparent,
//            focusedBorderColor = Color.Transparent
//        ),
        trailingIcon = {
            if (isDatePicker) {
                Image(
                    painter = painterResource(id = R.drawable.calendario_icon),
                    contentDescription = "Select date",
                    modifier = Modifier.size(19.dp)
                )
            } else if (isPassword) {
                Image(
                    painter = painterResource(id = R.drawable.eye_transp_icon),
                    contentDescription = "Toggle password visibility",
                    modifier = Modifier.size(19.dp)
                )
            }
        }
    )
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigation() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF262626)) // Cor preta
            .padding(horizontal = 30.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BottomNavigationItem("Início", R.drawable.home_icon)
        BottomNavigationItem("Cadastros", R.drawable.add_icon)
        BottomNavigationItem("Gestão", R.drawable.gestao_icon)
        BottomNavigationItem("Ajustes", R.drawable.ajuste_icon)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
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
fun EditEmployeeScreenPreview() {
    EditEmployeeScreen()
}
