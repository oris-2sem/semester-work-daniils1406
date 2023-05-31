package com.example.tinycian.controllers;

import com.example.tinycian.dto.agency.AgencyResponse;
import com.example.tinycian.service.AgencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/agencys")
public class AgencysPage {

    private final AgencyService agencyService;

    @RequestMapping(method = RequestMethod.GET)
    public String getPage() {
        return "agencysPage";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/data")
    public List<AgencyResponse> getAgencys(@RequestParam(value = "status", required = false, defaultValue = "VERIFIED") String status,
                                           @RequestParam(value = "column", required = false, defaultValue = "id") String column,
                                           @RequestParam(value = "order", required = false, defaultValue = "ASC") String order) {
        return agencyService.findAll("VERIFIED", column, order);
    }
}
