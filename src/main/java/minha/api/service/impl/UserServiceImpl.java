package minha.api.service.impl;


import minha.api.controller.exception.CampoInexistenteException;
import minha.api.domain.model.Usuario;
import minha.api.domain.repository.UsuarioRepository;
import minha.api.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UserServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario encontrarPorId(Long id) {
        if(!usuarioRepository.existsById(id)){
            throw new CampoInexistenteException("O campo id " +id+ " não existe.");
        }
        return usuarioRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Usuario criar(Usuario usuarioCriar) {
        if (usuarioRepository.existePorEmail(usuarioCriar.getConta().getEmail())) {
            throw new IllegalArgumentException("Esse e-mail já possui uma conta registrada.");
        }
        return usuarioRepository.save(usuarioCriar);
    }

    @Override
    public Iterable<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }
}
