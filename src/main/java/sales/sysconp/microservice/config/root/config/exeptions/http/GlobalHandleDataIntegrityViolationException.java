package sales.sysconp.microservice.config.root.config.exeptions.http;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandleDataIntegrityViolationException {
    @SuppressWarnings("null")
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, Object>> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        Map<String, Object> response = new HashMap<>();

        response.put("status", HttpStatus.CONFLICT.value());
        response.put("message", "Erro de integridade de dados: " + ex.getRootCause().getMessage());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}