package com.example.tinycian.controllers;

import com.example.tinycian.service.AgencyService;
import com.example.tinycian.service.AgentService;
import com.google.gson.JsonElement;
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

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainPage {


    @RequestMapping(method = RequestMethod.GET)
    public String getMainPage(Model model) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();

//        Request request = new Request.Builder()
//                .url("https://api.apilayer.com/currency_data/live?source=EUR&currencies=RUB")
//                .addHeader("apikey", "c2r3B9SHEf7PtQa1ik3zCwoOrRCYdrDJ")
//                .get()
//                .build();
//        Response response = client.newCall(request).execute();
//        String string=response.body().string();
//        JsonObject o=JsonParser.parseString(string).getAsJsonObject();
//        JsonObject e=o.get("quotes").getAsJsonObject();
//        model.addAttribute("EUR",e.get("EURRUB").toString());
//
//        request = new Request.Builder()
//                .url("https://api.apilayer.com/currency_data/live?source=USD&currencies=RUB")
//                .addHeader("apikey", "c2r3B9SHEf7PtQa1ik3zCwoOrRCYdrDJ")
//                .get()
//                .build();
//        response = client.newCall(request).execute();
//        string=response.body().string();
//        o=JsonParser.parseString(string).getAsJsonObject();
//        e=o.get("quotes").getAsJsonObject();
//        model.addAttribute("USD",e.get("USDRUB").toString());
        return "mainPage";
    }

}
