package com.example.estoquetoc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.estoquetoc.LoginInicial.WelcomeScreen
import com.example.estoquetoc.atributosCadastro.CategoriaAtributos
import com.example.estoquetoc.atributosCadastro.FornecedorAtributos
import com.example.estoquetoc.atributosCadastro.FuncionarioAtributo
import com.example.estoquetoc.atributosCadastro.ProdutoAtributo
import com.example.estoquetoc.cadastrados.FuncionariosCadastradoScreen
import com.example.estoquetoc.formulario.CadastroFornecedores
import com.example.estoquetoc.formulario.CadastroFuncionarios
import com.example.estoquetoc.formulario.CadastroProdutos
import com.example.estoquetoc.ui.theme.EstoqueTocTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EstoqueTocTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Scaffold() {
                        innerPadding ->
                        AppNavHost(
                            navController = navController,
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val produtos = rememberSaveable { mutableListOf<ProdutoAtributo>() }
    val funcionarios = remember { mutableListOf<FuncionarioAtributo>() }
    val fornecedores = remember { mutableListOf<FornecedorAtributos>() }
    val categorias = remember { mutableListOf<CategoriaAtributos>() }

    NavHost(
        navController = navController,
        startDestination = "inicial_screen",
        modifier = modifier
    ) {

//        TELAS INICIAS
        composable("inicial_screen") { WelcomeScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("cadastro_usuario") { CadastroUsuarioScreen(navController) }

//        FORMULARIOS DE CADASTRO
        composable("cadastro_produto") { CadastroProdutos(navController, produtos) }
        composable("cadastro_fornecedor") { CadastroFornecedores(navController, fornecedores) }
        composable("cadastro_funcionario") { CadastroFuncionarios(navController, funcionarios) }

//        TELAS DE EXIBIÇÃO DE CADASTRADOS (PRODUTOS, FORNECEDORES, FUNCIONARIOS E CATEGORIAS)
        composable("fornecedores") { FornecedoresCadastradoScreen(navController,fornecedores ) }
        composable("funcionarios"){ FuncionariosCadastradoScreen(navController, funcionarios) }
        composable("produtos_screen") { ProdutoCadastrados(navController,produtos) }
        composable("categorias") { CategoriasCadastradoScreen( navController, categorias ) }

//        TELAS ESPECIFICAS
        composable("faturamento") { FaturamentoScreen(navController) }
        composable("dashboard") { DashboardScreen(navController) }
        composable("relatorios") { RelatorioScreen(navController) }
        composable("menu") {MenuCadastros(navController)}
        composable("usuario") { Usuario(navController) }
        composable("gestao") { GestaoScreen(navController = navController) }
        composable("ajustes") { AjustesScreen(navController,userName = "Admin", functionName = "Admin") }
    }
}

@Composable
fun RelatorioScreen(navController: NavHostController) {
    TODO("Not yet implemented")
}

@Composable
fun DashboardScreen(navController: NavController) {
    TODO("Not yet implemented")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EstoqueTocTheme {
        MainActivity()
    }
}
