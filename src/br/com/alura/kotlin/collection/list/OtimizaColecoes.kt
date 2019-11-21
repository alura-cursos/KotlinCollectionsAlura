package br.com.alura.kotlin.collection.list

import kotlin.system.measureTimeMillis

fun main() {
    val listaGrandeLivros = List(10000) {
        Livro(titulo = "Livro $it", autor = "Autor $it", anoPublicacao = it.toLong(), editora = "Editora $it")
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


    val livroMaisRecente = listaDeLivros().filter {
        it.anoPublicacao == listaDeLivros().maxBy(Livro::anoPublicacao)?.anoPublicacao
    }
    println(livroMaisRecente)

    val anoPublicacaoMaisRecente = listaDeLivros().maxBy(Livro::anoPublicacao)?.anoPublicacao
    val livroMaisRecenteOtimizado = listaDeLivros().filter { it.anoPublicacao == anoPublicacaoMaisRecente }
    println(livroMaisRecenteOtimizado)

    println(livroMaisRecente == livroMaisRecenteOtimizado)


    val tamanho = listaDeLivros().filter { it.autor == "João Guimarães Rosa" }.size
    val tamanhoOtimizado = listaDeLivros().filter { it.autor == "João Guimarães Rosa" }.count()
    println(tamanho == tamanhoOtimizado)
}