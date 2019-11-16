package br.com.alura.kotlin.collection.map

fun main() {
    val coisas = mutableMapOf(
            "fruta" to "abacaxi",
            "animal" to "cachorro",
            "pais" to "Brasil"
    )

    println(coisas)
    println(coisas["fruta"])

    coisas["fruta"] = "banana"
    println(coisas)

    coisas["estado"] = "São Paulo"
    println(coisas)

    coisas["cidade"] = "São Paulo"
    println(coisas)

    val animal by coisas
    println(animal)

    println("cachorro" in coisas)
    println("animal" in coisas)

    val letraEBinario = listOf('a', 'l', 'u', 'r', 'a')
            .map { it to Integer.toBinaryString(it.toInt()) }
            .toMap()

    println(letraEBinario)
}