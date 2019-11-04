package br.com.alura.kotlin.collection.list

fun main() {
    val meusLivros: MutableList<Livro> = mutableListOf(
        Livro(nome = "Grande Sertão: Veredas", autor = "João Guimarães Rosa", anoPublicacao = 1956),
        Livro(nome = "Minha vida de menina", autor = "Helena Morley", anoPublicacao = 1942),
        Livro(nome = "Memórias Póstumas de Brás Cubas", autor = "Machado de Assis", anoPublicacao = 1881),
        Livro(nome = "Iracema", autor = "José de Alencar", anoPublicacao = 1865)
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

    val meusLivrosComNulls: MutableList<Livro?> = mutableListOf(
        Livro(nome = "Grande Sertão: Veredas", autor = "João Guimarães Rosa", anoPublicacao = 1956),
        Livro(nome = "Minha vida de menina", autor = "Helena Morley", anoPublicacao = 1942),
        null,
        Livro(nome = "Memórias Póstumas de Brás Cubas", autor = "Machado de Assis", anoPublicacao = 1881),
        Livro(nome = "Iracema", autor = "José de Alencar", anoPublicacao = 1865),
        null,
        Livro(nome = "Sagarana", autor = "João Guimarães Rosa", anoPublicacao = 1946)
    )

    println()
    println(meusLivrosComNulls.joinToString(separator = "\n") { " - ${it?.nome} de ${it?.autor}" })

    println()
    println(meusLivrosComNulls.filter{ it != null }.joinToString(separator = "\n") { " - ${it?.nome} de ${it?.autor}" })

    val nomes = meusLivrosComNulls
        .filter { it != null }
        .filter { it?.autor?.startsWith("J") ?: false }
        .sortedBy { it?.anoPublicacao }
        .map { it?.nome }

    println()
    println(nomes)

    meusLivrosComNulls
        .filter { it != null }
        .filter { it!!.autor.startsWith("J") }
        .sortedBy { it!!.anoPublicacao }
        .map { it!!.nome }

    val nomesSemNulos = meusLivrosComNulls
        .filterNotNull()
        .filter { it.autor.startsWith("J") }
        .sortedBy { it.anoPublicacao }
        .map { it.nome }

    println()
    println(nomesSemNulos)

    println()
    println(meusLivrosComNulls.autoresOrdenados())
}

fun Collection<Livro?>.autoresOrdenados(): List<String> {
    return this
        .filterNotNull()
        .map { it.autor }
        .distinct()
        .sorted()
}