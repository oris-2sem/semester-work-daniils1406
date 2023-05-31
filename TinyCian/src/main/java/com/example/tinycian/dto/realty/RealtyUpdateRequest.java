package com.example.tinycian.dto.realty;

import com.example.tinycian.entities.Regions;
import com.example.tinycian.entities.cianenum.AdvertType;
import com.example.tinycian.entities.cianenum.FlatOrHouse;
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
public class RealtyUpdateRequest {
    private UUID id;
    private UUID residentialComplex;
    private Integer square;
    private Regions regions;
    private String district;
    private String address;
    private String description;
    private AdvertType advertType;
    private Integer cost;
    private FlatOrHouse flatOrHouse;
    private Date releaseDate;
}
