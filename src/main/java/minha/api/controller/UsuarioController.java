package minha.api.controller;

import minha.api.domain.model.Usuario;
import minha.api.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        var usuario = usuarioService.encontrarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario userCriar) {
        var usuarioCriado = usuarioService.criar(userCriar);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usuarioCriado.getId())
                .toUri();
        return ResponseEntity.created(location).body(usuarioCriado);
    }

    @GetMapping
    public ResponseEntity<Iterable<Usuario>> buscarTodos() {
        return ResponseEntity.ok(usuarioService.buscarTodos());
    }

    @GetMapping("filmes/")
    public ResponseEntity<Integer> contarFilmes(@RequestBody Usuario usuario){ //método para fazer a verificação da quantidade de filmes que o usuário tal possui cadastrado
        int quantidadeFilmes = usuarioService.contarFilmes(usuario);
        return ResponseEntity.ok(quantidadeFilmes);
    }
}
