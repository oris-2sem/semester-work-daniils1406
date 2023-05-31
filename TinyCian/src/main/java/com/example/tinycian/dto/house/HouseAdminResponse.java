package com.example.tinycian.dto.house;

import com.example.tinycian.entities.CianUser;
import com.example.tinycian.entities.Regions;
import com.example.tinycian.entities.ResidentialComplex;
import com.example.tinycian.entities.cianenum.*;
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
public class HouseAdminResponse {
    private UUID id;
    private ResidentialComplex residentialComplex;
    private CianUser owner;
    private Integer square;
    private Regions regions;
    private String district;
    private String address;
    private String description;
    private AdvertType advertType;
    private Integer cost;
    private FlatOrHouse flatOrHouse;
    private Status status;
    private Date releaseDate;
    private Integer areaSquare;
    private Material material;
    private Integer levels;
    private Currency currency;
}
