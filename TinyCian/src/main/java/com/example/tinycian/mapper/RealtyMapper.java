package com.example.tinycian.mapper;

import com.example.tinycian.dto.flat.FlatAdminResponse;
import com.example.tinycian.dto.flat.FlatRequest;
import com.example.tinycian.dto.flat.FlatResponse;
import com.example.tinycian.dto.flat.FlatUpdateRequest;
import com.example.tinycian.dto.realty.RealtyAdminResponse;
import com.example.tinycian.dto.realty.RealtyResponse;
import com.example.tinycian.entities.Realty;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring")
public interface RealtyMapper {
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "status",ignore = true)
    @Mapping(target = "insertDate",ignore = true)
    @Mapping(target = "updateDate",ignore = true)
    @Mapping(target = "residentialComplex",ignore = true)
    @Mapping(target = "owner",ignore = true)
    @Mapping(target = "regions",ignore = true)
    Realty fromRequestToEntity(FlatRequest flatRequest);

    @Mapping(target = "status",ignore = true)
    @Mapping(target = "insertDate",ignore = true)
    @Mapping(target = "updateDate",ignore = true)
    @Mapping(target = "residentialComplex",ignore = true)
    @Mapping(target = "owner",ignore = true)
    @Mapping(target = "regions",ignore = true)
    Realty fromUpdateRequestToEntity(FlatUpdateRequest flatUpdateRequest);

    RealtyResponse fromEntityToResponse(Realty flat);


    RealtyAdminResponse fromEntityToAdminResponse(Realty flat);

    List<RealtyResponse> fromEntityToResponseList(List<Realty> flat);

    List<RealtyAdminResponse> fromEntityToAdminResponseList(List<Realty> flat);
}
