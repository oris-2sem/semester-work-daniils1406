package com.example.tinycian.dto.agent;

import com.example.tinycian.entities.Agency;
import com.example.tinycian.entities.cianenum.AgentLevel;
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
public class AgentAdminResponse {
    private UUID id;

    private Date birthdayDate;

    private Date insertDate;

    private Date updateDate;

    private String firstName;

    private String lastName;

    private String patronymic;

    private String phone;

    private String login;

    private String role;

    private String status;

    private Agency organisation;

    private AgentLevel agentLevel;

    private String logo;
}
