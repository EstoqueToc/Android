package com.example.estoquetoc.componentes

data class Produto (
    val nomeProduto: String,
    val descricaoProduto: String,
    val dataValidade: String,
    val unidadeMedida: String,
    val qtdEntrada: String,
    val precoCompra: String,
    val precoVenda: String,
    val categoria: String
)