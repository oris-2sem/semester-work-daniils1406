package com.example.tinycian.service;

import com.example.tinycian.dto.house.HouseAdminResponse;
import com.example.tinycian.dto.house.HouseRequest;
import com.example.tinycian.dto.house.HouseResponse;
import com.example.tinycian.dto.house.HouseUpdateRequest;

import java.util.List;
import java.util.UUID;

public interface HouseService {
    List<HouseAdminResponse> findAllByAdmin(String realtyStatus, String realtyType, String advertType, Integer squareFrom, Integer squareTo, Integer costFrom, Integer costTo);

    List<HouseResponse> findAll(String realtyStatus, String realtyType, String advertType, Integer squareFrom, Integer squareTo,Integer costFrom,Integer costTo);

    HouseResponse createHome(HouseRequest home);

    HouseResponse updateHome(HouseUpdateRequest newHome);

    void deleteHomeById(UUID id);

    HouseResponse findById(UUID id);

    HouseAdminResponse findByIdByAdmin(UUID id);
//    List<HouseResponse> findByField(String fiend, String value);
    List<HouseResponse> findByAddress(String value);

    void setStatusHome(UUID id, String newStatus);

    List<HouseResponse> findAllHousesOfSomeUser(UUID id);

}
