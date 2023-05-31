package com.example.tinycian.service.impl;

import com.example.tinycian.dto.notification.NotificationDto;
import com.example.tinycian.dto.notification.NotificationMapper;
import com.example.tinycian.entities.Notification;
import com.example.tinycian.entities.cianenum.Status;
import com.example.tinycian.repository.CianUserRepository;
import com.example.tinycian.repository.NotificationRepository;
import com.example.tinycian.repository.RealtyRepository;
import com.example.tinycian.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    private final CianUserRepository cianUserRepository;

    private final RealtyRepository realtyRepository;


    @Override
    public void create(UUID clientId, UUID ownerId, UUID realtyId) {
        Notification notification = Notification.builder()
                .client(cianUserRepository.findCianUserById(clientId))
                .owner(cianUserRepository.findCianUserById(ownerId))
                .realty(realtyRepository.findRealtyById(realtyId))
                .status(Status.VERIFIED)
                .build();
        notificationRepository.save(notification);
    }

    @Override
    public void delete(UUID id) {
        notificationRepository.deleteById(id);
    }

    @Override
    public List<Notification> getNotificationsOfSomeUser(UUID ownerId) {
        return notificationRepository.findAllVerifiedNotifiactionsOfSomeUser(ownerId);
    }

    @Override
    public List<NotificationDto> getDeletedNotificationsOfSomeUser(UUID ownerId) {
        return NotificationMapper.fromEntityToResponseList(notificationRepository.findAllDeletedNotificationsOfSomeUser(ownerId));
    }
}
