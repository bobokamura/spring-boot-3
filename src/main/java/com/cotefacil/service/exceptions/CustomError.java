package com.cotefacil.service.exceptions;

import lombok.*;

import java.time.Instant;

@Data
public class CustomError {

    private Instant timestamp;
    private int status;
    private String error;
    private String path;
}
