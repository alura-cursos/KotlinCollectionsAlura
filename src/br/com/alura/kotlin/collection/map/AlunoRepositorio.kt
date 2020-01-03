package br.com.alura.kotlin.collection.map

class AlunoRepositorio {

    private val alunos: MutableMap<String, Aluno> = mutableMapOf()

    fun adiciona(aluno: Aluno) {
        if(alunos.containsValue(aluno)) return

        alunos[aluno.rm] = aluno
    }

    fun buscaTodos(): Map<String, Aluno> = alunos

    fun busca(rm: String): Aluno? = alunos[rm]

    fun altera(rm: String, aluno: Aluno) {
        if(alunos.containsKey(rm)) {
            alunos[rm] = aluno
        }
    }

    fun remove(rm: String): Aluno? = alunos.remove(rm)
}