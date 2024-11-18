package com.example.estoquetoc

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
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
import com.example.estoquetoc.codigoDeBarra.BarcodeScannerScreen
import com.example.estoquetoc.formulario.CadastroFornecedores
import com.example.estoquetoc.formulario.CadastroFuncionarios
import com.example.estoquetoc.formulario.CadastroProdutos
import com.example.estoquetoc.ui.theme.EstoqueTocTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {

    private val requestCameraPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                Toast.makeText(this, "Permissão da câmera concedida", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Permissão da câmera negada", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EstoqueTocTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Scaffold { innerPadding ->
                        AppNavHost(
                            navController = navController,
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }

        // Verificar permissão da câmera ao iniciar
        checkCameraPermission()
    }

    private fun checkCameraPermission() {
        when {
            ContextCompat.checkSelfPermission(
                this, Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED -> {
                // Permissão já concedida
                Toast.makeText(this, "Permissão já concedida", Toast.LENGTH_SHORT).show()
            }
            shouldShowRequestPermissionRationale(Manifest.permission.CAMERA) -> {
            showToast("A permissão da câmera é necessária para escanear códigos de barra.")
            requestCameraPermissionLauncher.launch(Manifest.permission.CAMERA)
        }
            else -> {
                // Solicitar permissão de câmera
                requestCameraPermissionLauncher.launch(Manifest.permission.CAMERA)
            }
        }
    }
    // Método para exibir Toasts
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    // Dados compartilhados entre as telas
    val produtos = rememberSaveable { mutableListOf<ProdutoAtributo>() }
    val funcionarios = rememberSaveable  { mutableListOf<FuncionarioAtributo>() }
    val fornecedores = rememberSaveable  { mutableListOf<FornecedorAtributos>() }
    val categorias = rememberSaveable  { mutableListOf<CategoriaAtributos>() }

    // Configuração de navegação
    NavHost(
        navController = navController,
        startDestination = "inicial_screen",
        modifier = modifier
    ) {
      // Telas Iniciais
        composable("inicial_screen") { WelcomeScreen(navController) }
        composable("login") {
            val loginViewModel: LoginViewModel = viewModel() // Obtenha uma instância do ViewModel
            LoginScreen(viewModel = loginViewModel, navController = navController)
        }        
        composable("cadastro_usuario") { CadastroUsuarioScreen(navController) }
        // Formulários de Cadastro
        composable("cadastro_produto") { CadastroProdutos(navController, produtos) }
        composable("cadastro_fornecedor") { CadastroFornecedores(navController, fornecedores) }
        composable("cadastro_funcionario") { CadastroFuncionarios(navController, funcionarios) }

        // Telas de Exibição de Cadastros
        composable("fornecedores") { FornecedoresCadastradoScreen(navController, fornecedores) }
        composable("funcionarios") { FuncionariosCadastradoScreen(navController, funcionarios) }
        composable("produtos_screen") { ProdutoCadastrados(navController, produtos) }
        composable("categorias") { CategoriasCadastradoScreen(navController, categorias) }

        // Telas Específicas
        composable("faturamento") { FaturamentoScreen(navController) }
        composable("dashboard") { DashboardScreen(navController) }
        composable("relatorios") { RelatorioScreen(navController) }
        composable("menu") { MenuCadastros(navController) }
        composable("usuario") { UsuarioScreen(navController) }
        composable("gestao") { GestaoScreen(navController = navController) }
        composable("ajustes") { AjustesScreen(navController, userName = "Admin", functionName = "Admin") }
        composable("ajuda") { AjudaScreen(navController) }

        // Tela do Scanner de Código de Barras
        composable("barcode_scanner") { BarcodeScannerScreen() }

        // Tela de Planos
        composable("planos") { PlanosUI(navController) }
        composable("relatorios"){ RelatoriosScreen(navController)}
    }
}

@Serializable
object LoginScreen



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
