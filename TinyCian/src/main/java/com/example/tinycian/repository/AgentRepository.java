package com.example.tinycian.repository;

import com.example.tinycian.dto.agent.AgentResponse;
import com.example.tinycian.entities.Agent;
import com.example.tinycian.entities.cianenum.AgentLevel;
import com.example.tinycian.entities.cianenum.Status;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AgentRepository extends JpaRepository<Agent, UUID> {


    List<Agent> findAllByStatusAndAgentLevel(Status status, AgentLevel agentLevel, Sort sort);

    Optional<Agent> findAgentByLogin(String login);

    @Transactional
    @Modifying
    @Query(value = "update cian_user set status='DELETE' where id=:id", nativeQuery = true)
    void deleteAgent(UUID id);

    List<Agent> findAgentByFirstName(String name);

    List<Agent> findAgentByPhone(String phone);

    @Query(value = "select agent from Agent agent where agent.organisation.name=:name")
    List<Agent> findAgentByAgencyName(String name);

    @Query(value = "select agent from Agent agent where agent.organisation.id=:id")
    List<Agent> findAgentByAgencyId(UUID id);

    Agent findAgentById(UUID id);

}
