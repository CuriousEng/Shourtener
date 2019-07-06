package com.pack.strategy;


import com.pack.ExceptionHandler;
import com.pack.Helper;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile("t" + Helper.generateRandomString(),".txt");
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
        try {
            ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path));
            for (Entry e = entry; e != null; e = e.next) {
                oos.writeObject(e);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

public Entry getEntry() {
    if (getFileSize() == 0) return null;
    Entry entry = null;

    try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
        entry = (Entry) ois.readObject();
        Entry tmp = entry.next;
        while (tmp != null) {
            tmp = (Entry) ois.readObject();
            tmp = tmp.next;
        }
    } catch (IOException e) {
        ExceptionHandler.log(e);
    } catch (ClassNotFoundException e) {
        ExceptionHandler.log(e);
    }

    return entry;
}

    public void remove(){
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
