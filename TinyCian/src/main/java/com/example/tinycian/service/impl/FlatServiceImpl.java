package com.example.tinycian.service.impl;

import com.example.tinycian.dto.flat.FlatAdminResponse;
import com.example.tinycian.dto.flat.FlatRequest;
import com.example.tinycian.dto.flat.FlatResponse;
import com.example.tinycian.dto.flat.FlatUpdateRequest;
import com.example.tinycian.dto.realty.RealtyResponse;
import com.example.tinycian.entities.CianUser;
import com.example.tinycian.entities.Flat;
import com.example.tinycian.entities.Regions;
import com.example.tinycian.entities.ResidentialComplex;
import com.example.tinycian.entities.cianenum.Status;
import com.example.tinycian.mapper.FlatMapper;
import com.example.tinycian.mapper.RealtyMapper;
import com.example.tinycian.repository.*;
import com.example.tinycian.service.FlatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FlatServiceImpl implements FlatService {

    private final FlatRepository flatRepository;

    private final RealtyRepository realtyRepository;

    private final CianUserRepository cianUserRepository;

    private final RegionsRepository regionsRepository;

    private final ResidentialComplexRepository residentialComplexRepository;

    private final FlatMapper mapper;

    private final RealtyMapper realtyMapper;

    @Override
    public List<FlatAdminResponse> findAllByAdmin(String realtyStatus, String realtyType, String advertType, Integer squareFrom, Integer squareTo, Integer costFrom, Integer costTo) {
        if (squareTo == 0) {
            squareTo = realtyRepository.findMaxSquareOfFlat();
        }
        if (costTo == 0) {
            costTo = realtyRepository.findMaxCostOfFlat();
        }
        return mapper.fromEntityToAdminResponseList(flatRepository.customFindAllASC(realtyStatus, realtyType, advertType, squareFrom, squareTo, costFrom, costTo));
    }

    @Override
    public List<FlatResponse> findAll(String realtyStatus, String realtyType, String advertType, Integer squareFrom, Integer squareTo, Integer costFrom, Integer costTo) {
        if (squareTo == 0) {
            squareTo = realtyRepository.findMaxSquareOfFlat();
        }
        if (costTo == 0) {
            costTo = realtyRepository.findMaxCostOfFlat();
        }
        return mapper.fromEntityToResponseList(flatRepository.customFindAllASC(realtyStatus, realtyType, advertType, squareFrom, squareTo, costFrom, costTo));
    }

    @Override
    public FlatResponse createFlat(@RequestBody FlatRequest flat) {
        Flat flatForInsert = mapper.fromRequestToEntity(flat);
        flatForInsert.setInsertDate(Date.valueOf(LocalDate.now()));
        flatForInsert.setUpdateDate(Date.valueOf(LocalDate.now()));
        CianUser cianUser = cianUserRepository.findCianUserById(flat.getOwner());
        flatForInsert.setOwner(cianUser);
        ResidentialComplex residentialComplex = residentialComplexRepository.findResidentialComplexById(flat.getResidentialComplex());
        flatForInsert.setResidentialComplex(residentialComplex);
        flatForInsert.setStatus(Status.VERIFIED);
        Regions regions = regionsRepository.findRegionsByCode(flat.getRegions());
        flatForInsert.setRegions(regions);
        return mapper.fromEntityToResponse(flatRepository.save(flatForInsert));
    }

    @Override
    public FlatResponse updateFlat(@RequestBody FlatUpdateRequest newFlat) {
        Flat oldFlat = flatRepository.findFlatById(newFlat.getId());
        Flat flat = mapper.fromUpdateRequestToEntity(newFlat);
        mapper.updateConvertor(flat, oldFlat);
        oldFlat.setRegions(regionsRepository.findRegionsByCode(newFlat.getRegions()));
        return mapper.fromEntityToResponse(flatRepository.save(oldFlat));
    }

    @Override
    public FlatResponse findById(UUID flatId) {
        return mapper.fromEntityToResponse(flatRepository.findFlatById(flatId));
    }

    @Override
    public FlatAdminResponse findByIdByAdmin(UUID flatId) {
        return mapper.fromEntityToAdminResponse(flatRepository.findFlatById(flatId));
    }

    @Override
    public List<FlatResponse> findByAddress(String value) {
        return mapper.fromEntityToResponseList(flatRepository.findFlatByAddress(value));
    }

    @Override
    public List<FlatResponse> findByResidentialComplexName(String value) {
        return mapper.fromEntityToResponseList(flatRepository.findFlatByResidentialComplexName(value));
    }

    @Override
    public void setStatusFlat(UUID flatId, String newStatus) {
        flatRepository.setStatusForFlatById(flatId, newStatus);
    }

    @Override
    public List<RealtyResponse> findAllRealtysOfSomeUser(UUID idOfUser) {
        return realtyMapper.fromEntityToResponseList(realtyRepository.findRealtiesByOwner(idOfUser));
    }

    @Override
    public List<FlatResponse> findAllFlatOfSomeUser(UUID idOfUser) {
        return mapper.fromEntityToResponseList(flatRepository.findAllFlatsOfSomeUser(idOfUser));
    }

    @Override
    public void deleteById(UUID id) {
        flatRepository.deleteFlatById(id);
    }


    @Override
    public Integer findMaxSquare() {
        return realtyRepository.findMaxSquareOfFlat();
    }

    @Override
    public Integer findMaxCost() {
        return realtyRepository.findMaxCostOfFlat();
    }
}
