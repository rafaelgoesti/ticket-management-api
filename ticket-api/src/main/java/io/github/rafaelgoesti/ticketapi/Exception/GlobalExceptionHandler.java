package io.github.rafaelgoesti.ticketapi.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handle(ResponseStatusException ex) {

        Map<String, Object> erro = new HashMap<>();
        erro.put("status", ex.getStatusCode().value());
        erro.put("message", ex.getReason());

        return ResponseEntity
                .status(ex.getStatusCode())
                .body(erro);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleEnumError(HttpMessageNotReadableException ex){

        Map<String, Object> erro = new HashMap<>();
        erro.put("status", 400);

        // verifica se foi erro no PerfilUsuario
        if(ex.getMessage().contains("PerfilUsuario")){
            erro.put("message","Perfil inválido. Use: ADMIN, USUARIO ou TECNICO");
        } else {
            erro.put("message","JSON inválido");
        }

        return ResponseEntity.badRequest().body(erro);
    }
}
