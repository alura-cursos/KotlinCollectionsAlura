package br.com.alura.kotlin.collection.array

fun main() {
    val salarios = doubleArrayOf(1500.55, 9100.0, 2990.99, 8500.0, 10000.0)
    println("Salários: ${salarios.joinToString(prefix = "[", postfix = "]")}")

    val somaDosSalarios: Double = salarios.sum()
    println("Soma total de salários: $somaDosSalarios")

    println("Maior salário entre os três primeiros: ${salarios.take(3).max()}")

    println("Menor salário entre os três últimos: ${salarios.takeLast(3).min()}")

    val aumento = 1.1
    val salariosComAumento = salarios.map { it * aumento }
    println("Salários com aumento: $salariosComAumento")

    val salariosComAumentoRelativo = salarios.map { salario ->
        calculaAumentoRelativo(salario, aumento)
    }
    println("Salários com aumento relativo: $salariosComAumentoRelativo")

    val gastoInicial = salarios.sum()
    val meses = 6
    val somatoriaComAumento = somaSalariosComAumentoXMeses(salarios, gastoInicial, meses)
    println("Soma total de salários com aumento: $somatoriaComAumento")

    val salariosEmOrdem = salarios.sorted()
    println("Do menor para o maior: $salariosEmOrdem")

    val menorValorRemovido = salarios.sorted().drop(1)
    println("Menor valor excluído: $menorValorRemovido")

    val mediaFiltrada: Double = salarios.filter { it > 2000 }.sorted().drop(1).average()
    println("Média dos salários acima de R$ 2000,00 excluindo o menor valor: $mediaFiltrada")

}

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
