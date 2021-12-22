package com.lits.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class DTOExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidExceptions(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(ex.getBindingResult().toString(), HttpStatus.BAD_REQUEST);
    }
}
