package io.github.rafaelgoesti.ticketapi.Controller;
import io.github.rafaelgoesti.ticketapi.Entity.Prioridade;
import io.github.rafaelgoesti.ticketapi.Service.PrioridadeSerive;
import io.github.rafaelgoesti.ticketapi.dto.AtualizarPrioridadeDto;
import io.github.rafaelgoesti.ticketapi.dto.CriarPrioridadeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prioridades")
public class PrioridadeController {
    private final PrioridadeSerive prioridadeSerive;

    public PrioridadeController(PrioridadeSerive prioridadeSerive) {
        this.prioridadeSerive = prioridadeSerive;
    }

    @PostMapping
    public ResponseEntity<String> criarPrioridade(@RequestBody CriarPrioridadeDto dto){
        Prioridade prioridade = prioridadeSerive.criarPrioridade(dto.nome());

        return ResponseEntity.status(HttpStatus.CREATED).body("Prioridade criada com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<Prioridade>> listarPrioridade(){
        List<Prioridade> prioridades = prioridadeSerive.listarPrioridade();
        return ResponseEntity.ok(prioridades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prioridade> buscarPrioridadePorId(@PathVariable Long id){
        Prioridade prioridade = prioridadeSerive.listarPorId(id);

        return ResponseEntity.ok(prioridade);
    }

    @PutMapping("/{id}")
    public Prioridade atualizarPrioridade(@PathVariable Long id, @RequestBody AtualizarPrioridadeDto dto){
        return prioridadeSerive.atualizarPrioridade(
                id,
                dto.nome());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPrioridade(@PathVariable Long id){
        prioridadeSerive.deletarPrioridade(id);

        return ResponseEntity.noContent().build();
    }
}
