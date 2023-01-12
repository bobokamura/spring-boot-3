package com.cotefacil.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Integer id) {
        super("Id: " + id + " not found");
    }
}
