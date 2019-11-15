package br.com.alura.kotlin.collection.list

import kotlin.system.measureTimeMillis

fun main() {
    val listaGrandeLivros = List(10000) {
        Livro(nome = "Livro $it", autor = "Autor $it", anoPublicacao = it.toLong(), editora = "Editora $it")
    }

    val tempoList = measureTimeMillis {
        listaGrandeLivros
                .filter { it.anoPublicacao > 1900 }
                .map { it.autor }
                .find { it.startsWith("A") }
    }

    val tempoSequence = measureTimeMillis {
        listaGrandeLivros
                .asSequence()
                .filter { it.anoPublicacao > 1900 }
                .map { it.autor }
                .find { it.startsWith("A") }
    }

    println("Tempo List: $tempoList")
    println("Tempo Sequence: $tempoSequence")

    listaDeLivros()
            .filter { print("f-"); it.anoPublicacao > 1900 }
            .map { print("m-"); it.autor }
            .find { print("F-"); it.startsWith("J") }
            .also { print("$it\n") }

    listaDeLivros()
            .asSequence()
            .filter { print("f-"); it.anoPublicacao > 1900 }
            .map { print("m-"); it.autor }
            .find { print("F-"); it.startsWith("J") }
            .also { print("$it\n") }

}