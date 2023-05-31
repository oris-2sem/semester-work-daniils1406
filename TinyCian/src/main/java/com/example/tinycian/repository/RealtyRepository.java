package com.example.tinycian.repository;

import com.example.tinycian.entities.Realty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface RealtyRepository extends JpaRepository<Realty, UUID> {


    @Query(value = "select * from Realty realty where realty.owner.id=:idOfUser", nativeQuery = true)
    List<Realty> findRealtiesByOwner(UUID idOfUser);

    @Query(value = "select max(realty.square) from Realty realty where realty.flat_or_house='FLAT'", nativeQuery = true)
    Integer findMaxSquareOfFlat();

    @Query(value = "select max(realty.cost) from Realty realty where realty.flat_or_house='FLAT'", nativeQuery = true)
    Integer findMaxCostOfFlat();

    @Query(value = "select max(realty.square) from Realty realty where realty.flat_or_house='HOUSE'", nativeQuery = true)
    Integer findMaxSquareOfHouse();

    @Query(value = "select max(realty.cost) from Realty realty where realty.flat_or_house='HOUSE'", nativeQuery = true)
    Integer findMaxCostOfHouse();

    Realty findRealtyById(UUID id);
}
