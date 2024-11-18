package com.example.estoquetoc

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.estoquetoc.componentes.BottomBarApp
import com.example.estoquetoc.componentes.CardComponetizado
import com.example.estoquetoc.componentes.TopBarApp

@Composable
fun AjustesScreen(
    navController: NavController? = null,
    userName: String,
    functionName: String
) {
    val context = LocalContext.current
    var profileImageUri by remember { mutableStateOf<Uri?>(null) }

    // Launcher para abrir a galeria
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        profileImageUri = uri
    }

    Box(modifier = Modifier.fillMaxSize()) {

        Box(modifier = Modifier.align(Alignment.TopCenter)) {
            TopBarApp(
                FirstImage = R.drawable.back_icon,
                "Voltar",
                SecondImage = R.drawable.adicionar_icon,
                "Adicionar",
                Titulo = "Ajustes",
                onFirstClickImage = { navController?.navigate("menu") },
                onSecondClickImage = { navController?.navigate("") }
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 90.dp,
                    bottom = 70.dp,
                    start = 10.dp,
                    end = 10.dp
                )
        ) {

            CardComponetizado(
                icon = R.drawable.usuario,
                DescIcon = "Usuario",
                DescriptionProduct = userName,
                QtdEmEstoque = functionName
            ) {
                navController?.navigate("usuario")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Seção de botões
            Button(
                onClick = {TODO("Not yet implemented")},
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
                onClick = { navController?.navigate("inicial_screen") },
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
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            BottomBarApp(navController = navController!!)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AjusteScreenPreview() {
    AjustesScreen(userName = "Raquel Guimarães", functionName = "Administrador")
}
