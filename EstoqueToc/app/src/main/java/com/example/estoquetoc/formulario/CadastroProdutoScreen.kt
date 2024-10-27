package com.example.estoquetoc.formulario

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.estoquetoc.R
import com.example.estoquetoc.atributosCadastro.ProdutoAtributo
import com.example.estoquetoc.componentes.BottomBarApp
import com.example.estoquetoc.componentes.CompButton
import com.example.estoquetoc.componentes.InputFormulario
import com.example.estoquetoc.componentes.TopBarApp
import com.example.estoquetoc.ui.theme.Orange
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun CadastroProdutos(
    navController: NavHostController,
    items: MutableList<ProdutoAtributo>
) {
    var nomeProduto by remember { mutableStateOf("") }
    var descricaoProduto by remember { mutableStateOf("") }
    var dataValidade by remember { mutableStateOf("") }
    var unidadeMedida by remember { mutableStateOf("") }
    var qtdEntrada by remember { mutableStateOf("") }
    var precoCompra by remember { mutableStateOf("") }
    var precoVenda by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf("") }
    var fornecedor by remember { mutableStateOf("") }
    var novacategoria by remember { mutableStateOf("") }
    var novoFornecedor by remember { mutableStateOf("") }
    var popUpVisibleCategoria by remember { mutableStateOf(false) }
    var popUpVisibleFornecedor by remember { mutableStateOf(false) }
    var categoriaVisible by remember { mutableStateOf(false) }
    var fornecedorVisible by remember { mutableStateOf(false) }
    var categorias by remember { mutableStateOf(listOf<String>()) }
    var fornecedores by remember { mutableStateOf(listOf<String>()) }

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
                value = nomeProduto,
                onValueChange = { nomeProduto = it },
                labelText = "Nome"
            )
            Spacer(modifier = Modifier.size(16.dp))

            InputFormulario(
                value = descricaoProduto,
                onValueChange = { descricaoProduto = it },
                labelText = "Descrção"
            )
            Spacer(modifier = Modifier.size(16.dp))

            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = dataValidade,
                    onValueChange = { input ->
                        dataValidade = input
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
                    label = { Text(text = "Data de Validade") }
                )
                Image(
                    painter = painterResource(id = R.drawable.calendar_icon),
                    contentDescription = "Data de Validade",
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(30.dp)
                        .align(Alignment.CenterEnd)
                )
            }
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

//         Seção para categoria
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = categoria,
                    onValueChange = { categoria = it },
                    label = { Text("Categoria") },
                    modifier = Modifier.fillMaxWidth()
                )
                Button(
                    onClick = {
                        categoriaVisible = !categoriaVisible
                    }, // Alterna a visibilidade da lista
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .clip(RoundedCornerShape(16.dp))
                ) {
                    Image(
                        painter = painterResource(
                            id = if (categoriaVisible) R.drawable.show_arrow_icon else R.drawable.hide_arrow_icon
                        ),
                        contentDescription = if (categoriaVisible) "Mostrar" else "Esconder",
                        modifier = Modifier
                            .size(20.dp)
                            .background(Color.Transparent)
                    )
                }
            }
            AnimatedVisibility(
                visible = categoriaVisible,
                enter = fadeIn(tween(500)),
                exit = fadeOut(tween(500))
            ) {
                Column(
                    Modifier.padding(16.dp)
                ) {
                    categorias.forEach { item ->
                        Button(
                            colors = ButtonDefaults.buttonColors(Orange),
                            onClick = { categoria = item },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp) // Adiciona um pouco de espaço entre os botões
                        ) {
                            Text(
                                text = item,
                                modifier = Modifier.padding(8.dp),
                                fontSize = 16.sp
                            )
                        }
                    }
                    Spacer(modifier = Modifier.size(16.dp))
                    Button(
                        colors = ButtonDefaults.buttonColors(Orange),
                        onClick = {
                            popUpVisibleCategoria = !popUpVisibleCategoria
                        }) {
                        Text("Adicionar Nova Categoria")
                    }
                }
            }


            AnimatedVisibility(
                visible = popUpVisibleCategoria,
                enter = fadeIn(tween(500)),
                exit = fadeOut(tween(500))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    OutlinedTextField(
                        value = novacategoria,
                        onValueChange = { novacategoria = it },
                        label = { Text("Nova Categoria") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(
                        modifier = Modifier.clip(RoundedCornerShape(16.dp)),
                        colors = ButtonDefaults.buttonColors(Orange),
                        onClick = {
                            if (novacategoria.isNotBlank()) {
                                categorias = categorias + novacategoria
                                categoria = novacategoria // Atualiza a categoria selecionada
                                novacategoria = ""
                                popUpVisibleCategoria = false
                            } else {
                                Toast.makeText(
                                    context,
                                    "Categoria não pode ser vazia",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }) {
                        Text(text = "Salvar")
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
//         Seção para fornecedor
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = fornecedor,
                    onValueChange = { fornecedor = it },
                    label = { Text("Fornecedor") },
                    modifier = Modifier.fillMaxWidth()
                )
                Button(
                    onClick = {
                        fornecedorVisible = !fornecedorVisible
                    }, // Alterna a visibilidade da lista
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .clip(RoundedCornerShape(16.dp))
                ) {
                    Image(
                        painter = painterResource(
                            id = if (fornecedorVisible) R.drawable.show_arrow_icon else R.drawable.hide_arrow_icon
                        ),
                        contentDescription = if (fornecedorVisible) "Mostrar" else "Esconder",
                        modifier = Modifier
                            .size(20.dp)
                            .background(Color.Transparent)
                    )
                }
            }
            AnimatedVisibility(
                visible = fornecedorVisible,
                enter = fadeIn(tween(500)),
                exit = fadeOut(tween(500))
            ) {
                Column(
                    Modifier.padding(16.dp)
                ) {
                    fornecedores.forEach { fornecedor1 ->
                        Button(
                            colors = ButtonDefaults.buttonColors(Orange),
                            onClick = { fornecedor = fornecedor1 },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp) // Adiciona um pouco de espaço entre os botões
                        ) {
                            Text(
                                text = fornecedor1,
                                modifier = Modifier.padding(8.dp),
                                fontSize = 16.sp
                            )
                        }
                    }
                    Spacer(modifier = Modifier.size(16.dp))
                    Button(
                        colors = ButtonDefaults.buttonColors(Orange),
                        onClick = {
                            popUpVisibleFornecedor = !popUpVisibleFornecedor
                        }) {
                        Text("Adicionar Novo Fornecedor")
                    }
                }
            }


            AnimatedVisibility(
                visible = popUpVisibleFornecedor,
                enter = fadeIn(tween(500)),
                exit = fadeOut(tween(500))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    OutlinedTextField(
                        value = novoFornecedor,  // Corrigir para usar novoFornecedor
                        onValueChange = { novoFornecedor = it },  // Atualizar novoFornecedor
                        label = { Text("Novo Fornecedor") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(
                        modifier = Modifier.clip(RoundedCornerShape(16.dp)),
                        colors = ButtonDefaults.buttonColors(Orange),
                        onClick = {
                            if (novoFornecedor.isNotBlank()) {  // Verificar se novoFornecedor não está vazio
                                fornecedores =
                                    fornecedores + novoFornecedor  // Adicionar à lista de fornecedores
                                fornecedor =
                                    novoFornecedor  // Atualizar o campo fornecedor com o novo valor
                                novoFornecedor = ""  // Limpar o campo novoFornecedor
                                popUpVisibleFornecedor = false  // Fechar o pop-up
                            } else {
                                Toast.makeText(
                                    context,
                                    "Fornecedor não pode ser vazio",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }) {
                        Text(text = "Salvar")
                    }
                }
            }


            Spacer(modifier = Modifier.height(16.dp))

            CompButton(onClickAction = {
                if (nomeProduto.isNotBlank() && descricaoProduto.isNotBlank()) {
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
                    //                    produtoViewModel.addProduto(novoProduto)
                    navController.navigate("produtos_screen")
                    // Limpar campos após o salvamento
                    nomeProduto = ""
                    descricaoProduto = ""
                    dataValidade = ""
                    unidadeMedida = ""
                    qtdEntrada = ""
                    precoCompra = ""
                    precoVenda = ""
                    categoria = ""
                } else {
                    Toast.makeText(
                        context,
                        "Por favor, preencha todos os campos.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }, text = "Salvar", icon = R.drawable.edit_icon, descIcon = "vazio")
        }
        Box(
            Modifier.align(Alignment.BottomCenter)
        ) {
            BottomBarApp(navController = navController)
        }

    }
}


////@Preview(showBackground = true)
//@Composable
//fun CadastroProdutoScreenPreview(
//    navController: NavHostController,
//    items: MutableList<ProdutoAtributo>
//) {
////    val navController = rememberNavController()
////    val items = remember { mutableListOf<ProdutoAtributo>() }
//
//    Box(modifier = Modifier.fillMaxSize()){
//        TopBarApp(
//            FirstImage = R.drawable.back_icon,
//            "Voltar",
//            SecondImage = R.drawable.lixeira_icon,
//            "lixeira",
//            Titulo = "Produtos",
//            false,
//            onClick = { navController.navigate("produtos_screen") }
//        )
//
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(vertical = 56.dp)
//                .verticalScroll(rememberScrollState())
//                .background(Color.Black)
//        ) {
//            CadastroProdutoScreen(
//                navController = navController,
//                items = items
//            )
//        }
//
//        Box(modifier = Modifier.align(Alignment.BottomCenter)){
//            BottomBarApp(navController = navController, modifier = Modifier.align(Alignment.BottomCenter))
//        }
//
//    }
//}
