package com.example.tinycian.controllers;

import com.example.tinycian.dto.flat.FlatRequest;
import com.example.tinycian.dto.flat.FlatResponse;
import com.example.tinycian.dto.flat.FlatUpdateRequest;
import com.example.tinycian.entities.CianUser;
import com.example.tinycian.repository.CianUserRepository;
import com.example.tinycian.security.utils.JwtUtil;
import com.example.tinycian.service.FileService;
import com.example.tinycian.service.FlatService;
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
@RequestMapping("/myFlat")
public class MyFlatPage {

    private final FlatService flatService;

    private final CianUserRepository userRepository;

    private final FileService fileService;

    private final JwtUtil jwtUtil;


    @RequestMapping(method = RequestMethod.GET)
    public String getAllMyRealty(Model model, HttpServletRequest request) {
        CianUser user = userRepository.findCianUserByLogin(jwtUtil.parse(request.getHeader("AUTHORIZATION")).getEmail()).get();
        List<FlatResponse> realtyListOfSomeUser = flatService.findAllFlatOfSomeUser(user.getId());
        model.addAttribute("realtyList", realtyListOfSomeUser);
        model.addAttribute("userId", user.getId());
        List<List<String>> imagesOfFlats = new LinkedList<>();
        for (FlatResponse flatResponse : realtyListOfSomeUser) {
            imagesOfFlats.add(fileService.getImagesOfRealty(String.valueOf(flatResponse.getId())));
        }
        model.addAttribute("imagesOfFlats", imagesOfFlats);
        return "myFlatPage";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public void addNewRealty(@RequestBody FlatRequest flatRequest) {
        flatService.createFlat(flatRequest);
//        return "redirect:/myFlat";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    public void deleteRealty(@RequestParam(value = "id") UUID idOfRealty) {
        flatService.setStatusFlat(idOfRealty, "DELETE");
//        return "redirect:/myFlat";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/hide")
    public void hideRealty(@RequestParam(value = "id") UUID idOfRealty) {
        flatService.setStatusFlat(idOfRealty, "REGISTERED");
//        return "redirect:/myFlat";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/show")
    public void showRealty(@RequestParam(value = "id") UUID idOfRealty) {
        flatService.setStatusFlat(idOfRealty, "VERIFIED");
//        return "redirect:/myFlat";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public void updateRealty(@RequestBody FlatUpdateRequest flatUpdateRequest) {
        flatService.updateFlat(flatUpdateRequest);
//        return "redirect:/myFlat";
    }

}
