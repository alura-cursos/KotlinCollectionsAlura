package br.com.alura.kotlin.collection.array

fun main() {

    // Inicializando arrays de valores primitivos

    val arrayDeZeros = IntArray(10)
    println(arrayDeZeros.joinToString())

    val arrayDeIndices = IntArray(10) { it }
    println(arrayDeIndices.joinToString())

    val arrayDeSetes = DoubleArray(10) { 7.0 }
    println(arrayDeSetes.joinToString())

    val multiplosDeMil = LongArray(10) { it * 1000L }
    println(multiplosDeMil.joinToString())

    // Outras funções para construir e inicializar arrays de valores primitivos
    println(byteArrayOf(-128, 0, 1, 2, 127).joinToString())
    println(shortArrayOf(-32768, 0, 1, 2, 32767).joinToString())
    println(charArrayOf('\u0000', 'a', 'b', 'c', '\uffff').joinToString())
    println(intArrayOf(-2_147_483_648, 0, 42, 2_147_483_647).joinToString())
    println(longArrayOf(-9_223_372_036_854_775_807, 10L, 123_456_789_10, 9_223_372_036_854_775_807).joinToString())
    println(doubleArrayOf(987.1, .2, 123412342143.123143214).joinToString())
    println(booleanArrayOf(true, true, false).joinToString())

    // Acessando elementos do array

    val primeiroElemento = arrayDeIndices[0] // O índice inicia em zero
    println(primeiroElemento)

    val ultimoElemento = arrayDeIndices[9] // O último índice é igual ao tamanho do array -1
    println(ultimoElemento)

    arrayDeIndices[arrayDeIndices.size -1] // Outra forma de acessar o último elemento do array

    // Percorrendo arrays

    // Alterando arrays

    arrayDeZeros[0] = 1
    println(arrayDeZeros.joinToString())
}