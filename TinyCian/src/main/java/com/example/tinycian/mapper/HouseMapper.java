package com.example.tinycian.mapper;

import com.example.tinycian.dto.house.HouseAdminResponse;
import com.example.tinycian.dto.house.HouseRequest;
import com.example.tinycian.dto.house.HouseResponse;
import com.example.tinycian.dto.house.HouseUpdateRequest;
import com.example.tinycian.entities.Flat;
import com.example.tinycian.entities.House;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface HouseMapper {
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "status",ignore = true)
    @Mapping(target = "insertDate",ignore = true)
    @Mapping(target = "updateDate",ignore = true)
    @Mapping(target = "residentialComplex",ignore = true)
    @Mapping(target = "owner",ignore = true)
    @Mapping(target = "regions",ignore = true)
    House fromRequestToEntity(HouseRequest realtyRequest);

    @Mapping(target = "status",ignore = true)
    @Mapping(target = "insertDate",ignore = true)
    @Mapping(target = "updateDate",ignore = true)
    @Mapping(target = "residentialComplex",ignore = true)
    @Mapping(target = "owner",ignore = true)
    @Mapping(target = "regions",ignore = true)
    House fromUpdateRequestToEntity(HouseUpdateRequest realtyUpdateRequest);

    HouseResponse fromEntityToResponse(House realty);

    HouseAdminResponse fromEntityToAdminResponse(House realty);

    List<HouseResponse> fromEntityToResponseList(List<House> realty);

    List<HouseAdminResponse> fromEntityToAdminResponseList(List<House> realty);

    void updateConvertor(House house, @MappingTarget House newHouse);
}
