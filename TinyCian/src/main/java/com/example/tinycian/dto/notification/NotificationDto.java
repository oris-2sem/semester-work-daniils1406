package com.example.tinycian.dto.notification;

import com.example.tinycian.entities.cianenum.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationDto {
    private UUID id;
    private UUID client;
    private UUID owner;
    private UUID realty;
    private Status status;
}
