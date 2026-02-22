package io.github.rafaelgoesti.ticketapi.Repository;

import io.github.rafaelgoesti.ticketapi.Entity.Statu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatuRepository extends JpaRepository<Statu, Long> {
}
