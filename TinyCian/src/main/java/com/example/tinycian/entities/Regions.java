package com.example.tinycian.entities;


import com.example.tinycian.entities.cianenum.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Regions {

    @Id
    private Integer code;

    private String regionName;

    private Integer salesPrice;

    private Integer rentPrice;

    @JsonManagedReference("regions")
    @OneToMany(mappedBy = "regions", fetch = FetchType.LAZY)
    private Set<ResidentialComplex> residentialComplexList;

    @JsonManagedReference("regionsRealty")
    @OneToMany(mappedBy = "regions", fetch = FetchType.LAZY)
    private Set<Realty> realtyList;

    @JsonIgnoreProperties("regionsList")
    @ManyToMany(mappedBy = "regionsList", fetch = FetchType.LAZY)
    Set<Agency> agencies;
}
