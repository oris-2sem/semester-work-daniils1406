package com.example.tinycian.security.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 24.06.2022
 * 29. Spring Boot REST + Security
 *
 * @author Sidikov Marsel (Akvelon)
 * @version v1.0
 */
public interface AuthorizationHeaderUtil {
    boolean hasAuthorizationToken(HttpServletRequest request);

    String getToken(HttpServletRequest request);
}
