package br.com.alura.kotlin.collection.array

fun main() {
    val idades: IntArray = intArrayOf(10, 12, 18, 33, 40, 67)

    imprimeArray(idades)

    println("Idades: ${idades.contentToString()}")

    println("Maior idade: ${idades.max()}")

    println("Menor idade: ${idades.min()}")

    val mediaIdades: Double = idades.average()
    println("Média das idades: $mediaIdades")

    val todosMaiores: Boolean = idades.all { it >= 18 }
    println("Todos são maiores de idade? $todosMaiores")

    val existeMenor: Boolean = idades.any { it < 18 }
    println("Existe algum menor de idade? $existeMenor")

    val maiores: List<Int> = idades.filter { it >= 18 }
    println("Maiores de idade: $maiores")

    val menores: IntArray = idades.filter { it < 18 }.toIntArray()
    println("Menores de idade: ${menores.contentToString()}")

    val contemQuarenta: Boolean = idades.contains(40)
    println("Existe alguem com 40 anos? $contemQuarenta")

    val busca: Int? = idades.find { it == 33 }
    println("Idade encontrada: $busca")
}

private fun imprimeArray(idades: IntArray) {
    val texto = StringBuilder()
    for (i in idades.indices) {
        texto.append(idades[i])
        if (i < idades.lastIndex)
            texto.append(", ")
    }
    println("Idades: [$texto]")
}