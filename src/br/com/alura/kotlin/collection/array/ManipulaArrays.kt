package br.com.alura.kotlin.collection.array

fun main() {

    // Arrays de inteiros

    val arrayDeZeros = IntArray(10)
    println(arrayDeZeros.joinToString())

    val arrayDeSetes = IntArray(10) { 7 }
    println(arrayDeSetes.joinToString())

    val arrayDeIndices = IntArray(10) { it }
    println(arrayDeIndices.joinToString())

    val arrayIncremental = IntArray(10) { it +1 }
    println(arrayIncremental.joinToString())

    val arrayDeInteiros = intArrayOf(42, 18, 33333333)
    println(arrayDeInteiros.joinToString())

    arrayDeZeros[0] = 1
    println(arrayDeZeros.joinToString())
}