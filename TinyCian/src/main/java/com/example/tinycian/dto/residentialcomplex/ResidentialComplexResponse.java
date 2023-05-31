package com.example.tinycian.dto.residentialcomplex;

import com.example.tinycian.entities.Agency;
import com.example.tinycian.entities.Regions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResidentialComplexResponse {
    private UUID id;

    private String city;

    private String district;

    private Integer numberOfBuildings;

    private Integer numberOfReadyBuildings;

    private Agency agency;

    private String name;

    private String description;

    private String linkOnWebsite;

    private String phoneNumber;

    private String deliveryYear;

    private Regions regions;
}
