package io.github.rafaelgoesti.ticketapi.dto;

import io.github.rafaelgoesti.ticketapi.Entity.PerfilUsuario;

public record AtualizarUsuarioDto (
        String nome,
        String email,
        String senha,
        PerfilUsuario perfilUsuario
){}
