package com.example.tinycian.entities;


import com.example.tinycian.entities.cianenum.AdvertType;
import com.example.tinycian.entities.cianenum.Currency;
import com.example.tinycian.entities.cianenum.FlatOrHouse;
import com.example.tinycian.entities.cianenum.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Realty {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @JsonBackReference("residential-complex")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "residentialComplex")
    private ResidentialComplex residentialComplex;

    @JsonBackReference("owner")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner")
    private CianUser owner;

    private Integer square;

    @JsonBackReference("regionsRealty")
    @ManyToOne(fetch = FetchType.EAGER)
    private Regions regions;

    private String district;

    private String address;

    private String description;

    @Enumerated(EnumType.STRING)
    private AdvertType advertType;

    private Integer cost;

    @Enumerated(EnumType.STRING)
    private FlatOrHouse flatOrHouse;

    private Date insertDate;

    private Date updateDate;

    private Date releaseDate;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonManagedReference("realtyList")
    @OneToMany(mappedBy = "realty")
    private Set<Notification> notificationRealtySet;


}