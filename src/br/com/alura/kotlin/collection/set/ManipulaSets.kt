package br.com.alura.kotlin.collection.set

import java.util.*

fun main() {
    val alura = mutableSetOf('A', 'L', 'U', 'R', 'A')
    println(alura)

    alura.add('A')
    println(alura)

    alura.add('a')
    println(alura)

    alura.forEach {
        print("${Integer.toBinaryString(it.toInt())} ")
    }
    println()

    val frutas = listOf("pera", "uva", "maçã", "banana", "mamão", "banana", "uva")
    val frutasDistintas = frutas.toSet()
    println(frutasDistintas)

    val listaOrdenada: SortedSet<String> = frutasDistintas.toSortedSet()
    println(listaOrdenada)

    val filmesDeFiccao = listaDeFilmes
            .filter { it.genero.contains("ficção científica") }
            .map { it.titulo }

    println(filmesDeFiccao)

    val filmesDeAcaoEFiccao = listaDeFilmes
            .filter { it.genero.containsAll(setOf("ação", "ficção científica")) }
            .map { it.titulo }

    println(filmesDeAcaoEFiccao)

    val qtdFilmes = listaDeFilmes.filter { it.genero.size > 2 }.count()
    println(qtdFilmes)

    val todosOsGeneros = listaDeFilmes
            .flatMap { it.genero }
            .distinct()
            .map { it.capitalize() }
    
    println(todosOsGeneros)
}