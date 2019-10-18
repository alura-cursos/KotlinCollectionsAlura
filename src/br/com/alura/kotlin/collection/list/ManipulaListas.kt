package br.com.alura.kotlin.collection.list

fun main() {
    val autores = listOf("João", "Helena", "Joaquim")

    // Percorre todos os autores
    println("# Lista Completa #")
    for(autor in autores) {
        println(autor)
    }

    println("\n# Primeiro Autor #")

    // Acessa primeiro autor via Index Operator
    val primeiroAutorIndexOperator = autores[0]
    println(primeiroAutorIndexOperator)

    // Acessa primeiro autor via método get
    val primeiroAutorGet = autores.get(0)
    println(primeiroAutorGet)

    // Acessa primeiro autor via função first
    val primeiroAutorFirstFun = autores.first()
    println(primeiroAutorFirstFun)


    val outrosAutores: List<String> = listOf<String>("Carlos", "José", "Euclides")

    println("São do mesmo tipo: ${autores::class == outrosAutores::class}")


}