package br.com.alura.kotlin.collection.array

import java.math.BigDecimal

fun main() {
    val salarios: Array<BigDecimal> = arrayOf(
            1500.55.toBigDecimal(),
            9100.0.toBigDecimal(),
            2990.99.toBigDecimal(),
            8500.0.toBigDecimal(),
            10000.0.toBigDecimal()
    )
    println("Salários: ${salarios.joinToString(prefix = "[", postfix = "]")}")

    val somaDosSalarios: BigDecimal = salarios.soma()
    println("Soma total de salários: $somaDosSalarios")

    println("Maior salário entre os três primeiros: ${salarios.take(3).max()}")

    println("Menor salário entre os três últimos: ${salarios.takeLast(3).min()}")

    val aumento = 1.1.toBigDecimal()
    val salariosComAumento: List<BigDecimal> = salarios.map { it * aumento }
    println("Salários com aumento: $salariosComAumento")

}

private fun Array<BigDecimal>.soma(): BigDecimal {
    var total = BigDecimal.ZERO
    for(elemento in this) {
        total += elemento
    }
    return total
}

private fun DoubleArray.mediaDosValoresAcimaDe(valorMinimo: Double): Double =
    this
        .filter { it > valorMinimo }
        .average()

private fun ordenaSalariosERemoveOMenor(salarios: DoubleArray) = salarios.sorted().drop(1)

private fun somaSalariosComAumentoXMeses(salarios: DoubleArray, gastoInicial: Double, meses: Int): Double {
    return salarios.fold(gastoInicial) { acumulador, salario ->
        acumulador + (salario * meses)
    }
}

private fun calculaAumentoRelativo(salario: Double, aumento: Double): Double =
    if (salario < 5000) {
        salario + 500
    } else {
        salario * aumento
    }
