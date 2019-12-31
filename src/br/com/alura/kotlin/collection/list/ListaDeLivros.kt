package br.com.alura.kotlin.collection.list

fun main() {
    val livro1 = Livro(
        titulo = "Grande Sertão: Veredas",
        autor = "João Guimarães Rosa",
        anoPublicacao = 1956
    )

    val livro2 = Livro(
        titulo = "Minha vida de menina",
        autor = "Helena Morley",
        anoPublicacao = 1942,
        editora = "Editora A"
    )

    val livro3 = Livro(
        titulo = "Memórias Póstumas de Brás Cubas",
        autor = "Machado de Assis",
        anoPublicacao = 1881
    )

    val livro4 = Livro(
        titulo = "Iracema",
        autor = "José de Alencar",
        anoPublicacao = 1865,
        editora = "Editora B"
    )

    val meusLivros: MutableList<Livro> = mutableListOf(livro1, livro2, livro3, livro4)

    val livro5 = Livro(
        titulo = "Sagarana",
        autor = "João Guimarães Rosa",
        anoPublicacao = 1946,
        editora = "Editora A"
    )
    meusLivros.add(livro5)

    meusLivros.imprimeListaComMarcadores()

    meusLivros.remove(livro3)

    meusLivros.imprimeListaComMarcadores()

    val titulos: List<String> = meusLivros.titulosPorAnoPublicacaoDoAutor("João")

    println("\n $titulos")

    val meusLivrosComNulos: MutableList<Livro?> = mutableListOf(null, null, *meusLivros.toTypedArray())

    meusLivrosComNulos.imprimeListaComMarcadores()

    val titulosFiltrados = meusLivrosComNulos.titulosPorAnoPublicacaoDoAutor("Jo")

    println("\n $titulosFiltrados \n")

    meusLivros.add(livro3)
    meusLivros
        .groupBy { it.editora ?: "Editora desconhecida" }
        .forEach { (editora: String?, livros: List<Livro>) ->
            println(" $editora: ${livros.joinToString { it.titulo }}")
        }


}