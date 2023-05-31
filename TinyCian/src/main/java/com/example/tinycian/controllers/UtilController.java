package com.example.tinycian.controllers;

import com.example.tinycian.dto.user.UserAdminResponse;
import com.example.tinycian.dto.user.UserResponse;
import com.example.tinycian.entities.CianUser;
import com.example.tinycian.repository.CianUserRepository;
import com.example.tinycian.repository.RealtyRepository;
import com.example.tinycian.security.utils.JwtUtil;
import com.example.tinycian.security.utils.impl.JwtUtilAuth0Impl;
import com.example.tinycian.service.CianUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/util")
public class UtilController {

    private final JwtUtil jwtUtil;

    private final CianUserService cianUserService;

    private final RealtyRepository realtyRepository;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET,value = "/getId")
    public UUID getClientIdFromToken(@RequestParam("token") String token){
        JwtUtilAuth0Impl.ParsedToken parsedToken=jwtUtil.parse(token);
        UserAdminResponse cianUser=cianUserService.findByLogin(parsedToken.getEmail());
        return cianUser.getId();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET,value = "/findOutRealty")
    public String findOutTypeOfRealty(@RequestParam("id") UUID id){
        return realtyRepository.findRealtyById(id).getFlatOrHouse().toString();

    }
}
