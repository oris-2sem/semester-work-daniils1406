package com.example.tinycian.dto.realty;

import com.example.tinycian.entities.CianUser;
import com.example.tinycian.entities.Regions;
import com.example.tinycian.entities.ResidentialComplex;
import com.example.tinycian.entities.cianenum.AdvertType;
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
public class RealtyResponse {
    private UUID id;
    private ResidentialComplex residentialComplex;
    private CianUser owner;
    private String city;
    private Integer square;
    private Regions regions;
    private String district;
    private String address;
    private String description;
    private AdvertType advertType;
    private Integer cost;
    private Date insertDate;
    private Date releaseDate;
}
