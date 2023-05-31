package com.example.tinycian.mapper;

import com.example.tinycian.dto.representative.RepresentativeAdminResponse;
import com.example.tinycian.dto.representative.RepresentativeRequest;
import com.example.tinycian.dto.representative.RepresentativeResponse;
import com.example.tinycian.dto.representative.RepresentativeUpdateRequest;
import com.example.tinycian.entities.CianUser;
import com.example.tinycian.entities.Realty;
import com.example.tinycian.entities.Representative;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface RepresentativeMapper {
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "status",ignore = true)
    @Mapping(target = "createDate",ignore = true)
    @Mapping(target = "updateDate",ignore = true)
    @Mapping(target = "logo",ignore = true)
    @Mapping(target = "organisation",ignore = true)
    Representative fromRequestToEntity(RepresentativeRequest representativeRequest);

    @Mapping(target = "status",ignore = true)
    @Mapping(target = "createDate",ignore = true)
    @Mapping(target = "updateDate",ignore = true)
    @Mapping(target = "logo",ignore = true)
    @Mapping(target = "role",ignore = true)
    @Mapping(target = "userType",ignore = true)
    @Mapping(target = "organisation",ignore = true)
    Representative fromUpdateRequestToEntity(RepresentativeUpdateRequest representativeUpdateRequest);

    RepresentativeResponse fromEntityToResponse(Representative representative);

    RepresentativeAdminResponse fromEntityToAdminResponse(Representative representative);

    List<RepresentativeResponse> fromEntityToResponseList(List<Representative> representative);

    List<RepresentativeAdminResponse> fromEntityToAdminResponseList(List<Representative> representative);

    void updateConvertor(Representative representative, @MappingTarget Representative newRepresentative);
}
