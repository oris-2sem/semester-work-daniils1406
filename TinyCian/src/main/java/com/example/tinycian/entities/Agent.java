package com.example.tinycian.entities;

import com.example.tinycian.entities.cianenum.AgentLevel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Agent extends CianUser {
    @JsonBackReference("organisation")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "organisation")
    private Agency organisation;
    @Enumerated(EnumType.STRING)
    private AgentLevel agentLevel;
}
