package com.example.tinycian.repository;

import com.example.tinycian.entities.Flat;
import com.example.tinycian.entities.cianenum.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public interface FlatRepository extends JpaRepository<Flat, UUID> {
    @Query(value = "select * from Flat flat join realty realty on realty.id=flat.id where realty.status = :realtyStatus and flat.realty_type = :realtyType and realty.advert_type = :advertType " +
            "and realty.square >= :squareFrom and realty.square <= :squareTo and realty.cost >= :costFrom and realty.cost <= :costTo and realty.flat_or_house='FLAT'", nativeQuery = true)
    List<Flat> customFindAllASC(String realtyStatus, String realtyType, String advertType, Integer squareFrom, Integer squareTo, Integer costFrom, Integer costTo);

    Flat findFlatById(UUID id);

    @Query(value = "select * from Flat flat join realty realty on realty.id=flat.id where realty.address like concat('%',:address,'%') ", nativeQuery = true)
    List<Flat> findFlatByAddress(String address);

    @Query(value = "select * from Flat flat join realty realty on realty.id=flat.id where cianUser.residential_complex.name like concat('%',:name,'%')", nativeQuery = true)
    List<Flat> findFlatByResidentialComplexName(String name);


    @Transactional
    @Modifying
    @Query(value = "UPDATE realty SET status=:status where id=:id", nativeQuery = true)
    void setStatusForFlatById(UUID id, String status);


    @Query(value = "SELECT * from Flat flat join realty realty on realty.id=flat.id where realty.owner=:uuid", nativeQuery = true)
    List<Flat> findAllFlatsOfSomeUser(UUID uuid);

    @Transactional
    @Modifying
    @Query(value = "UPDATE realty SET status='DELETE' where id=:id", nativeQuery = true)
    void deleteFlatById(UUID id);
}