package com.cotefacil.dto;

import com.cotefacil.service.exceptions.CustomError;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {

    public final List<FieldMessage> errors = new ArrayList<>();

    public void addErrors(String fieldName, String message) {
        errors.add(new FieldMessage(fieldName, message));
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }
}
