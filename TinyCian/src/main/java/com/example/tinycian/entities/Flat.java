package com.example.tinycian.entities;

import com.example.tinycian.entities.cianenum.RealtyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flat extends Realty {
    private Integer numberOfRoom;

    private Integer level;

    private Integer kitchenSquare;

    private Integer livingSquare;

    @Enumerated(EnumType.STRING)
    private RealtyType realtyType;
}
