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

    println()
    println(meusLivros.joinToString(separator = "\n") { " - ${it.nome} de ${it.autor}" })

    val meusLivrosComFiltro = meusLivros
        .filter { it.autor.startsWith("J") }
        .sortedBy { it.anoPublicacao }
        .map { it.nome }

    println()
    println(meusLivrosComFiltro)

    val meusLivrosComNulos = mutableListOf<Livro?>(null, null)
    meusLivrosComNulos.addAll(meusLivros)

    println()
    println(meusLivrosComNulos.joinToString(separator = "\n") { " - ${it?.nome} de ${it?.autor}" })

    println()
    println(meusLivrosComNulos.filter { it != null }.joinToString(separator = "\n") { " - ${it!!.nome} de ${it.autor}" })

    val nomesComFilter = meusLivrosComNulos
        .filter { it != null }
        .filter { it!!.autor.startsWith("J") }
        .sortedBy { it!!.anoPublicacao }
        .map { it!!.nome }

    println()
    println(nomesComFilter)

    val nomesComFilterNotNull = meusLivrosComNulos
        .filterNotNull()
        .filter { it.autor.startsWith("J") }
        .sortedBy { it.anoPublicacao }
        .map { it.nome }

    println()
    println(nomesComFilterNotNull)

    meusLivrosComNulos.addAll(
            listOf(
                Livro(nome = "Vidas Secas", autor = "Graciliano Ramos", anoPublicacao = 1938, editora = "Editora A"),
                Livro(nome = "Mayombe", autor = "Pepetela", anoPublicacao = 1979, editora = "Editora B"),
                Livro(nome = "O Cortiço", autor = "Aluísio Azevedo", anoPublicacao = 1890, editora = "Editora B")
            )
    )

    println()
    meusLivrosComNulos
            .filterNotNull()
            .groupBy { it.editora ?: "Editora X" }
            .forEach { (editora: String, livros: List<Livro>) ->
                println("$editora: ${livros.joinToString { it.nome }}")
            }

    println()
    println(meusLivrosComNulos.autoresOrdenados())

}

fun Collection<Livro?>.autoresOrdenados(): List<String> {
    return this
        .filterNotNull()
        .map { it.autor }
        .distinct()
        .sorted()
}