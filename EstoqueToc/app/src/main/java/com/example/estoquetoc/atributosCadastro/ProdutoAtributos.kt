package com.example.estoquetoc.atributosCadastro

data class ProdutoAtributo (
    val nomeProduto: String,
    val descricaoProduto: String,
    val dataValidade: String,
    val unidadeMedida: String,
    val qtdEntrada: String,
    val precoCompra: String,
    val precoVenda: String,
    val categoria: String
)