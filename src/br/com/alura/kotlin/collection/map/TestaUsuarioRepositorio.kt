package br.com.alura.kotlin.collection.map

fun main() {

    val repositorio = UsuarioRepositorio()

    val fernando = Usuario(
        nome = "Fernando",
        sobreNome = "Silva",
        email = "fernandosilva@alura.com.br"
    )

    repositorio.adicionaUsuario(fernando)

    println(repositorio.carregaUsuarios())
    println(repositorio.buscaUsuario(0))

    val patricia = Usuario(
        nome = "Patrícia",
        sobreNome = "Pereira",
        email = "patriciapereira@alura.com.br"
    )
    val amanda = Usuario(
        nome = "Amanda",
        sobreNome = "Nunes",
        email = "amandanunes@alura.com.br"
    )
    val novosUsuarios = setOf(patricia, amanda)

    repositorio.adicionaUsuarios(novosUsuarios)

    println(repositorio.carregaUsuarios())
    println(repositorio.buscaUsuario(2))

    repositorio.adicionaUsuario(fernando)
    println(repositorio.carregaUsuarios())

    repositorio.alteraUsuario(0, fernando.copy(sobreNome = "Souza"))
    println(repositorio.buscaUsuario(0))

    val usuarioRemovido = repositorio.removeUsuario(1)
    println(usuarioRemovido)
    println(repositorio.carregaUsuarios())
    println(repositorio.buscaUsuario(1) ?: "não existe usuário com índice 1")
}