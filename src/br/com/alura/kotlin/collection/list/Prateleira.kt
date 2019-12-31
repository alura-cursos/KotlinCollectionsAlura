package br.com.alura.kotlin.collection.list

data class Prateleira (
    val genero: String,
    val livros: List<Livro>
) {
    fun livrosOrdenadosPorAutor(): List<Livro> {
        return this.livros.sortedBy { it.autor }
    }

    fun livrosOrdenadosPorAnoPublicacao(): List<Livro> {
        return this.livros.sortedBy { it.anoPublicacao }
    }
}