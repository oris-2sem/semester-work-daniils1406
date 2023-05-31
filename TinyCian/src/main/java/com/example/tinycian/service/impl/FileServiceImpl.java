package com.example.tinycian.service.impl;


import com.example.tinycian.dto.file.FileInfo;
import com.example.tinycian.entities.File;
import com.example.tinycian.entities.cianenum.EntityType;
import com.example.tinycian.entities.cianenum.FileType;
import com.example.tinycian.entities.cianenum.Status;
import com.example.tinycian.exceptions.BucketCreationException;
import com.example.tinycian.exceptions.FileDeletingException;
import com.example.tinycian.exceptions.FileDownloadingException;
import com.example.tinycian.exceptions.FileInsertingException;
import com.example.tinycian.mapper.FileInfoMapper;
import com.example.tinycian.repository.FileRepository;
import com.example.tinycian.service.FileService;
import com.example.tinycian.util.PathFileMapper;
import io.minio.*;
import io.minio.errors.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.FileNameUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileRepository filesRepository;


    private final FileInfoMapper mapper;

    private final MinioClient minioClient;

    @Value("${minio.bucketName}")
    private String bucketName;

    @Value("${imageExtension}")
    private final String[] imageExtensionsList;

    private int putViewOfRealty(UUID id, String entity, MultipartFile file, InputStream inputStream) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        int currentNumberOfViews = filesRepository.numberOfViewImagesOfRealtyById(String.valueOf(id));
        currentNumberOfViews++;
        String q = FileNameUtils.getExtension(file.getOriginalFilename());
        if (q.equals("jpeg")) {
            q = "jpg";
        }
        minioClient.putObject(

                PutObjectArgs.builder()
                        .bucket(bucketName)
                        .object(PathFileMapper.getFilePath(EntityType.valueOf(entity),
                                FileType.VIEW, false) + "/"
                                + id + "_" + currentNumberOfViews + "."
                                + q)
                        .stream(inputStream, inputStream.available(), -1)
                        .contentType("image/png")
                        .build());
        return currentNumberOfViews;
    }

    private void putViewOfSubject(UUID id, String entity, MultipartFile file, InputStream inputStream, String fileType, boolean isDocument) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        String q = FileNameUtils.getExtension(file.getOriginalFilename());
        if (q.equals("jpeg")) {
            q = "jpg";
        }
        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(bucketName)
                        .object(PathFileMapper.getFilePath(EntityType.valueOf(entity),
                                FileType.valueOf(fileType), isDocument) + "/"
                                + id + "_" + fileType + "."
                                + q)
                        .stream(inputStream, inputStream.available(), -1)
                        .contentType("image/png")
                        .build());
    }

    @Override
    public String upload(UUID id, String entity, MultipartFile file, String fileType, boolean isDocument) {
        List<String> imageExtensions = List.of(imageExtensionsList);
        boolean found;
        try {
            found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        if (!found) {
            try {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
                BufferedInputStream inputStream = new BufferedInputStream(new URL("https://e7.pngegg.com/pngimages/93/725/png-clipart-burkina-faso-pro-realtors-realtalyst-online-services-llp-hollow-structural-section-user-profile-others-miscellaneous-english.png").openStream());
                minioClient.putObject(
                        PutObjectArgs.builder()
                                .bucket(bucketName)
                                .object("default." + FileNameUtils.getExtension(file.getOriginalFilename()))
                                .stream(inputStream, inputStream.available(), -1)
                                .build());
                File file1 = File.builder()
                        .originalFileName("default.jpg")
                        .insertDate(Date.valueOf(LocalDate.now()))
                        .updateDate(Date.valueOf(LocalDate.now()))
                        .id("default.jpg")
                        .path("/")
                        .mimeType("image/jpeg")
                        .fileStatus(Status.VERIFIED)
                        .build();
                filesRepository.save(file1);
            } catch (Exception e) {
                throw new BucketCreationException(e.getMessage());
            }
        }

        FileInfo fileInfo = FileInfo.builder()
                .originalFileName(file.getOriginalFilename())
                .size((int) file.getSize())
                .mimeType(file.getContentType())
                .insertDate(Date.valueOf(LocalDate.now()))
                .updateDate(Date.valueOf(LocalDate.now()))
                .path(PathFileMapper.getFilePath(EntityType.valueOf(entity), FileType.valueOf(fileType), isDocument))
                .fileType(fileType)
                .entityType(entity)
                .fileStatus("VERIFIED")
                .build();


        try (InputStream inputStream = file.getInputStream()) {
            if (imageExtensions.contains(FileNameUtils.getExtension(file.getOriginalFilename()))) {
                String q = FileNameUtils.getExtension(file.getOriginalFilename());
                if (q.equals("jpeg")) {
                    q = "jpg";
                }
                if (FileType.valueOf(fileType).equals(FileType.VIEW)) {
                    int currentNumbersOfViews = putViewOfRealty(id, entity, file, inputStream);

                    fileInfo.setId(id + "_" + currentNumbersOfViews + "." + q);
                } else {
                    putViewOfSubject(id, entity, file, inputStream, fileType, isDocument);
                    fileInfo.setId(id + "_" + fileType + "." + q);
                }
            } else {
                String q = FileNameUtils.getExtension(file.getOriginalFilename());
                if (q.equals("jpeg")) {
                    q = "jpg";
                }
                minioClient.putObject(
                        PutObjectArgs.builder()
                                .bucket(bucketName)
                                .object(PathFileMapper.getFilePath(EntityType.valueOf(entity),
                                        FileType.valueOf(fileType), isDocument) + "/" +
                                        id + "_" + fileType + "." + q)
                                .stream(inputStream, inputStream.available(), -1)
                                .build());
            }
        } catch (Exception e) {
            throw new FileInsertingException(e.getMessage());
        }


        if (!filesRepository.existByIdAndFileType(fileInfo.getId(), fileInfo.getFileType()) ||
                FileType.valueOf(fileInfo.getFileType()).equals(FileType.VIEW)) {
            filesRepository.save(mapper.fromInfoToEntity(fileInfo));
        } else {
            File oldFile = filesRepository.findFileById(fileInfo.getId());
            File newFile = mapper.fromInfoToEntity(fileInfo);
            mapper.updateConvertor(newFile, oldFile);
            filesRepository.save(oldFile);
        }
        return fileInfo.getId();
    }


    @Override
    public ResponseEntity<ByteArrayResource> downloadView(String id) {
        boolean found;
        try {
            found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        if (!found) {
            try {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
                BufferedInputStream inputStream = new BufferedInputStream(new URL("https://e7.pngegg.com/pngimages/93/725/png-clipart-burkina-faso-pro-realtors-realtalyst-online-services-llp-hollow-structural-section-user-profile-others-miscellaneous-english.png").openStream());
                minioClient.putObject(
                        PutObjectArgs.builder()
                                .bucket(bucketName)
                                .object("default.jpg")
                                .stream(inputStream, inputStream.available(), -1)
                                .build());
                File file1 = File.builder()
                        .originalFileName("default.jpg")
                        .insertDate(Date.valueOf(LocalDate.now()))
                        .updateDate(Date.valueOf(LocalDate.now()))
                        .id("default.jpg")
                        .path("/")
                        .mimeType("image/jpeg")
                        .fileStatus(Status.VERIFIED)
                        .build();
                filesRepository.save(file1);
            } catch (Exception e) {
                throw new BucketCreationException(e.getMessage());
            }
        }
        File fileInfo = filesRepository.findFileById(id);
        return getFileFromMinio(fileInfo);
    }

    @Override
    public List<String> getImagesOfRealty(String id) {
        List<String> imagesNames = new LinkedList<>();
        for (File file : filesRepository.findAllImagesOfRealty(id)) {
            imagesNames.add(file.getId());
        }
        return imagesNames;
    }


    private ResponseEntity<ByteArrayResource> getFileFromMinio(File fileInfo) {
        try (InputStream in = minioClient.getObject(GetObjectArgs
                .builder()
                .bucket(bucketName)
                .object(fileInfo.getPath() + "/" + fileInfo.getId())
                .build())) {
            byte[] serializeFile = IOUtils.toByteArray(in);
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(serializeFile.length)
                    .header("Content-disposition", "attachment; filename=\"" +
                            fileInfo.getOriginalFileName() +
                            "\"")
                    .body(new ByteArrayResource(serializeFile));
        } catch (Exception e) {
            throw new FileDownloadingException(e.getMessage());
        }
    }


    @Override
    public void deleteView(String id) {
        File fileInfo = filesRepository.findFileById(id);
        try {
            minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object(fileInfo.getPath() + "/" + fileInfo.getId()).build());
        } catch (Exception e) {
            throw new FileDeletingException(e.getMessage());
        }
        filesRepository.deleteFileById(id);
    }
}