package io.github.rafaelgoesti.ticketapi.Repository;

import io.github.rafaelgoesti.ticketapi.Entity.Prioridade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrioridadeRepository extends JpaRepository<Prioridade, Long> {
}
