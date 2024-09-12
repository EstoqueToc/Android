package com.example.estoquetoc

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

@Composable
fun AjusteScreen(navController: NavController? = null, userName: String, functionName: String) {
    var profileImageUri by remember { mutableStateOf<Uri?>(null) }

    // Launcher para abrir a galeria
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        profileImageUri = uri
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF5F5F5))
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFEAAC47))
                .padding(16.dp)
        ) {
            Text(
                text = "Ajustes",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Seção de informações do usuário
        Row(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .clickable { launcher.launch("image/*") }
            ) {
                if (profileImageUri != null) {
                    Image(
                        painter = rememberAsyncImagePainter(profileImageUri),
                        contentDescription = "Imagem do usuário",
                        modifier = Modifier.size(50.dp),
                    )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.usuario),
                        contentDescription = "Ícone do usuário",
                        modifier = Modifier.size(50.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    userName,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    functionName,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Seção de botões
        Button(
            onClick = { /* Ação de Guia */ },
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(45.dp)
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6F00))
        ) {
            Text("Guia", color = Color.White, fontSize = 16.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = R.drawable.interrogacao),
                contentDescription = "Ícone de ajuda",
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(Color(0xFFFFFFFF))
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {  navController?.navigate("InicialScreen") },
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(45.dp)
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6F00))
        ) {
            Text("Sair", color = Color.White, fontSize = 16.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = R.drawable.sair),
                contentDescription = "Ícone de sair",
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(Color(0xFFFFFFFF))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AjusteScreenPreview() {
    AjusteScreen(userName = "Raquel Guimarães", functionName = "Administrador")
}
