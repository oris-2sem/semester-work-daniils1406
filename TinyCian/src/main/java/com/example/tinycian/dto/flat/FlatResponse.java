package com.example.tinycian.dto.flat;

import com.example.tinycian.entities.CianUser;
import com.example.tinycian.entities.Regions;
import com.example.tinycian.entities.ResidentialComplex;
import com.example.tinycian.entities.cianenum.AdvertType;
import com.example.tinycian.entities.cianenum.Currency;
import com.example.tinycian.entities.cianenum.FlatOrHouse;
import com.example.tinycian.entities.cianenum.RealtyType;
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
public class FlatResponse {
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
    private Integer numberOfRoom;
    private Integer level;
    private Integer kitchenSquare;
    private Integer livingSquare;
    private RealtyType realtyType;
    private Currency currency;
}
