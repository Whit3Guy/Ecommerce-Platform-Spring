package com.whiteStudio.Ecommerce_Platform_Spring.controllers.exceptions;

import com.whiteStudio.Ecommerce_Platform_Spring.services.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ValidationExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex)
  {

    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getFieldErrors().forEach( error -> errors.put(error.getField(), error.getDefaultMessage()));
    return ResponseEntity.badRequest().body(errors);

  }
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<String> handleDeleteException(ResourceNotFoundException ex)
  {
    return ResponseEntity.badRequest().body(ex.getMessage());
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<String> handleGenericExceptions(RuntimeException ex){return ResponseEntity.status(500).body("Erro interno: " + ex.getMessage());}

}
