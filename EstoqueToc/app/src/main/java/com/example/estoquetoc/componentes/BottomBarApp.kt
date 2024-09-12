package com.example.estoquetoc.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.estoquetoc.R


@Composable
fun BottomBarApp(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Black),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        BottomBarItem(
            icon = R.drawable.home,
            text = "Inicio",
            onClick = { navController.navigate("inicial_screen") }
        )
        BottomBarItem(
            icon = R.drawable.mais,
            text = "Cadastro",
            onClick = { navController.navigate("produtos_screen") }
        )
        BottomBarItem(
            icon = R.drawable.gestao,
            text = "Gestão",
            onClick = { navController.navigate("faturamento") }
        )
        BottomBarItem(
            icon = R.drawable.configuracao,
            text = "Ajustes",
            onClick = { navController.navigate("dashboard") }
        )
    }
}

@Composable
fun BottomBarItem(icon: Int, text: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable(onClick = onClick)
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = text,
            modifier = Modifier.size(30.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = text,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBottomBarApp() {
    val navController = rememberNavController()
    BottomBarApp(navController = navController)
}
