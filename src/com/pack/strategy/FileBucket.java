package com.pack.strategy;

import com.javarush.task.task33.task3310.Helper;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    Path path;

    public FileBucket() {
        try {
            this.path = Files.createTempFile("/home/code/MyFolder/", Helper.generateRandomString());
            Files.deleteIfExists(path);
            Files.createFile(path);
            path.toFile().deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long getFileSize(){
        try {
            return Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void putEntry(Entry entry){
        for (Entry e = entry; e != null; e = e.next) {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path));
                oos.writeObject(e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public Entry getEntry(){
        Entry outEntry = null;
        if(getFileSize() > 0) {
            try {
                ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path));
                outEntry = (Entry) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return outEntry;
    }

    public void remove(){
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
