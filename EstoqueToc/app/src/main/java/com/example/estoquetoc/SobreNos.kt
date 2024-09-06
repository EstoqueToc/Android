package com.example.estoquetoc

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Developer(
    val name: String,
    val description: String,
    val imageId: Int
)

@Composable
fun AboutUsScreen() {
    val developers = listOf(
        Developer(
            name = "Arthur Cilliberti",
            description = "Analista de Negócio",
            imageId = R.drawable.arthur
        ),
        Developer(
            name = "Gustavo Andrade",
            description = "Desenvolvedor Back-End e Cloud",
            imageId = R.drawable.gustavo
        ),
        Developer(
            name = "Isabel Fagundes",
            description = "Desenvolvedora Front-End e Android",
            imageId = R.drawable.isabel
        ),
        Developer(
            name = "Jonatha Gabriel",
            description = "Desenvolvedor Front-End.",
            imageId = R.drawable.jhonatta
        ),
        Developer(
            name = "Lúcio Garcia",
            description = "Desenvolvedor Back-End",
            imageId = R.drawable.lucio
        ),
        Developer(
            name = "Raquel Oliveira",
            description = "Analista de QA e UI/UX",
            imageId = R.drawable.raquel
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(Color(0xFFEAAC47), Color(0xFFEAAC89))
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_semfundo),
                contentDescription = "Logo da estoquetoc",
                modifier = Modifier
                    .size(120.dp)
                    .padding(8.dp)
                    .padding(bottom = 8.dp),
            )

            Text(
                text = "Time de Desenvolvedores",
                color = Color.Black,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .shadow(78.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                items(developers) { developer ->
                    DeveloperCard(developer)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
fun DeveloperCard(developer: Developer) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(1.dp)
            .padding(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = developer.imageId),
            contentDescription = "Imagem de ${developer.name}",
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(8.dp)),
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = developer.name,
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(2.dp)
            )
            Text(
                text = developer.description,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AboutUsScreenPreview() {
    AboutUsScreen()
}
