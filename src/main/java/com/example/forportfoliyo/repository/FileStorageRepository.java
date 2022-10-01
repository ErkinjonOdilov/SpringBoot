package com.example.forportfoliyo.repository;

import com.example.forportfoliyo.entity.FileStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileStorageRepository extends JpaRepository<FileStorage, Long> {

    FileStorage findByHashId(String hashId);
}
