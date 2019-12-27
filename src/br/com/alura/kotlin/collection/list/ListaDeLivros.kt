package br.com.alura.kotlin.collection.list

fun main() {
    val meusLivros: MutableList<Livro> = mutableListOf(
        Livro(titulo = "Grande Sertão: Veredas", autor = "João Guimarães Rosa", anoPublicacao = 1956),
        Livro(titulo = "Minha vida de menina", autor = "Helena Morley", anoPublicacao = 1942, editora = "Editora A"),
        Livro(titulo = "Memórias Póstumas de Brás Cubas", autor = "Machado de Assis", anoPublicacao = 1881),
        Livro(titulo = "Iracema", autor = "José de Alencar", anoPublicacao = 1865, editora = "Editora B")
    )
    println(meusLivros)

    meusLivros.add(Livro(titulo = "Sagarana", autor = "João Guimarães Rosa", anoPublicacao = 1946))

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
            titulo = "Vidas Secas",
            autor = "Graciliano Ramos",
            anoPublicacao = 1938,
            editora = "Editora A"),
        Livro(
            titulo = "Mayombe",
            autor = "Pepetela",
            anoPublicacao = 1979,
            editora = "Editora B"),
        Livro(
            titulo = "O Cortiço",
            autor = "Aluísio Azevedo",
            anoPublicacao = 1890,
            editora = "Editora B")
    )

fun MutableList<Livro>.imprimeListaComMarcadores() {
    val listaComMarcadores = this.joinToString(separator = "\n") {
        " - ${it.titulo} de ${it.autor}"
    }
    println("\n ### Lista de Livros ### \n${listaComMarcadores}")
}

fun titulosOrdenadosPorAnoPublicacaoFiltradosPorAutor(livros: Collection<Livro?>, prefixoAutor: String): List<String> {
    return livros
        .filterNotNull()
        .filter { it.autor.startsWith(prefixoAutor) }
        .sortedBy { it.anoPublicacao }
        .map { it.titulo }
}