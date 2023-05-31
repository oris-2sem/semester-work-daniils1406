package com.example.tinycian.controllers;

import com.example.tinycian.dto.user.UserResponse;
import com.example.tinycian.entities.CianUser;
import com.example.tinycian.entities.Notification;
import com.example.tinycian.repository.AgentRepository;
import com.example.tinycian.repository.CianUserRepository;
import com.example.tinycian.repository.RepresentativeRepository;
import com.example.tinycian.security.utils.JwtUtil;
import com.example.tinycian.security.utils.impl.JwtUtilAuth0Impl;
import com.example.tinycian.service.AgentService;
import com.example.tinycian.service.CianUserService;
import com.example.tinycian.service.NotificationService;
import com.example.tinycian.service.RepresentativeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoginPage {


    private final CianUserService cianUserService;

    private final CianUserRepository userRepository;

    private final AgentRepository agentRepository;

    private final RepresentativeRepository representativeRepository;

    private final AgentService agentService;


    private final RepresentativeService representativeService;

    private final NotificationService notificationService;


    private final JwtUtil jwtUtil;

    @RequestMapping(method = RequestMethod.GET,value = "/loginPage")
    public String getLoginPage(Model model,@RequestParam(value="value",required = false) String expiredToken){
        if(expiredToken!=null){
            model.addAttribute("value",expiredToken);
        }
        return "logInPage";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/account")
    public String logIn(){
        return "emptyAccountPage";
    }


//    @PreAuthorize("hasAuthority('REPRESENTATIVE')")
    @RequestMapping(method = RequestMethod.GET,value = "/accountInfo")
    public String getAccountInfo(HttpServletRequest request, Model model){
        String token=request.getHeader("AUTHORIZATION");
        JwtUtilAuth0Impl.ParsedToken parsedToken=jwtUtil.parse(token);
        switch (parsedToken.getRole()){
            case "CLIENT","OWNER","ADMIN"->{
//                model.addAttribute("user",userRepository.findCianUserByLogin(parsedToken.getEmail()).get());
                model.addAttribute("user",cianUserService.findByLogin(parsedToken.getEmail()));
            }
            case "AGENT"->{
//                model.addAttribute("user",agentRepository.findAgentByLogin(parsedToken.getEmail()).get());
                model.addAttribute("user",agentService.findByLogin(parsedToken.getEmail()));
            }
            case "REPRESENTATIVE"->{
//                model.addAttribute("user",representativeRepository.findRepresentativeByLogin(parsedToken.getEmail()).get());
                model.addAttribute("user",representativeService.findByLogin(parsedToken.getEmail()));
            }
        }

        List<Notification> notificationList=notificationService.getNotificationsOfSomeUser(cianUserService.findByLogin(parsedToken.getEmail()).getId());
        model.addAttribute("notifications",notificationList);

        return "accountPage";
    }

}
