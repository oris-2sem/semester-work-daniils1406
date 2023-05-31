package com.example.tinycian.repository;

import com.example.tinycian.entities.Flat;
import com.example.tinycian.entities.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public interface HouseRepository extends JpaRepository<House, UUID> {

    @Query(value = "select * from House house join realty realty on realty.id=house.id where realty.status = :realtyStatus and realty.advert_type = :advertType " +
            "and realty.square >= :squareFrom and realty.square <= :squareTo and realty.cost >= :costFrom and realty.cost <= :costTo and realty.flat_or_house='HOUSE'", nativeQuery = true)
    List<House> customFindAllASC(String realtyStatus, String advertType, Integer squareFrom, Integer squareTo, Integer costFrom, Integer costTo);

    House findHouseById(UUID id);

    @Query(value = "select * from House house join realty realty on realty.id=house.id where realty.address like %:address%", nativeQuery = true)
    List<House> findHouseByAddress(String address);

    @Transactional
    @Modifying
    @Query(value = "UPDATE realty SET status=:status where id=:id", nativeQuery = true)
    void setStatusOfHomeById(UUID id, String status);

    @Query(value = "SELECT * from House house join realty realty on realty.id=house.id where realty.owner=:uuid", nativeQuery = true)
    List<House> findAllHousesOfSomeUser(UUID uuid);

    @Transactional
    @Modifying
    @Query(value = "update house set status='DELETE' where id=:id", nativeQuery = true)
    void deleteHouseById(UUID id);
}