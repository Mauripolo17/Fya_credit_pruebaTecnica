package com.fya.credit.fya_credit.advice;

import com.fya.credit.fya_credit.exceptions.CreditNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CreditExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getFieldErrors().forEach(error -> {
        errors.put(error.getField(), error.getDefaultMessage());
    });
        return errors;
    }

    @ExceptionHandler(CreditNotFoundException.class)
    public Map<String, String> handleCreditNotFound(CreditNotFoundException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("credit", ex.getMessage());
        errors.put("Status", HttpStatus.NOT_FOUND.toString());
        errors.put("timestamp", LocalDate.now().toString());
        return errors;
    }


}
