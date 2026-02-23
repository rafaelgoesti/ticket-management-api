package io.github.rafaelgoesti.ticketapi.Controller;

import io.github.rafaelgoesti.ticketapi.Entity.Chamado;
import io.github.rafaelgoesti.ticketapi.Service.ChamadoService;
import io.github.rafaelgoesti.ticketapi.dto.CriarChamadoDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {
    private final ChamadoService chamadoService;

    public ChamadoController(ChamadoService chamadoService) {
        this.chamadoService = chamadoService;
    }

    @PostMapping
    public ResponseEntity<String> abrirChamado(@RequestBody CriarChamadoDto dto){
        Chamado chamado = chamadoService.abirChamado(
                dto.titulo(),
                dto.descricao(),
                dto.usuario(),
                dto.tecnico(),
                dto.categoria(),
                dto.status(),
                dto.prioridade()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body("Chamado aberto com sucesso!");
    }
}
