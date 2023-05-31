package com.example.tinycian.controllers.CRUD;

import com.example.tinycian.dto.residentialcomplex.ResidentialComplexRequest;
import com.example.tinycian.dto.residentialcomplex.ResidentialComplexResponse;
import com.example.tinycian.dto.residentialcomplex.ResidentialComplexUpdateRequest;
import com.example.tinycian.service.ResidentialComplexService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ResidentialComplexImpl implements ResidentialComplex {

    private final ResidentialComplexService residentialComplexService;

    @Override
    public List<ResidentialComplexResponse> getAll(String realtyStatus, String column, String order) {
        return residentialComplexService.findAll(realtyStatus, column, order);
    }

    @Override
    public ResidentialComplexResponse create(ResidentialComplexRequest residentialComplexRequest) {
        return residentialComplexService.createResidentialComplex(residentialComplexRequest);
    }

    @Override
    public ResidentialComplexResponse update(ResidentialComplexUpdateRequest residentialComplexUpdateRequest) {
        return residentialComplexService.updateResidentialComplexById(residentialComplexUpdateRequest);
    }

    @Override
    public void delete(UUID id) {
        residentialComplexService.deleteById(id);
    }

    @Override
    public ResidentialComplexResponse getById(UUID id) {
        return residentialComplexService.findById(id);
    }


}
