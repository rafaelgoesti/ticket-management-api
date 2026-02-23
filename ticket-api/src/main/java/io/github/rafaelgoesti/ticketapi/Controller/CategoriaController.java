package io.github.rafaelgoesti.ticketapi.Controller;
import io.github.rafaelgoesti.ticketapi.Entity.Categoria;
import io.github.rafaelgoesti.ticketapi.Service.CategoriaService;
import io.github.rafaelgoesti.ticketapi.Service.UsuarioService;
import io.github.rafaelgoesti.ticketapi.dto.AtualizarCategoriaDto;
import io.github.rafaelgoesti.ticketapi.dto.CriarCategoriaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<String> criarCategoria(@RequestBody CriarCategoriaDto dto){
        Categoria categoria = categoriaService.criarCategoria(dto.nome());

        return ResponseEntity.status(HttpStatus.CREATED).body("Categoria criada com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias(){
        List<Categoria> categorias = categoriaService.listarCategorias();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarCategoriaPorId(@PathVariable Long id){
        Categoria categoria = categoriaService.buscarPorId(id);

        return ResponseEntity.ok(categoria);
    }

    @PutMapping("/{id}")
    public Categoria atualizarCategoria(@PathVariable Long id, @RequestBody AtualizarCategoriaDto dto){
        return categoriaService.atulizarCategoria(
                id,
                dto.nome());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id){
        categoriaService.deletarCategoria(id);

        return ResponseEntity.noContent().build();
    }
}
