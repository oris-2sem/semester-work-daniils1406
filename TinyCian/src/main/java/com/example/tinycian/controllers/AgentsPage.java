package com.example.tinycian.controllers;

import com.example.tinycian.dto.agent.AgentResponse;
import com.example.tinycian.service.AgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/agents")
public class AgentsPage {

    private final AgentService agentService;

    @RequestMapping(method = RequestMethod.GET)
    public String getPage() {
        return "agentsPage";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/data")
    public List<AgentResponse> getAllAgents(@RequestParam(value = "status", defaultValue = "VERIFIED", required = false) String userStatus,
                                            @RequestParam(value = "level", defaultValue = "PRO", required = false) String agentLevel,
                                            @RequestParam(value = "column", defaultValue = "id", required = false) String column,
                                            @RequestParam(value = "order", defaultValue = "ASC", required = false) String order) {
        return agentService.findAll(userStatus, agentLevel, column, order);
    }
}
