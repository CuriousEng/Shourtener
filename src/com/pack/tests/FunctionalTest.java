package com.pack.tests;


import com.pack.Shortener;
import com.pack.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {

    public void testStorage(Shortener shortener){
        String s1 = "День прожит, солнце с вышины стремится прочь в другие страны.";
        String s2 = "Зачем мне крылья не даны с ним вровень мчаться неустанно.";
        String s3 = "День прожит, солнце с вышины стремится прочь в другие страны.";
        //получаем ид по строке
        Long id1 = shortener.getId(s1);
        Long id2 = shortener.getId(s2);
        Long id3 = shortener.getId(s3);
        //проверяем ид на равенство.
        Assert.assertNotEquals(id2, id1);
        Assert.assertNotEquals(id2, id3);
        Assert.assertEquals(id1, id3);
        //получаем строки по ид
        String res1 = shortener.getString(id1);
        String res2 = shortener.getString(id2);
        String res3 = shortener.getString(id3);
        //строки должны быть равны
        Assert.assertEquals(s1, res1);
        Assert.assertEquals(s2, res2);
        Assert.assertEquals(s3, res3);
    }

    @Test
    public void testHashMapStorageStrategy() {
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(hashMapStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy() {
        OurHashMapStorageStrategy ourHashMapStorageStrategy = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(ourHashMapStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy() {
        FileStorageStrategy fileStorageStrategy = new FileStorageStrategy();
        Shortener shortener = new Shortener(fileStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy() {
        HashBiMapStorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(hashBiMapStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        DualHashBidiMapStorageStrategy dualHashBidiMapStorageStrategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(dualHashBidiMapStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        OurHashBiMapStorageStrategy ourHashBiMapStorageStrategy = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(ourHashBiMapStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testDataBaseStorageStrategy() {
        DataBaseStorageStrategy dataBaseStorageStrategy = new DataBaseStorageStrategy();
        Shortener shortener = new Shortener(dataBaseStorageStrategy);
        testStorage(shortener);
    }
}
