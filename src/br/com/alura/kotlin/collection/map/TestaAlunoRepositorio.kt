package br.com.alura.kotlin.collection.map

fun main() {

    val repositorio = AlunoRepositorio()

    val fernando = Aluno(
        rm = "RM101",
        nome = "Fernando",
        sobreNome = "Silva",
        email = "fsilva@alura.com.br"
    )

    repositorio.adiciona(fernando)

    println(repositorio.buscaTodos())

    val aluno = repositorio.busca("RM101")
    println(aluno)

    val alunoEmailAlterado = fernando.copy(email = "fernando.silva@alura.com.br")
    repositorio.altera("RM101", alunoEmailAlterado)

    repositorio.altera("RM102", alunoEmailAlterado)
    println(repositorio.buscaTodos())


}