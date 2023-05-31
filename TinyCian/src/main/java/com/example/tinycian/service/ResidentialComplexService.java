package com.example.tinycian.service;

import com.example.tinycian.dto.residentialcomplex.ResidentialComplexAdminResponse;
import com.example.tinycian.dto.residentialcomplex.ResidentialComplexRequest;
import com.example.tinycian.dto.residentialcomplex.ResidentialComplexResponse;
import com.example.tinycian.dto.residentialcomplex.ResidentialComplexUpdateRequest;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ResidentialComplexService {
    List<ResidentialComplexResponse> findAll(String status,String column,String order);

    List<ResidentialComplexAdminResponse> findAllByAdmin(String status,String column,String order);

    ResidentialComplexResponse createResidentialComplex(ResidentialComplexRequest residentialComplexRequest);

    ResidentialComplexResponse updateResidentialComplexById(ResidentialComplexUpdateRequest residentialComplexRequest);

    ResidentialComplexResponse findById(UUID residentialComplexId);

    void deleteById(UUID residentialComplexId);

    void approveById(UUID residentialComplexId);

    ResidentialComplexAdminResponse findByIdByAdmin(UUID id);

    List<ResidentialComplexAdminResponse> findByName(String name);
}
