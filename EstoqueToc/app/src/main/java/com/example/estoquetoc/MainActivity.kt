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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.estoquetoc.Formularios.CadastroFornecedorScreen
import com.example.estoquetoc.Formularios.CadastroFuncionarioScreen
import com.example.estoquetoc.Formularios.CadastroProdutoScreen
import com.example.estoquetoc.Formularios.CadastroUsuarioScreen
import com.example.estoquetoc.LoginInicial.LoginScreen
import com.example.estoquetoc.LoginInicial.WelcomeScreen
import com.example.estoquetoc.atributosCadastro.FornecedorAtributos
import com.example.estoquetoc.atributosCadastro.FuncionarioAtributo
import com.example.estoquetoc.atributosCadastro.Produto
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
    val produtos = rememberSaveable { mutableListOf<Produto>() }
    val funcionarios = remember { mutableListOf<FuncionarioAtributo>() }
    val fornecedores = remember { mutableListOf<FornecedorAtributos>() }

    NavHost(navController = navController, startDestination = "cadastro_funcionario", modifier = modifier) {
        composable("inicial_screen") { WelcomeScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("produtos_screen") { ProdutoScreen(navController,produtos) }
        composable("cadastro_usuario") { CadastroUsuarioScreen(navController) }
        composable("faturamento") { FaturamentoScreen(navController) }
        composable("dashboard") { DashboardScreen(navController) }
        composable("cadastro_produto") { CadastroProdutoScreen(navController, produtos) }
        composable("cadastro_fornecedor") { CadastroFornecedorScreen(navController, fornecedores) }
        composable("fornecedores") { CadastroFornecedorScreen(navController,fornecedores ) }
        composable("cadastro_funcionario") { CadastroFuncionarioScreen(navController, funcionarios) }
        composable("funcionarios"){ FuncionariosCadastradoScreen(navController, funcionarios) }
        composable("relatorios") { RelatorioScreen(navController) }
        composable("menu_cadastros") {MenuCadastros(navController)}
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EstoqueTocTheme {
        MainActivity()
    }
}
