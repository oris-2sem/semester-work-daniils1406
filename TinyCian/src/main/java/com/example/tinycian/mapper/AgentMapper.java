package com.example.tinycian.mapper;

import com.example.tinycian.dto.agent.AgentAdminResponse;
import com.example.tinycian.dto.agent.AgentRequest;
import com.example.tinycian.dto.agent.AgentResponse;
import com.example.tinycian.dto.agent.AgentUpdateRequest;
import com.example.tinycian.entities.Agent;
import com.example.tinycian.entities.CianUser;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AgentMapper {

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "status",ignore = true)
    @Mapping(target = "createDate",ignore = true)
    @Mapping(target = "updateDate",ignore = true)
    @Mapping(target = "logo",ignore = true)
    @Mapping(target = "organisation",ignore = true)
    @Mapping(target = "agentLevel",ignore = true)
    Agent fromRequestToEntity(AgentRequest agentRequest);
    @Mapping(target = "status",ignore = true)
    @Mapping(target = "createDate",ignore = true)
    @Mapping(target = "updateDate",ignore = true)
    @Mapping(target = "logo",ignore = true)
    @Mapping(target = "role",ignore = true)
    @Mapping(target = "userType",ignore = true)
    @Mapping(target = "organisation",ignore = true)
    @Mapping(target = "agentLevel",ignore = true)
    Agent fromUpdateRequestToEntity(AgentUpdateRequest agentUpdateRequest);

    AgentResponse fromEntityToResponse(Agent agent);

    AgentAdminResponse fromEntityToAdminResponse(Agent agent);

    List<AgentResponse> fromEntityToResponseList(List<Agent> agent);

    List<AgentAdminResponse> fromEntityToAdminResponseList(List<Agent> agent);

    void updateConvertor(Agent agent, @MappingTarget Agent newAgent);
}
