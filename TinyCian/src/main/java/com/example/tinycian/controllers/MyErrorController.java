package com.example.tinycian.controllers;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class MyErrorController implements ErrorController {

//    @RequestMapping("/error")
//    public String handleError() {
//        //do something like logging
//        System.out.println("qqqqqq");
//        Logger logger = LoggerFactory.getLogger("errorLogger");
//        logger.error("Handler executed");
//        return "error";
//    }


    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        Logger logger = LoggerFactory.getLogger("errorLogger");
        logger.error("Handler executed");

        if(status!=null){
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode== HttpStatus.SC_NOT_FOUND){
                return "404";
            }

            if(statusCode== HttpStatus.SC_UNAUTHORIZED){
                System.out.println("!");
                return "401";
            }

            if(statusCode== HttpStatus.SC_FORBIDDEN){
                return "403";
            }

            if(statusCode== HttpStatus.SC_INTERNAL_SERVER_ERROR){
                return "500";
            }

        }
        Integer statusCode = Integer.valueOf(status.toString());
        System.out.println(statusCode);
        //do something like logging
        return "error";
    }

}