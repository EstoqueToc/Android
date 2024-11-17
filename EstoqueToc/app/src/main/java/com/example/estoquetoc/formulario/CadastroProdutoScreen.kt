package com.example.estoquetoc.formulario

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.estoquetoc.R
import com.example.estoquetoc.atributosCadastro.ProdutoAtributo
import com.example.estoquetoc.componentes.BottomBarApp
import com.example.estoquetoc.componentes.CompButton
import com.example.estoquetoc.componentes.InputFormulario
import com.example.estoquetoc.componentes.TopBarApp
import com.google.zxing.integration.android.IntentIntegrator

@Composable
fun CadastroProdutos(
    navController: NavHostController,
    items: MutableList<ProdutoAtributo>
) {
    var nomeProduto by remember { mutableStateOf("") }
    var descricaoProduto by remember { mutableStateOf("") }
    var codigoBarras by remember { mutableStateOf("") }
    var dataValidade by remember { mutableStateOf("") }
    var unidadeMedida by remember { mutableStateOf("") }
    var qtdEntrada by remember { mutableStateOf("") }
    var precoCompra by remember { mutableStateOf("") }
    var precoVenda by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf("") }

    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            Modifier.align(Alignment.TopCenter)
        ) {
            TopBarApp(
                FirstImage = R.drawable.back_icon,
                "Voltar",
                SecondImage = R.drawable.lixeira_icon,
                "lixeira",
                Titulo = "Produtos",
                false,
                Modifier.align(Alignment.TopCenter),
                onFirstClickImage = { navController.navigate("menu") },
                onSecondClickImage = { navController.navigate("cadastro_produto") }
            )
        }
        val activity = LocalContext.current as? Activity

        val barcodeLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.StartActivityForResult()
        ) { result ->
            val intentResult = IntentIntegrator.parseActivityResult(
                result.resultCode, result.data
            )
            codigoBarras = intentResult?.contents ?: "Leitura cancelada"
        }

        val gradientBrush = Brush.horizontalGradient(
            colors = listOf(
                Color(0xFFFFA726),
                Color(0xFFFF7043)
            )
        )

        Box(modifier = Modifier.fillMaxSize()) {
            // TopBar na parte superior
            TopBarApp(
                FirstImage = R.drawable.back_icon,
                "Voltar",
                SecondImage = R.drawable.lixeira_icon,
                "lixeira",
                Titulo = "Produtos",
                false,
                Modifier.align(Alignment.TopCenter),
                onFirstClickImage = { navController.navigate("produtos_screen") },
                onSecondClickImage = { navController.navigate("cadastro_produto") }
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .padding(top = 120.dp, bottom = 80.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                InputFormulario(
                    value = nomeProduto,
                    onValueChange = { nomeProduto = it },
                    labelText = "Nome"
                )
                Spacer(modifier = Modifier.size(16.dp))

                InputFormulario(
                    value = descricaoProduto,
                    onValueChange = { descricaoProduto = it },
                    labelText = "Descrição"
                )
                Spacer(modifier = Modifier.size(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = codigoBarras,
                        onValueChange = { codigoBarras = it },
                        label = { Text("Código de Barras") },
                        placeholder = { Text("") },
                        modifier = Modifier.weight(1f),
                        singleLine = true
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                            activity?.let {
                                val integrator = IntentIntegrator(it)
                                integrator.setPrompt("Escaneie o código de barras")
                                integrator.setBeepEnabled(true)
                                integrator.setOrientationLocked(false)
                                integrator.captureActivity =
                                    com.journeyapps.barcodescanner.CaptureActivity::class.java
                                val scanIntent = integrator.createScanIntent()
                                barcodeLauncher.launch(scanIntent)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .height(56.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(gradientBrush)
                            .padding(horizontal = 16.dp)
                    ) {
                        Text("Escanear", color = Color.Black)
                    }
                }
                Spacer(modifier = Modifier.size(16.dp))

                InputFormulario(
                    value = dataValidade,
                    onValueChange = { dataValidade = it },
                    labelText = "Data de Validade"
                )
                Spacer(modifier = Modifier.size(16.dp))

                InputFormulario(
                    value = unidadeMedida,
                    onValueChange = { unidadeMedida = it },
                    labelText = "Unidade de Medida"
                )
                Spacer(modifier = Modifier.size(16.dp))

                InputFormulario(
                    value = qtdEntrada,
                    onValueChange = { qtdEntrada = it },
                    labelText = "Quantidade de Entrada"
                )
                Spacer(modifier = Modifier.size(16.dp))

                InputFormulario(
                    value = precoCompra,
                    onValueChange = { precoCompra = it },
                    labelText = "Preço de Compra"
                )
                Spacer(modifier = Modifier.size(16.dp))

                InputFormulario(
                    value = precoVenda,
                    onValueChange = { precoVenda = it },
                    labelText = "Preço de Venda"
                )
                Spacer(modifier = Modifier.size(16.dp))

                CompButton(onClickAction = {
                    if (nomeProduto.isNotBlank() && descricaoProduto.isNotBlank() && codigoBarras.isNotBlank()) {
                        Toast.makeText(
                            context,
                            "Produto '$nomeProduto' salvo com sucesso!",
                            Toast.LENGTH_SHORT
                        ).show()
                        val novoProduto = ProdutoAtributo(
                            nomeProduto = nomeProduto,
                            descricaoProduto = descricaoProduto,
                            dataValidade = dataValidade,
                            unidadeMedida = unidadeMedida,
                            qtdEntrada = qtdEntrada,
                            precoCompra = precoCompra,
                            precoVenda = precoVenda,
                            categoria = categoria
                        )
                        items.add(novoProduto)
                        navController.navigate("produtos_screen")
                    } else {
                        Toast.makeText(
                            context,
                            "Por favor, preencha todos os campos.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }, text = "Salvar", icon = R.drawable.edit_icon, descIcon = "Salvar")
            }

            // BottomBar na parte inferior
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
            ) {
                BottomBarApp(navController = navController)
            }
        }
    }
}
