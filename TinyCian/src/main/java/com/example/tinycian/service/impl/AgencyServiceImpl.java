package com.example.tinycian.service.impl;

import com.example.tinycian.dto.agency.AgencyAdminResponse;
import com.example.tinycian.dto.agency.AgencyRequest;
import com.example.tinycian.dto.agency.AgencyResponse;
import com.example.tinycian.dto.agency.AgencyUpdateRequest;
import com.example.tinycian.dto.agent.AgentResponse;
import com.example.tinycian.entities.Agency;
import com.example.tinycian.entities.cianenum.Status;
import com.example.tinycian.mapper.AgencyMapper;
import com.example.tinycian.mapper.AgentMapper;
import com.example.tinycian.repository.AgencyRepository;
import com.example.tinycian.repository.AgentRepository;
import com.example.tinycian.repository.RegionsRepository;
import com.example.tinycian.service.AgencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AgencyServiceImpl implements AgencyService {

    private final AgencyMapper mapper;

    private final AgencyRepository agencyRepository;

    private final RegionsRepository regionsRepository;

    private final AgentRepository agentRepository;

    private final AgentMapper agentMapper;


    @Override
    public List<AgencyResponse> findAll(String status, String column, String order) {
        switch (order) {
            case "ASC", "asc" -> {
                return mapper.fromEntityToResponseList(agencyRepository.findAllByStatus(Status.valueOf(status), Sort.by(Sort.Direction.ASC, column)));
            }
            case "DESC", "desc" -> {
                return mapper.fromEntityToResponseList(agencyRepository.findAllByStatus(Status.valueOf(status), Sort.by(Sort.Direction.DESC, column)));
            }
        }
        return null;
    }

    @Override
    public List<AgencyAdminResponse> findAllByAdmin(String status, String column, String order) {
        switch (order) {
            case "ASC", "asc" -> {
                return mapper.fromEntityToAdminResponseList(agencyRepository.findAllByStatus(Status.valueOf(status), Sort.by(Sort.Direction.ASC, column)));
            }
            case "DESC", "desc" -> {
                return mapper.fromEntityToAdminResponseList(agencyRepository.findAllByStatus(Status.valueOf(status), Sort.by(Sort.Direction.DESC, column)));
            }
        }
        return null;
    }

    @Override
    public AgencyResponse createAgency(AgencyRequest agencyRequest) {
        Agency agency = mapper.fromRequestToEntity(agencyRequest);
        agency.setRegionsList(new HashSet<>());
        for (String regionName : agencyRequest.getRegionsList()) {
            agency.getRegionsList().add(regionsRepository.findRegionsByCode(Integer.parseInt(regionName)));
        }
        agency.setInsertDate(Date.valueOf(LocalDate.now()));
        agency.setStatus(Status.VERIFIED);
        return mapper.fromEntityToResponse(agencyRepository.save(agency));
    }

    @Override
    public AgencyResponse updateAgencyById(AgencyUpdateRequest agencyRequest) {
        System.out.println(agencyRequest.getRegionsList().toString());
        Agency newAgency = mapper.fromUpdateRequestToEntity(agencyRequest);
        newAgency.setStatus(Status.VERIFIED);
        newAgency.setInsertDate(Date.valueOf(LocalDate.now()));
        newAgency.setRegionsList(new HashSet<>());
        for(String regionCode:agencyRequest.getRegionsList()){
            newAgency.getRegionsList().add(regionsRepository.findRegionsByCode(Integer.valueOf(regionCode)));
        }
        return mapper.fromEntityToResponse(agencyRepository.save(newAgency));
    }

    @Override
    public AgencyResponse findById(UUID agencyId) {
        return mapper.fromEntityToResponse(agencyRepository.findAgencyById(agencyId));
    }

    @Override
    public void deleteById(UUID agencyId) {
        agencyRepository.deleteAgency(agencyId);
    }

    @Override
    public void approveById(UUID agencyId) {
        agencyRepository.verifiedAgency(agencyId);
    }

    @Override
    public AgencyAdminResponse findByIdByAdmin(UUID id) {
        return mapper.fromEntityToAdminResponse(agencyRepository.findAgencyById(id));
    }

    @Override
    public List<AgentResponse> getAllAgentsOfSomeAgency(UUID id) {
        return agentMapper.fromEntityToResponseList(agentRepository.findAgentByAgencyId(id));
    }

}
