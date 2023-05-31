package com.example.tinycian.dto.agency;

import com.example.tinycian.entities.Regions;
import com.example.tinycian.entities.cianenum.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgencyResponse {
    private UUID id;

    private String name;

    private String description;

    private String phoneNumber;

    private String linkOnWebsite;

    private Date insertDate;

    private Set<Regions> regionsList;
}
