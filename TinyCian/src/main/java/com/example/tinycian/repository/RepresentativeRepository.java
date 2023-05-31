package com.example.tinycian.repository;

import com.example.tinycian.entities.Representative;
import com.example.tinycian.entities.cianenum.Status;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RepresentativeRepository extends JpaRepository<Representative, UUID> {


    List<Representative> findAllByStatus(Status status, Sort sort);

    @Transactional
    @Modifying
    @Query(value = "update cian_user set status='DELETE' where id=:id", nativeQuery = true)
    void deleteRepresentative(UUID id);

    @Transactional
    @Modifying
    @Query("update Representative representative set representative .status='VERIFIED' where representative .id=:id")
    void approveById(UUID id);

    @Transactional
    @Modifying
    @Query("update Representative representative set representative .status='BANNED' where representative .id=:id")
    void bannedById(UUID id);

    Optional<Representative> findRepresentativeById(UUID id);

    Optional<Representative> findRepresentativeByLogin(String login);

    List<Representative> findRepresentativeByFirstName(String name);

    List<Representative> findRepresentativeByPhone(String phone);

    @Query("select representative from Representative representative where representative.organisation.name=:agencyName")
    List<Representative> findRepresentativeByAgencyName(String agencyName);
}
