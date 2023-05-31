package com.example.tinycian.mapper;


import com.example.tinycian.dto.file.FileInfo;
import com.example.tinycian.entities.File;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FileInfoMapper {
    File fromInfoToEntity(FileInfo fileInfo);

    void updateConvertor(File oldFile, @MappingTarget File newFile);
}
