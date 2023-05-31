package com.example.tinycian.service.impl;


import com.example.tinycian.dto.agent.AgentAdminResponse;
import com.example.tinycian.dto.agent.AgentRequest;
import com.example.tinycian.dto.agent.AgentResponse;
import com.example.tinycian.dto.agent.AgentUpdateRequest;
import com.example.tinycian.entities.Agent;
import com.example.tinycian.entities.cianenum.AgentLevel;
import com.example.tinycian.entities.cianenum.Status;
import com.example.tinycian.exceptions.UserWithThisLoginAlreadyExists;
import com.example.tinycian.mapper.AgentMapper;
import com.example.tinycian.repository.AgencyRepository;
import com.example.tinycian.repository.AgentRepository;
import com.example.tinycian.repository.CianUserRepository;
import com.example.tinycian.service.AgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AgentServiceImpl implements AgentService {


    private final AgentRepository agentRepository;

    private final CianUserRepository userRepository;

    private final AgencyRepository agencyRepository;

    private final PasswordEncoder passwordEncoder;


    private final AgentMapper mapper;

    @Override
    public List<AgentResponse> findAll(String userStatus, String agentLevel, String column, String order) {
        switch (order) {
            case "ASC", "asc" -> {
                return mapper.fromEntityToResponseList(agentRepository.findAllByStatusAndAgentLevel(Status.valueOf(userStatus), AgentLevel.valueOf(agentLevel), Sort.by(Sort.Direction.ASC, column)));
            }
            case "DESC", "desc" -> {
                return mapper.fromEntityToResponseList(agentRepository.findAllByStatusAndAgentLevel(Status.valueOf(userStatus), AgentLevel.valueOf(agentLevel), Sort.by(Sort.Direction.DESC, column)));
            }
        }
        return null;
    }


    @Override
    public AgentResponse createNewAgent(AgentRequest agentRequest) {
        Agent agent = mapper.fromRequestToEntity(agentRequest);
        agent.setCreateDate(Date.valueOf(LocalDate.now()));
        agent.setUpdateDate(Date.valueOf(LocalDate.now()));
        agent.setStatus(Status.VERIFIED);
        agent.setLogo("default.jpg");
        agent.setPassword(passwordEncoder.encode(agentRequest.getPassword()));
        agent.setAgentLevel(AgentLevel.STARTING);
        agent.setOrganisation(agencyRepository.findAgencyById(agentRequest.getOrganisation()));
        if (userRepository.findCianUserByLogin(agentRequest.getLogin()).isEmpty()) {
            return mapper.fromEntityToResponse(agentRepository.save(agent));
        } else {
            throw new UserWithThisLoginAlreadyExists(agentRequest.getLogin());
        }
    }

    @Override
    public AgentResponse updateAgentById(AgentUpdateRequest updateRequest) {
        Agent agent = mapper.fromUpdateRequestToEntity(updateRequest);
        Agent oldAgent = agentRepository.findAgentById(updateRequest.getId());
        mapper.updateConvertor(agent, oldAgent);
        if (userRepository.findCianUserByLogin(updateRequest.getLogin()).isEmpty()) {
            return mapper.fromEntityToResponse(agentRepository.save(oldAgent));
        } else {
            throw new UserWithThisLoginAlreadyExists(updateRequest.getLogin());
        }
    }

    @Override
    public void deleteById(UUID id) {
        agentRepository.deleteAgent(id);
    }

    @Override
    public List<AgentAdminResponse> findByName(String value) {
        return mapper.fromEntityToAdminResponseList(agentRepository.findAgentByFirstName(value));
    }

    @Override
    public List<AgentAdminResponse> findByPhone(String value) {
        return mapper.fromEntityToAdminResponseList(agentRepository.findAgentByPhone(value));
    }

    @Override
    public List<AgentAdminResponse> findByAgencyName(String value) {
        return mapper.fromEntityToAdminResponseList(agentRepository.findAgentByAgencyName(value));
    }

    @Override
    public AgentAdminResponse findByLogin(String login) {
        return mapper.fromEntityToAdminResponse(agentRepository.findAgentByLogin(login).get());
    }


    @Override
    public AgentResponse getAgentById(UUID id) {
        return mapper.fromEntityToResponse(agentRepository.findAgentById(id));
    }

    @Override
    public void hireAgentToSomeAgency(UUID idOfCompany, UUID idOfAgent) {
        Agent agent = agentRepository.findAgentById(idOfAgent);
        agent.setOrganisation(agencyRepository.findAgencyById(idOfCompany));
        agentRepository.save(agent);
    }

    @Override
    public void dismissAgentFromSomeAgency(UUID idOfAgent) {
        Agent agent = agentRepository.findAgentById(idOfAgent);
        agent.setOrganisation(null);
        agentRepository.save(agent);
    }

    @Override
    public List<AgentAdminResponse> findAllByAdmin(String userStatus, String agentLevel, String column, String order) {
        switch (order) {
            case "ASC", "asc" -> {
                return mapper.fromEntityToAdminResponseList(agentRepository.findAllByStatusAndAgentLevel(Status.valueOf(userStatus), AgentLevel.valueOf(agentLevel), Sort.by(Sort.Direction.ASC, column)));
            }
            case "DESC", "desc" -> {
                return mapper.fromEntityToAdminResponseList(agentRepository.findAllByStatusAndAgentLevel(Status.valueOf(userStatus), AgentLevel.valueOf(agentLevel), Sort.by(Sort.Direction.DESC, column)));
            }
        }
        return null;
    }

    @Override
    public AgentAdminResponse getAgentByIdByAdmin(UUID id) {
        return mapper.fromEntityToAdminResponse(agentRepository.findAgentById(id));
    }
}
