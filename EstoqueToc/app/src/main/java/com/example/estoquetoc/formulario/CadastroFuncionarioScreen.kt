package com.example.estoquetoc.formulario

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.estoquetoc.R
import com.example.estoquetoc.atributosCadastro.FuncionarioAtributo
import com.example.estoquetoc.componentes.BottomBarApp
import com.example.estoquetoc.componentes.CompButton
import com.example.estoquetoc.componentes.InputFormulario
import com.example.estoquetoc.componentes.TopBarApp
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun CadastroFuncionarios(
    navController: NavHostController,
    Items: MutableList<FuncionarioAtributo>
) {
    var nomeFuncionario by remember { mutableStateOf("") }
    var cpf by remember { mutableStateOf("") }
    var dtNascimento by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var funcao by remember { mutableStateOf("") }

    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(modifier = Modifier.align(Alignment.TopCenter)) {
            TopBarApp(
                FirstImage = R.drawable.back_icon,
                "Voltar",
                SecondImage = R.drawable.adicionar_icon,
                "Adicionar",
                Titulo = "Funcionários",
                onFirstClickImage = { navController.navigate("funcionarios") },
                onSecondClickImage = {navController.navigate("cadastro_funcionario")}
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
                value = nomeFuncionario,
                onValueChange = { nomeFuncionario = it },
                labelText = "Nome"
            )
            Spacer(modifier = Modifier.size(16.dp))

            InputFormulario(
                value = cpf,
                onValueChange = { cpf = it },
                labelText = "CPF"
            )
            Spacer(modifier = Modifier.size(16.dp))

            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = dtNascimento,
                    onValueChange = { input ->
                        dtNascimento = input
                        // Verificar se a data é válida e mostrar um Toast se não for
                        if (input.isNotEmpty()) {
                            try {
                                val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                                format.isLenient = false
                                format.parse(input)
                            } catch (e: Exception) {
                                Toast.makeText(
                                    context,
                                    "Por favor, insira uma data válida no formato dd/MM/yyyy",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    },
                    label = { Text(text = "Data de Nascimento") }
                )
                Image(
                    painter = painterResource(id = R.drawable.calendar_icon),
                    contentDescription = "Data de Nascimento",
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(30.dp)
                        .align(Alignment.CenterEnd)
                )
            }
            Spacer(modifier = Modifier.size(16.dp))

            InputFormulario(
                value = email,
                onValueChange = { email = it },
                labelText = "E-mail"
            )
            Spacer(modifier = Modifier.size(16.dp))

            InputFormulario(
                value = senha,
                onValueChange = { senha = it },
                labelText = "Senha"
            )
            Spacer(modifier = Modifier.size(16.dp))

            InputFormulario(
                value = funcao,
                onValueChange = { funcao = it },
                labelText = "Função"
            )
            Spacer(modifier = Modifier.size(16.dp))

            CompButton(onClickAction = {
                if (nomeFuncionario.isNotBlank() && cpf.isNotBlank()) {
                    Toast.makeText(
                        context,
                        "Funcionario '$nomeFuncionario' salvo com sucesso!",
                        Toast.LENGTH_SHORT
                    ).show()
                    val novoFuncionario = FuncionarioAtributo(
                        nome = nomeFuncionario,
                        cpf = cpf,
                        dtNascimento = dtNascimento,
                        emailFuncionario = email,
                        senha = senha,
                        funcao = funcao
                    )
                    Items.add(novoFuncionario)
                    navController.navigate("funcionarios")
                    nomeFuncionario = ""
                    cpf = ""
                    dtNascimento = ""
                    email = ""
                    senha = ""
                    funcao = ""
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
            BottomBarApp(navController = navController)
        }

    }
}


@Preview(showBackground = true)
@Composable
private fun preview() {
    val navController = rememberNavController()
    val items = remember {
        mutableListOf<FuncionarioAtributo>()
    }
    CadastroFuncionarios(navController, items)
}