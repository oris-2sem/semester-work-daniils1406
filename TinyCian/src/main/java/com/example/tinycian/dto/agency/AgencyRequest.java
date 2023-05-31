package com.example.tinycian.dto.agency;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgencyRequest {
    private String name;

    private String description;

    private String phoneNumber;

    private String linkOnWebsite;

    private Set<String> regionsList;
}
