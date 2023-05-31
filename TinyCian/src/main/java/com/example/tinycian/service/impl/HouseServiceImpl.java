package com.example.tinycian.service.impl;

import com.example.tinycian.dto.house.HouseAdminResponse;
import com.example.tinycian.dto.house.HouseRequest;
import com.example.tinycian.dto.house.HouseResponse;
import com.example.tinycian.dto.house.HouseUpdateRequest;
import com.example.tinycian.entities.CianUser;
import com.example.tinycian.entities.House;
import com.example.tinycian.entities.Regions;
import com.example.tinycian.entities.ResidentialComplex;
import com.example.tinycian.entities.cianenum.Status;
import com.example.tinycian.mapper.HouseMapper;
import com.example.tinycian.repository.*;
import com.example.tinycian.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {

    private final HouseRepository houseRepository;

    private final RealtyRepository realtyRepository;

    private final CianUserRepository cianUserRepository;

    private final HouseMapper mapper;
    private final ResidentialComplexRepository residentialComplexRepository;
    private final RegionsRepository regionsRepository;

    @Override
    public List<HouseAdminResponse> findAllByAdmin(String realtyStatus, String realtyType, String advertType, Integer squareFrom, Integer squareTo, Integer costFrom, Integer costTo) {
        if (squareTo == 0) {
            squareTo = realtyRepository.findMaxSquareOfHouse();
        }
        if (costTo == 0) {
            costTo = realtyRepository.findMaxCostOfHouse();
        }
        return mapper.fromEntityToAdminResponseList(houseRepository.customFindAllASC(realtyStatus, advertType, squareFrom, squareTo, costFrom, costTo));
    }

    @Override
    public List<HouseResponse> findAll(String realtyStatus, String realtyType, String advertType, Integer squareFrom, Integer squareTo, Integer costFrom, Integer costTo) {
        if (squareTo == 0) {
            squareTo = realtyRepository.findMaxSquareOfHouse();
        }
        if (costTo == 0) {
            costTo = realtyRepository.findMaxCostOfHouse();
        }
        return mapper.fromEntityToResponseList(houseRepository.customFindAllASC(realtyStatus, advertType, squareFrom, squareTo, costFrom, costTo));
    }

    @Override
    public HouseResponse createHome(HouseRequest home) {
        House house = mapper.fromRequestToEntity(home);
        house.setInsertDate(Date.valueOf(LocalDate.now()));
        house.setUpdateDate(Date.valueOf(LocalDate.now()));
        CianUser cianUser = cianUserRepository.findCianUserById(home.getOwner());
        house.setOwner(cianUser);
        ResidentialComplex residentialComplex = residentialComplexRepository.findResidentialComplexById(home.getResidentialComplex());
        house.setResidentialComplex(residentialComplex);
        house.setStatus(Status.VERIFIED);
        Regions regions = regionsRepository.findRegionsByCode(home.getRegions());
        house.setRegions(regions);
        return mapper.fromEntityToResponse(houseRepository.save(house));
    }

    @Override
    public HouseResponse updateHome(HouseUpdateRequest newHome) {
        House oldHouse = houseRepository.findHouseById(newHome.getId());
        House house = mapper.fromUpdateRequestToEntity(newHome);
        mapper.updateConvertor(house, oldHouse);
        return mapper.fromEntityToResponse(houseRepository.save(oldHouse));
    }

    @Override
    public void deleteHomeById(UUID id) {
        houseRepository.deleteHouseById(id);
    }

    @Override
    public HouseResponse findById(UUID id) {
        return mapper.fromEntityToResponse(houseRepository.findHouseById(id));
    }

    @Override
    public HouseAdminResponse findByIdByAdmin(UUID id) {
        return mapper.fromEntityToAdminResponse(houseRepository.findHouseById(id));
    }

    @Override
    public List<HouseResponse> findByAddress(String value) {
        return mapper.fromEntityToResponseList(houseRepository.findHouseByAddress(value));
    }


    @Override
    public void setStatusHome(UUID id, String newStatus) {
        houseRepository.setStatusOfHomeById(id, newStatus);
    }

    @Override
    public List<HouseResponse> findAllHousesOfSomeUser(UUID id) {
        return mapper.fromEntityToResponseList(houseRepository.findAllHousesOfSomeUser(id));
    }

}
