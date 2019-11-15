package br.com.alura.kotlin.collection.sets


class SemEquals(val atributo: Int)

class ComEquals(val atributo: Int) {
    override fun equals(other: Any?) = other is ComEquals && other.atributo == atributo
}

class ComEqualsEHashCode(val atributo: Int) {
    override fun equals(other: Any?) = other is ComEqualsEHashCode && other.atributo == atributo
    override fun hashCode() = atributo
}

data class DataClass(val atributo: Int)

fun main() {
    val conjuntoSemEquals = mutableSetOf(
            SemEquals(10),
            SemEquals(10),
            SemEquals(42),
            SemEquals(42)
    )
    println(conjuntoSemEquals.size)

    val conjuntoComEquals = mutableSetOf(
            ComEquals(10),
            ComEquals(10),
            ComEquals(42),
            ComEquals(42)
    )
    println(conjuntoComEquals.size)

    val conjuntoComEqualsEHashCode = mutableSetOf(
            ComEqualsEHashCode(10),
            ComEqualsEHashCode(10),
            ComEqualsEHashCode(42),
            ComEqualsEHashCode(42)
    )
    println(conjuntoComEqualsEHashCode.size)

    val conjuntoDataClass = mutableSetOf(
            DataClass(10),
            DataClass(10),
            DataClass(42),
            DataClass(42)
    )
    println(conjuntoDataClass.size)
}