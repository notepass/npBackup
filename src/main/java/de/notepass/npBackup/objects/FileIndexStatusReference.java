package de.notepass.npBackup.objects;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by kim on 1/4/16.
 */
public class FileIndexStatusReference {
    AtomicInteger numberOfFilesToIndex = new AtomicInteger();
    AtomicInteger indexedFiles = new AtomicInteger();
    Thread[] threadRef;
    Thread fileIndexThread;

    protected FileIndexStatusReference(int numberOfFilesToIndex, Thread[] threadRef, Thread fileIndexThread) {
        this.numberOfFilesToIndex.set(numberOfFilesToIndex);
        this.threadRef = threadRef;
        this.fileIndexThread = fileIndexThread;
    }

    protected void setIndexedFiles(int indexedFiles) {
        this.indexedFiles.set(indexedFiles);
    }

    public int getNumberOfFilesToIndex() {
        return numberOfFilesToIndex.get();
    }

    public int getIndexedFiles() {
        return indexedFiles.get();
    }

    public Thread[] getThreadRef() {
        return threadRef;
    }

    protected void setThreadRef(Thread[] threadRef) {
        this.threadRef = threadRef;
    }

    public boolean isRunning() {
        for (Thread t:threadRef) {
            if (fileIndexThread.isAlive() || t == null || t.isAlive()) {
                return true;
            }
        }

        return false;
    }

    protected void setNumberOfFilesToIndex(int numberOfFilesToIndex) {
        this.numberOfFilesToIndex.set(numberOfFilesToIndex);
    }

    public Thread getFileIndexThread() {
        return fileIndexThread;
    }
}
