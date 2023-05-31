package com.example.tinycian.exceptions;

import org.springframework.http.HttpStatus;

public class ResidentialComplexNotDoundException extends ServiceExceptions{
    public ResidentialComplexNotDoundException(String id) {
        super(String.format("Residential complex with id %S not found",id), HttpStatus.NOT_FOUND);
    }
}
