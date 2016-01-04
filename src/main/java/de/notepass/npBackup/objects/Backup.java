package de.notepass.npBackup.objects;

import com.google.gson.Gson;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by kim on 1/4/16.
 */
public class Backup {
    private BackupFile[] files = null;
    private BackupConfiguration config = new BackupConfiguration();

    public void saveToFile(File target) throws IOException {
        Gson gson = new Gson();
        gson.toJson(this, new FileWriter(target));
    }

    public static Backup fromFile(File target) throws FileNotFoundException {
        Gson gson = new Gson();
        return gson.fromJson(new FileReader(target), Backup.class);
    }

    public FileIndexStatusReference createFileList(File base, boolean async) {
        final File[][] filesToIndex = {null};
        Thread fileIndexThread = new Thread(() -> {
            filesToIndex[0] = generateFilesList(base);
        });
        fileIndexThread.start();
        Thread[] threads = new Thread[GlobalConfiguration.cpuCores];
        final FileIndexStatusReference statusRef = new FileIndexStatusReference(!(fileIndexThread.getState() == Thread.State.TERMINATED)?-1:filesToIndex[0].length, threads, fileIndexThread);

        new Thread(() -> {
            while (!(fileIndexThread.getState() == Thread.State.TERMINATED)) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    //TODO: log error
                    e.printStackTrace();
                }
            }
            this.files = new BackupFile[filesToIndex[0].length];
            statusRef.setNumberOfFilesToIndex(filesToIndex[0].length);
            for (int thread=0;thread<GlobalConfiguration.cpuCores;thread++) {
                final int THREAD_ID = thread;
                threads[thread] = new Thread(() -> {

                    for (int i= THREAD_ID;i< filesToIndex[0].length;i++) {
                        files[i] = new BackupFile();
                        try {
                            files[i].setFileReference(new URI(filesToIndex[0][i].getCanonicalPath()));
                        } catch (Exception e) {
                            //TODO: Log error
                            e.printStackTrace();
                        }
                    }
                });
                threads[thread].start();
            }
        }).start();

        if (!async) {
            while (statusRef.isRunning()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //TODO: Log error
                    e.printStackTrace();
                }
            }
        }

        return statusRef;
    }

    protected File[] generateFilesList(File base) {
        ArrayList<File> files = new ArrayList<>();
        File[] filesList = base.listFiles();
        if (filesList != null) {
            for (File f:filesList) {
                if (f.isFile()) {
                    files.add(f);
                } else {
                    Collections.addAll(files, generateFilesList(f));
                }
            }
        }
        return files.toArray(new File[files.size()]);
    }
}
