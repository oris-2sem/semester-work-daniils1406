package com.example.tinycian.service.impl;

import com.example.tinycian.dto.user.UserAdminResponse;
import com.example.tinycian.dto.user.UserRequest;
import com.example.tinycian.dto.user.UserResponse;
import com.example.tinycian.dto.user.UserUpdateRequest;
import com.example.tinycian.entities.CianUser;
import com.example.tinycian.entities.cianenum.Role;
import com.example.tinycian.entities.cianenum.Status;
import com.example.tinycian.exceptions.UserWithThisLoginAlreadyExists;
import com.example.tinycian.exceptions.UserWithThisLoginNotExists;
import com.example.tinycian.mapper.CianUserMapper;
import com.example.tinycian.repository.CianUserRepository;
import com.example.tinycian.service.CianUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CianUserServiceImpl implements CianUserService {

    private final CianUserRepository cianUserRepository;

    private final CianUserMapper mapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserResponse> findAll(String userStatus, String role, String column, String order) {
        switch (order) {
            case "ASC", "asc" -> {
                return mapper.fromEntityToResponseList(cianUserRepository.findAllByStatusAndRole(Status.valueOf(userStatus), Role.valueOf(role), Sort.by(Sort.Direction.ASC, column)));
            }
            case "DESC", "desc" -> {
                return mapper.fromEntityToResponseList(cianUserRepository.findAllByStatusAndRole(Status.valueOf(userStatus), Role.valueOf(role), Sort.by(Sort.Direction.DESC, column)));
            }
        }
        return null;
    }

    @Override
    public List<UserAdminResponse> findAllByAdmin(String userStatus, String role, String column, String order) {
        switch (order) {
            case "ASC", "asc" -> {
                return mapper.fromEntityToAdminResponseList(cianUserRepository.findAllByStatusAndRole(Status.valueOf(userStatus), Role.valueOf(role), Sort.by(Sort.Direction.ASC, column)));
            }
            case "DESC", "desc" -> {
                return mapper.fromEntityToAdminResponseList(cianUserRepository.findAllByStatusAndRole(Status.valueOf(userStatus), Role.valueOf(role), Sort.by(Sort.Direction.DESC, column)));
            }
        }
        return null;
    }

    @Override
    public UserResponse createNewCianUser(UserRequest cianUserRequest) {
        CianUser cianUser = mapper.fromRequestToEntity(cianUserRequest);
        cianUser.setCreateDate(Date.valueOf(LocalDate.now()));
        cianUser.setUpdateDate(Date.valueOf(LocalDate.now()));
        cianUser.setStatus(Status.VERIFIED);
        cianUser.setLogo("default.jpg");
        cianUser.setPassword(passwordEncoder.encode(cianUserRequest.getPassword()));
        if (cianUserRepository.findCianUserByLogin(cianUserRequest.getLogin()).isEmpty()) {
            return mapper.fromEntityToResponse(cianUserRepository.save(cianUser));
        } else {
            throw new UserWithThisLoginAlreadyExists(cianUserRequest.getLogin());
        }
    }

    @Override
    public UserResponse updateCianUser(UserUpdateRequest cianUserUpdateRequest) {
        CianUser cianUser = mapper.fromUpdateRequestToEntity(cianUserUpdateRequest);
        CianUser oldCianUser = cianUserRepository.findCianUserById(cianUserUpdateRequest.getId());
        mapper.updateConvertor(cianUser, oldCianUser);
        if (cianUserRepository.findCianUserByLogin(cianUserUpdateRequest.getLogin()).isEmpty()) {
            return mapper.fromEntityToResponse(cianUserRepository.save(oldCianUser));
        } else {
            if (cianUserRepository.findCianUserByLogin(cianUserUpdateRequest.getLogin()).get().getId().equals(cianUserUpdateRequest.getId())) {
                return mapper.fromEntityToResponse(cianUserRepository.save(oldCianUser));
            }
            throw new UserWithThisLoginAlreadyExists(cianUserUpdateRequest.getLogin());
        }
    }

    @Override
    public void deleteById(UUID id) {
        cianUserRepository.deleteCianUser(id);
    }

    @Override
    public UserResponse getUserById(UUID id) {
        return mapper.fromEntityToResponse(cianUserRepository.findCianUserById(id));
    }

    @Override
    public UserAdminResponse findByLogin(String login) {
        return mapper.fromEntityToAdminResponse(cianUserRepository.findCianUserByLogin(login).orElseThrow(() ->
                new UserWithThisLoginNotExists(login)));
    }

    @Override
    public List<UserAdminResponse> findByName(String value) {
        return mapper.fromEntityToAdminResponseList(cianUserRepository.findCianUserByFirstName(value));
    }

    @Override
    public List<UserAdminResponse> findByPhone(String value) {
        return mapper.fromEntityToAdminResponseList(cianUserRepository.findCianUserByPhone(value));
    }


    @Override
    public void approveById(UUID id) {
        cianUserRepository.verifiedCianUser(id);
    }

    @Override
    public void bannedById(UUID id) {
        cianUserRepository.bannedCianUser(id);
    }

    @Override
    public void resetPassword(String login, String newPassword) {
        CianUser cianUser = cianUserRepository.findCianUserByLogin(login).orElseThrow(() ->
                new UserWithThisLoginNotExists(login));
        cianUser.setPassword(passwordEncoder.encode(newPassword));
        cianUserRepository.save(cianUser);
    }

    @Override
    public void setLogo(String logo, UUID id) {
        cianUserRepository.setLogoUser(logo, id);
    }

}
