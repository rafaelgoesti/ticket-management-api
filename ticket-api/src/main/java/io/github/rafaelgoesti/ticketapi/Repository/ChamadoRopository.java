package io.github.rafaelgoesti.ticketapi.Repository;

import io.github.rafaelgoesti.ticketapi.Entity.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadoRopository extends JpaRepository<Chamado, Long> {
}
