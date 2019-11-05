package br.com.alura.kotlin.collection.list

fun main() {

    val prateleira = Prateleira(genero = "Literatura", livros = getLivros())

    println(prateleira.livrosOrdenadosPorAutor())
    println(prateleira.livrosOrdenadosPorAnoPublicacao())

    val porAutor = prateleira.livrosOrdenadosPorAutor()
    val porAnoPublicacao = prateleira.livrosOrdenadosPorAnoPublicacao()

    println()
    println(porAutor)
    println(porAnoPublicacao)

}

private fun Prateleira.livrosOrdenadosPorAutor(): List<Livro> {
    return this.livros.sortedBy { it.autor }
}

private fun Prateleira.livrosOrdenadosPorAnoPublicacao(): List<Livro> {
    return this.livros.sortedBy { it.anoPublicacao }
}