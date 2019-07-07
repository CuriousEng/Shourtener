package com.pack.strategy;

import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class DualHashBidiMapStorageStrategy implements StorageStrategy {
    DualHashBidiMap data;

    public DualHashBidiMapStorageStrategy() {

        this.data = new DualHashBidiMap();
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
        if (data.containsValue( value )){
            return (Long)data.getKey(value);
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        if (data.containsKey( key )) {
            return (String) data.get(key);
        }
        return null;
    }
}
