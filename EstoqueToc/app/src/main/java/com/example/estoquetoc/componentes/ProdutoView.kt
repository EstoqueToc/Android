package com.example.estoquetoc.componentes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ProdutoViewModel : ViewModel() {
    var listaProduto by mutableStateOf(listOf<Produto>())
        private set

    fun addProduto(produto: Produto) {
        listaProduto = listaProduto + produto
    }

    fun setListaProduto(produtos: List<Produto>) {
        listaProduto = produtos
    }
}
