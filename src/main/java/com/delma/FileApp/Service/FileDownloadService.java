package com.delma.FileApp.Service;


import com.delma.FileApp.Entity.FileMetadata;
import com.delma.FileApp.Repository.FileMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class FileDownloadService {

    // Define the base directory where files are uploaded
    private final String baseUploadDirectory = "src/main/uploads/";

    public Resource downloadFileByFileId(String fileId) {
        String filePath = baseUploadDirectory + fileId;
        Path path = Paths.get(filePath);

        if (Files.exists(path)) {
            Resource resource;
            try {
                resource = new UrlResource(path.toUri());
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

            if (resource.exists() && resource.isReadable()) {
                return resource;
            }
        }

        return null;
    }

}
