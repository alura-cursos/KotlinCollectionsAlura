package br.com.alura.kotlin.collection.list

fun main() {

    val livros = getLivros()

    val prateleira = PrateleiraMutavel(genero = "Literatura", livros = livros)

    println(prateleira.livrosOrdenadosPorAutor())
    println(prateleira.livrosOrdenadosPorAnoPublicacao())

    val porAutor = prateleira.livrosOrdenadosPorAutor()
    val porAnoPublicacao = prateleira.livrosOrdenadosPorAnoPublicacao()

    println()
    println(porAutor)
    println(porAnoPublicacao)

}

private fun PrateleiraMutavel.livrosOrdenadosPorAutor(): List<Livro> {
    this.livros.sortBy { it.autor }
    return this.livros
}

private fun PrateleiraMutavel.livrosOrdenadosPorAnoPublicacao(): List<Livro> {
    this.livros.sortBy { it.anoPublicacao }
    return this.livros
}