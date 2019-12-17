package br.com.alura.kotlin.collection.array

import java.math.BigDecimal
import java.math.RoundingMode

fun bigDecimalArrayDe(vararg elementos: String): Array<BigDecimal> {
    val bigDecimalArray: Array<BigDecimal> = Array(elementos.size) { BigDecimal.ZERO }
    for(i in elementos.indices) {
        bigDecimalArray[i] = elementos[i].toBigDecimal()
    }
    return bigDecimalArray
}

fun BigDecimal.multiplicaPor(
    multiplicando: BigDecimal,
    escala: Int = 2,
    arredondamento: RoundingMode = RoundingMode.UP
): BigDecimal {
    return (this * multiplicando).setScale(escala, arredondamento)
}

fun Array<BigDecimal>.soma(): BigDecimal {
    var total = BigDecimal.ZERO
    for(elemento in this) {
        total += elemento
    }
    return total
}

fun Array<BigDecimal>.mediaDosValoresAcimaDe(valorMinimo: BigDecimal): BigDecimal =
    this.filter { it > valorMinimo }
        .toTypedArray()
        .media()

fun Array<BigDecimal>.media(): BigDecimal {
    val soma: BigDecimal = this.soma()
    return if (this.isEmpty()) {
        BigDecimal.ZERO
    } else {
        soma / this.size.toBigDecimal()
    }
}