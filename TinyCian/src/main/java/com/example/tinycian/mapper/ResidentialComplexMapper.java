package com.example.tinycian.mapper;

import com.example.tinycian.dto.residentialcomplex.ResidentialComplexAdminResponse;
import com.example.tinycian.dto.residentialcomplex.ResidentialComplexRequest;
import com.example.tinycian.dto.residentialcomplex.ResidentialComplexResponse;
import com.example.tinycian.dto.residentialcomplex.ResidentialComplexUpdateRequest;
import com.example.tinycian.entities.Agent;
import com.example.tinycian.entities.ResidentialComplex;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ResidentialComplexMapper {
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "status",ignore = true)
    @Mapping(target = "regions",ignore = true)
    @Mapping(target = "agency",ignore = true)
    ResidentialComplex fromRequestToEntity(ResidentialComplexRequest residentialComplexRequest);

    @Mapping(target = "status",ignore = true)
    @Mapping(target = "regions",ignore = true)
    @Mapping(target = "agency",ignore = true)
    ResidentialComplex fromUpdateRequestToEntity(ResidentialComplexUpdateRequest residentialComplexUpdateRequest);

    ResidentialComplexResponse fromEntityToResponse(ResidentialComplex residentialComplex);

    ResidentialComplexAdminResponse fromEntityToAdminResponse(ResidentialComplex residentialComplex);

    List<ResidentialComplexResponse> fromEntityToResponseList(List<ResidentialComplex> residentialComplex);

    List<ResidentialComplexAdminResponse> fromEntityToAdminResponseList(List<ResidentialComplex> residentialComplex);

    void updateConvertor(ResidentialComplex residentialComplex, @MappingTarget ResidentialComplex newResidentialComplex);
}
