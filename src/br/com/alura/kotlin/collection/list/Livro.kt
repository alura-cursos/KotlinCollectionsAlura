package br.com.alura.kotlin.collection.list

data class Livro(
    val titulo: String,
    val autor: String,
    val anoPublicacao: Long,
    val editora: String? = null
)