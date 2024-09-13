package com.example.estoquetoc.Formularios

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.estoquetoc.R
import com.example.estoquetoc.atributosCadastro.FornecedorAtributos
import com.example.estoquetoc.componentes.BottomBarApp
import com.example.estoquetoc.componentes.CompButton
import com.example.estoquetoc.componentes.InputFormulario
import com.example.estoquetoc.componentes.TopBarApp

@Composable
fun CadastroFornecedorScreen(
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
    Column {
        TopBarApp(
            FirstImage = R.drawable.back_icon,
            "Voltar",
            SecondImage = R.drawable.lixeira_icon,
            "lixeira",
            Titulo = "Produtos",
            onClick = { navController.navigate("produtos_screen") }
        )
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            InputFormulario(
                value = razaoSocial,
                onValueChange = { razaoSocial = it },
                labelText = "Razão Social"
            )
            Spacer(modifier = Modifier.size(16.dp))

            InputFormulario(
                value = nomeFantasia,
                onValueChange = { nomeFantasia = it },
                labelText = "Nome Fantasia"
            )
            Spacer(modifier = Modifier.size(16.dp))
            InputFormulario(
                value = cnpj,
                onValueChange = { cnpj = it },
                labelText = "CNPJ"
            )

            Spacer(modifier = Modifier.size(16.dp))

            InputFormulario(
                value = email,
                onValueChange = { email = it },
                labelText = "E-mail"
            )
            Spacer(modifier = Modifier.size(16.dp))

            InputFormulario(
                value = telefone,
                onValueChange = { telefone = it },
                labelText = "Telefone"
            )
            Spacer(modifier = Modifier.size(16.dp))

            InputFormulario(
                value = cep,
                onValueChange = { cep = it },
                labelText = "CEP"
            )
            Spacer(modifier = Modifier.size(16.dp))

            InputFormulario(
                value = logradouro,
                onValueChange = { logradouro = it },
                labelText = "Logradouro"
            )
            Spacer(modifier = Modifier.size(16.dp))
            InputFormulario(
                value = numero,
                onValueChange = { numero = it },
                labelText = "Numero"
            )
            Spacer(modifier = Modifier.size(16.dp))
            InputFormulario(
                value = cidade,
                onValueChange = { cidade = it },
                labelText = "Cidade"
            )
            Spacer(modifier = Modifier.size(16.dp))

//         Seção para categoria

            Spacer(modifier = Modifier.height(16.dp))

            CompButton(onClickAction = {
                if (razaoSocial.isNotBlank() && nomeFantasia.isNotBlank()) {
                    Toast.makeText(
                        context,
                        "Produto '$razaoSocial' salvo com sucesso!",
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
                    navController.navigate("produtos_screen")
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
        BottomBarApp(navController = navController)
    }
}
