package com.PBL4.test.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value =  RuntimeException.class)
    ResponseEntity<String> handlingRuntimeException(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());

    }
    
}
