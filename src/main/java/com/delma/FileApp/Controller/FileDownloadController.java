package com.delma.FileApp.Controller;

import com.delma.FileApp.Service.FileDownloadService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class FileDownloadController {

    private final FileDownloadService fileDownloadService;

    public FileDownloadController(FileDownloadService fileDownloadService) {
        this.fileDownloadService = fileDownloadService;
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        Resource resource = fileDownloadService.downloadFileByFileId(fileId);

        if (resource != null) {
            // Set the appropriate headers for the file download
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileId + "\"")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        } else {

            // If the file is not found, return a not found response
            return ResponseEntity.notFound().build();
        }
    }
}


