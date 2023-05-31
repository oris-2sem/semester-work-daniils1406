package com.example.tinycian.controllers;

import com.example.tinycian.dto.agency.AgencyAdminResponse;
import com.example.tinycian.dto.agent.AgentAdminResponse;
import com.example.tinycian.dto.flat.FlatAdminResponse;
import com.example.tinycian.dto.flat.FlatResponse;
import com.example.tinycian.dto.house.HouseAdminResponse;
import com.example.tinycian.dto.house.HouseResponse;
import com.example.tinycian.dto.representative.RepresentativeAdminResponse;
import com.example.tinycian.dto.residentialcomplex.ResidentialComplexAdminResponse;
import com.example.tinycian.dto.residentialcomplex.ResidentialComplexResponse;
import com.example.tinycian.dto.user.UserAdminResponse;
import com.example.tinycian.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminAccount {

    private final FlatService flatService;

    private final HouseService houseService;

    private final CianUserService cianUserService;

    private final AgentService agentService;

    private final RepresentativeService representativeService;

    private final ResidentialComplexService residentialComplexService;

    private final AgencyService agencyService;


    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public String getPage() {
        return "adminPage";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/flats")
    public List<FlatAdminResponse> getAllFlat(@RequestParam(value = "realtyStatus", required = false) String realtyStatus,
                                              @RequestParam(value = "realtyType", required = false) String realtyType,
                                              @RequestParam(value = "advertType", required = false) String advertType,
                                              @RequestParam(value = "squareFrom", required = false, defaultValue = "0") String squareFrom,
                                              @RequestParam(value = "squareTo", required = false, defaultValue = "0") String squareTo,
                                              @RequestParam(value = "costFrom", required = false, defaultValue = "0") String costFrom,
                                              @RequestParam(value = "costTo", required = false, defaultValue = "0") String costTo) {
        return flatService.findAllByAdmin(realtyStatus, realtyType, advertType, Integer.valueOf(squareFrom), Integer.valueOf(squareTo), Integer.valueOf(costFrom), Integer.valueOf(costTo));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/houses")
    public List<HouseAdminResponse> getAllHouse(@RequestParam(value = "realtyStatus", required = false) String realtyStatus,
                                                @RequestParam(value = "realtyType", required = false) String realtyType,
                                                @RequestParam(value = "advertType", required = false) String advertType,
                                                @RequestParam(value = "squareFrom", required = false, defaultValue = "0") String squareFrom,
                                                @RequestParam(value = "squareTo", required = false, defaultValue = "0") String squareTo,
                                                @RequestParam(value = "costFrom", required = false, defaultValue = "0") String costFrom,
                                                @RequestParam(value = "costTo", required = false, defaultValue = "0") String costTo) {
        return houseService.findAllByAdmin(realtyStatus, realtyType, advertType, Integer.valueOf(squareFrom), Integer.valueOf(squareTo), Integer.valueOf(costFrom), Integer.valueOf(costTo));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<UserAdminResponse> getAllUsers(@RequestParam(value = "role", required = false) String role,
                                               @RequestParam(value = "userStatus", required = false) String userStatus,
                                               @RequestParam(value = "column", required = false) String column,
                                               @RequestParam(value = "order", required = false) String order) {
        List<UserAdminResponse> userAdminResponses = cianUserService.findAllByAdmin(userStatus, role, column, order);
        return userAdminResponses;
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/agents")
    public List<AgentAdminResponse> getAllAgents(@RequestParam(value = "agentLevel", required = false) String agentLevel,
                                                 @RequestParam(value = "userStatus", required = false) String userStatus,
                                                 @RequestParam(value = "column", required = false) String column,
                                                 @RequestParam(value = "order", required = false) String order) {

        List<AgentAdminResponse> agentAdminResponses = agentService.findAllByAdmin(userStatus, agentLevel, column, order);
        return agentAdminResponses;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/representative")
    public List<RepresentativeAdminResponse> getAllRepresentative(@RequestParam(value = "userStatus", required = false) String userStatus,
                                                                  @RequestParam(value = "column", required = false) String column,
                                                                  @RequestParam(value = "order", required = false) String order) {
        return representativeService.findAllByAdmin(userStatus, column, order);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/agencys")
    public List<AgencyAdminResponse> getAllAgencys(@RequestParam(value = "agencyStatus", required = false) String agencyStatus,
                                                   @RequestParam(value = "column", required = false) String column,
                                                   @RequestParam(value = "order", required = false) String order) {
        return agencyService.findAllByAdmin(agencyStatus, column, order);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/residentialComplexes")
    public List<ResidentialComplexResponse> getAllResidentialComplexes(Model model,
                                                                       @RequestParam(value = "residentialComplexStatus", required = false) String residentialComplexStatus,
                                                                       @RequestParam(value = "column", required = false) String column,
                                                                       @RequestParam(value = "order", required = false) String order) {
        return residentialComplexService.findAll(residentialComplexStatus, column, order);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteUser")
    public void deleteUserById(@RequestParam("id") UUID id) {
        cianUserService.deleteById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteAgent")
    public void deleteAgentById(@RequestParam("id") UUID id) {
        agentService.deleteById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteRepresentative")
    public void deleteRepresentativeById(@RequestParam("id") UUID id) {
        representativeService.deleteById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteAgency")
    public void deleteAgencyById(@RequestParam("id") UUID id) {
        agencyService.deleteById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteResidentialComplex")
    public void deleteResidentialComplexById(@RequestParam("id") UUID id) {
        residentialComplexService.deleteById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteHouse")
    public void deleteHouseById(@RequestParam("id") UUID id) {
        houseService.deleteHomeById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteFlat")
    public void deleteFlatById(@RequestParam("id") UUID id) {
        flatService.deleteById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/certainUser")
    public List<UserAdminResponse> getCertainUser(@RequestParam(value = "field", required = false) String field,
                                                  @RequestParam(value = "value", required = false) String value) {
        switch (field) {
            case "login" -> {
                return List.of(cianUserService.findByLogin(value));
            }
            case "name" -> {
                return cianUserService.findByName(value);
            }
            case "phone" -> {
                return cianUserService.findByPhone(value);
            }
        }
        throw new RuntimeException("exception in method getCertainUser");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/certainAgent")
    public List<AgentAdminResponse> getCertainAgent(@RequestParam(value = "field", required = false) String field,
                                                    @RequestParam(value = "value", required = false) String value) {
        switch (field) {
            case "agency" -> {
                return agentService.findByAgencyName(value);
            }
            case "name" -> {
                return agentService.findByName(value);
            }
            case "phone" -> {
                return agentService.findByPhone(value);
            }
        }
        throw new RuntimeException("Exception in method getCertainAgent");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/certainRepresentative")
    public List<RepresentativeAdminResponse> getCertainRepresntative(@RequestParam(value = "field", required = false) String field,
                                                                     @RequestParam(value = "value", required = false) String value) {
        switch (field) {
            case "agency" -> {
                return representativeService.findByAgencyName(value);
            }
            case "name" -> {
                return representativeService.findByName(value);
            }
            case "phone" -> {
                return representativeService.findByPhone(value);
            }
        }
        throw new RuntimeException("Exception in method getCertainAgent");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/certainAgency")
    public List<AgencyAdminResponse> getCertainAgency(@RequestParam(value = "field", required = false) String field,
                                                      @RequestParam(value = "value", required = false) String value) {
        return List.of(agencyService.findByIdByAdmin(UUID.fromString(value)));
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/certainResidentialComplex")
    public List<ResidentialComplexAdminResponse> getCertainResidentialComplex(@RequestParam(value = "field", required = false) String field,
                                                                              @RequestParam(value = "value", required = false) String value) {
        switch (field) {
            case "id" -> {
                return List.of(residentialComplexService.findByIdByAdmin(UUID.fromString(value)));
            }
            case "name" -> {
                return residentialComplexService.findByName(value);
            }
        }
        throw new RuntimeException("method getCertainResidentialComplex exception");
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/certainFlat")
    public List<FlatResponse> getCertainFlat(@RequestParam(value = "field", required = false) String field,
                                             @RequestParam(value = "value", required = false) String value) {
        switch (field) {
            case "id" -> {
                return List.of(flatService.findById(UUID.fromString(value)));
            }
            case "residentialComplexName" -> {
                return flatService.findByResidentialComplexName(value);
            }
        }
        throw new RuntimeException("mistake in method getCertainFlat");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/certainHouse")
    public List<HouseResponse> getCertainHouse(@RequestParam(value = "field", required = false) String field,
                                               @RequestParam(value = "value", required = false) String value) {
        return List.of(houseService.findById(UUID.fromString(value)));
    }


}