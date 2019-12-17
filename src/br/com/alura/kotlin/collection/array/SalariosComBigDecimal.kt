package br.com.alura.kotlin.collection.array

import java.math.BigDecimal

fun main() {
    val salarios: Array<BigDecimal> = bigDecimalArrayDe("1500.55", "9100.00", "2990.99", "8500.00", "10000.00")

    println(salarios.contentToString())

    val aumento = "1.10".toBigDecimal()
    val salariosComAumento: List<BigDecimal> = salarios.map { salario -> salario.multiplicaPor(aumento) }

    val salariosComAumentoRelativo: List<BigDecimal> = salarios.map { salario ->
        calculaAumentoRelativo(salario, aumento)
    }

    val gastoInicial = salarios.soma()
    val meses = 6
    val somatoriaComAumento: BigDecimal = somaSalariosComAumentoXMeses(
            salariosComAumentoRelativo.toTypedArray(),
            gastoInicial,
            BigDecimal(meses))
    println(somatoriaComAumento)

    val maiorSalarioDosTresPrimeiros = salarios.take(3).max()

    val menorSalarioDosTresUltimos = salarios.takeLast(3).min()

    val salariosEmOrdem = salarios.sorted()

    val menorValorRemovido: List<BigDecimal> = ordenaSalariosERemoveOMenor(salarios)

    val media: BigDecimal = salarios.mediaDosValoresAcimaDe(BigDecimal(2000))

}

private fun ordenaSalariosERemoveOMenor(salarios: Array<BigDecimal>) = salarios.sorted().drop(1)

private fun somaSalariosComAumentoXMeses(salarios: Array<BigDecimal>, gastoInicial: BigDecimal, meses: BigDecimal): BigDecimal {
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
