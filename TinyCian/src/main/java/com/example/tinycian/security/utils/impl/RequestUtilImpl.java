package com.example.tinycian.security.utils.impl;

import com.example.tinycian.security.utils.AuthorizationHeaderUtil;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 24.06.2022
 * 29. Spring Boot REST + Security
 *
 * @author Sidikov Marsel (Akvelon)
 * @version v1.0
 */
@Component
public class RequestUtilImpl implements AuthorizationHeaderUtil {

    private static final String AUTHORIZATION_HEADER_NAME = "AUTHORIZATION";

    @Override
    public boolean hasAuthorizationToken(HttpServletRequest request) {
        String header = request.getHeader(AUTHORIZATION_HEADER_NAME);
        return header != null;
    }

    @Override
    public String getToken(HttpServletRequest request) {
        return request.getHeader(AUTHORIZATION_HEADER_NAME);
    }
}
