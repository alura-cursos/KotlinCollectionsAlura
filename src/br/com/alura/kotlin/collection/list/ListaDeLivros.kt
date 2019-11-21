package br.com.alura.kotlin.collection.list

fun main() {
    val meusLivros: MutableList<Livro> = mutableListOf(
        Livro(nome = "Grande Sertão: Veredas", autor = "João Guimarães Rosa", anoPublicacao = 1956),
        Livro(nome = "Minha vida de menina", autor = "Helena Morley", anoPublicacao = 1942, editora = "Editora A"),
        Livro(nome = "Memórias Póstumas de Brás Cubas", autor = "Machado de Assis", anoPublicacao = 1881),
        Livro(nome = "Iracema", autor = "José de Alencar", anoPublicacao = 1865, editora = "Editora B")
    )
    println(meusLivros)

    meusLivros.add(Livro(nome = "Sagarana", autor = "João Guimarães Rosa", anoPublicacao = 1946))

    meusLivros.imprimeListaComMarcadores()

    val titulos: List<String> = titulosOrdenadosPorAnoPublicacaoFiltradosPorAutor(meusLivros, "Jo")

    println("\n $titulos")

    val meusLivrosComNulos: MutableList<Livro?> = mutableListOf(null, null, *meusLivros.toTypedArray())

    meusLivrosComNulos.imprimeListaComMarcadores()

    val titulosFiltrados = titulosOrdenadosPorAnoPublicacaoFiltradosPorAutor(meusLivrosComNulos, "Jo")

    println("\n" + titulosFiltrados)

    meusLivrosComNulos.addAll( livrosNovos() )

    meusLivrosComNulos.imprimeLivrosPorEditora()

    println("\n" + meusLivrosComNulos.autoresOrdenados())

}

private fun livrosNovos(): List<Livro> =
    listOf(
            Livro(
                    nome = "Vidas Secas",
                    autor = "Graciliano Ramos",
                    anoPublicacao = 1938,
                    editora = "Editora A"),
            Livro(
                    nome = "Mayombe",
                    autor = "Pepetela",
                    anoPublicacao = 1979,
                    editora = "Editora B"),
            Livro(
                    nome = "O Cortiço",
                    autor = "Aluísio Azevedo",
                    anoPublicacao = 1890,
                    editora = "Editora B")
    )


fun Collection<Livro?>.imprimeListaComMarcadores() {
    println("\n ### Lista de Livros ###")
    println(this.filterNotNull().joinToString(separator = "\n") { " - ${it.nome} de ${it.autor}" })
}

fun Collection<Livro?>.imprimeLivrosPorEditora() {
    println("\n ### Lista de Livros Por Editora ###")
    this.filterNotNull()
        .groupBy { it.editora ?: "Editora X" }
        .forEach { (editora: String, livros: List<Livro>) ->
            println(" $editora: ${livros.joinToString { it.nome }}")
        }
}

fun Collection<Livro?>.autoresOrdenados(): List<String> =
    this.filterNotNull()
        .map { it.autor }
        .distinct()
        .sorted()

fun titulosOrdenadosPorAnoPublicacaoFiltradosPorAutor(livros: Collection<Livro?>, prefixoAutor: String): List<String> {
    return livros
        .filterNotNull()
        .filter { it.autor.startsWith(prefixoAutor) }
        .sortedBy { it.anoPublicacao }
        .map { it.nome }
}