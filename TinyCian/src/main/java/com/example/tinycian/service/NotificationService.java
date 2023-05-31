package com.example.tinycian.service;

import com.example.tinycian.dto.notification.NotificationDto;
import com.example.tinycian.entities.Notification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface NotificationService {
    void create(UUID clientId, UUID ownerId, UUID realtyId);

    void delete(UUID id);

    List<Notification> getNotificationsOfSomeUser(UUID ownerId);

    List<NotificationDto> getDeletedNotificationsOfSomeUser(UUID ownerId);
}
