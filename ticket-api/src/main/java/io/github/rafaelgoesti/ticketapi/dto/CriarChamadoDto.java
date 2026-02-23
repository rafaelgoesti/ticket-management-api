package io.github.rafaelgoesti.ticketapi.dto;

import io.github.rafaelgoesti.ticketapi.Entity.Categoria;
import io.github.rafaelgoesti.ticketapi.Entity.Prioridade;
import io.github.rafaelgoesti.ticketapi.Entity.Statu;
import io.github.rafaelgoesti.ticketapi.Entity.Usuario;

public record CriarChamadoDto(
        String titulo, String descricao,
        Usuario usuario, Usuario tecnico, Categoria categoria, Statu status, Prioridade prioridade
){
}
