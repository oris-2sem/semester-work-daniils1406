package com.example.tinycian.dto.realty;

import com.example.tinycian.entities.CianUser;
import com.example.tinycian.entities.Regions;
import com.example.tinycian.entities.ResidentialComplex;
import com.example.tinycian.entities.cianenum.*;
import lombok.*;

import java.sql.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RealtyAdminResponse {
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
    private Date releaseDate;
    private Date insertDate;
    private Date updateDate;
    private Integer areaSquare;
    private Material material;
    private Integer levels;
    private Status status;

}
