package com.example.tinycian.entities;

import com.example.tinycian.entities.cianenum.Status;
import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Agency {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "id",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    private String name;

    private String description;

    private String phoneNumber;

    private String linkOnWebsite;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Date insertDate;

    @JsonManagedReference("agency")
    @OneToMany(mappedBy = "agency", fetch = FetchType.LAZY)
    private Set<ResidentialComplex> residentialComplexList;

    @JsonManagedReference("organisation-for-representative")
    @OneToMany(mappedBy = "organisation", fetch = FetchType.LAZY)
    private Set<Representative> representativeList;

    @JsonManagedReference("organisation")
    @OneToMany(mappedBy = "organisation", fetch = FetchType.LAZY)
    private Set<Agent> agentList;


    @ManyToMany(fetch = FetchType.EAGER)
//    @JsonIgnoreProperties("agencies")
    @JoinTable(joinColumns = @JoinColumn(name = "agency_id"),
            inverseJoinColumns = @JoinColumn(name = "regions_code"))
    Set<Regions> regionsList;
}
