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

    val kotlin = charArrayOf('k', 'o', 't', 'l', 'i', 'n')
    val idades = intArrayOf(10, 19, 33, 40, 67)
    val fibonacci = intArrayOf(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89)
    val salarios = doubleArrayOf(1500.55, 9100.0, 2990.99, 8500.0, 10000.0)


    // Acessando elementos do array

    val letraK = kotlin[0]

    val quartoElementoSequenciaDeFibonacci = fibonacci[3]

    val ultimoSalario = salarios[salarios.size -1]


    // Percorrendo arrays

//    for(i in 0..fibonacci.size) {
//        print("${fibonacci[i]} - ")
//    }
//    ArrayIndexOutOfBoundsException

    for(i in 0..(fibonacci.size -1)) {
        print("${fibonacci[i]} - ")
    }

    println()
    for(i in 0 until salarios.size) {
        val valorFormatado = "R$ %.2f".format(salarios[i]) // formata para duas casas decimais
        println(valorFormatado)
    }

    val maiorIdade = encontraMaiorIdade(idades)
    println("Maior idade: $maiorIdade")

    val menorIdade = encontraMenorIdade(idades)
    println("Menor idade: $menorIdade")

    // Alterando arrays

    arrayDeZeros[0] = 1
    println(arrayDeZeros.joinToString())

//    for(valor in valores) {
//        valor =  valor * 2
//    }
//    Não compila

    val aumento = 1.1
    for(i in salarios.indices) {
        salarios[i] = salarios[i] * aumento
    }
    println("Salários após aumento: ${salarios.joinToString()}")

    salarios.forEachIndexed { i, salario ->
        salarios[i] = salario * aumento
    }
    println("Salários após segundo aumento: ${salarios.joinToString()}")
}

private fun encontraMenorIdade(idades: IntArray): Int {
    var menorIdade = Int.MAX_VALUE
    idades.forEach {
        if (menorIdade > it) {
            menorIdade = it
        }
    }
    return menorIdade
}

private fun encontraMaiorIdade(idades: IntArray): Int {
    var maiorIdade = Int.MIN_VALUE
    for (idade in idades) {
        if (maiorIdade < idade) {
            maiorIdade = idade
        }
    }
    return maiorIdade
}