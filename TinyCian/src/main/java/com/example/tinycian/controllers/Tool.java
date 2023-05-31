package com.example.tinycian.controllers;

import com.example.tinycian.dto.agency.AgencyRequest;
import com.example.tinycian.dto.agency.AgencyResponse;
import com.example.tinycian.dto.agency.AgencyUpdateRequest;
import com.example.tinycian.dto.residentialcomplex.ResidentialComplexRequest;
import com.example.tinycian.service.AgencyService;
import com.example.tinycian.service.ResidentialComplexService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tool")
public class Tool {

    private final AgencyService agencyService;

    private final ResidentialComplexService residentialComplexService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public String getAgencyTool() {

        return "toolPage";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/createAgency")
    public String addAgency(@RequestBody AgencyRequest agencyRequest) {
        AgencyResponse agencyResponse = agencyService.createAgency(agencyRequest);
        return String.valueOf(agencyResponse.getId());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/createResidentialComplex")
    public void addResidentialComplex(@RequestBody ResidentialComplexRequest residentialComplexRequest) {
        residentialComplexService.createResidentialComplex(residentialComplexRequest);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public void updateAgency(@RequestBody AgencyUpdateRequest agencyRequest) {
        agencyService.updateAgencyById(agencyRequest);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/hide")
    public void hideAgency(@RequestParam String idOfAgency) {
        agencyService.deleteById(UUID.fromString(idOfAgency));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/show")
    public void showAgency(@RequestParam String idOfAgency) {
        agencyService.approveById(UUID.fromString(idOfAgency));
    }

}
