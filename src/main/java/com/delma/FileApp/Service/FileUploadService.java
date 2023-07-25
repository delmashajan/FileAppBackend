package com.delma.FileApp.Service;

import com.delma.FileApp.Entity.FileMetadata;
import com.delma.FileApp.Repository.FileMetadataRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.UUID;

@Service
public class FileUploadService {

    private final FileMetadataRepository fileMetadataRepository;
    private final String uploadDirectory = "src/main/uploads/";
    private final long maxFileSize = 5 * 1024 * 1024; // 5MB

    public FileUploadService(FileMetadataRepository fileMetadataRepository) {
        this.fileMetadataRepository = fileMetadataRepository;
    }

    public String uploadFile(MultipartFile file) {
        // Validate file type
        if (!isValidFileType(file)) {
            throw new RuntimeException("Invalid file type. Only JPEG, PNG, GIF and pdf files are allowed.");
        }

        // Validate file size
        if (file.getSize() > maxFileSize) {
            throw new RuntimeException("File size exceeds the allowed limit (5MB).");
        }

        // Generate a unique name or identifier for the uploaded file
        String fileId = UUID.randomUUID().toString();
        String fileName = fileId + "_" + file.getOriginalFilename();

        try {
            // Save the file to the server's file system
            Path filePath = Paths.get(uploadDirectory + fileName);
            Files.copy(file.getInputStream(), filePath);

            // Save file metadata to the database
            FileMetadata metadata = new FileMetadata(fileId, file.getOriginalFilename(), new Date());
            fileMetadataRepository.save(metadata);

            return fileId;
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file: " + e.getMessage());
        }
    }

    private boolean isValidFileType(MultipartFile file) {
        String contentType = file.getContentType();
        return contentType != null &&
                (contentType.equals("image/jpeg") ||
                        contentType.equals("image/png") ||
                        contentType.equals("image/gif") ||
                        contentType.equals("application/pdf"));
    }
}


