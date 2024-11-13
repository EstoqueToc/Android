package com.example.estoquetoc.formulario

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.estoquetoc.R
import com.example.estoquetoc.atributosCadastro.FornecedorAtributos
import com.example.estoquetoc.componentes.BottomBarApp
import com.example.estoquetoc.componentes.CompButton
import com.example.estoquetoc.componentes.InputFormulario
import com.example.estoquetoc.componentes.TopBarApp

@Composable
fun CadastroFornecedores(
    navController: NavHostController,
    Items: MutableList<FornecedorAtributos>
) {
    var razaoSocial by remember { mutableStateOf("") }
    var nomeFantasia by remember { mutableStateOf("") }
    var cnpj by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var cep by remember { mutableStateOf("") }
    var bairro by remember { mutableStateOf("") }
    var logradouro by remember { mutableStateOf("") }
    var numero by remember { mutableStateOf("") }
    var cidade by remember { mutableStateOf("") }

    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.align(Alignment.TopCenter)) {
            TopBarApp(
                FirstImage = R.drawable.back_icon,
                "Voltar",
                SecondImage = R.drawable.adicionar_icon,
                "lixeira",
                Titulo = "Produtos",
                onFirstClickImage = { navController.navigate("fornecedores") },
                onSecondClickImage = {navController.navigate("cadastro_fornecedor")}
            )
        }
        Column(
            Modifier
                .fillMaxWidth()
                .padding(
                    top = 120.dp,
                    bottom = 70.dp,
                    start = 10.dp,
                    end = 10.dp
                )
                .verticalScroll(rememberScrollState())
        ) {
            InputFormulario(
                value = razaoSocial,
                onValueChange = { razaoSocial = it },
                labelText = "Razão Social",
                modifier = Modifier.fillMaxWidth().background(color = Color.LightGray),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
            )
            Spacer(modifier = Modifier.size(16.dp))

            InputFormulario(
                value = nomeFantasia,
                onValueChange = { nomeFantasia = it },
                labelText = "Nome Fantasia",
                modifier = Modifier.fillMaxWidth().background(color = Color.LightGray),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
            )
            Spacer(modifier = Modifier.size(16.dp))
            InputFormulario(
                value = cnpj,
                onValueChange = { cnpj = it },
                labelText = "CNPJ",
                modifier = Modifier.fillMaxWidth().background(color = Color.LightGray),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.size(16.dp))

            InputFormulario(
                value = email,
                onValueChange = { email = it },
                labelText = "E-mail",
                modifier = Modifier.fillMaxWidth().background(color = Color.LightGray),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
            )
            Spacer(modifier = Modifier.size(16.dp))

            InputFormulario(
                value = telefone,
                onValueChange = { telefone = it },
                labelText = "Telefone",
                modifier = Modifier.fillMaxWidth().background(color = Color.LightGray),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
            )
            Spacer(modifier = Modifier.size(16.dp))

            InputFormulario(
                value = cep,
                onValueChange = { cep = it },
                labelText = "CEP",
                modifier = Modifier.fillMaxWidth().background(color = Color.LightGray),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
            )
            Spacer(modifier = Modifier.size(16.dp))

            InputFormulario(
                value = logradouro,
                onValueChange = { logradouro = it },
                labelText = "Logradouro",
                modifier = Modifier.fillMaxWidth().background(color = Color.LightGray),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
            )
            Spacer(modifier = Modifier.size(16.dp))
            InputFormulario(
                value = numero,
                onValueChange = { numero = it },
                labelText = "Numero",
                modifier = Modifier.fillMaxWidth().background(color = Color.LightGray),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
            )
            Spacer(modifier = Modifier.size(16.dp))
            InputFormulario(
                value = cidade,
                onValueChange = { cidade = it },
                labelText = "Cidade",
                modifier = Modifier.fillMaxWidth().background(color = Color.LightGray),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
            )
            Spacer(modifier = Modifier.size(16.dp))

            Spacer(modifier = Modifier.height(16.dp))

            CompButton(onClickAction = {
                if (razaoSocial.isNotBlank() && nomeFantasia.isNotBlank()) {
                    Toast.makeText(
                        context,
                        "Fornecedor '$razaoSocial' salvo com sucesso!",
                        Toast.LENGTH_SHORT
                    ).show()
                    val novoFornecedor = FornecedorAtributos(
                        razaoSocial = razaoSocial,
                        nomeFantasia = nomeFantasia,
                        cnpj = cnpj,
                        emailFornecedor = email,
                        telefoneFornecedor = telefone,
                        cepFornecedor = cep,
                        logradouroFornecedor = logradouro,
                        bairroFornecedor = bairro,
                        numeroFornecedor = numero,
                        cidadeFornecedor = cidade
                    )
                    Items.add(novoFornecedor)
                    navController.navigate("fornecedores")
                    razaoSocial = ""
                    nomeFantasia = ""
                    cnpj = ""
                    email = ""
                    telefone = ""
                    cep = ""
                    logradouro = ""
                    bairro = ""
                    numero = ""
                    cidade = ""
                } else {
                    Toast.makeText(
                        context,
                        "Por favor, preencha todos os campos.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }, text = "Salvar", icon = R.drawable.edit_icon, descIcon = "vazio")


        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            BottomBarApp(
                navController = navController
            )
        }


    }
}

@Preview(showBackground = true)
@Composable
private fun preview() {
    val navController = rememberNavController()
    val items = remember {
        mutableListOf<FornecedorAtributos>()
    }
    CadastroFornecedores(navController, items)
}