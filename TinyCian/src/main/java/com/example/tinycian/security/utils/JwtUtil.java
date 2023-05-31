package com.example.tinycian.security.utils;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.tinycian.security.utils.impl.JwtUtilAuth0Impl;
import org.springframework.security.core.Authentication;

import java.util.Map;

public interface JwtUtil {
    Map<String, String> generateTokens(String subject, String authority, String issuer);

    Authentication buildAuthentication(String token) throws JWTVerificationException;

    public JwtUtilAuth0Impl.ParsedToken parse(String token) throws JWTVerificationException;
}
