package com.apps.archiver.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerExceptionsHandler {
    @ExceptionHandler({RoleNotFoundException.class})
    public ResponseEntity<Map<String, String>> handleRoleNotFoundException(RoleNotFoundException exc){
        Map<String, String> errors = new HashMap<>();
        errors.put("error", exc.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Map<String, List<String>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exc){
        Map<String, List<String>> errors = new HashMap<>();
        List<String> internalErrors = exc.getBindingResult().getFieldErrors().stream().map((field) -> field.getDefaultMessage())
                .collect(Collectors.toList());
        errors.put("errors", internalErrors);
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
