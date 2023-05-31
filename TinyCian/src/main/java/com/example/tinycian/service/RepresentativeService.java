package com.example.tinycian.service;

import com.example.tinycian.dto.agent.AgentAdminResponse;
import com.example.tinycian.dto.representative.RepresentativeAdminResponse;
import com.example.tinycian.dto.representative.RepresentativeRequest;
import com.example.tinycian.dto.representative.RepresentativeResponse;
import com.example.tinycian.dto.representative.RepresentativeUpdateRequest;
import com.example.tinycian.dto.user.UserRequest;
import com.example.tinycian.dto.user.UserResponse;
import com.example.tinycian.dto.user.UserUpdateRequest;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface RepresentativeService {
    List<RepresentativeResponse> findAll(String userStatus,String column,String order);

    List<RepresentativeAdminResponse> findAllByAdmin(String userStatus, String column, String order);

    RepresentativeResponse createRepresentative(RepresentativeRequest cianUserRequest);

    RepresentativeResponse updateCianUser(RepresentativeUpdateRequest cianUserUpdateRequest);

    void deleteById(UUID id);

    List<RepresentativeAdminResponse> findByName(String value);

    List<RepresentativeAdminResponse> findByPhone(String value);

    List<RepresentativeAdminResponse> findByAgencyName(String value);

    RepresentativeAdminResponse findByLogin(String login);

    RepresentativeResponse getUserById(UUID id);

    RepresentativeResponse getRepresentativeByLogin(String login);

    void approveById(UUID id);

    void bannedById(UUID id);
}
