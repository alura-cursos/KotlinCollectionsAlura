package br.com.alura.kotlin.collection.array

fun main() {
    val salarios = doubleArrayOf(1500.55, 9100.0, 2990.99, 8500.0, 10000.0)
    println("Salários: ${salarios.joinToString(prefix = "[", postfix = "]")}")

    val somaDosSalarios = salarios.sum()
    println("Soma total de salários: $somaDosSalarios")

    val aumento = 1.1
    val salariosComAumento = salarios.map { it * aumento }
    println("Salários com aumento: $salariosComAumento")

    val salariosComAumentoRelativo = salarios.map { salario ->
        calculaAumentoRelativo(salario, aumento)
    }
    println("Salários com aumento relativo: $salariosComAumentoRelativo")

    val gastoInicial = salarios.sum()
    val meses = 6
    val somaSalariosComAumentoXMeses = salariosComAumentoRelativo.fold(gastoInicial) { acumulador, salario ->
        acumulador + (salario * meses)
    }
    println("Soma total de salários com aumento: $somaSalariosComAumentoXMeses")

    val salariosEmOrdem = salarios.sorted()
    println("Do menor para o maior: $salariosEmOrdem")

    val menorValorRemovido = salarios.sorted().drop(1)
    println("Menor valor excluído: $menorValorRemovido")

    val mediaFiltrada = salarios.filter { it > 2000 }.sorted().drop(1).average()
    println("Média dos salários acima de R$ 2000,00 excluindo o menor valor: $mediaFiltrada")

}

private fun calculaAumentoRelativo(salario: Double, aumento: Double): Double =
    if (salario < 5000) {
        salario + 500
    } else {
        salario * aumento
    }
