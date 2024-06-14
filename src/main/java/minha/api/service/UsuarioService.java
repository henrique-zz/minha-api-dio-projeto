package minha.api.service;


import minha.api.domain.model.Usuario;

public interface UsuarioService {

    Usuario encontrarPorId(Long id);

    Usuario criar(Usuario usuarioCriar);

    Iterable<Usuario> buscarTodos();

    public int contarFilmes(Usuario usuario);
}
