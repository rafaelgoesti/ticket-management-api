package io.github.rafaelgoesti.ticketapi.Repository;

import io.github.rafaelgoesti.ticketapi.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);
}
