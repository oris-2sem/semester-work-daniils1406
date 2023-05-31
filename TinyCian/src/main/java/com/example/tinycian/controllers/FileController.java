package com.example.tinycian.controllers;


import com.example.tinycian.dto.file.FileNameRequest;
import com.example.tinycian.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {
    private final FileService fileService;

    @PostMapping("/uploadImage")
    public FileNameRequest uploadImage(@RequestParam("id") UUID id, @RequestParam("entity") String entity, @RequestParam("file") MultipartFile file, @RequestParam("fileType") String fileType) {
        String i = fileService.upload(id, entity, file, fileType, false);
        return FileNameRequest.builder().fileName(i).build();

    }

    @PostMapping("/uploadDocument")
    public void uploadDocument(@RequestParam("id") UUID id, @RequestParam("entity") String entity, @RequestParam("file") MultipartFile file, @RequestParam("fileType") String fileType) {
        fileService.upload(id, entity, file, fileType, true);
    }


    @DeleteMapping("/deleteFile")
    public void deleteView(@RequestParam("id") String id) {
        fileService.deleteView(id);
    }

    @GetMapping("/downloadFile")
    public ResponseEntity<ByteArrayResource> downloadView(@RequestParam("id") String id) {
        return fileService.downloadView(id);
    }

    @GetMapping("/getImagesOfRealty")
    public List<String> getImagesOfRealty(@RequestParam("id") String id) {
        return fileService.getImagesOfRealty(id);
    }

}
