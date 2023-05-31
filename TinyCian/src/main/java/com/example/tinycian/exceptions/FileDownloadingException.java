package com.example.tinycian.exceptions;

import org.springframework.http.HttpStatus;

public class FileDownloadingException extends ServiceExceptions {
    public FileDownloadingException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
