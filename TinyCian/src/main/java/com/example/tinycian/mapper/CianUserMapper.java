package com.example.tinycian.mapper;

import com.example.tinycian.dto.user.UserAdminResponse;
import com.example.tinycian.dto.user.UserRequest;
import com.example.tinycian.dto.user.UserResponse;
import com.example.tinycian.dto.user.UserUpdateRequest;
import com.example.tinycian.entities.CianUser;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CianUserMapper {
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "status",ignore = true)
    @Mapping(target = "createDate",ignore = true)
    @Mapping(target = "updateDate",ignore = true)
    @Mapping(target = "logo",ignore = true)
    CianUser fromRequestToEntity(UserRequest cianUserRequest);

    @Mapping(target = "status",ignore = true)
    @Mapping(target = "createDate",ignore = true)
    @Mapping(target = "updateDate",ignore = true)
    @Mapping(target = "logo",ignore = true)
    @Mapping(target = "role",ignore = true)
    @Mapping(target = "userType",ignore = true)
    CianUser fromUpdateRequestToEntity(UserUpdateRequest cianUserUpdateRequest);

    UserResponse fromEntityToResponse(CianUser cianUser);

    UserAdminResponse fromEntityToAdminResponse(CianUser cianUser);

    List<UserResponse> fromEntityToResponseList(List<CianUser> cianUser);

    List<UserAdminResponse> fromEntityToAdminResponseList(List<CianUser> cianUser);


    void updateConvertor(CianUser oldCianUser,@MappingTarget CianUser newCianUser);
}
