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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsuarioScreen(navController: NavController? = null, userName: String, functionName: String) {
    var profileImageUri by remember { mutableStateOf<Uri?>(null) }
    var email by remember { mutableStateOf("") }
    var nome by remember { mutableStateOf("") }
    var funcao by remember { mutableStateOf("") }

    // Launcher para abrir a galeria
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        profileImageUri = uri
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF5F5F5)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFEAAC47))
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.voltar),
                        contentDescription = "seta de voltar",
                        modifier = Modifier
                            .size(80.dp)
                            .clickable { navController?.navigate("AjusteScreen") },
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                    Text(
                        text = "Usuário",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                    Text(
                        text = "Salvar",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .clickable { navController?.navigate("LoginScreen") }
                    )
                }
            }
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
                    .clickable {
                        launcher.launch("image/*")
                    }
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
                    functionName,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(16.dp)
                .background(Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                Text(
                    text = "Nome",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                TextField(
                    value = nome,
                    onValueChange = { nome = it },
                    label = { Text("xxx xxx xxx") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.LightGray),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
//                    colors = TextFieldDefaults.textFieldColors(
//                        containerColor = Color.Transparent,
//                        focusedIndicatorColor = Color.Transparent,
//                        unfocusedIndicatorColor = Color.Transparent,
//                        disabledIndicatorColor = Color.Transparent,
//                        focusedLabelColor = Color.Black,
//                        unfocusedLabelColor = Color.Black
                  //  )
                )
            }
            Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                Text(
                    text = "E-mail",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("xxxx@gmail.com") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.LightGray),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
//                    colors = TextFieldDefaults.textFieldColors(
//                        containerColor = Color.Transparent,
//                        focusedIndicatorColor = Color.Transparent,
//                        unfocusedIndicatorColor = Color.Transparent,
//                        disabledIndicatorColor = Color.Transparent,
//                        focusedLabelColor = Color.Black,
//                        unfocusedLabelColor = Color.Black
//                    )
                )
            }
            Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                Text(
                    text = "Função",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                TextField(
                    value = funcao,
                    onValueChange = { funcao = it },
                    label = { Text("xxxx") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.LightGray),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
//                    colors = TextFieldDefaults.textFieldColors(
//                        containerColor = Color.Transparent,
//                        focusedIndicatorColor = Color.Transparent,
//                        unfocusedIndicatorColor = Color.Transparent,
//                        disabledIndicatorColor = Color.Transparent,
//                        focusedLabelColor = Color.Black,
//                        unfocusedLabelColor = Color.Black
//                    )
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            // Seção de botões
            Button(
                onClick = { /* Ação de Deletar */ },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(45.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6F00))
            ) {
                Text("Deletar Conta", color = Color.White, fontSize = 16.sp)
                Spacer(modifier = Modifier.width(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.lixeira),
                    contentDescription = "Ícone de lixeira",
                    modifier = Modifier.size(24.dp),
                    colorFilter = ColorFilter.tint(Color(0xFFFFFFFF))
                )
            }
        }
    }
}
        @Preview(showBackground = true)
        @Composable
        fun UsuarioScreenPreview() {
            UsuarioScreen(userName = "Raquel Guimarães", functionName = "Administrador")
        }
