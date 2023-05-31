package com.example.tinycian.repository;

import com.example.tinycian.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public interface FileRepository extends JpaRepository<File, UUID> {


    @Transactional
    @Modifying
    @Query(value = "UPDATE file set file_status='DELETE' where id=:id", nativeQuery = true)
    void deleteFileById(String id);

    File findFileById(String id);

    @Query(value = "SELECT COUNT(*) FROM file WHERE id like concat('%',:id,'%') and file_type='VIEW'", nativeQuery = true)
    Integer numberOfViewImagesOfRealtyById(String id);


    @Query(value = "SELECT EXISTS(SELECT 1 FROM file WHERE id=:id and file_type=:fileType and file_status='VERIFIED')", nativeQuery = true)
    boolean existByIdAndFileType(String id, String fileType);

    @Query(value = "SELECT * FROM file where id like concat('%',:id,'%') and file_type='VIEW' AND file_status='VERIFIED'", nativeQuery = true)
    List<File> findAllImagesOfRealty(String id);

}
