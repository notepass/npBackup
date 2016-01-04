package de.notepass.npBackup.objects;

import java.net.URI;
import java.nio.file.Path;

/**
 * Created by kim on 1/4/16.
 */
public class BackupFile {
    private URI fileReference;
    private String md5;
    private String sha256;

    public URI getFileReference() {
        return fileReference;
    }

    public void setFileReference(URI fileReference) {
        this.fileReference = fileReference;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getSha256() {
        return sha256;
    }

    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }
}
