package com.example.tinycian.dto.notification;

import com.example.tinycian.entities.Notification;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class NotificationMapper {

    public static NotificationDto fromEntityToResponse(Notification notification){
        return NotificationDto.builder()
                .id(notification.getId())
                .client(notification.getClient().getId())
                .owner(notification.getOwner().getId())
                .realty(notification.getRealty().getId())
                .status(notification.getStatus())
                .build();
    }

    public static List<NotificationDto> fromEntityToResponseList(List<Notification> notifications){
        List<NotificationDto> notificationDtoList=new LinkedList<>();
        for(Notification notification:notifications){
            notificationDtoList.add(fromEntityToResponse(notification));
        }
        return notificationDtoList;
    }
}
