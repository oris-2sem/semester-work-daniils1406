package com.example.tinycian.controllers;

import com.example.tinycian.service.FileService;
import com.example.tinycian.service.FlatService;
import com.example.tinycian.service.HouseService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/realty")
public class RealtyPage {

    private final FlatService flatService;

    private final FileService fileService;

    private final HouseService houseService;

    @RequestMapping(method = RequestMethod.GET)
    public String getRealty(Model model, @RequestParam("id") String realtyId, @RequestParam("realtyType") String realtyType) {
        List<String> imagesOfFlats = fileService.getImagesOfRealty(String.valueOf(realtyId));
        model.addAttribute("imagesOfFlats", imagesOfFlats);
        if (realtyType.equals("HOUSE")) {
            model.addAttribute("realty", houseService.findById(UUID.fromString(realtyId)));
            return "realtyHousePage";
        } else {
            model.addAttribute("realty", flatService.findById(UUID.fromString(realtyId)));
            return "realtyFlatPage";
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public String getRealtyWithSum(Model model, @RequestParam("id") String realtyId, @RequestParam("realtyType") String realtyType,
                                   @RequestParam("to") String to,
                                   @RequestParam("from") String from,
                                   @RequestParam("amount") String amount) throws IOException {
        if(amount.equals("")|| to.equals("") || from.equals("")){
            model.addAttribute("result","Please fill all labels");
        }else{
            OkHttpClient client = new OkHttpClient().newBuilder().build();
            Request request = new Request.Builder()
                    .url("https://api.apilayer.com/currency_data/convert?to="+to+"&from="+from+"&amount="+amount+"")
                    .addHeader("apikey", "c2r3B9SHEf7PtQa1ik3zCwoOrRCYdrDJ")
                    .get()
                    .build();
            Response response = client.newCall(request).execute();
            String string=response.body().string();
            JsonObject o= JsonParser.parseString(string).getAsJsonObject();
            model.addAttribute("result",o.get("result"));
        }
        List<String> imagesOfFlats = fileService.getImagesOfRealty(String.valueOf(realtyId));
        model.addAttribute("imagesOfFlats", imagesOfFlats);
        if (realtyType.equals("HOUSE")) {
            model.addAttribute("realty", houseService.findById(UUID.fromString(realtyId)));
            return "realtyHousePage";
        } else {
            model.addAttribute("realty", flatService.findById(UUID.fromString(realtyId)));
            return "realtyFlatPage";
        }
    }
}
