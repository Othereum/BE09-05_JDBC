package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application1 {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "ohgiraffers", "ohgiraffers");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
