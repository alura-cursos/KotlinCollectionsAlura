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

    val bytes = byteArrayOf(-128, 0, 1, 2, 127)
    val idades = shortArrayOf(10, 19, 40, 67)
    val alfabeto = charArrayOf('a', 'b', 'c', 'd', 'e')
    val fibonacci = intArrayOf(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89)
    val arrayDeMilissegundos = longArrayOf(10000000093333, 23400000093333, 33904392035517)
    val valores = doubleArrayOf(10.55, 29.99, 10000.00)
    val respostas = booleanArrayOf(true, true, false, true, false)


    // Acessando elementos do array

    val primeiraLetraDoAlfabeto = alfabeto[0]

    val quartoElementoSequenciaDeFibonacci = fibonacci[3]

    val ultimaResposta = respostas[respostas.size - 1]


    // Percorrendo arrays

    for(i in 0..fibonacci.size) { // ArrayIndexOutOfBoundsException
        print("${fibonacci[i]} - ")
    }

    for(i in 0..(fibonacci.size -1)) {
        print("${fibonacci[i]} - ")
    }

    for(i in 0 until valores.size) {
        val valorFormatado = "%.2f".format(valores[i]) // formata para duas casas decimais
        println("R$ $valorFormatado")
    }

    var maiorIdade: Short = 0

    for(idade in idades) {
        if(maiorIdade < idade) {
            maiorIdade = idade
        }
    }

    println("Maior idade: $maiorIdade")

    println("Maior idade: ${idades.max()}")

    // Alterando arrays

    arrayDeZeros[0] = 1
    println(arrayDeZeros.joinToString())

    for(valor in valores) {
        valor =  valor * 2 // não compila
    }

    for(i in 0 until valores.size) {
        valores[i] = valores[i] * 2
    }

    for(i in valores.indices) {
        valores[i] = valores[i] * 2
    }
}