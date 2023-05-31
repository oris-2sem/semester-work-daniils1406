package com.example.tinycian.service.impl;

import com.example.tinycian.dto.residentialcomplex.ResidentialComplexAdminResponse;
import com.example.tinycian.dto.residentialcomplex.ResidentialComplexRequest;
import com.example.tinycian.dto.residentialcomplex.ResidentialComplexResponse;
import com.example.tinycian.dto.residentialcomplex.ResidentialComplexUpdateRequest;
import com.example.tinycian.entities.ResidentialComplex;
import com.example.tinycian.entities.cianenum.Status;
import com.example.tinycian.exceptions.ResidentialComplexNotDoundException;
import com.example.tinycian.mapper.ResidentialComplexMapper;
import com.example.tinycian.repository.AgencyRepository;
import com.example.tinycian.repository.RegionsRepository;
import com.example.tinycian.repository.ResidentialComplexRepository;
import com.example.tinycian.service.ResidentialComplexService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ResidentialComplexServiceImpl implements ResidentialComplexService {

    private final ResidentialComplexRepository repository;

    private final AgencyRepository agencyRepository;

    private final RegionsRepository regionsRepository;

    private final ResidentialComplexMapper mapper;

    @Override
    public List<ResidentialComplexResponse> findAll(String status, String column, String order) {
        if (order.equalsIgnoreCase("ASC")) {
            return mapper.fromEntityToResponseList(repository.findAllByStatus(Status.valueOf(status), Sort.by(Sort.Direction.ASC, column)));
        } else {
            return mapper.fromEntityToResponseList(repository.findAllByStatus(Status.valueOf(status), Sort.by(Sort.Direction.DESC, column)));
        }
    }

    @Override
    public List<ResidentialComplexAdminResponse> findAllByAdmin(String status, String column, String order) {
        if (order.equalsIgnoreCase("ASC")) {
            return mapper.fromEntityToAdminResponseList(repository.findAllByStatus(Status.valueOf(status), Sort.by(Sort.Direction.ASC, column)));
        } else {
            return mapper.fromEntityToAdminResponseList(repository.findAllByStatus(Status.valueOf(status), Sort.by(Sort.Direction.DESC, column)));
        }
    }

    @Override
    public ResidentialComplexResponse createResidentialComplex(ResidentialComplexRequest residentialComplexRequest) {
        ResidentialComplex residentialComplex = mapper.fromRequestToEntity(residentialComplexRequest);
        residentialComplex.setAgency(agencyRepository.findAgencyById(residentialComplexRequest.getAgency()));
        residentialComplex.setRegions(regionsRepository.findRegionsByCode(residentialComplexRequest.getRegions()));
        residentialComplex.setStatus(Status.VERIFIED);
        return mapper.fromEntityToResponse(repository.save(residentialComplex));
    }

    @Override
    public ResidentialComplexResponse updateResidentialComplexById(ResidentialComplexUpdateRequest residentialComplexRequest) {
        ResidentialComplex oldResidentialComplex = repository.findResidentialComplexById(residentialComplexRequest.getId());
        ResidentialComplex residentialComplex = mapper.fromUpdateRequestToEntity(residentialComplexRequest);
        mapper.updateConvertor(residentialComplex, oldResidentialComplex);
        return mapper.fromEntityToResponse(repository.save(oldResidentialComplex));
    }

    @Override
    public ResidentialComplexResponse findById(UUID residentialComplexId) {
        ResidentialComplexResponse response= mapper.fromEntityToResponse(repository.findResidentialComplexById(residentialComplexId));
        if (response!= null) {
            return response;
        }else{
            throw new ResidentialComplexNotDoundException(residentialComplexId.toString());
        }
    }

    @Override
    public void deleteById(UUID residentialComplexId) {
        repository.deleteResidentialComplex(residentialComplexId);
    }

    @Override
    public void approveById(UUID residentialComplexId) {
        repository.approveResidentialComplex(residentialComplexId);
    }

    @Override
    public ResidentialComplexAdminResponse findByIdByAdmin(UUID id) {
        return mapper.fromEntityToAdminResponse(repository.findResidentialComplexById(id));
    }

    @Override
    public List<ResidentialComplexAdminResponse> findByName(String name) {
        return mapper.fromEntityToAdminResponseList(repository.findResidentialComplexByName(name));
    }
}
