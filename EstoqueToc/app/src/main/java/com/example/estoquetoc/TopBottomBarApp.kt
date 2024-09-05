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


@Composable
fun TopBarApp() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(

                )
            )
            .padding(start = 6.dp, top = 9.dp, end = 14.dp, bottom = 9.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.voltar),
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
            painter = painterResource(id = R.drawable.editar),
            contentDescription = "Editar",
            modifier = Modifier.size(22.dp)
        )
    }
}

@Composable
fun BottomBarApp(modifier: Modifier = Modifier) {
    Row (
        Modifier
            .fillMaxWidth()
            .background(color = Color.Black),
        horizontalArrangement = Arrangement.SpaceAround

    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.home),
                contentDescription = "Home",
                Modifier
                    .size(20.dp)
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(text = "Inicio",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.mais),
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
                painter = painterResource(id = R.drawable.gestao),
                contentDescription = "Gestão",
                Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(text = "Gestão",
                color = Color.White,
                fontWeight = FontWeight.Bold)
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.configuracao),
                contentDescription = "Ajustes",
                Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = "Ajustes",
                color = Color.White,
                fontWeight = FontWeight.Bold)
        }
    }
}