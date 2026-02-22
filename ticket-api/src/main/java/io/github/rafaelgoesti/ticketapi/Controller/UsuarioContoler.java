package io.github.rafaelgoesti.ticketapi.Controller;

import io.github.rafaelgoesti.ticketapi.Entity.Usuario;
import io.github.rafaelgoesti.ticketapi.Service.UsuarioService;
import io.github.rafaelgoesti.ticketapi.dto.CriarUsuarioDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioContoler {
    private final UsuarioService usuarioService;

    public UsuarioContoler(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<?> criarUsuario(@RequestBody CriarUsuarioDto dto){
        Usuario usuario = new Usuario(
                dto.nome(),
                dto.email(),
                dto.senha(),
                dto.perfilUsuario()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario criado com sucesso!");

    }
}
