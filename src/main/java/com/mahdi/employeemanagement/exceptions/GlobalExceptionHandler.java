package com.mahdi.employeemanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errorRes = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(err -> errorRes.put(err.getField(), err.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errorRes);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleResourceNotFoundException(ResourceNotFoundException ex){
        Map<String, String> errorRes = new HashMap<>();
        errorRes.put("status", "404 Not Found");
        errorRes.put("message", ex.getMessage());

        return new ResponseEntity<>(errorRes, HttpStatus.NOT_FOUND);
    }
}
