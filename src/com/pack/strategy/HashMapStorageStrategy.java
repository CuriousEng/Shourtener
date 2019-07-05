package com.pack.strategy;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorageStrategy implements StorageStrategy {
    private HashMap<Long, String> data = new HashMap<>();

    @Override
    public boolean containsKey(Long key) {
        if (data.containsKey(key)) return true;
        return false;
    }

    @Override
    public boolean containsValue(String value) {
        if (data.containsValue(value)) return true;
        return false;
    }

    @Override
    public void put(Long key, String value) {
        data.put(key, value);
    }

    @Override
    public Long getKey(String value) {
        if (data.containsValue(value)) {
            for (Map.Entry<Long, String> dt : data.entrySet()) {
                if (dt.getValue().equals(value)) {
                    return dt.getKey();
                }
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        return data.get(key);
    }
}
