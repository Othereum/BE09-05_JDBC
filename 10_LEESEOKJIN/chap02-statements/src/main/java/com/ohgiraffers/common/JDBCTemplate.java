package com.ohgiraffers.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {
    public static Connection getConnection() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/main/resources/db.properties"));

        String url = properties.getProperty("url");
        return DriverManager.getConnection(url, properties);
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ignored) {}
        }
    }

    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ignored) {}
        }
    }

    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException ignored) {}
        }
    }
}
