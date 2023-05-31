package com.example.tinycian.exceptions;

import org.springframework.http.HttpStatus;

public class UserWithThisLoginNotExists extends ServiceExceptions{
    public UserWithThisLoginNotExists(String login) {
        super(String.format("User with login %s not exists",login), HttpStatus.NOT_FOUND);
    }
}
