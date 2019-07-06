package com.pack.strategy;

import java.util.HashMap;

public class OurHashBiMapStorageStrategy implements StorageStrategy {
    HashMap<Long, String> k2v = new HashMap<>();  //key to value
    HashMap<String, Long> v2k = new HashMap<>();  //value to key

    @Override
    public boolean containsKey(Long key) {
        return k2v.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return v2k.containsKey(value);
    }

    @Override
    public void put(Long key, String value) {
        k2v.put(key, value);
        v2k.put(value, key);
    }

    @Override
    public Long getKey(String value) {
        if (v2k.containsValue( value )) {
            return v2k.get(value);
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        if (k2v.containsKey( key )) {
            return k2v.get(key);
        }
        return null;
    }
}
