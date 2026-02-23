package io.github.rafaelgoesti.ticketapi.Service;
import io.github.rafaelgoesti.ticketapi.Entity.*;
import io.github.rafaelgoesti.ticketapi.Repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
public class ChamadoService {

    private final ChamadoRopository chamadoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CategoriaRepository categoriaRepository;
    private final StatuRepository statuRepository;
    private final PrioridadeRepository prioridadeRepository;

    public ChamadoService(
            ChamadoRopository chamadoRepository,
            UsuarioRepository usuarioRepository,
            CategoriaRepository categoriaRepository,
            StatuRepository statuRepository,
            PrioridadeRepository prioridadeRepository
    ) {
        this.chamadoRepository = chamadoRepository;
        this.usuarioRepository = usuarioRepository;
        this.categoriaRepository = categoriaRepository;
        this.statuRepository = statuRepository;
        this.prioridadeRepository = prioridadeRepository;
    }

    public Chamado abirChamado(
            String titulo,
            String descricao,
            Usuario usuario,
            Usuario tecnico,
            Categoria categoria,
            Statu status,
            Prioridade prioridade
    ){

        Usuario usuarioReal = usuarioRepository.findById(usuario.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        Usuario tecnicoReal = usuarioRepository.findById(tecnico.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Técnico não encontrado"));

        Categoria categoriaReal = categoriaRepository.findById(categoria.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Categoria não encontrada"));

        Statu statusReal = statuRepository.findById(status.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Status não encontrado"));

        Prioridade prioridadeReal = prioridadeRepository.findById(prioridade.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Prioridade não encontrada"));

        System.out.println(tecnicoReal.getPerfilUsuario());

        if (tecnicoReal.getPerfilUsuario() != PerfilUsuario.TECNICO) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Exige perfil TECNICO");
        }

        Chamado chamado = new Chamado(
                titulo,
                descricao,
                usuarioReal,
                tecnicoReal,
                categoriaReal,
                statusReal,
                prioridadeReal
        );

        chamado.setCriadoEm(LocalDateTime.now());
        chamado.setAbertoEm(LocalDateTime.now());

        return chamadoRepository.save(chamado);
    }
}