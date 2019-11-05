package br.com.alura.kotlin.collection.list

data class PrateleiraMutavel (
    val genero: String,
    val livros: MutableList<Livro>
)