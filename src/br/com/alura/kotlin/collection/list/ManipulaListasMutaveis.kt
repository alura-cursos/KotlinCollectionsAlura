package br.com.alura.kotlin.collection.list

fun main() {
    // Criando listas mutáveis

    val autores = mutableListOf("João", "Helena", "Joaquim") // Tipo implícito: MutableList<String>

    println(autores)

    // Adicionando elementos

    autores.add("Euclides")

    println(autores)

    autores.addAll(listOf("João", "Joaquim"))

    println(autores)

    // Removendo elementos

    autores.removeAt(0)

    println(autores)

    autores.remove("Joaquim")

    println(autores)

    autores.removeAll { it.startsWith("J") }

    println(autores)

}