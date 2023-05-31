package com.example.tinycian.controllers;

import com.example.tinycian.dto.agent.AgentRequest;
import com.example.tinycian.dto.representative.RepresentativeRequest;
import com.example.tinycian.dto.user.UserRequest;
import com.example.tinycian.service.AgentService;
import com.example.tinycian.service.CianUserService;
import com.example.tinycian.service.RepresentativeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/signin")
public class SignIn {

    private final CianUserService cianUserService;

    private final AgentService agentService;

    private final RepresentativeService representativeService;

    @RequestMapping(method = RequestMethod.GET)
    public String getPage() {
        return "signInPage";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/agent")
    public void signInAgent(@RequestBody AgentRequest agentRequest) {
        agentService.createNewAgent(agentRequest);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/representative")
    public void signInRepresentative(@RequestBody RepresentativeRequest representativeRequest) {
        representativeService.createRepresentative(representativeRequest);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public void signInUser(@RequestBody UserRequest userRequest) {
        cianUserService.createNewCianUser(userRequest);
    }
}
