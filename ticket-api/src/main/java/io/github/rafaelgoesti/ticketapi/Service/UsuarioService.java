package io.github.rafaelgoesti.ticketapi.Service;

import io.github.rafaelgoesti.ticketapi.Entity.PerfilUsuario;
import io.github.rafaelgoesti.ticketapi.Entity.Usuario;
import io.github.rafaelgoesti.ticketapi.Repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Criar Usuários
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

    // Listar Usuários
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    // Buscar por ID
    public Usuario buscarPorId(Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new
                ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }
}