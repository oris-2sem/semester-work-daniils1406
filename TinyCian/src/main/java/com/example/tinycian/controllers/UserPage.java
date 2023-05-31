package com.example.tinycian.controllers;

import com.example.tinycian.dto.user.UserAdminResponse;
import com.example.tinycian.dto.user.UserResponse;
import com.example.tinycian.dto.user.UserUpdateRequest;
import com.example.tinycian.entities.CianUser;
import com.example.tinycian.security.utils.JwtUtil;
import com.example.tinycian.security.utils.impl.JwtUtilAuth0Impl;
import com.example.tinycian.service.CianUserService;
import com.example.tinycian.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserPage {

    private final CianUserService cianUserService;


    private final JwtUtil jwtUtil;

    @RequestMapping(method = RequestMethod.GET)
    public String getUser(Model model, @RequestParam("id") UUID idOfUser) {
        model.addAttribute("user", cianUserService.getUserById(idOfUser));
        return "userPage";
    }


    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public UserResponse changeUser(@RequestBody UserUpdateRequest userUpdateRequest, HttpServletRequest request) {
        UserAdminResponse user = cianUserService.findByLogin(jwtUtil.parse(request.getHeader("AUTHORIZATION")).getEmail());
        userUpdateRequest.setId(user.getId());
        return cianUserService.updateCianUser(userUpdateRequest);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/resetPassword")
    public void changeUserPassword(@RequestParam("login") String login,
                                   @RequestParam("newPassword") String newPassword) {
        cianUserService.resetPassword(login, newPassword);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/setAvatar")
    public void changeAvatar(@RequestParam("id") UUID id, @RequestParam("logo") String logo) {
        cianUserService.setLogo(logo, id);
    }
}
