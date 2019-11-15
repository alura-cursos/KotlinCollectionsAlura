package br.com.alura.kotlin.collection.set

class HashCodeBom(val propriedade: Int) {
    companion object {
        var contador = 0
    }

    override fun equals(other: Any?): Boolean {
        contador++
        return other is ComEqualsEHashCode && other.propriedade == propriedade
    }

    override fun hashCode() = propriedade
}

class HashCodeRuim(val propriedade: Int) {
    companion object {
        var contador = 0
    }

    override fun equals(other: Any?): Boolean {
        contador++
        return other is ComEqualsEHashCode && other.propriedade == propriedade
    }

    override fun hashCode() = 42
}

fun main() {
    val conjunto = List(10000) { HashCodeBom(it) }.toSet()
    HashCodeBom(1000) in conjunto
    println("Chamadas a equals: ${HashCodeBom.contador}")

    val conjuntoIneficiente = List(10000) { HashCodeRuim(it) }.toSet()
    HashCodeRuim(1000) in conjuntoIneficiente
    println("Chamadas a equals: ${HashCodeRuim.contador}")
}