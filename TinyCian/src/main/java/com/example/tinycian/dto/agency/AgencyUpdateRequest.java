package com.example.tinycian.dto.agency;

import com.example.tinycian.entities.Regions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgencyUpdateRequest {
    private UUID id;

    private String name;

    private String description;

    private String phoneNumber;

    private String linkOnWebsite;

    private Set<String> regionsList;
}
