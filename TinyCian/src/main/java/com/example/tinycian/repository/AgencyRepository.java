package com.example.tinycian.repository;

import com.example.tinycian.entities.Agency;
import com.example.tinycian.entities.cianenum.Status;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public interface AgencyRepository extends JpaRepository<Agency, UUID> {


    List<Agency> findAllByStatus(Status status, Sort sort);

    Agency findAgencyById(UUID id);

    Agency findAgenciesByName(String name);

    @Transactional
    @Modifying
    @Query(value = "update agency set status='DELETE' where id=:id", nativeQuery = true)
    void deleteAgency(UUID id);

    @Transactional
    @Modifying
    @Query(value = "update agency set status='VERIFIED' where id=:id", nativeQuery = true)
    void verifiedAgency(UUID id);


}
