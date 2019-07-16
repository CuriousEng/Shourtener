package com.pack.strategy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseStorageStrategy implements StorageStrategy {

    private Statement stmt;


    public DataBaseStorageStrategy() {
        DBConnection dbConnection = DBConnection.getInstance();
        stmt = dbConnection.getStatement();
    }

    @Override
    public boolean containsKey(Long key) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT key FROM url_base WHERE key = \'" + key + "\'");
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean containsValue(String value) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT value FROM url_base WHERE value = \'" + value + "\'");
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        if (this.containsKey(key)){
            System.out.println("Такой ключ уже существует!");
            return;
        }
        try {
            stmt.execute("INSERT INTO url_base VALUES (" + key + ", \'"+ value + "\');");
            System.out.println("Значение " + value + " добавлено!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long getKey(String value) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT key FROM url_base WHERE value = \'" + value + "\'");
            if (rs.next()) {
                return rs.getLong(1);
            } else {
                System.out.println("Невозможно найти ключ по значению" + value +". Возможно, значение не существует.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT value FROM url_base WHERE key = \'" + key + "\'");
            if (rs.next()) {
                return rs.getString(1);
            } else {
                System.out.println("Невозможно найти значение по ключу" + key + ". Возможно, ключ не существует.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(Long key) {
        if (!this.containsKey(key)){
            System.out.println("Ключ " + key + " не существует!");
            return;
        }
        try {
            stmt.execute("DELETE FROM url_base WHERE key = \'" + key + "\'");
            System.out.println("Значение по ключу " + key + " удалено.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
