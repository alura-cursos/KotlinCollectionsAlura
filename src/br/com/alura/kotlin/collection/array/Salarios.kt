package br.com.alura.kotlin.collection.array

fun main() {
    val salarios = doubleArrayOf(1500.55, 9100.0, 2990.99, 8500.0, 10000.0)
    println("Salários: ${salarios.joinToString(prefix = "[", postfix = "]")}")

    val somaDosSalarios = salarios.sum()
    println("Soma total de salários: $somaDosSalarios")

    val gastoInicial = 50000.0
    val aumento = 1.1
    val meses = 4
    val somaSalariosComAumento = salarios.fold(gastoInicial) { acumulador, salario ->
        acumulador + (salario * aumento * meses)
    }
    println("Soma total de salários com aumento: $somaSalariosComAumento")

    val salariosAcimaDeCincoMil = salarios.filter { it > 5000 }
    println("Salários acima de 5 mil: $salariosAcimaDeCincoMil")

    val salariosEmOrdem = salarios.sorted()
    println("Do menor para o maior: $salariosEmOrdem")

    val menorValorRemovido = salarios.sorted().drop(1)
    println("Menor valor excluído: $menorValorRemovido")

    val mediaFiltrada = salarios.filter { it > 2000 }.sorted().drop(1).average()
    println("Média dos salários acima de R$ 2000,00 excluindo o menor valor: $mediaFiltrada")

}