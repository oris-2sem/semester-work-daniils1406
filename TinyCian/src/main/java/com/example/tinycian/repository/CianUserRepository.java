package com.example.tinycian.repository;

import com.example.tinycian.entities.Agent;
import com.example.tinycian.entities.CianUser;
import com.example.tinycian.entities.cianenum.Role;
import com.example.tinycian.entities.cianenum.Status;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CianUserRepository extends JpaRepository<CianUser, UUID> {


    List<CianUser> findAllByStatusAndRole(Status status, Role role, Sort sort);

    Optional<CianUser> findCianUserByLogin(String login);


    @Transactional
    @Modifying
    @Query(value = "update cian_user set status='DELETE' where id=:id", nativeQuery = true)
    void deleteCianUser(UUID id);

    CianUser findCianUserById(UUID id);

    List<CianUser> findCianUserByFirstName(String name);

    List<CianUser> findCianUserByPhone(String phone);

    @Transactional
    @Modifying
    @Query("update CianUser a set a.status='VERIFIED' where a.id=:id")
    void verifiedCianUser(UUID id);

    @Transactional
    @Modifying
    @Query("update CianUser a set a.status='BANNED' where a.id=:id")
    void bannedCianUser(UUID id);

    @Transactional
    @Modifying
    @Query(value = "update cian_user set logo=:logoUser where id=:id", nativeQuery = true)
    void setLogoUser(String logoUser, UUID id);

}
