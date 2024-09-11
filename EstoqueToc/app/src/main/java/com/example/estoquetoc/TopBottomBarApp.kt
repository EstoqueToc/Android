package com.example.estoquetoc

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.estoquetoc.ui.theme.Orange
import com.example.estoquetoc.ui.theme.StrongOrange
import com.example.estoquetoc.ui.theme.StrongYellow
import com.example.estoquetoc.ui.theme.Yellow

//@Preview(showBackground = true)
@Composable
fun TopBarApp(
    FirstImage: Int,
    FirstImageDescription: String,
    SecondImage: Int,
    SecondImageDescription: String,
    Titulo: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(StrongOrange, Orange, StrongYellow, Yellow)
                )
            )
            .padding(start = 6.dp, top = 9.dp, end = 14.dp, bottom = 9.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = onClick) {
                Image(
                    painter = painterResource(id = FirstImage),
                    contentDescription = FirstImageDescription,
                    Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(9.dp))
                Text(
                    text = FirstImageDescription,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
        Text(
            text = Titulo,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Image(
            painter = painterResource(id = SecondImage),
            contentDescription = SecondImageDescription,
            modifier = Modifier.size(22.dp)
        )
    }
}


//@Preview(showBackground = true)
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
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(
            StrongOrange
        )

    ) {
        Text(text = text, fontWeight = FontWeight.Bold, fontSize = 20.sp)
    }
}


//@Preview
@Composable
 fun Testando(navController: NavController) {

    Produtos(
        icon = R.drawable.box_icon,
        DescIcon = "Box",
        DescriptionProduct = "Produto XX",
        QtdEmEstoque = "Quantidade: 008",
        enable = true,
        valor = "R$ 25,00",
        onClick = {navController.navigate("cadastro_produto")}
    )
}

@Composable
fun Produtos(
    icon: Int,
    DescIcon: String,
    DescriptionProduct: String,
    QtdEmEstoque: String,
    enable: Boolean = false,
    valor: String = "",
    onClick: () -> Unit
) {
    var produto by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = icon),
                        contentDescription = DescIcon,
                        modifier = Modifier.size(40.dp)
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Column {
                        Text(
                            text = DescriptionProduct,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = QtdEmEstoque,
                            color = Color.Gray,
                            fontSize = 12.sp
                        )
                    }
                }
                AnimatedVisibility(
                    visible = enable,
                    enter = fadeIn(tween(500)),
                    exit = fadeOut(tween(500))
                ) {
                    Text(
                        text = valor,
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                }
            }
        }
        Spacer(modifier = Modifier.size(10.dp))
    }
}
