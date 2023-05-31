package com.example.tinycian.entities;

import com.example.tinycian.entities.cianenum.Material;
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
public class House extends Realty {
    private Integer areaSquare;

    @Enumerated(EnumType.STRING)
    private Material material;

    private Integer levels;
}
