package com.devsuperior.demo.controllers.exceptionsHandlers;
/* Essa classe intercepta erros na camada do controlador
    e customiza a resposta e status de erro. */

import com.devsuperior.demo.dto.StandardErrorDTO;
import com.devsuperior.demo.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardErrorDTO> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        StandardErrorDTO errorDTO = new StandardErrorDTO();
        errorDTO.setTimestamp(Instant.now());
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorDTO.setError(e.getMessage());
        errorDTO.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }
}
