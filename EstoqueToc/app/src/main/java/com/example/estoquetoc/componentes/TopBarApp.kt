package com.example.estoquetoc.componentes

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.estoquetoc.R
import com.example.estoquetoc.ui.theme.Orange
import com.example.estoquetoc.ui.theme.StrongOrange
import com.example.estoquetoc.ui.theme.StrongYellow
import com.example.estoquetoc.ui.theme.Yellow


@Composable
fun TopBarApp(
    FirstImage: Int,
    FirstImageDescription: String,
    SecondImage: Int,
    SecondImageDescription: String,
    Titulo: String,
    habilitar: Boolean = false,
    modifier: Modifier = Modifier,
    onFirstClickImage: () -> Unit,
    onSecondClickImage: () -> Unit

) {
    val height = if(habilitar) 120 else 70
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(height.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(StrongOrange, Orange, StrongYellow, Yellow)
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Button(
                    onClick = onFirstClickImage,
                    colors = ButtonDefaults.buttonColors(Color.Transparent)
                ) {
                    Image(
                        painter = painterResource(id = FirstImage),
                        contentDescription = FirstImageDescription,
                        colorFilter = ColorFilter.tint(Color.Black),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(9.dp))
                    Text(
                        text = FirstImageDescription,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
            }
            Text(
                text = Titulo,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White
            )
            Button(
                modifier = Modifier.padding(horizontal = 2.dp),
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                onClick = onSecondClickImage
            ) {
                Image(
                    painter = painterResource(id = SecondImage),
                    contentDescription = SecondImageDescription,
                    colorFilter = ColorFilter.tint(Color.Black),
                    modifier = Modifier.size(22.dp)
                )
            }
        }

        AnimatedVisibility(visible = habilitar,
            modifier= Modifier.padding(horizontal = 20.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFFE0CC), RoundedCornerShape(8.dp))
                    .padding(horizontal = 10.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.buscar_icon),
                    contentDescription = "Search",
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Buscar Fornecedor",
                    color = Color(0x66A35C5C),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}
