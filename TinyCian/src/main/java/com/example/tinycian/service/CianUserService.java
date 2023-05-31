package com.example.tinycian.service;

import com.example.tinycian.dto.flat.FlatResponse;
import com.example.tinycian.dto.user.UserAdminResponse;
import com.example.tinycian.dto.user.UserRequest;
import com.example.tinycian.dto.user.UserResponse;
import com.example.tinycian.dto.user.UserUpdateRequest;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface CianUserService {
    List<UserResponse> findAll(String userStatus,String role,String column,String order);

    List<UserAdminResponse> findAllByAdmin(String userStatus, String role, String column, String order);

    UserResponse createNewCianUser(UserRequest cianUserRequest);

    UserResponse updateCianUser(UserUpdateRequest cianUserUpdateRequest);// проверить, что входящий пароль корректен и только потом изменять

    void deleteById(UUID id);

    UserResponse getUserById(UUID id);

    UserAdminResponse findByLogin(String login);

//    List<UserResponse> findByField(String fiend, String value);
    List<UserAdminResponse> findByName(String value);
    List<UserAdminResponse> findByPhone(String value);

    void approveById(UUID id);

    void bannedById(UUID id);

    void resetPassword(String login, String newPassword);

    void setLogo(String logo,UUID id);
}
