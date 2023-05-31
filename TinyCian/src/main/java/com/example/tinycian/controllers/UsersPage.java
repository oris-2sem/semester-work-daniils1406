package com.example.tinycian.controllers;

import com.example.tinycian.dto.user.UserResponse;
import com.example.tinycian.service.CianUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersPage {

    private final CianUserService cianUserService;

    @RequestMapping(method = RequestMethod.GET)
    public String getPage() {
        return "usersPage";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/data")
    public List<UserResponse> getAllUsers(@RequestParam(value = "status", required = false, defaultValue = "VERIFIED") String userStatus,
                                          @RequestParam(value = "role", required = false, defaultValue = "CLIENT") String userRole,
                                          @RequestParam(value = "column", required = false, defaultValue = "id") String column,
                                          @RequestParam(value = "order", required = false, defaultValue = "ASC") String order) {

        List<UserResponse> responses = cianUserService.findAll(userStatus, userRole, column, order);
        return responses;
    }


}
