package com.cotefacil.controller.exceptionHandler;

import com.cotefacil.dto.ValidationError;
import com.cotefacil.service.exceptions.CustomError;
import com.cotefacil.service.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        CustomError err = new CustomError();
        HttpStatus status = HttpStatus.NOT_FOUND;

        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError(e.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
        ValidationError err = new ValidationError();
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Invalid Data");
        err.setPath(request.getRequestURI());

        e.getBindingResult().getFieldErrors().forEach(fieldError ->
                err.addErrors(fieldError.getField(), fieldError.getDefaultMessage()));

//        for (FieldError f : e.getBindingResult().getFieldErrors()) {
//            err.addErrors(f.getField(), f.getDefaultMessage());
//        }

        return ResponseEntity.status(status).body(err);
    }
}
