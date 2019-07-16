package com.pack;


import com.pack.strategy.*;


import java.util.HashSet;
import java.util.Set;


public class Solution {
    private Shortener shortener = new Shortener(new HashMapStorageStrategy());

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> ids = new HashSet<>();
        for (String s: strings){
            ids.add(shortener.getId(s));
        }
        return ids;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> strings = new HashSet<>();
        for (Long s : keys){
            strings.add(shortener.getString(s));
        }
        return strings;
    }

    public static void main(String[] args){

        DataBaseStorageStrategy dataBaseStorageStrategy = new DataBaseStorageStrategy();
        dataBaseStorageStrategy.containsKey(3l);
        dataBaseStorageStrategy.containsValue("CuriousEngineer");
        dataBaseStorageStrategy.put(2l ,"testTestTest");
        dataBaseStorageStrategy.put(5l ,"Пиф-Паф!");
        System.out.println(dataBaseStorageStrategy.getKey("Пиф-Паф!"));
        System.out.println(dataBaseStorageStrategy.getValue(5l));
        dataBaseStorageStrategy.delete(5l);
        dataBaseStorageStrategy.delete(1l);
        dataBaseStorageStrategy.delete(2l);
        dataBaseStorageStrategy.delete(3l);
    }
}
