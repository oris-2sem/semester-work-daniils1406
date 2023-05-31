package com.example.tinycian.mapper;

import com.example.tinycian.dto.agency.AgencyAdminResponse;
import com.example.tinycian.dto.agency.AgencyRequest;
import com.example.tinycian.dto.agency.AgencyResponse;
import com.example.tinycian.dto.agency.AgencyUpdateRequest;
import com.example.tinycian.entities.Agency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgencyMapper {

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "status",ignore = true)
    @Mapping(target = "insertDate",ignore = true)
    @Mapping(target = "regionsList",ignore = true)
    Agency fromRequestToEntity(AgencyRequest agencyRequest);

    @Mapping(target = "status",ignore = true)
    @Mapping(target = "insertDate",ignore = true)
    @Mapping(target = "regionsList",ignore = true)
    Agency fromUpdateRequestToEntity(AgencyUpdateRequest agencyUpdateRequest);

    AgencyResponse fromEntityToResponse(Agency agency);

    AgencyAdminResponse fromEntityToAdminResponse(Agency agency);

    List<AgencyResponse> fromEntityToResponseList(List<Agency> agency);

    List<AgencyAdminResponse> fromEntityToAdminResponseList(List<Agency> agency);

}
