package com.example.tinycian.service;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface FileService {
    String upload(UUID id, String entity, MultipartFile file, String fileType, boolean isDocument);

    void deleteView(String id);


    ResponseEntity<ByteArrayResource> downloadView(String id);

    List<String> getImagesOfRealty(String id);
}
