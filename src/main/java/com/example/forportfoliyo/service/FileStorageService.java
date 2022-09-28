package com.example.forportfoliyo.service;

import com.example.forportfoliyo.entity.FileStorage;
import com.example.forportfoliyo.entity.enummration.FileStorageStatus;
import com.example.forportfoliyo.repository.FileStorageRepository;
import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class FileStorageService {


    public final FileStorageRepository fileStorageRepository;
    @Value("${upload.server.folder}")
    private String serverFolderPath;

    private final Hashids hashids;

    public FileStorageService(FileStorageRepository fileStorageRepository) {
        this.fileStorageRepository = fileStorageRepository;
        this.hashids = new Hashids(getClass().getName(),6);
    }


    public FileStorage save(MultipartFile multipartFile){
        FileStorage fileStorage=new FileStorage();
        fileStorage.setName(multipartFile.getOriginalFilename());
        fileStorage.setFileSize(multipartFile.getSize());
        fileStorage.setContentType(multipartFile.getContentType());
        fileStorage.setExtension(getExt(multipartFile.getOriginalFilename()));
        fileStorage.setFileStorageStatus(FileStorageStatus.DRAFT);
        fileStorage= fileStorageRepository.save(fileStorage);

        //serverFolderPath/upload_files/2022/09/29/arabiya.pdf

        Date now=new Date();

//        File uploadFolder=new File(this.serverFolderPath + "/upload_files"+1900+now.getYear()+"/"+1+now.getMonth()+"/"+now.getDate());

        String path=String.format("%s/upload_files/%d/%d/%d",
                this.serverFolderPath,1900+now.getYear(),
                1+now.getMonth(),now.getDate());

        File uploadFolder=new File(path);

        if(!uploadFolder.exists() && uploadFolder.mkdirs()){
            System.out.println("Created Folder");
        }

        fileStorage.setHashId(hashids.encode(fileStorage.getId()));
        String pathLocal=String.format("/upload_files/%d/%d/%d/%s.%s",
                1900+now.getYear(),1+now.getMonth(),now.getDate(),
                fileStorage.getHashId(),fileStorage.getExtension());

        fileStorage.setUploadFolder(pathLocal); //folderni saqladik
        fileStorageRepository.save(fileStorage);

        uploadFolder=uploadFolder.getAbsoluteFile();
        File file=new File(uploadFolder,String.format("%s.%s",fileStorage.getHashId(),fileStorage.getExtension()));
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileStorage;
    }

    public FileStorage findByHashId(String hashId){
        return fileStorageRepository.findByHashId(hashId);
    }

    private String getExt(String fileName){
        String ext=null;
        //hisobot.doc
        if(fileName!=null && !fileName.isEmpty()){
            int dot=fileName.lastIndexOf('.');
            if(dot>0 && dot<=fileName.length()-2){
                ext=fileName.substring(dot+1);
            }
        }
        return ext;
    }
}
