package com.example.estoquetoc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.estoquetoc.ui.theme.EstoqueTocTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EstoqueTocTheme {
                val navController = rememberNavController()
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    NavigationComponent(navController)
                    AppNavHost(navController = navController)

                }
            }
        }
    }
}

@Composable
fun NavigationComponent(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "cadastro") {
        composable("cadastro") { CadastroUsuarioScreen(navController = navController) }
        composable("login") { LoginScreen(navController = navController) }
    }
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("cadastro_usuario") { CadastroUsuarioScreen(navController) }
        composable("dashboard") { DashboardScreen(navController) }
        composable("cadastro_produto") { CadastroProdutoScreen(navController) }
        composable("cadastro_fornecedor") { CadastroFornecedorScreen(navController) }
        composable("cadastro_funcionario") { CadastroFuncionarioScreen(navController) }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EstoqueTocTheme {
        AppNavHost(navController = rememberNavController())
    }
}
