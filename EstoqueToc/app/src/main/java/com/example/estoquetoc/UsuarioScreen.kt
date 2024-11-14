package com.example.estoquetoc

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.estoquetoc.componentes.BottomBarApp
import com.example.estoquetoc.componentes.InputFormulario

@Composable
fun UsuarioScreen(navController: NavController) {
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
            .background(color = Color(0xFFF5F5F5))
            .verticalScroll(rememberScrollState()), // Habilita a rolagem
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .background(color = Color(0xFFEAAC47)),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(8.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.back_icon),
                        contentDescription = "seta de voltar",
                        modifier = Modifier
                            .size(28.dp)
                            .clickable { navController.navigate("AjusteScreen") },
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                    Text(
                        text = "Usuário",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                    Text(
                        text = "Salvar",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        modifier = Modifier
                            .clickable { navController.navigate("LoginScreen") }
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
                    .clickable { launcher.launch("image/*") }
            ) {
                if (profileImageUri != null) {
                    Image(
                        painter = rememberAsyncImagePainter(profileImageUri),
                        contentDescription = "Imagem do usuário",
                        modifier = Modifier.size(54.dp)
                    )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.usuario),
                        contentDescription = "Ícone do usuário",
                        modifier = Modifier.size(54.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                // Exibe "Perfil" se funcao estiver vazio
                Text(
                    text = funcao.ifEmpty { "Perfil do usuário" },
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(16.dp)
                .background(Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(modifier = Modifier.fillMaxWidth(1f)) {
                Text(
                    text = "Nome",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 6.dp)
                )
                InputFormulario(
                    value = nome,
                    onValueChange = { nome = it },
                    labelText = "xxx xxx xxx",
                    modifier = Modifier.fillMaxWidth().background(color = Color.LightGray).padding(bottom = 8.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
                )

                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "E-mail",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 6.dp)
                )
                InputFormulario(
                    value = email,
                    onValueChange = { email = it },
                    labelText = "Email",
                    modifier = Modifier.fillMaxWidth().background(color = Color.LightGray).padding(bottom = 8.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
                )

                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Função",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 6.dp)
                )
                InputFormulario(
                    value = funcao,
                    onValueChange = { funcao = it },
                    labelText = "Função",
                    modifier = Modifier.fillMaxWidth().background(color = Color.LightGray).padding(bottom = 8.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
                )

                Spacer(modifier = Modifier.height(32.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp) // Espaçamento uniforme entre os botões
                ) {
                    Button(
                        onClick = { navController.navigate("inicial_screen") },
                        modifier = Modifier
                            .weight(1f)
                            .height(45.dp),
                        shape = RoundedCornerShape(6.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6F00))
                    ) {
                        Text("Deletar Conta", color = Color.White, fontSize = 12.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Image(
                            painter = painterResource(id = R.drawable.lixeira),
                            contentDescription = "Ícone de lixeira",
                            modifier = Modifier.size(16.dp),
                            colorFilter = ColorFilter.tint(Color.White)
                        )
                    }

                    Button(
                        onClick = { navController.navigate("faturamento") },
                        modifier = Modifier
                            .weight(1f)
                            .height(45.dp),
                        shape = RoundedCornerShape(6.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6F00))
                    ) {
                        Text("Salvar Conta", color = Color.White, fontSize = 12.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.ic_salvar),
                            contentDescription = "Ícone de salvar",
                            modifier = Modifier.size(16.dp),
                            tint = Color.White
                        )
                    }
                }


            }
        }
        BottomBarApp(navController = navController)
    }
}

@Preview(showBackground = true)
@Composable
private fun UsuarioScreenPreview() {
    val navController = rememberNavController()
    UsuarioScreen(navController = navController)
}
