package com.example.tinycian.exceptions;

import org.springframework.http.HttpStatus;

import java.util.UUID;

public class UserWithThisLoginAlreadyExists extends ServiceExceptions {
    public UserWithThisLoginAlreadyExists(String login) {
        super(String.format("User with login %s already exists",login), HttpStatus.BAD_REQUEST);
    }
}
