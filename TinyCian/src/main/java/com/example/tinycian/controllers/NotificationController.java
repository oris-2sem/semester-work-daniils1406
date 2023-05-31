package com.example.tinycian.controllers;

import com.example.tinycian.dto.notification.NotificationDto;
import com.example.tinycian.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;


    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public void createNotification(@RequestParam("clientId") UUID clientId,
                                   @RequestParam("ownerId") UUID ownerId,
                                   @RequestParam("realtyId") UUID realtyId) {
        notificationService.create(clientId, ownerId, realtyId);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/notificationList")
    public List<NotificationDto> getDeletedNotificationOfSomeUser(@RequestParam("id") UUID id) {

        return notificationService.getDeletedNotificationsOfSomeUser(id);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/delete")
    public void deleteNotification(@RequestParam("id") UUID id) {
        notificationService.delete(id);
    }

}
