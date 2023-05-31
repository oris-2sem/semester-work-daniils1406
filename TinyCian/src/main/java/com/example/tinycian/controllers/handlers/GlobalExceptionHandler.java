package com.example.tinycian.controllers.handlers;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.tinycian.exceptions.ResidentialComplexNotDoundException;
import com.example.tinycian.exceptions.UserWithThisLoginAlreadyExists;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Level;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public final ResponseEntity<ExceptionMessage> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ExceptionMessage.builder()
                        .message(ex.getMessage())
                        .exceptionName(ex.getClass().getSimpleName())
                        .build());
    }

    @ExceptionHandler(TokenExpiredException.class)
    public final String handleTokenExpiredException(Exception e) {
        Logger logger = LoggerFactory.getLogger(TokenExpiredException.class);
        logger.error(e.toString());
        return "redirect:/loginPage?value=Session end. Please log in again!";
    }

    @ResponseBody
    @ExceptionHandler(UserWithThisLoginAlreadyExists.class)
    public final String handleAlreadyExistsException(Exception e) {
        Logger logger = LoggerFactory.getLogger(UserWithThisLoginAlreadyExists.class);
        logger.error(e.toString());
        return "true";
    }


    @ResponseBody
    @ExceptionHandler(ResidentialComplexNotDoundException.class)
    public final ExceptionMessage notFound(Exception e) {
        Logger logger = LoggerFactory.getLogger(ResidentialComplexNotDoundException.class);
        logger.error(e.toString());
        return ExceptionMessage.builder().message(e.getMessage()).code(HttpStatus.NOT_FOUND).exceptionName(e.getClass().getSimpleName()).build();
    }

}