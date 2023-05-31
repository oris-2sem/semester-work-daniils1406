package com.example.tinycian.controllers;

import com.example.tinycian.dto.residentialcomplex.ResidentialComplexResponse;
import com.example.tinycian.entities.ResidentialComplex;
import com.example.tinycian.service.ResidentialComplexService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@RequestMapping("/residentialComplex")
public class ResidentialComplexPage {

    private final ResidentialComplexService residentialComplexService;

    @RequestMapping(method = RequestMethod.GET)
    public String getResidentialComplexById(Model model,
                                            @RequestParam("id") UUID residentialComplexId) {
        ResidentialComplexResponse residentialComplex = residentialComplexService.findById(residentialComplexId);
        model.addAttribute("residentialComplex", residentialComplex);
        return "residentialComplexPage";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/byId")
    public ResidentialComplexResponse getResidentialComplexByIdRest(
            @RequestParam("id") UUID residentialComplexId) {
        ResidentialComplexResponse response = residentialComplexService.findById(residentialComplexId);
        return response;
    }
}
