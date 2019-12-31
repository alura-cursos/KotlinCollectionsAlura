package br.com.alura.kotlin.collection.list

fun main() {

    val prateleira = Prateleira(genero = "Literatura", livros = listaDeLivros())

    val porAutor = prateleira.livrosOrdenadosPorAutor()
    val porAnoPublicacao = prateleira.livrosOrdenadosPorAnoPublicacao()

    println(porAutor)
    println(porAnoPublicacao)

}