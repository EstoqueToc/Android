package com.example.estoquetoc

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.example.estoquetoc.atributosCadastro.FornecedorAtributos
import com.example.estoquetoc.componentes.BottomBarApp
import com.example.estoquetoc.componentes.CardComponetizado
import com.example.estoquetoc.componentes.TopBarApp

@Composable
fun FornecedoresCadastradoScreen(
    navController: NavHostController,
    Items:MutableList<FornecedorAtributos>
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
                Titulo = "Fornecedores",
                true,
                onFirstClickImage = { navController.navigate("menu") },
                onSecondClickImage = {navController.navigate("cadastro_fornecedor")},
                Search = "Buscar Fornecedor"
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
                            text = "Nenhum Fornecedor Cadastrado",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                }else{
                    Items.forEach{fornecedor ->
                        CardComponetizado(
                            icon = R.drawable.box_icon,
                            DescIcon = fornecedor.razaoSocial,
                            DescriptionProduct = fornecedor.razaoSocial,
                            QtdEmEstoque =fornecedor.cidadeFornecedor,
                            valor = fornecedor.logradouroFornecedor,
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