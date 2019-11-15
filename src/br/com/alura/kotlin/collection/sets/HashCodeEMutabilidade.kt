package br.com.alura.kotlin.collection.sets

data class Funcionario(val nome: String, var cargo: String)

fun main() {
    val carlos = Funcionario(nome = "Carlos", cargo = "Analista")
    val paula = Funcionario(nome = "Paula", cargo = "Analista")

    val funcionarios = setOf(carlos, paula)

    println("Carlos está no conjunto? ${carlos in funcionarios}")
    println("Paula está no conjunto? ${paula in funcionarios}")
    println(funcionarios)
    println(paula.hashCode())

    paula.cargo = "Gerente"

    println("Carlos está no conjunto? ${carlos in funcionarios}")
    println("Paula está no conjunto? ${paula in funcionarios}")
    println(funcionarios)
    println(paula.hashCode())
}