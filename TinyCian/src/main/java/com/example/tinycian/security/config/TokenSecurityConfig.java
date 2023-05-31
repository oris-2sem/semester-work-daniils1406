package com.example.tinycian.security.config;

import com.example.tinycian.security.filters.JwtAuthenticationFilter;
import com.example.tinycian.security.filters.JwtAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TokenSecurityConfig {

    private final PasswordEncoder passwordEncoder;

    private final UserDetailsService userDetailsServiceImpl;

    private final AuthenticationProvider refreshTokenAuthenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity,
                                                   JwtAuthenticationFilter jwtAuthenticationFilter,
                                                   JwtAuthorizationFilter jwtAuthorizationFilter) throws Exception {

        httpSecurity.csrf().disable();
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//        httpSecurity.authorizeRequests()
//                .anyRequest().permitAll();

        httpSecurity.authorizeRequests()
                .antMatchers("/config", "/actuator/health", "/swagger-resources/**", "/v2/**", "/webjars/**", "/swagger-ui.html", "/swagger-ui/**", "/signin/**", "/login", "/loginPage", "/", "/file/**", "/agencys/**", "/agency/**", "/agency/byId", "/residentialComplexes/**", "/residentialComplex", "/user/**", "/users/**", "/agents/**", "/agent/**", "/static/**", "/account", "/advertisement/**", "/realty/**", "/util/**").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
                .and()
                .authorizeRequests()
                .antMatchers("/**/create")
                .permitAll()
                .anyRequest()
                .authenticated();

        httpSecurity.addFilter(jwtAuthenticationFilter);
        httpSecurity.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    @Autowired
    public void bindUserDetailsServiceAndPasswordEncoder(AuthenticationManagerBuilder builder) throws Exception {
        builder.authenticationProvider(refreshTokenAuthenticationProvider);
        builder.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder);
    }
}
