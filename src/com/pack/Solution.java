package com.pack;

import com.pack.strategy.*;

import java.util.Date;
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
    //функция теста
    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        System.out.println(strategy.getClass().getSimpleName());  // имя класса стратегии

        Set<String> testSet = new HashSet<>();
        Shortener shortener = new Shortener(strategy);

        for (int i = 0; i < elementsNumber; i++){
            testSet.add(Helper.generateRandomString());
        }

        Long startDate1 = new Date().getTime();
        Set<Long> ids = getIds(shortener, testSet);
        Long endDate1 = new Date().getTime();
        System.out.println(endDate1 - startDate1);

        Long startDate2 = new Date().getTime();
        Set<String> str = getStrings(shortener, ids);
        Long endDate2 = new Date().getTime();
        System.out.println(endDate2 - startDate2);

        if (testSet.equals(str)) System.out.println("Тест пройден.");
        else System.out.println("Тест не пройден.");
    }

    public static void main(String[] args){
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        OurHashMapStorageStrategy ourHashMapStorageStrategy = new OurHashMapStorageStrategy();
        FileStorageStrategy fileStorageStrategy = new FileStorageStrategy();
        OurHashBiMapStorageStrategy ourHashBiMapStorageStrategy = new OurHashBiMapStorageStrategy();
        testStrategy(hashMapStorageStrategy, 10000);
        testStrategy(ourHashMapStorageStrategy, 10000);
        testStrategy(ourHashBiMapStorageStrategy, 10000);
        testStrategy(fileStorageStrategy, 2000);
    }
}
