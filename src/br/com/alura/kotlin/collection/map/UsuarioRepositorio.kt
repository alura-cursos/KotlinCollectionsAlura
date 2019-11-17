package br.com.alura.kotlin.collection.map

class UsuarioRepositorio {
    private var ultimoIndice: Int = 0
    private val usuarios: MutableMap<Int, Usuario> = mutableMapOf()

    fun adicionaUsuario(usuario: Usuario) {
        if(usuarios.containsValue(usuario)) return

        usuarios[ultimoIndice++] = usuario
    }

    fun adicionaUsuarios(usuarios: Collection<Usuario>) {
        usuarios.forEach { usuario ->
            adicionaUsuario(usuario)
        }
    }

    fun buscaUsuario(id: Int): Usuario? = usuarios[id]

    fun carregaUsuarios(): Map<Int, Usuario> = usuarios

    fun alteraUsuario(id: Int, usuario: Usuario) {
        if(id > ultimoIndice) {
            adicionaUsuario(usuario)
        }

        usuarios[id] = usuario
    }

    fun removeUsuario(id: Int): Usuario? = usuarios.remove(id)
}