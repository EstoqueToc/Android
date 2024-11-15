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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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
    SecondImage: Int? = null, // Parâmetro opcional para a segunda imagem
    SecondImageDescription: String? = null, // Descrição opcional
    Titulo: String,
    habilitar: Boolean = false,
    modifier: Modifier = Modifier,
    onFirstClickImage: () -> Unit,
    onSecondClickImage: (() -> Unit)? = null, // Função opcional para o clique na segunda imagem
    Search: String? = null
) {
    val height = if (habilitar) 120.dp else 70.dp
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(StrongOrange, Orange, StrongYellow, Yellow)
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Primeira imagem (obrigatória)
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
                    color = Color.Black
                )
            }

            // Centraliza o título, ajustando o espaçamento dinamicamente
            Text(
                text = Titulo,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.weight(1f), // Centraliza o texto
                textAlign = TextAlign.Center
            )

            // Segunda imagem ou um Spacer para manter o título centralizado
            if (SecondImage != null) {
                Button(
                    onClick = { onSecondClickImage?.invoke() },
                    colors = ButtonDefaults.buttonColors(Color.Transparent)
                ) {
                    Image(
                        painter = painterResource(id = SecondImage),
                        contentDescription = SecondImageDescription ?: "",
                        colorFilter = ColorFilter.tint(Color.Black),
                        modifier = Modifier.size(22.dp)
                    )
                }
            } else {
                Spacer(modifier = Modifier.width(40.dp)) // Ajuste a largura conforme necessário
            }
        }

        // Exibe a barra de busca opcional
        AnimatedVisibility(visible = habilitar, modifier = Modifier.padding(horizontal = 20.dp)) {
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
                    text = Search ?: "Buscar Fornecedor", // Texto padrão caso Search seja nulo
                    color = Color(0x66A35C5C),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

@Preview
@Composable
private fun TopBarPreview() {
    TopBarApp(
        FirstImage = R.drawable.back_icon,
        FirstImageDescription = "Voltar",
        Titulo = "Cadastros",
        habilitar = true,
        onFirstClickImage = { /* Ação do primeiro clique */ },
        Search = "deu certo"
    )
}
