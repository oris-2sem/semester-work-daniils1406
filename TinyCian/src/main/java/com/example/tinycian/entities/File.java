package com.example.tinycian.entities;

import com.example.tinycian.entities.cianenum.EntityType;
import com.example.tinycian.entities.cianenum.FileType;
import com.example.tinycian.entities.cianenum.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class File {

    @Id
    private String id;

    private String originalFileName;


    private Integer size;

    private String mimeType;

    private Date insertDate;

    private Date updateDate;

    private String path;

    @Enumerated(EnumType.STRING)
    private FileType fileType;

    @Enumerated(EnumType.STRING)
    private Status fileStatus;

    @Enumerated(EnumType.STRING)
    private EntityType entityType;

}
