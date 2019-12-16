package br.com.alura.kotlin.collection.array

fun main() {

    val idades: IntArray = intArrayOf(18, 19, 33, 40, 67)

    val maiorIdade = encontraMaiorIdade(idades)

    val menorIdade = encontraMenorIdade(idades)

    val salarios: DoubleArray = doubleArrayOf(1500.55, 9100.0, 2990.99, 8500.0, 10000.0)

    val aumento = 1.1
    for(i in salarios.indices) {
        salarios[i] = salarios[i] * aumento
    }

    salarios.forEachIndexed { i, salario ->
        salarios[i] = salario * aumento
    }
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