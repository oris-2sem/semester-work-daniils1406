package com.example.tinycian.controllers;

import com.example.tinycian.dto.agency.AgencyResponse;
import com.example.tinycian.service.AgencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/agency")
public class AgencyPage {

    private final AgencyService agencyService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAgency(Model model, @RequestParam("id") UUID idOfAgency) {
        AgencyResponse agencyResponse = agencyService.findById(idOfAgency);
        model.addAttribute("agency", agencyResponse);
        return "agencyPage";
    }


    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/byId")
    public AgencyResponse getAgencyByIdRest(@RequestParam("id") UUID id) {
        AgencyResponse agencyResponse = agencyService.findById(id);
        return agencyResponse;
    }
}
