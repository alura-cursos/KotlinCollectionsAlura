package br.com.alura.kotlin.collection.list

import kotlin.system.measureTimeMillis

fun main() {
    val listaGrandeLivros = List(10000) {
        Livro(nome = "Livro $it", autor = "Autor $it", anoPublicacao = it.toLong(), editora = "Editora $it")
    }

    val tempoList = measureTimeMillis {
        listaGrandeLivros
                .filter { it.anoPublicacao > 1000 }
                .sortedBy { it.autor }
                .map { "Título: ${it.nome}" }
                .find { it.contains("1001") }
    }

    val tempoSequence = measureTimeMillis {
        listaGrandeLivros
                .asSequence()
                .filter { it.anoPublicacao > 1000 }
                .sortedBy { it.autor }
                .map { "Título: ${it.nome}" }
                .find { it.contains("1001") }
    }

    println("Tempo List: $tempoList")
    println("Tempo Sequence: $tempoSequence")


}