package com.example.tinycian.exceptions;

import org.springframework.http.HttpStatus;

public class FileDeletingException extends ServiceExceptions{
    public FileDeletingException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
