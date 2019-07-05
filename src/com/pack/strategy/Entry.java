package com.pack.strategy;

import java.io.Serializable;

public class Entry implements Serializable {
    Long key;
    String value;
    Entry next;
    int hash;
    public Long getKey(){
        return this.key;
    }

    public String getValue(){
        return this.value;
    }

    public int hashCode(){
        return (int)(key * 24) + value.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entry entry = (Entry) o;

        if (!key.equals(entry.key)) return false;
        return value.equals(entry.value);
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }

    public Entry(int hash, Long key, String value, Entry next){
        this.key = key;
        this.value = value;
        this.next = next;
        this.hash = hash;
    }
}
