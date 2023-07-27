package com.delma.FileApp.Controller;

import com.delma.FileApp.Entity.FileMetadata;
import com.delma.FileApp.Service.FileMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FileMetadataList {

    @Autowired
    private FileMetadataService fileMetadataService;



    @CrossOrigin(origins = "*")
    @GetMapping("/list")
    public List<FileMetadata> getFileDetails(){
        return fileMetadataService.getAvailableDetails();
    }

}
