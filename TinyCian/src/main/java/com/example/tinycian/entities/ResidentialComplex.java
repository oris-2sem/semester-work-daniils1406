package com.example.tinycian.entities;


import com.example.tinycian.entities.cianenum.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ResidentialComplex {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    private String city;

    private String district;

    private Integer numberOfBuildings;

    private Integer numberOfReadyBuildings;

    @JsonBackReference("agency")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agency")
    private Agency agency;

    private String name;

    private String description;

    private String linkOnWebsite;

    private String phoneNumber;

    private String deliveryYear;

    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonBackReference("regions")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "region")
    private Regions regions;

    @JsonManagedReference("residential-complex")
    @OneToMany(mappedBy = "residentialComplex", fetch = FetchType.LAZY)
    private Set<Realty> realtyList;

}
