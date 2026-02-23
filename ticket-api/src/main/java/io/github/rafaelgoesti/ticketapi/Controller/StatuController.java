package io.github.rafaelgoesti.ticketapi.Controller;
import io.github.rafaelgoesti.ticketapi.Entity.Statu;
import io.github.rafaelgoesti.ticketapi.Service.StatuService;
import io.github.rafaelgoesti.ticketapi.dto.AtualizarStatuDto;
import io.github.rafaelgoesti.ticketapi.dto.CriarStatuDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("status")
public class StatuController {
    private final StatuService statuService;

    public StatuController(StatuService statuService) {
        this.statuService = statuService;
    }

    @PostMapping
    public ResponseEntity<String> criarStatus(@RequestBody CriarStatuDto dto){
        Statu statu = statuService.criarStatu(dto.nome());

        return ResponseEntity.status(HttpStatus.CREATED).body("Status criado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<Statu>> listarStatus(){
        List<Statu> status = statuService.listarStatus();
        return ResponseEntity.ok(status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Statu> buscarStatuPorId(@PathVariable Long id){
        Statu statu = statuService.listarPorId(id);

        return ResponseEntity.ok(statu);
    }

    @PutMapping("/{id}")
    public Statu atualizarStatus(@PathVariable Long id, @RequestBody AtualizarStatuDto dto){
        return statuService.atualizarStatus(
                id,
                dto.nome());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarStatus(@PathVariable Long id){
        statuService.deletarStatus(id);

        return ResponseEntity.noContent().build();
    }
}
