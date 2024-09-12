package com.example.estoquetoc.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.example.estoquetoc.ui.theme.StrongYellow
import com.example.estoquetoc.ui.theme.Yellow

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
            .padding(start = 0.dp, top = 9.dp, end = 14.dp, bottom = 9.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = onClick,
                colors = ButtonDefaults.buttonColors(Color.Transparent)) {
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
                    color = Color.Black
                )
            }
        }
        Text(
            text = Titulo,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.Black
        )
        Image(
            painter = painterResource(id = SecondImage),
            contentDescription = SecondImageDescription,
            modifier = Modifier.size(22.dp)
        )
    }
}
