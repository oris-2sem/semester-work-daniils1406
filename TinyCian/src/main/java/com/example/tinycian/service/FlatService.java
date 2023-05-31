package com.example.tinycian.service;

import com.example.tinycian.dto.flat.FlatAdminResponse;
import com.example.tinycian.dto.flat.FlatRequest;
import com.example.tinycian.dto.flat.FlatResponse;
import com.example.tinycian.dto.flat.FlatUpdateRequest;
import com.example.tinycian.dto.realty.RealtyResponse;
import com.example.tinycian.entities.Flat;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface FlatService {
    List<FlatAdminResponse> findAllByAdmin(String realtyStatus, String realtyType, String advertType, Integer squareFrom, Integer squareTo, Integer costFrom, Integer costTo);

    List<FlatResponse> findAll(String realtyStatus, String realtyType, String advertType, Integer squareFrom, Integer squareTo,Integer costFrom,Integer costTo);

    FlatResponse createFlat(FlatRequest flat);

    FlatResponse updateFlat(FlatUpdateRequest newFlat);

    FlatResponse findById(UUID flatId);

    FlatAdminResponse findByIdByAdmin(UUID flatId);

    List<FlatResponse> findByAddress(String value);

    List<FlatResponse> findByResidentialComplexName(String value);

    void setStatusFlat(UUID flatId, String newStatus);

    List<RealtyResponse> findAllRealtysOfSomeUser(UUID idOfUser);

    List<FlatResponse> findAllFlatOfSomeUser(UUID idOfUser);

    void deleteById(UUID id);

    Integer findMaxSquare();

    Integer findMaxCost();

}
