package com.example.tinycian.exceptions;

import org.springframework.http.HttpStatus;

public class FileInsertingException extends ServiceExceptions{
    public FileInsertingException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
