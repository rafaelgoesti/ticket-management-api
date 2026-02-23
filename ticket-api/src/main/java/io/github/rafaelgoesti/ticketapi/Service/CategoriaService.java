package io.github.rafaelgoesti.ticketapi.Service;

import io.github.rafaelgoesti.ticketapi.Entity.Categoria;
import io.github.rafaelgoesti.ticketapi.Repository.CategoriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // Criar
    public Categoria criarCategoria(String nome){
        Categoria categoria = new Categoria(nome);

        return categoriaRepository.save(categoria);
    }

    // Listar
    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }

    // Pegar por ID
    public Categoria buscarPorId(Long id){
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada."));
    }

    // Atualizar
    public Categoria atulizarCategoria(Long id, String nome){
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada."));

        categoria.setNome(nome);

        return categoriaRepository.save(categoria);
    }

    // Deletar
    public void deletarCategoria(Long id){
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada."));

        categoriaRepository.delete(categoria);
    }

}

