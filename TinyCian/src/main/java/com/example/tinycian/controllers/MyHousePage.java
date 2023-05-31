package com.example.tinycian.controllers;


import com.example.tinycian.dto.house.HouseRequest;
import com.example.tinycian.dto.house.HouseResponse;
import com.example.tinycian.dto.house.HouseUpdateRequest;
import com.example.tinycian.entities.CianUser;
import com.example.tinycian.repository.CianUserRepository;
import com.example.tinycian.security.utils.JwtUtil;
import com.example.tinycian.service.FileService;
import com.example.tinycian.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/myHouse")
public class MyHousePage {

    private final HouseService houseService;

    private final JwtUtil jwtUtil;

    private final FileService fileService;

    private final CianUserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllMyRealty(Model model, HttpServletRequest request) {
        CianUser user = userRepository.findCianUserByLogin(jwtUtil.parse(request.getHeader("AUTHORIZATION")).getEmail()).get();
        List<HouseResponse> realtyListOfSomeUser = houseService.findAllHousesOfSomeUser(user.getId());
        model.addAttribute("realtyList", realtyListOfSomeUser);
        model.addAttribute("userId", user.getId());
        List<List<String>> imagesOfFlats = new LinkedList<>();
        for (HouseResponse flatResponse : realtyListOfSomeUser) {
            imagesOfFlats.add(fileService.getImagesOfRealty(String.valueOf(flatResponse.getId())));
        }
        model.addAttribute("imagesOfFlats", imagesOfFlats);
        return "myHousePage";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public void addNewRealty(@RequestBody HouseRequest houseRequest) {
        houseService.createHome(houseRequest);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    public void deleteRealty(@RequestParam(value = "id") UUID idOfRealty) {
        houseService.setStatusHome(idOfRealty, "DELETE");
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/hide")
    public void hideRealty(@RequestParam(value = "id") UUID idOfRealty) {
        houseService.setStatusHome(idOfRealty, "REGISTERED");
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/show")
    public void showRealty(@RequestParam(value = "id") UUID idOfRealty) {
        houseService.setStatusHome(idOfRealty, "VERIFIED");
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public void updateRealty(@RequestBody HouseUpdateRequest realtyUpdateRequest) {
        houseService.updateHome(realtyUpdateRequest);
    }


}
