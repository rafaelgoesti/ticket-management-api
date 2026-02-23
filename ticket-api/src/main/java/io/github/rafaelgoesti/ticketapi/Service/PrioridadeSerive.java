package io.github.rafaelgoesti.ticketapi.Service;
import io.github.rafaelgoesti.ticketapi.Entity.Prioridade;
import io.github.rafaelgoesti.ticketapi.Repository.PrioridadeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PrioridadeSerive {
    private final PrioridadeRepository prioridadeRepository;

    public PrioridadeSerive(PrioridadeRepository prioridadeRepository) {
        this.prioridadeRepository = prioridadeRepository;
    }

    // Criar
    public Prioridade criarPrioridade(String nome){
        Prioridade prioridade = new Prioridade(nome);
        return prioridadeRepository.save(prioridade);
    }

    // Listar
    public List<Prioridade> listarPrioridade(){
        return prioridadeRepository.findAll();
    }

    // Listar por ID
    public Prioridade listarPorId(Long id){
        return prioridadeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prioridade não encontrada."));
    }

    // Atualizar
    public Prioridade atualizarPrioridade(Long id, String nome){
        Prioridade prioridade = prioridadeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prioridade não encontrada."));

        prioridade.setNome(nome);

        return prioridadeRepository.save(prioridade);
    }

    // Deletar
    public void deletarPrioridade(Long id){
        Prioridade prioridade = prioridadeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prioridade não encontrada."));

        prioridadeRepository.delete(prioridade);
    }
}