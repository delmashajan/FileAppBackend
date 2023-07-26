package com.delma.FileApp.Entity;

import javax.persistence.*;


import java.util.Date;

@Entity

@Table(name = "file_metadata")
public class FileMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fileId")
    private String fileId;

    @Column(name = "originalFileName")
    private String originalFileName;

    @Column(name = "uploadTimestamp")
    private Date uploadTimestamp;

    public FileMetadata( String fileId, String originalFileName, Date uploadTimestamp) {

        this.fileId = fileId;
        this.originalFileName = originalFileName;
        this.uploadTimestamp = uploadTimestamp;
    }

    public FileMetadata() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public Date getUploadTimestamp() {
        return uploadTimestamp;
    }

    public void setUploadTimestamp(Date uploadTimestamp) {
        this.uploadTimestamp = uploadTimestamp;
    }
}

