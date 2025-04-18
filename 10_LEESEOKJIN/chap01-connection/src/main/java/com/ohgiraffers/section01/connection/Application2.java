package com.ohgiraffers.section01.connection;

import com.ohgiraffers.section02.template.JDBCTemplate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Application2 {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = JDBCTemplate.getConnection();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
