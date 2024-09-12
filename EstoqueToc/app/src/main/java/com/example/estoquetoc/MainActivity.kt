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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
    val items = rememberSaveable { mutableListOf<Produto>() }
    NavHost(navController = navController, startDestination = "inicial_screeen", modifier = modifier) {
        composable("inicial_screen") { WelcomeScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("produtos_screen") { ProdutoScreen(navController,items)}
        composable("cadastro_usuario") { CadastroUsuarioScreen(navController) }
        composable("faturamento") { FaturamentoScreen(navController) }
        composable("gestao") { GestaoScreen(navController) }
        composable("cadastro_produto") { CadastroProdutoScreen(navController, items) }
        composable("relatorios") { RelatoriosScreen(navController) }
        composable("usuario") { UsuarioScreen(navController, "Raquel Guimarães", "Administrador") }
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
