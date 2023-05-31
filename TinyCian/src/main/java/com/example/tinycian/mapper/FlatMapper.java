package com.example.tinycian.mapper;

import com.example.tinycian.dto.flat.FlatAdminResponse;
import com.example.tinycian.dto.flat.FlatRequest;
import com.example.tinycian.dto.flat.FlatResponse;
import com.example.tinycian.dto.flat.FlatUpdateRequest;
import com.example.tinycian.entities.CianUser;
import com.example.tinycian.entities.Flat;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FlatMapper {

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "status",ignore = true)
    @Mapping(target = "insertDate",ignore = true)
    @Mapping(target = "updateDate",ignore = true)
    @Mapping(target = "residentialComplex",ignore = true)
    @Mapping(target = "owner",ignore = true)
    @Mapping(target = "regions",ignore = true)
    Flat fromRequestToEntity(FlatRequest flatRequest);

    @Mapping(target = "status",ignore = true)
    @Mapping(target = "insertDate",ignore = true)
    @Mapping(target = "updateDate",ignore = true)
    @Mapping(target = "residentialComplex",ignore = true)
    @Mapping(target = "owner",ignore = true)
    @Mapping(target = "regions",ignore = true)
    Flat fromUpdateRequestToEntity(FlatUpdateRequest flatUpdateRequest);

    FlatResponse fromEntityToResponse(Flat flat);

    FlatAdminResponse fromEntityToAdminResponse(Flat flat);

    List<FlatResponse> fromEntityToResponseList(List<Flat> flat);

    List<FlatAdminResponse> fromEntityToAdminResponseList(List<Flat> flat);

    void updateConvertor(Flat flat, @MappingTarget Flat newFlat);
}
