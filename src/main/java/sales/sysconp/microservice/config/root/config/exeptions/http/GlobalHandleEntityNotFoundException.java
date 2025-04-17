package sales.sysconp.microservice.config.root.config.exeptions.http;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandleEntityNotFoundException {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleEntityNotFoundException(EntityNotFoundException ex) {
        Map<String, Object> response = new HashMap<>();

        response.put("status", HttpStatus.NOT_FOUND.value());
        response.put("message", ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}