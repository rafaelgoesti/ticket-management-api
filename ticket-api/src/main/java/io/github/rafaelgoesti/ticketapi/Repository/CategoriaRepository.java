package io.github.rafaelgoesti.ticketapi.Repository;

import io.github.rafaelgoesti.ticketapi.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
