package br.com.alura.kotlin.collection.array

fun main() {
    val idades = intArrayOf(10, 12, 18, 33, 40, 67)

    print("Idades: [")
    for(i in idades.indices) {
        print(idades[i])
        if(i < idades.lastIndex)
            print(", ")
    }
    println("]")

    println("Idades: ${idades.contentToString()}")

    println("Maior idade: ${idades.max()}")

    val mediaIdades = idades.average()
    println("Média das idades: $mediaIdades")

    val todosMaiores = idades.all { it >= 18 }
    println("Todos são maiores de idade? $todosMaiores")

    val existeMenor = idades.any { it < 18 }
    println("Existe algum menor de idade? $existeMenor")

    val maiores = idades.filter { it >= 18 }
    println("Maiores de idade: $maiores")

    val menores = idades.filter { it < 18 }
    println("Menores de idade: $menores")

    val contemQuarenta = idades.contains(40)
    println("Existe alguem com 40 anos? $contemQuarenta")

    val busca = idades.find { it == 33 }
    println("Idade encontrada: $busca")
}