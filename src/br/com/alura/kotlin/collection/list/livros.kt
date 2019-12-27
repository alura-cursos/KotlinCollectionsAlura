package br.com.alura.kotlin.collection.list

fun listaDeLivros() = mutableListOf(
    Livro(titulo = "Grande Sertão: Veredas", autor = "João Guimarães Rosa", anoPublicacao = 1956),
    Livro(titulo = "Minha vida de menina", autor = "Helena Morley", anoPublicacao = 1942, editora = "Editora A"),
    Livro(titulo = "Memórias Póstumas de Brás Cubas", autor = "Machado de Assis", anoPublicacao = 1881),
    Livro(titulo = "Sagarana", autor = "João Guimarães Rosa", anoPublicacao = 1946),
    Livro(titulo = "Iracema", autor = "José de Alencar", anoPublicacao = 1865, editora = "Editora B"),
    Livro(titulo = "Vidas Secas", autor = "Graciliano Ramos", anoPublicacao = 1938, editora = "Editora A"),
    Livro(titulo = "Mayombe", autor = "Pepetela", anoPublicacao = 1979, editora = "Editora B"),
    Livro(titulo = "O Cortiço", autor = "Aluísio Azevedo", anoPublicacao = 1890, editora = "Editora B")
)

fun Collection<Livro?>.imprimeListaComMarcadores() {
    val listaComMarcadores = this
        .filterNotNull()
        .joinToString(separator = "\n") {
            " - ${it.titulo} de ${it.autor}"
        }
    println("\n ### Lista de Livros ### \n${listaComMarcadores}")
}

fun Collection<Livro?>.imprimeLivrosPorEditora() {
    println("\n ### Lista de Livros Por Editora ###")
    this.filterNotNull()
        .groupBy { it.editora ?: "Editora X" }
        .forEach { (editora: String, livros: List<Livro>) ->
            println(" $editora: ${livros.joinToString { it.titulo }}")
        }
}

fun Collection<Livro?>.autoresOrdenados(): List<String> =
    this.filterNotNull()
        .map { it.autor }
        .distinct()
        .sorted()