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

    val alfabeto = charArrayOf('a', 'b', 'c', 'd', 'e', 'f')
    val idades = intArrayOf(10, 19, 33, 40, 67)
    val fibonacci = intArrayOf(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89)
    val salarios = doubleArrayOf(1500.55, 2990.99, 8500.0, 10000.0)


    // Acessando elementos do array

    val primeiraLetraDoAlfabeto = alfabeto[0]

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
        val valorFormatado = "%.2f".format(salarios[i]) // formata para duas casas decimais
        println("R$ $valorFormatado")
    }

    var maiorIdade = 0
    for(idade in idades) {
        if(maiorIdade < idade) {
            maiorIdade = idade
        }
    }

    println("Maior idade: $maiorIdade")

    println("Maior idade: ${idades.max()}")

    val mediaDasIdades = idades.average()
    println("Média das idades: $mediaDasIdades")

    val todosMaiores = idades.all { it < 18 }
    println("Todos são maiores? $todosMaiores")

    val existeAlgumMenor = idades.any { it < 18 }
    println("Existe algum menor? $existeAlgumMenor")

    val somaDosSalarios = salarios.sum()
    println("Soma de todos os salários: $somaDosSalarios")

    val salariosAcimaDeCincoMil = salarios.filter { it > 5000 }
    println("Salários acima de 5 mil: $salariosAcimaDeCincoMil")

    val def = alfabeto.drop(3)
    println("d e f: $def")

    // Alterando arrays

    arrayDeZeros[0] = 1
    println(arrayDeZeros.joinToString())

//    for(valor in valores) {
//        valor =  valor * 2
//    }
//    Não compila

    for(i in salarios.indices) {
        salarios[i] = salarios[i] * 2
    }
}