package io.github.rafaelgoesti.ticketapi.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

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
}
