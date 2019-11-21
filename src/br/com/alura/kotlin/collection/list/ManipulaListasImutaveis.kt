package br.com.alura.kotlin.collection.list

fun main() {

    val prateleira = Prateleira(genero = "Literatura", livros = listaDeLivros())

    println(prateleira.livrosOrdenadosPorAutor())
    println(prateleira.livrosOrdenadosPorAnoPublicacao())

    val porAutor: List<Livro> = prateleira.livrosOrdenadosPorAutor()
    val porAnoPublicacao: List<Livro> = prateleira.livrosOrdenadosPorAnoPublicacao()

    println(porAutor)
    println(porAnoPublicacao)

    val livroNovo = Livro(titulo = "Dom Casmurro", autor = "Machado de Assis", anoPublicacao = 1899)

    val prateleiraComLivroNovo = prateleira.copy(livros = prateleira.livros + livroNovo)

    println("Prateleira inicial: ${prateleira.livros.size}")
    println("Prateleira com livro novo: ${prateleiraComLivroNovo.livros.size}")

    val prateleiraSemLivroNovo = prateleiraComLivroNovo.copy(livros = prateleiraComLivroNovo.livros - livroNovo)

    println("Prateleira sem livro novo: ${prateleiraSemLivroNovo.livros.size}")

    println(prateleira == prateleiraSemLivroNovo)
    println(prateleira === prateleiraSemLivroNovo)
}

private fun Prateleira.livrosOrdenadosPorAutor(): List<Livro> {
    return this.livros.sortedBy { it.autor }
}

private fun Prateleira.livrosOrdenadosPorAnoPublicacao(): List<Livro> {
    return this.livros.sortedBy { it.anoPublicacao }
}