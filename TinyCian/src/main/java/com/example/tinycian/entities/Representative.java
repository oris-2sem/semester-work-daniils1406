package com.example.tinycian.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.websocket.OnError;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Representative extends CianUser {
    @JsonBackReference("organisation-for-representative")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "organisation")
    private Agency organisation;
}
