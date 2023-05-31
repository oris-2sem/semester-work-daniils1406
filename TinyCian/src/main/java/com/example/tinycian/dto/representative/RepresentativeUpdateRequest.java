package com.example.tinycian.dto.representative;

import com.example.tinycian.entities.Agency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RepresentativeUpdateRequest {
    private UUID id;

    private Date birthdayDate;

    private String firstName;

    private String lastName;

    private String patronymic;

    private String phone;

    private String login;

    private String password;

    private UUID organisation;
}
