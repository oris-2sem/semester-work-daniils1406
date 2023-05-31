package com.example.tinycian.security.utils.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.tinycian.entities.CianUser;
import com.example.tinycian.entities.cianenum.Role;
import com.example.tinycian.repository.CianUserRepository;
import com.example.tinycian.security.details.UserDetailsImpl;
import com.example.tinycian.security.utils.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtilAuth0Impl implements JwtUtil {

    private static final long ACCESS_TOKEN_EXPIRES_TIME = 100 * 60 * 1000;

    private static final long REFRESH_TOKEN_EXPIRES_TIME = 10 * 60 * 1000;

    @Value("${jwt.secret}")
    private String secret;
    private final CianUserRepository userRepository;

    public JwtUtilAuth0Impl(CianUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Map<String, String> generateTokens(String subject, String authority, String issuer) {
        Algorithm algorithm = Algorithm.HMAC256(secret.getBytes(StandardCharsets.UTF_8));

        String accessToken = JWT.create()
                .withSubject(subject)
                .withExpiresAt(new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRES_TIME))
                .withClaim("role", authority)
                .withIssuer(issuer)
                .sign(algorithm);

        String refreshToken = JWT.create()
                .withSubject(subject)
                .withExpiresAt(new Date(System.currentTimeMillis() + REFRESH_TOKEN_EXPIRES_TIME))
                .withClaim("role", authority)
                .withIssuer(issuer)
                .sign(algorithm);

        Map<String, String> tokens = new HashMap<>();
        tokens.put("accessToken", accessToken);
        tokens.put("refreshToken", refreshToken);

        return tokens;
    }

    @Override
    public Authentication buildAuthentication(String token) throws JWTVerificationException {
        ParsedToken parsedToken = parse(token);

        CianUser user = new CianUser();
        user.setLogin(parsedToken.getEmail());
        user.setRole(Role.valueOf(parsedToken.getRole()));
        UserDetails userDetails = new UserDetailsImpl(user);

        return new UsernamePasswordAuthenticationToken(userDetails,
                null,
                Collections.singleton(new SimpleGrantedAuthority(parsedToken.getRole())));
    }

    public ParsedToken parse(String token) throws JWTVerificationException {
        Algorithm algorithm = Algorithm.HMAC256(secret.getBytes(StandardCharsets.UTF_8));

        JWTVerifier verifier = JWT.require(algorithm).build();

        DecodedJWT decodedJWT = verifier.verify(token);

        String email = decodedJWT.getSubject();
        String role = decodedJWT.getClaim("role").asString();

        return ParsedToken.builder()
                .role(role)
                .email(email)
                .build();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ParsedToken {
        private String email;
        private String role;
    }
}
