package com.delma.FileApp.Service;

import com.delma.FileApp.Entity.FileMetadata;

import java.util.List;

public interface FileMetadataService {
    public List<FileMetadata> getAvailableDetails();
}
