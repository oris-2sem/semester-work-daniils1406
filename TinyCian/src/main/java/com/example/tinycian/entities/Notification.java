package com.example.tinycian.entities;

import com.example.tinycian.entities.cianenum.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Notification {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @JsonBackReference("ownerList")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner")
    private CianUser owner;

    @JsonBackReference("clientList")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client")
    private CianUser client;

    @JsonBackReference("realtyList")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "realty")
    private Realty realty;

    @Enumerated(EnumType.STRING)
    private Status status;
}
