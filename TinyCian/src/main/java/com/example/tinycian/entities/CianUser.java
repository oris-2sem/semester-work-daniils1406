package com.example.tinycian.entities;

import com.example.tinycian.entities.cianenum.Role;
import com.example.tinycian.entities.cianenum.Status;
import com.example.tinycian.entities.cianenum.UserType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class CianUser {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    private Date createDate;

    private Date updateDate;

    private Date birthdayDate;

    private String firstName;

    private String lastName;

    private String patronymic;

    private String logo;

    private String phone;

    private String login;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @JsonManagedReference("owner")
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<Realty> realtyList;


    public boolean isBanned() {
        if (status.equals(Status.BANNED)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isConfirmed() {
        if (status.equals(Status.VERIFIED)) {
            return true;
        } else {
            return false;
        }
    }


    @JsonManagedReference("ownerList")
    @OneToMany(mappedBy = "owner")
    private Set<Notification> notificationOwnerList;

    @JsonManagedReference("clientList")
    @OneToMany(mappedBy = "client")
    private Set<Notification> notificationClientList;
}
