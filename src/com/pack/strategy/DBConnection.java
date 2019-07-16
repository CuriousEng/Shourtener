package com.pack.strategy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {
    private Statement stmt;
    private static DBConnection dbConnection;

    private DBConnection() {
        try {
            String url = "jdbc:postgresql://localhost:5432/lessons";
            String login = "author";
            String password = "1234";
            Connection connection = DriverManager.getConnection(url, login, password);  //подключаемся к БД
            stmt = connection.createStatement();  //создание запроса
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DBConnection getInstance(){
        if (dbConnection == null){
            dbConnection = new DBConnection();
            return dbConnection;
        } else return dbConnection;
    }

    public Statement getStatement() {
        return stmt;
    }
}

