package com.example.estoquetoc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.estoquetoc.componentes.Produto
import com.example.estoquetoc.componentes.ProdutoViewModel
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
    val produtoViewModel:ProdutoViewModel = viewModel()
    NavHost(navController = navController, startDestination = "inicial_screen", modifier = modifier) {
        composable("inicial_screen") { WelcomeScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("produtos_screen") { ProdutoScreen(navController, produtoViewModel)}
        composable("cadastro_usuario") { CadastroUsuarioScreen(navController) }
        composable("faturamento") { FaturamentoScreen(navController) }
        composable("dashboard") { DashboardScreen(navController) }
        composable("cadastro_produto") { CadastroProdutoScreen(navController) }
        composable("cadastro_fornecedor") { CadastroFornecedorScreen(navController) }
        composable("cadastro_funcionario") { CadastroFuncionarioScreen(navController) }
        composable("relatorios") { RelatorioScreen(navController) }
        composable("menu_cadastros") {MenuCadastros(navController)}
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EstoqueTocTheme {
        MainActivity() // Para visualizar a estrutura completa, você pode precisar ajustar a visualização aqui
    }
}
