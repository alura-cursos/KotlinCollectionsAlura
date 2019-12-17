package br.com.alura.kotlin.collection.array

import java.math.BigDecimal

fun main() {
    val salarios: Array<BigDecimal> = bigDecimalArrayDe("1500.55", "9100.00", "2990.99", "8500.00", "10000.00")

    val aumento = "1.10".toBigDecimal()
    val salariosComAumento: List<BigDecimal> = salarios.map { salario -> salario.multiplicaPor(aumento) }

    val salariosComAumentoRelativo: Array<BigDecimal> = salarios
        .map { salario -> calculaAumentoRelativo(salario, aumento) }
        .toTypedArray()

    val gastoInicial = salarios.soma()
    val meses = 6
    val somatoriaComAumento: BigDecimal = somaSalariosXMeses(
            salariosComAumentoRelativo,
            gastoInicial,
            BigDecimal(meses))

    val menorMedia = salariosComAumentoRelativo
        .sorted()
        .take(3)
        .toTypedArray()
        .media()

    val maiorMedia = salariosComAumentoRelativo
        .sorted()
        .takeLast(3)
        .toTypedArray()
        .media()
}

private fun somaSalariosXMeses(salarios: Array<BigDecimal>, gastoInicial: BigDecimal, meses: BigDecimal): BigDecimal {
    return salarios.fold(gastoInicial) { acumulador, salario ->
        acumulador + salario.multiplicaPor(meses)
    }
}

private fun calculaAumentoRelativo(salario: BigDecimal, aumento: BigDecimal): BigDecimal =
    if (salario < BigDecimal(5000)) {
        salario + BigDecimal(500)
    } else {
        salario.multiplicaPor(aumento)
    }