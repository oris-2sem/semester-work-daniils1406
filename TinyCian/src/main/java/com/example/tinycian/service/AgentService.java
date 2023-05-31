package com.example.tinycian.service;

import com.example.tinycian.dto.agent.AgentAdminResponse;
import com.example.tinycian.dto.agent.AgentRequest;
import com.example.tinycian.dto.agent.AgentResponse;
import com.example.tinycian.dto.agent.AgentUpdateRequest;
import com.example.tinycian.dto.flat.FlatResponse;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface AgentService {
    List<AgentResponse> findAll(String userStatus,String agentLevel,String column,String order);


    AgentResponse createNewAgent(AgentRequest agentRequest);

    AgentResponse updateAgentById(AgentUpdateRequest updateRequest);

    void deleteById(UUID id);

//    List<AgentResponse> findByField(String fiend, String value);
    List<AgentAdminResponse> findByName(String value);
    List<AgentAdminResponse> findByPhone(String value);
    List<AgentAdminResponse> findByAgencyName(String value);

    AgentAdminResponse findByLogin(String login);

    AgentResponse getAgentById(UUID id);


    void hireAgentToSomeAgency(UUID idOfCompany,UUID idOfAgent);

    void dismissAgentFromSomeAgency(UUID idOfAgent);

    List<AgentAdminResponse> findAllByAdmin(String userStatus, String agentLevel, String column, String order);

    AgentAdminResponse getAgentByIdByAdmin(UUID id);
}
