package io.github.rafaelgoesti.ticketapi.Service;

import io.github.rafaelgoesti.ticketapi.Entity.PerfilUsuario;
import io.github.rafaelgoesti.ticketapi.Entity.Usuario;
import io.github.rafaelgoesti.ticketapi.Repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Criar
    public Usuario criarUsuario(String nome, String email, String senha, PerfilUsuario perfilUsuario){
        if (usuarioRepository.existsByEmail(email)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email já cadastrado.");
        }

        if(senha == null || senha.length() < 6) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha inválida.");
        }

        if (perfilUsuario == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Perfil obrigatório.");
        }

        Usuario usuario = new Usuario(
                nome,
                email,
                senha,
                perfilUsuario
        );

        return usuarioRepository.save(usuario);
    }

    // Listar
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    // Buscar por ID
    public Usuario buscarPorId(Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new
                ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    // Atualizar
    public Usuario atualizarUsuario(Long id, String nome, String email, String senha, PerfilUsuario perfilUsuario){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setPerfilUsuario(perfilUsuario);
        usuario.setAtualizadoEm(LocalDateTime.now());

        return usuarioRepository.save(usuario);
    }
}