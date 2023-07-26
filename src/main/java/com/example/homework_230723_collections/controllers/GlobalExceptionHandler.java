package com.example.homework_230723_collections.controllers;

import com.example.homework_230723_collections.EmployeeNotFoundException;
import com.example.homework_230723_collections.EmployeeAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> handleMissingParametersException(WebRequest request, MissingServletRequestParameterException e) {
        logger.error("Missing parameters in request " + request.getDescription(true));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> handleNoSuchElementException(WebRequest request, EmployeeNotFoundException e) {
        logger.error("No element found " + request.getDescription(true));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error. No element found<br>"
                + e.getMessage());
    }

    @ExceptionHandler(EmployeeAlreadyExistsException.class)
    public ResponseEntity<String> handleEmployeeAlreadyExistsException(WebRequest request, EmployeeAlreadyExistsException e) {
        logger.error("Employee already exists " + request.getDescription(true));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee already exists!<br>"
                + e.getMessage());
    }
}
