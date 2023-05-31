package com.example.tinycian.controllers;

import com.example.tinycian.service.AgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/agent")
public class AgentPage {

    private final AgentService agentService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAgent(Model model,
                           @RequestParam("id") UUID idOfAgent) {
        model.addAttribute("user", agentService.getAgentById(idOfAgent));
        return "agentPage";
    }
}
