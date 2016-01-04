package de.notepass.npBackup.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by kim on 1/4/16.
 */
public class HashUtil {
    private static HashUtil instance = new HashUtil();
    public static enum HASH_TYPES {
        SHA_256, MD5
    }

    public static HashUtil getInstance() {
        return instance;
    }

    public String generateFileHash(HASH_TYPES hashType, File inputFile) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance(hashType.toString().replace('_', '-'));
        FileInputStream fis = new FileInputStream(inputFile);

        byte[] buffer = new byte[1024];

        int bufferContent = 0;
        while ((bufferContent = fis.read(buffer)) != -1) {
            md.update(buffer, 0, bufferContent);
        }


        byte[] calculatedDigest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte aCalculatedDigest : calculatedDigest) {
            sb.append(Integer.toString((aCalculatedDigest & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }
}
