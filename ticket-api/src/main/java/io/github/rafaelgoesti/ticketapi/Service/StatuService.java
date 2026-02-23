package io.github.rafaelgoesti.ticketapi.Service;
import io.github.rafaelgoesti.ticketapi.Entity.Statu;
import io.github.rafaelgoesti.ticketapi.Repository.StatuRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StatuService {
    private final StatuRepository statuRepository;

    public StatuService(StatuRepository statuRepository) {
        this.statuRepository = statuRepository;
    }

    // Criar
    public Statu criarStatu(String nome){
        Statu statu = new Statu(nome);
        return statuRepository.save(statu);
    }

    // Listar
    public List<Statu> listarStatus(){
        return statuRepository.findAll();
    }

    // Listar por ID
    public Statu listarPorId(Long id){
        return statuRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Status não encontrado."));
    }

    // Atualizar
    public Statu atualizarStatus(Long id, String nome){
        Statu statu = statuRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Status não encontrado."));

        statu.setNome(nome);

        return statuRepository.save(statu);
    }

    // Deletar
    public void deletarStatus(Long id){
        Statu statu = statuRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Status não encontrado."));

        statuRepository.delete(statu);
    }
}
