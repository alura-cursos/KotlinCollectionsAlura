package br.com.alura.kotlin.collection.list

fun main() {
    val livros = mutableListOf(
        Livro(nome = "Grande Sertão: Veredas", autor = "João Guimarães Rosa", anoPublicacao = 1956),
        Livro(nome = "Minha vida de menina", autor = "Helena Morley", anoPublicacao = 1942, editora = "Editora A"),
        Livro(nome = "Memórias Póstumas de Brás Cubas", autor = "Machado de Assis", anoPublicacao = 1881),
        Livro(nome = "Sagarana", autor = "João Guimarães Rosa", anoPublicacao = 1946),
        Livro(nome = "Iracema", autor = "José de Alencar", anoPublicacao = 1865, editora = "Editora B"),
        Livro(nome = "Vidas Secas", autor = "Graciliano Ramos", anoPublicacao = 1938, editora = "Editora A"),
        Livro(nome = "Mayombe", autor = "Pepetela", anoPublicacao = 1979, editora = "Editora B"),
        Livro(nome = "O Cortiço", autor = "Aluísio Azevedo", anoPublicacao = 1890, editora = "Editora B")
    )

    val prateleira = Prateleira(genero = "Literatura", livros = livros)

    println(prateleira.livrosOrdenadosPorAutor())
    println(prateleira.livrosOrdenadosPorAnoPublicacao())

    val porAutor = prateleira.livrosOrdenadosPorAutor()
    val porAnoPublicacao = prateleira.livrosOrdenadosPorAnoPublicacao()

    println()
    println(porAutor)
    println(porAnoPublicacao)

}

private fun Prateleira.livrosOrdenadosPorAutor(): List<Livro> {
    this.livros.sortBy { it.autor }
    return this.livros
}

private fun Prateleira.livrosOrdenadosPorAnoPublicacao(): List<Livro> {
    this.livros.sortBy { it.anoPublicacao }
    return this.livros
}