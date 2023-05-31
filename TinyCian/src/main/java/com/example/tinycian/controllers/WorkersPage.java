package com.example.tinycian.controllers;

import com.example.tinycian.dto.agent.AgentResponse;
import com.example.tinycian.dto.representative.RepresentativeResponse;
import com.example.tinycian.entities.Representative;
import com.example.tinycian.security.utils.JwtUtil;
import com.example.tinycian.security.utils.impl.JwtUtilAuth0Impl;
import com.example.tinycian.service.AgencyService;
import com.example.tinycian.service.AgentService;
import com.example.tinycian.service.RepresentativeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/workers")
public class WorkersPage {

    private final AgentService agentService;

    private final RepresentativeService representativeService;

    private final JwtUtil jwtUtil;

    private final AgencyService agencyService;

    @PreAuthorize("hasAuthority('REPRESENTATIVE')")
    @RequestMapping(method = RequestMethod.GET)
    public String getListOfWorkers(Model model, HttpServletRequest request) {
        JwtUtilAuth0Impl.ParsedToken parsedToken = jwtUtil.parse(request.getHeader("AUTHORIZATION"));
        RepresentativeResponse representative = representativeService.getRepresentativeByLogin(parsedToken.getEmail());
        List<AgentResponse> agentsOfAgency = agencyService.getAllAgentsOfSomeAgency(representative.getOrganisation().getId());
        model.addAttribute("agentsList", agentsOfAgency);
        return "workersPage";
    }

    @PreAuthorize("hasAuthority('REPRESENTATIVE')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/hire")
    public void hireWorker(@RequestParam(value = "id") UUID idOfAgent, HttpServletRequest request) {
        JwtUtilAuth0Impl.ParsedToken parsedToken = jwtUtil.parse(request.getHeader("AUTHORIZATION"));
        RepresentativeResponse representative = representativeService.getRepresentativeByLogin(parsedToken.getEmail());
        agentService.hireAgentToSomeAgency(representative.getOrganisation().getId(),
                idOfAgent);
    }

    @PreAuthorize("hasAuthority('REPRESENTATIVE')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/dismiss")
    public void dismissWorker(@RequestParam(value = "id") UUID idOfAgent) {
        agentService.dismissAgentFromSomeAgency(idOfAgent);
    }


}
