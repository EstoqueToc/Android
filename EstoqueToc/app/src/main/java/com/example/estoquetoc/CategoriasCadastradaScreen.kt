package com.example.estoquetoc

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.estoquetoc.atributosCadastro.CategoriaAtributos
import com.example.estoquetoc.componentes.BottomBarApp
import com.example.estoquetoc.componentes.CardComponetizado
import com.example.estoquetoc.componentes.InputFormulario
import com.example.estoquetoc.componentes.TopBarApp

@Composable
fun CategoriasCadastradoScreen(
    navController: NavHostController,
    Items:MutableList<CategoriaAtributos>
) {

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            TopBarApp(
                FirstImage = R.drawable.back_icon,
                "Voltar",
                SecondImage = R.drawable.adicionar_icon,
                "Editar",
                Titulo = "Categorias",
                true,
                onFirstClickImage = { navController.navigate("menu") },
                onSecondClickImage = {navController.navigate("cadasstro_categoria")}
            )
            Spacer(modifier = Modifier.size(30.dp))
            Column(
                modifier = Modifier.fillMaxSize(),
                Arrangement.SpaceBetween
            ) {
                if(Items.isEmpty()){
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.nenhum_registro_encontrado),
                            contentDescription = "No Item Founded",
                            modifier = Modifier.size(500.dp)
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Nenhuma Categoria Cadastrada",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                }else{
                    Items.forEach{categoria ->
                        CardComponetizado(
                            icon = R.drawable.box_icon,
                            DescIcon = categoria.nomeCategoria,
                            DescriptionProduct = categoria.nomeCategoria,
                            QtdEmEstoque =categoria.nomeCategoria,
                            valor = categoria.nomeCategoria,
                            onClick = {
                                navController.navigate("cadastro_fornecedor")
                            }
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                    }
                }
            }
        }
        BottomBarApp(
            navController = navController
        )
    }
}

@Composable
fun cadastroCategoria(modifier: Modifier = Modifier) {
    var categoria by remember { mutableStateOf("") }
    var visualizar by remember { mutableStateOf(false) }

    AnimatedVisibility(visible = visualizar) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Informe o nome da Categoria", fontWeight = FontWeight.Bold)
            InputFormulario(value = categoria, onValueChange = {categoria = it}, labelText = "Categoria")
            Button(onClick = { /*TODO*/ }) {
                Text(text ="Salvar", fontWeight = FontWeight.Bold, color = Color.White)
            }
        }
    }
}