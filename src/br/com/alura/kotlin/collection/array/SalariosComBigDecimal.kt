package br.com.alura.kotlin.collection.array

import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    val salarios: Array<BigDecimal> = bigDecimalArrayDe("1500.55", "9100.00", "2990.99", "8500.00", "10000.00")
    println("Salários: ${salarios.joinToString(prefix = "[", postfix = "]")}")

    val maiorSalarioDosTresPrimeiros = salarios.take(3).max()
    println("Maior salário entre os três primeiros: $maiorSalarioDosTresPrimeiros")

    val menorSalarioDosTresUltimos = salarios.takeLast(3).min()
    println("Menor salário entre os três últimos: $menorSalarioDosTresUltimos")

    val aumento = "1.10".toBigDecimal()
    val salariosComAumento: List<BigDecimal> = salarios.map { salario -> calculaAumento(salario, aumento) }
    println("Salários com aumento: $salariosComAumento")

    val salariosComAumentoRelativo: List<BigDecimal> = salarios.map { salario ->
        calculaAumentoRelativo(salario, aumento)
    }
    println("Salários com aumento relativo: $salariosComAumentoRelativo")

    val gastoInicial = salarios.soma()
    val meses = 6
    val somatoriaComAumento: BigDecimal = somaSalariosComAumentoXMeses(salarios, gastoInicial, BigDecimal(meses))
    println("Soma total de salários com aumento: $somatoriaComAumento")

    val salariosEmOrdem = salarios.sorted()
    println("Do menor para o maior: $salariosEmOrdem")

    val menorValorRemovido: List<BigDecimal> = ordenaSalariosERemoveOMenor(salarios)
    println("Menor valor excluído: $menorValorRemovido")

    val media: BigDecimal = salarios.mediaDosValoresAcimaDe(BigDecimal(2000))
    println("Média dos salários acima de R$ 2000,00: $media")

}

private fun calculaAumento(salario: BigDecimal, aumento: BigDecimal) =
    multiplicaEArredonda(salario, aumento)

private fun multiplicaEArredonda(a: BigDecimal, b: BigDecimal) =
    (a * b).setScale(2, RoundingMode.UP)

private fun bigDecimalArrayDe(vararg elementos: String): Array<BigDecimal> {
    val bigDecimalArray: Array<BigDecimal> = Array(elementos.size) { BigDecimal.ZERO }
    for(i in elementos.indices) {
        bigDecimalArray[i] = elementos[i].toBigDecimal()
    }
    return bigDecimalArray
}

fun Array<BigDecimal>.soma(): BigDecimal {
    var total = BigDecimal.ZERO
    for(elemento in this) {
        total += elemento
    }
    return total
}

private fun Array<BigDecimal>.mediaDosValoresAcimaDe(valorMinimo: BigDecimal): BigDecimal =
    this.filter { it > valorMinimo }
        .toTypedArray()
        .media()

private fun Array<BigDecimal>.media(): BigDecimal {
    val soma: BigDecimal = this.soma()
    return if (this.isEmpty()) {
        BigDecimal.ZERO
    } else {
        soma / this.size.toBigDecimal()
    }
}

private fun ordenaSalariosERemoveOMenor(salarios: Array<BigDecimal>) = salarios.sorted().drop(1)

private fun somaSalariosComAumentoXMeses(salarios: Array<BigDecimal>, gastoInicial: BigDecimal, meses: BigDecimal): BigDecimal {
    return salarios.fold(gastoInicial) { acumulador, salario ->
        acumulador + multiplicaEArredonda(salario, meses)
    }
}

private fun calculaAumentoRelativo(salario: BigDecimal, aumento: BigDecimal): BigDecimal =
    if (salario < BigDecimal(5000)) {
        salario + BigDecimal(500)
    } else {
        calculaAumento(salario, aumento)
    }
