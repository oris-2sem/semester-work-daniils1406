package com.example.tinycian.dto.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    private Date birthdayDate;

    private String firstName;

    private String lastName;

    private String patronymic;

    private String phone;

    private String login;

    private String password;

    private String role;

    private String userType;
}
