package com.pack.strategy;


import com.google.common.collect.HashBiMap;

public class HashBiMapStorageStrategy implements StorageStrategy {
    HashBiMap<Long, String> data;

    public HashBiMapStorageStrategy() {
        this.data = data.create(10000);
    }

    @Override
    public boolean containsKey(Long key) {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return data.containsValue(value);
    }

    @Override
    public void put(Long key, String value) {
        data.put(key, value);
    }

    @Override
    public Long getKey(String value) {
        return (Long) data.inverse().get(value);
    }

    @Override
    public String getValue(Long key) {
        if (data.containsKey( key )) {
            return data.get(key);
         }
        return null;
    }
}
