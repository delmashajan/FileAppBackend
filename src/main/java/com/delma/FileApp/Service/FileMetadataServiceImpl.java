package com.delma.FileApp.Service;

import com.delma.FileApp.Entity.FileMetadata;
import com.delma.FileApp.Repository.FileMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FileMetadataServiceImpl implements FileMetadataService {
    @Autowired
    private FileMetadataRepository fileMetadataRepository;

    @Override
    public List<FileMetadata> getAvailableDetails(){
        return fileMetadataRepository.findAll();
    }
}
