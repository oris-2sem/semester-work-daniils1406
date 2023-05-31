package com.example.tinycian.dto.house;

import com.example.tinycian.entities.Regions;
import com.example.tinycian.entities.cianenum.AdvertType;
import com.example.tinycian.entities.cianenum.Currency;
import com.example.tinycian.entities.cianenum.FlatOrHouse;
import com.example.tinycian.entities.cianenum.Material;
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
public class HouseRequest {
    private UUID residentialComplex;
    private UUID owner;
    private Integer square;
    private Integer regions;
    private String district;
    private String address;
    private String description;
    private AdvertType advertType;
    private Integer cost;
    private FlatOrHouse flatOrHouse;
    private Date releaseDate;
    private Integer areaSquare;
    private Material material;
    private Integer levels;
    private Currency currency;
}
