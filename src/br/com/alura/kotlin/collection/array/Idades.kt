package br.com.alura.kotlin.collection.array

fun main() {
    val idades = intArrayOf(10, 19, 33, 40, 67)
    println("Idades: ${idades.joinToString(prefix = "[", postfix = "]")}")

    println("Maior idade: ${idades.max()}")

    val mediaIdades = idades.average()
    println("Média das idades: $mediaIdades")

    val todosMaiores = idades.all { it > 18 }
    println("Todos são maiores de idade? $todosMaiores")

    val existeMenor = idades.any { it < 18 }
    println("Existe algum menor de idade? $existeMenor")

    val contemQuarenta = idades.contains(40)
    println("Existe alguem com 40 anos? $contemQuarenta")
}