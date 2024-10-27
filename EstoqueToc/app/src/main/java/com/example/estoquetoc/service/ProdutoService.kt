package com.example.estoquetoc.service

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ProdutoService {

//    @POST("produtos")
//    suspend fun cadastrarProdutos(
//        @Body produtoRequest: ProdutoRequest
//    ): Response<ProdutoResponse>

    @POST("categorias")
    suspend fun cadastrarCategorias(
        @Body categoriaRequest: CategoriaRequest
    ): Response<CategoriaResponse>
}

data class CategoriaResponse(
    val id: Long,
    val nome: String
)

data class CategoriaRequest(
    val nome: String
)

