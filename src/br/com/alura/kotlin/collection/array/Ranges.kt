package br.com.alura.kotlin.collection.array

fun main() {
    val serie: IntRange = 1.rangeTo(10)
    println(serie)
    for (i in serie) {
        print("$i ")
    }

    val umADez: IntRange = 1..10
    println("\n$umADez")
    umADez.forEach { print("$it ") }

    val numerosPares: IntProgression = 2..100 step 2
    println("\n$numerosPares")
    numerosPares.forEach { print("$it ") }

    val multiplosDeTres: IntProgression = 99 downTo 3 step 3
    println("\n$multiplosDeTres")
    multiplosDeTres.forEach { print("$it ") }

    val deZeroANove: IntRange = 0 until 10
    println("\n$deZeroANove")
    deZeroANove.forEach { print("$it ") }

    val alfabeto: CharRange = 'a'..'z'
    println("\n$alfabeto")
    alfabeto.forEach { print("$it ") }
}