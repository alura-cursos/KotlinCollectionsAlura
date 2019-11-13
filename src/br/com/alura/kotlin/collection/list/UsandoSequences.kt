package br.com.alura.kotlin.collection.list

import kotlin.system.measureTimeMillis

fun main() {
    val listaGrandeLivros = List(2000) {
        Livro(nome = "Livro $it", autor = "Autor", anoPublicacao = it.toLong(), editora = "Editora $it")
    }

    val tempoList = measureTimeMillis {
        listaGrandeLivros
                .filter { it.anoPublicacao > 1000 }
                .sortedBy { it.autor }
                .map { "Título: ${it.nome}" }
                .forEach(::print)
    }

    val tempoSequence = measureTimeMillis {
        listaGrandeLivros
                .asSequence()
                .filter { it.anoPublicacao > 1000 }
                .sortedBy { it.autor }
                .map { "Título: ${it.nome}" }
                .forEach(::print)
    }

    println("\nTempo List: $tempoList")
    println("Tempo Sequence: $tempoSequence")
}