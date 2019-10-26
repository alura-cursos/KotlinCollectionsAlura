package br.com.alura.kotlin.collection.array

fun main() {
    val salarios = doubleArrayOf(1500.55, 9100.0, 2990.99, 8500.0, 10000.0)
    println("Salários: ${salarios.joinToString(prefix = "[", postfix = "]")}")

    val somaDosSalarios = salarios.sum()
    println("Soma total de salários: $somaDosSalarios")

    val aumento = 1.1
    val salariosComAumento = salarios.map { it * aumento }
    println("Salários com aumento: $salariosComAumento")

    val salariosComAumentoMinimo = salarios.map { salario ->
        if (salario < 5000) {
            salario + 500
        } else {
            salario * aumento
        }
    }
    println("Salários com aumento mínimo: $salariosComAumentoMinimo")

    val gastoInicial = 50000.0
    val meses = 4
    val somaSalariosComAumento = salariosComAumento.fold(gastoInicial) { acumulador, salario ->
        acumulador + (salario * meses)
    }
    println("Soma total de salários com aumento: $somaSalariosComAumento")

    val salariosEmOrdem = salarios.sorted()
    println("Do menor para o maior: $salariosEmOrdem")

    val menorValorRemovido = salarios.sorted().drop(1)
    println("Menor valor excluído: $menorValorRemovido")

    val mediaFiltrada = salarios.filter { it > 2000 }.sorted().drop(1).average()
    println("Média dos salários acima de R$ 2000,00 excluindo o menor valor: $mediaFiltrada")

}