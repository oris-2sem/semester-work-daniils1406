package com.example.tinycian.service;

import com.example.tinycian.dto.agency.AgencyAdminResponse;
import com.example.tinycian.dto.agency.AgencyRequest;
import com.example.tinycian.dto.agency.AgencyResponse;
import com.example.tinycian.dto.agency.AgencyUpdateRequest;
import com.example.tinycian.dto.agent.AgentResponse;
import com.example.tinycian.entities.Agent;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface AgencyService {
    List<AgencyResponse> findAll(String status, String column,String order);

    List<AgencyAdminResponse> findAllByAdmin(String status, String column,String order);

    AgencyResponse createAgency(AgencyRequest agencyRequest);

    AgencyResponse updateAgencyById(AgencyUpdateRequest agencyRequest);

    AgencyResponse findById(UUID agencyId);

    void deleteById(UUID agencyId);

    void approveById(UUID agencyId);

    AgencyAdminResponse findByIdByAdmin(UUID id);

    List<AgentResponse> getAllAgentsOfSomeAgency(UUID id);

//    void setLogo(String logo,UUID id);
}
