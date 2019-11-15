package br.com.alura.kotlin.collection.sets


class SemEquals(val propriedade: Int) {
    override fun toString() = propriedade.toString()
}

class ComEquals(val propriedade: Int) {
    override fun equals(other: Any?) = other is ComEquals && other.propriedade == propriedade
    override fun toString() = propriedade.toString()
}

class ComEqualsEHashCode(val propriedade: Int) {
    override fun equals(other: Any?) = other is ComEqualsEHashCode && other.propriedade == propriedade
    override fun hashCode() = propriedade
    override fun toString() = propriedade.toString()
}

data class DataClass(val propriedade: Int) 

fun main() {
    val conjuntoSemEquals = mutableSetOf(
            SemEquals(10),
            SemEquals(10),
            SemEquals(42),
            SemEquals(42)
    )
    println("Conjunto: [${conjuntoSemEquals.joinToString()}] - Tamanho: ${conjuntoSemEquals.size}")

    val conjuntoComEquals = mutableSetOf(
            ComEquals(10),
            ComEquals(10),
            ComEquals(42),
            ComEquals(42)
    )
    println("Conjunto: [${conjuntoComEquals.joinToString()}] - Tamanho: ${conjuntoComEquals.size}")

    val conjuntoComEqualsEHashCode = mutableSetOf(
            ComEqualsEHashCode(10),
            ComEqualsEHashCode(10),
            ComEqualsEHashCode(42),
            ComEqualsEHashCode(42)
    )
    println("Conjunto: [${conjuntoComEqualsEHashCode.joinToString()}] - Tamanho: ${conjuntoComEqualsEHashCode.size}")

    val conjuntoDataClass = mutableSetOf(
            DataClass(10),
            DataClass(10),
            DataClass(42),
            DataClass(42)
    )
    println("Conjunto: [${conjuntoDataClass.joinToString()}] - Tamanho: ${conjuntoDataClass.size}")
}