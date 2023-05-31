package com.example.tinycian.repository;

import com.example.tinycian.entities.ResidentialComplex;
import com.example.tinycian.entities.cianenum.Status;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public interface ResidentialComplexRepository extends JpaRepository<ResidentialComplex, UUID> {


    List<ResidentialComplex> findAllByStatus(Status status, Sort sort);

    ResidentialComplex findResidentialComplexById(UUID id);

    @Transactional
    @Modifying
    @Query(value = "update residential_complex set status='DELETE' where id=:id", nativeQuery = true)
    void deleteResidentialComplex(UUID id);

    @Transactional
    @Modifying
    @Query("update ResidentialComplex residentialComplex set residentialComplex.status='VERIFIED' where residentialComplex.id=:id")
    void approveResidentialComplex(UUID id);

    @Query(value = "select * from residential_complex residentialComplex where residentialComplex.name like CONCAT('%',:name,'%')", nativeQuery = true)
    List<ResidentialComplex> findResidentialComplexByName(String name);
}
