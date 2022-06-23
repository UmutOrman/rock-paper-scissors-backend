package com.rabobank.demo.controller;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author horman
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ConversionFailedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidParameter(ConversionFailedException ex) {
        return ex.getMessage();
    }
}
