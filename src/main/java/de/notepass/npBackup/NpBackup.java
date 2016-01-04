package de.notepass.npBackup;

import de.notepass.npBackup.objects.Backup;
import de.notepass.npBackup.objects.FileIndexStatusReference;
import de.notepass.npBackup.ui.api.FxUiApi;
import de.notepass.npBackup.util.HashUtil;
import javafx.application.Application;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by kim on 02.01.2016.
 */
public class NpBackup {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InterruptedException {
        /*
        long start = System.currentTimeMillis();
        //System.out.println(HashUtil.getInstance().generateFileHash(HashUtil.HASH_TYPES.MD5, new File("/home/kim/Microsoft.Office.Professional.Plus.2010.VL.x64.x86.SP2.German.mit.Microsoft.Toolkit.v2.4.5.7z")));
        System.out.println(HashUtil.getInstance().generateFileHash(HashUtil.HASH_TYPES.MD5, new File("/home/kim/Downloads/bluej-316.jar")));
        System.out.println(System.currentTimeMillis()-start+" ms");
        start = System.currentTimeMillis();
        System.out.println(HashUtil.getInstance().generateFileHash(HashUtil.HASH_TYPES.MD5, new File("/home/kim/Downloads/bluej-316.jar")));
        System.out.println(System.currentTimeMillis()-start+" ms");
        */
        //Application.launch(FxUiApi.class, args);
        Backup b = new Backup();
        FileIndexStatusReference statusRef = b.createFileList(new File("~/IdeaProjects/npBackup"), true);
        while (true) {
            System.out.println(statusRef.getIndexedFiles()+"/"+statusRef.getNumberOfFilesToIndex());
            System.out.println(statusRef.isRunning());
            Thread.sleep(500);
        }
    }
}
