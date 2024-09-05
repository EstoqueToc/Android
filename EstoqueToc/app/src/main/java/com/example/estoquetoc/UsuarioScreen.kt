package com.example.estoquetoc

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFFFA726), Color(0xFFFFB74D))
                )
            )
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // Top user info section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.usuario),
                contentDescription = "User Icon",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color.White)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text("Raquel Guimarães", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("Administrador", fontSize = 14.sp, color = Color.Gray)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Buttons section
        Button(
            onClick = { /* TODO: Guia action */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            )
            ) {
            Text("Guia", color = Color.White, fontSize = 16.sp)
        }

        Button(
            onClick = { /* TODO: Logout action */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            )) {
            Text("Logout", color = Color.White, fontSize = 16.sp)
        }
    }
}

@Composable
fun UserDetailsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFFFA726), Color(0xFFFFB74D))
                )
            )
    ) {
        // Top bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Voltar", color = Color(0xFFFF9800), fontSize = 18.sp, modifier = Modifier.clickable { /* TODO: Back action */ })
            Text("Salvar", color = Color(0xFFFF9800), fontSize = 18.sp, modifier = Modifier.clickable { /* TODO: Save action */ })
        }

        Spacer(modifier = Modifier.height(16.dp))

        // User information
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.usuario),
                contentDescription = "User Icon",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color.White)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text("Administrador", fontSize = 16.sp, color = Color.Gray)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Input fields
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Nome", fontSize = 14.sp, color = Color.Gray)
            TextField(
                value = "Raquel Guimarães",
                onValueChange = {},
                enabled = false,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text("Email", fontSize = 14.sp, color = Color.Gray)
            TextField(
                value = "rasousa555@gmail.com",
                onValueChange = {},
                enabled = false,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text("Função", fontSize = 14.sp, color = Color.Gray)
            TextField(
                value = "xxxxx",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Delete account button
        Button(
            onClick = { /* TODO: Delete account action */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Deletar Conta", color = Color.White, fontSize = 16.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen()
}

@Preview(showBackground = true)
@Composable
fun UserDetailsScreenPreview() {
    UserDetailsScreen()
}
