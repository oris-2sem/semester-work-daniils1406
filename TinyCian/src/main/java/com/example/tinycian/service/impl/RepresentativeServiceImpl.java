package com.example.tinycian.service.impl;

import com.example.tinycian.dto.agent.AgentAdminResponse;
import com.example.tinycian.dto.representative.RepresentativeAdminResponse;
import com.example.tinycian.dto.representative.RepresentativeRequest;
import com.example.tinycian.dto.representative.RepresentativeResponse;
import com.example.tinycian.dto.representative.RepresentativeUpdateRequest;
import com.example.tinycian.entities.Representative;
import com.example.tinycian.entities.cianenum.Status;
import com.example.tinycian.exceptions.UserWithThisLoginAlreadyExists;
import com.example.tinycian.mapper.RepresentativeMapper;
import com.example.tinycian.repository.AgencyRepository;
import com.example.tinycian.repository.CianUserRepository;
import com.example.tinycian.repository.RegionsRepository;
import com.example.tinycian.repository.RepresentativeRepository;
import com.example.tinycian.service.RepresentativeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RepresentativeServiceImpl implements RepresentativeService {

    private final RepresentativeRepository repository;

    private final CianUserRepository userRepository;

    private final RepresentativeMapper mapper;

    private final PasswordEncoder passwordEncoder;
    private final AgencyRepository agencyRepository;
    private final RegionsRepository regionsRepository;

    @Override
    public List<RepresentativeResponse> findAll(String userStatus, String column, String order) {
        switch (order) {
            case "ASC", "asc" -> {
                return mapper.fromEntityToResponseList(repository.findAllByStatus(Status.valueOf(userStatus), Sort.by(Sort.Direction.ASC, column)));
            }
            case "DESC", "desc" -> {
                return mapper.fromEntityToResponseList(repository.findAllByStatus(Status.valueOf(userStatus), Sort.by(Sort.Direction.DESC, column)));
            }
        }
        return null;
    }

    @Override
    public List<RepresentativeAdminResponse> findAllByAdmin(String userStatus, String column, String order) {
        switch (order) {
            case "ASC", "asc" -> {
                return mapper.fromEntityToAdminResponseList(repository.findAllByStatus(Status.valueOf(userStatus), Sort.by(Sort.Direction.ASC, column)));
            }
            case "DESC", "desc" -> {
                return mapper.fromEntityToAdminResponseList(repository.findAllByStatus(Status.valueOf(userStatus), Sort.by(Sort.Direction.DESC, column)));
            }
        }
        return null;
    }

    @Override
    public RepresentativeResponse createRepresentative(RepresentativeRequest cianUserRequest) {
        Representative representative = mapper.fromRequestToEntity(cianUserRequest);
        representative.setCreateDate(Date.valueOf(LocalDate.now()));
        representative.setUpdateDate(Date.valueOf(LocalDate.now()));
        representative.setStatus(Status.VERIFIED);
        representative.setLogo("default.jpg");
        representative.setOrganisation(agencyRepository.findAgencyById(cianUserRequest.getOrganisation()));
        representative.setPassword(passwordEncoder.encode(cianUserRequest.getPassword()));
//        return mapper.fromEntityToResponse(repository.save(representative));
        if (userRepository.findCianUserByLogin(cianUserRequest.getLogin()).isEmpty()) {
            return mapper.fromEntityToResponse(repository.save(representative));
        } else {
            throw new UserWithThisLoginAlreadyExists(cianUserRequest.getLogin());
        }
    }

    @Override
    public RepresentativeResponse updateCianUser(RepresentativeUpdateRequest cianUserUpdateRequest) {
        Representative representative = mapper.fromUpdateRequestToEntity(cianUserUpdateRequest);
        Representative oldRepresentative = repository.findRepresentativeById(cianUserUpdateRequest.getId()).get();
        mapper.updateConvertor(representative, oldRepresentative);
//        return mapper.fromEntityToResponse(repository.save(oldRepresentative));
        if (userRepository.findCianUserByLogin(cianUserUpdateRequest.getLogin()).isEmpty()) {
            return mapper.fromEntityToResponse(repository.save(oldRepresentative));
        } else {
            throw new UserWithThisLoginAlreadyExists(cianUserUpdateRequest.getLogin());
        }
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteRepresentative(id);
    }

    @Override
    public List<RepresentativeAdminResponse> findByName(String value) {
        return mapper.fromEntityToAdminResponseList(repository.findRepresentativeByFirstName(value));
    }

    @Override
    public List<RepresentativeAdminResponse> findByPhone(String value) {
        return mapper.fromEntityToAdminResponseList(repository.findRepresentativeByPhone(value));
    }

    @Override
    public List<RepresentativeAdminResponse> findByAgencyName(String value) {
        return mapper.fromEntityToAdminResponseList(repository.findRepresentativeByAgencyName(value));
    }

    @Override
    public RepresentativeAdminResponse findByLogin(String login) {
        return mapper.fromEntityToAdminResponse(repository.findRepresentativeByLogin(login).get());
    }

    @Override
    public RepresentativeResponse getUserById(UUID id) {
        return mapper.fromEntityToResponse(repository.findRepresentativeById(id).get());
    }

    @Override
    public RepresentativeResponse getRepresentativeByLogin(String login) {
        RepresentativeResponse representativeResponse = mapper.fromEntityToResponse(repository.findRepresentativeByLogin(login).get());
        return representativeResponse;
    }

    @Override
    public void approveById(UUID id) {
        repository.approveById(id);
    }

    @Override
    public void bannedById(UUID id) {
        repository.bannedById(id);
    }
}
