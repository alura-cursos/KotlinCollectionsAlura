package br.com.alura.kotlin.collection.map

import java.util.*

class AlunoRepositorio {

    private val alunos: MutableMap<String, Aluno> = mutableMapOf()

    fun adiciona(aluno: Aluno) {
        if(alunos.containsValue(aluno)) return

        alunos[aluno.rm] = aluno
    }

    fun carregaTodos(): Map<String, Aluno> = alunos

    fun buscaAluno(rm: String): Aluno? = alunos[rm]

    fun alteraAluno(rm: String, aluno: Aluno) {
        alunos[rm] = aluno
    }

    fun removeAluno(rm: String): Aluno? = alunos.remove(rm)
}