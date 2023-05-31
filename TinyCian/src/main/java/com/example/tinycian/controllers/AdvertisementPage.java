package com.example.tinycian.controllers;

import com.example.tinycian.dto.flat.FlatResponse;
import com.example.tinycian.dto.house.HouseResponse;
import com.example.tinycian.service.FlatService;
import com.example.tinycian.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/advertisement")
public class AdvertisementPage {

    private final FlatService flatService;

    private final HouseService houseService;

    @RequestMapping(method = RequestMethod.GET)
    public String getPage(Model model,
                          @RequestParam(value = "rentOrBuy", defaultValue = "buy") String rentOrBuy,
                          @RequestParam(value = "realtyType", defaultValue = "new  flat") String realtyType,
                          @RequestParam(value = "squareFrom", required = false, defaultValue = "0") String squareFrom,
                          @RequestParam(value = "squareTo", required = false, defaultValue = "0") String squareTo,
                          @RequestParam(value = "costFrom", required = false, defaultValue = "0") String costFrom,
                          @RequestParam(value = "costTo", required = false, defaultValue = "0") String costTo) {
        model.addAttribute("rentOrBuy", rentOrBuy);
        model.addAttribute("realtyType", realtyType);
        model.addAttribute("squareFrom", squareFrom);
        model.addAttribute("squareTo", squareTo);
        model.addAttribute("costFrom", costFrom);
        model.addAttribute("costTo", costTo);
        return "advertisementPage";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/dataFlat")
    public List<FlatResponse> getAdvertisementFlat(Model model,
                                                   @RequestParam(value = "rentOrBy", defaultValue = "PERMANENT") String rentOrBuy,
                                                   @RequestParam(value = "realtyType", defaultValue = "newFlat") String realtyType,
                                                   @RequestParam(value = "squareFrom", defaultValue = "0") String squareFrom,
                                                   @RequestParam(value = "squareTo", defaultValue = "0") String squareTo,
                                                   @RequestParam(value = "costFrom", defaultValue = "0") String costFrom,
                                                   @RequestParam(value = "costTo", defaultValue = "0") String costTo) {


        switch (realtyType) {
            case ("newFlat") -> {
                List<FlatResponse> flats=flatService.findAll(
                        "VERIFIED",
                        "NEW",
                        rentOrBuy,
                        Integer.valueOf(squareFrom),
                        Integer.valueOf(squareTo),
                        Integer.valueOf(costFrom),
                        Integer.valueOf(costTo));
                System.out.println(flats.get(0).toString());
                return flats;
            }
            case ("secondaryFlat") -> {
                return flatService.findAll(
                        "VERIFIED",
                        "SECONDARY",
                        rentOrBuy,
                        Integer.valueOf(squareFrom),
                        Integer.valueOf(squareTo),
                        Integer.valueOf(costFrom),
                        Integer.valueOf(costTo));
            }
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/dataHouse")
    public List<HouseResponse> getAdvertisementHouse(Model model,
                                                     @RequestParam(value = "rentOrBy", defaultValue = "PERMANENT") String rentOrBuy,
                                                     @RequestParam(value = "squareFrom", defaultValue = "0") String squareFrom,
                                                     @RequestParam(value = "squareTo", defaultValue = "0") String squareTo,
                                                     @RequestParam(value = "costFrom", defaultValue = "0") String costFrom,
                                                     @RequestParam(value = "costTo", defaultValue = "0") String costTo) {

        return houseService.findAll(
                "VERIFIED",
                "SECONDARY",
                rentOrBuy,
                Integer.valueOf(squareFrom),
                Integer.valueOf(squareTo),
                Integer.valueOf(costFrom),
                Integer.valueOf(costTo));
    }
}
