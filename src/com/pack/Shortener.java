package com.pack;

import com.pack.strategy.StorageStrategy;

public class Shortener {
    private Long lastId = 0l;  // отвечает за последнее значение идентификатора
    private StorageStrategy storageStrategy; // хранит стратегию

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    public synchronized Long getId(String string){
        if (storageStrategy.containsValue(string)) return storageStrategy.getKey(string);
        else {
            lastId++;
            storageStrategy.put(lastId, string);
            return lastId;
        }
    }

    public synchronized String getString(Long id){
        return storageStrategy.getValue(id);
    }
}
