package io.github.rafaelgoesti.ticketapi.Controller;

import io.github.rafaelgoesti.ticketapi.Entity.Usuario;
import io.github.rafaelgoesti.ticketapi.Service.UsuarioService;
import io.github.rafaelgoesti.ticketapi.dto.AtualizarUsuarioDto;
import io.github.rafaelgoesti.ticketapi.dto.CriarUsuarioDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioContoler {
    private final UsuarioService usuarioService;

    public UsuarioContoler(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<?> criarUsuario(@RequestBody CriarUsuarioDto dto){
        Usuario usuario = usuarioService.criarUsuario(
                dto.nome(),
                dto.email(),
                dto.senha(),
                dto.perfilUsuario()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario criado com sucesso!");

    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long id){
        Usuario usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody AtualizarUsuarioDto dto){
        return usuarioService.atualizarUsuario(
                id,
                dto.nome(),
                dto.email(),
                dto.senha(),
                dto.perfilUsuario()
        );
    }

}