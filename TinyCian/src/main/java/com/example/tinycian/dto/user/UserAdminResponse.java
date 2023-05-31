package com.example.tinycian.dto.user;

import com.example.tinycian.entities.cianenum.Role;
import com.example.tinycian.entities.cianenum.Status;
import com.example.tinycian.entities.cianenum.UserType;
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
public class UserAdminResponse {
    private UUID id;

    private Date insertDate;

    private Date updateDate;

    private Date birthdayDate;

    private String firstName;

    private String lastName;

    private String patronymic;

    private String phone;

    private String login;

    private String logo;

    private Role role;

    private Status status;

    private UserType userType;
}
