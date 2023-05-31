package com.example.tinycian.repository;

import com.example.tinycian.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public interface NotificationRepository extends JpaRepository<Notification, UUID> {


    @Query(value = "SELECT * FROM notification WHERE owner=:ownerId and status='VERIFIED'", nativeQuery = true)
    List<Notification> findAllVerifiedNotifiactionsOfSomeUser(UUID ownerId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE notification SET status='DELETE' WHERE id=:id", nativeQuery = true)
    void deleteById(UUID id);


    @Query(value = "SELECT * FROM notification WHERE owner=:ownerId and status='DELETE'", nativeQuery = true)
    List<Notification> findAllDeletedNotificationsOfSomeUser(UUID ownerId);
}