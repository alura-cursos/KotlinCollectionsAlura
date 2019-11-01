package br.com.alura.kotlin.collection.list

fun main() {
    val grandSertao = Livro(nome = "Grande Sertão: Veredas", autor = "João Guimarães Rosa")
    val minhaVida = Livro(nome = "Minha vida de menina", autor = "Helena Morley")
    val memoriasPostumas = Livro(nome = "Memórias Póstumas de Brás Cubas", autor = "Machado de Assis")

    val meusLivros = mutableListOf(grandSertao, minhaVida, memoriasPostumas)

    println("Livros: $meusLivros")

    meusLivros.add(Livro(nome = "Sagarana", autor = "João Guimarães Rosa"))

    println()
    println(meusLivros.joinToString(separator = "\n") { " - ${it.nome} por ${it.autor}" })

    val livrosDoGuimaraesRosa = meusLivros.filter { it.autor == "João Guimarães Rosa" }.toList()
    println()
    println(livrosDoGuimaraesRosa.joinToString { it.nome })
}