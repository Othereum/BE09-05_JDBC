package com.ohgiraffers.section02.template;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTemplate {
    public static Connection getConnection() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/main/resources/db.properties"));

        String url = properties.getProperty("url");
        return DriverManager.getConnection(url, properties);
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ignored) {}
        }
    }
}
