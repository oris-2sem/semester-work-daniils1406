package com.example.tinycian.repository;

import com.example.tinycian.entities.Regions;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RegionsRepository extends JpaRepository<Regions, UUID> {

    Regions findRegionsByRegionName(String regionName);

    Regions findRegionsByCode(Integer code);
}
