package com.example.tinycian.exceptions;

import org.springframework.http.HttpStatus;

public class ServiceExceptions extends RuntimeException{

    HttpStatus status;

    public ServiceExceptions(String message, HttpStatus httpStatus){
        super(message);
        this.status=httpStatus;
    }

    HttpStatus getStatus(){
        return status;
    }
}
