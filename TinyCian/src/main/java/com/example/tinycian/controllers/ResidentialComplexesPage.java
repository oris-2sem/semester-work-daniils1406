package com.example.tinycian.controllers;

import com.example.tinycian.dto.residentialcomplex.ResidentialComplexResponse;
import com.example.tinycian.service.ResidentialComplexService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/residentialComplexes")
public class ResidentialComplexesPage {

    private final ResidentialComplexService residentialComplexService;

    @RequestMapping(method = RequestMethod.GET)
    public String getPage() {
        return "residentialComplexesPage";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/data")
    public List<ResidentialComplexResponse> getAllResidentialComplexes(
            @RequestParam(value = "status", required = false, defaultValue = "VERIFIED") String realtyStatus,
            @RequestParam(value = "column", required = false, defaultValue = "id") String column,
            @RequestParam(value = "order", required = false, defaultValue = "ASC") String order) {

        return residentialComplexService.findAll(realtyStatus, column, order);
    }
}
