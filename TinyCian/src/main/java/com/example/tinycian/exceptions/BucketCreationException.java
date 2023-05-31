package com.example.tinycian.exceptions;

import org.springframework.http.HttpStatus;

public class BucketCreationException extends ServiceExceptions{
    public BucketCreationException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
