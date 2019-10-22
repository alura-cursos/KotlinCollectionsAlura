package br.com.alura.kotlin.collection.list

fun main() {
    // Criando listas

    val autores = listOf("João", "Helena", "Joaquim") // Tipo implícito: List<String>

    val nomesCompletos: List<String> = listOf(
            "João Guimarâes Rosa",
            "Helena Morley",
            "Joaquim Maria Machado de Assis"
    )

    val coisas = listOf(3, "Casa", 0.23) // Tipo implícito: List<Any>

    // Acessando elementos da lista

    println(autores.get(0))

    println(autores[0])

    println(autores.first())

    println(autores[1])

    println(autores[2])

    println(autores.last())

    // Percorrendo a lista

    for(autor in autores) {
        println(autor)
    }

    autores.forEach { println(it) }

    autores.forEach { autor ->
        val nomeEmLetrasMaiusculas = autor.toUpperCase()
        println(nomeEmLetrasMaiusculas)
    }

    // Obtendo sublista

    val subLista = autores.subList(fromIndex = 1, toIndex = 3)
    println(subLista)
}