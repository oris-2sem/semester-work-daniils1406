package com.example.tinycian.controllers.CRUD;

import com.example.tinycian.dto.residentialcomplex.ResidentialComplexRequest;
import com.example.tinycian.dto.residentialcomplex.ResidentialComplexResponse;
import com.example.tinycian.dto.residentialcomplex.ResidentialComplexUpdateRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Api(tags = "residentialComplexes", value = "Neighborhood")
@RequestMapping("/crud")
public interface ResidentialComplex {
    @ApiOperation(value = "Create residential complex", nickname = "residentialComplex-create", response = List.class)
    @GetMapping()
    List<ResidentialComplexResponse> getAll(@RequestParam(value = "status", required = false, defaultValue = "VERIFIED") String realtyStatus,
                                            @RequestParam(value = "column", required = false, defaultValue = "id") String column,
                                            @RequestParam(value = "order", required = false, defaultValue = "ASC") String order);

    @ApiOperation(value = "Create residential complex", nickname = "residentialComplex-create", response = ResidentialComplexResponse.class)
    @PostMapping()
    ResidentialComplexResponse create(@RequestBody ResidentialComplexRequest residentialComplexRequest);

    @ApiOperation(value = "Update residential complex", nickname = "residentialComplex-update", response = ResidentialComplexResponse.class)
    @PutMapping()
    ResidentialComplexResponse update(@RequestBody ResidentialComplexUpdateRequest residentialComplexUpdateRequest);

    @ApiOperation(value = "Delete residential complex", nickname = "residentialComplex-delete", response = Void.class)
    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") UUID id);

    @GetMapping("/{id}")
    ResidentialComplexResponse getById(@PathVariable("id") UUID id);

}
