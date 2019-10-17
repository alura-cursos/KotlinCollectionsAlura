package br.com.alura.kotlin.collection.list

fun main() {
    val autores = listOf("João", "Helena", "Joaquim")

    // Percorre todos os autores
    for(autor in autores) {
        println(autor)
    }

    // Acessa primeiro autor via Index Operator
    val primeiroAutorIndexOperator = autores[0]

    // Acessa primeiro autor via método get
    val primeiroAutorGet = autores.get(0)

    // Acessa primeiro autor via função first
    val primeiroAutorFirstFun = autores.first()


    val outrosAutores: List<String> = listOf<String>("Carlos", "José", "Euclides")

    println("São do mesmo tipo: ${autores::class == outrosAutores::class}")


}