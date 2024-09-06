package com.example.estoquetoc

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.estoquetoc.ui.theme.Orange
import com.example.estoquetoc.ui.theme.StrongOrange
import com.example.estoquetoc.ui.theme.Yellow

@Composable
fun TopBarApp() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        StrongOrange, Orange, Orange, Yellow, Yellow, Yellow, Yellow
                    )
                )
            )
            .padding(start = 6.dp, top = 9.dp, end = 14.dp, bottom = 9.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.back_icon),
                contentDescription = "Back",
                Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(9.dp))
            Text(
                text = "Voltar",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
            )
        }
        Text(
            text = "Novo Produto",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Image(
            painter = painterResource(id = R.drawable.edit_icon),
            contentDescription = "Editar",
            modifier = Modifier.size(22.dp)
        )
    }
}

@Composable
fun BottomBarApp(modifier: Modifier = Modifier) {
    Row(
        Modifier
            .fillMaxWidth()
            .background(color = Color.Black),
        horizontalArrangement = Arrangement.SpaceAround

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.home_icon),
                contentDescription = "Home",
                Modifier
                    .size(20.dp)
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = "Inicio",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.add_icon),
                contentDescription = "Cadastro",
                Modifier
                    .size(20.dp)
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = "Cadastro",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.gestao_icon),
                contentDescription = "Gestão",
                Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = "Gestão",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ajuste_icon),
                contentDescription = "Ajustes",
                Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = "Ajustes",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun CompButton(
    onClickAction: () -> Unit,
    text: String
) {
    Button(
        onClick = onClickAction,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(0.dp),
        colors = ButtonDefaults.buttonColors(
            StrongOrange
        )

    ) {
        Text(text = text, fontWeight = FontWeight.Bold, fontSize = 20.sp)
    }
}