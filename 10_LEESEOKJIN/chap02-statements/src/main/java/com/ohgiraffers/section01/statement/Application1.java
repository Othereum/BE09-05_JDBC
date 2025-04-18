package com.ohgiraffers.section01.statement;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application1 {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Scanner scanner = new Scanner(System.in);

        try {
            connection = getConnection();
            statement = connection.createStatement();

            System.out.print("메뉴코드: ");
            int menuCode = scanner.nextInt();

            resultSet = statement.executeQuery("SELECT * FROM tbl_menu WHERE menu_code = " + menuCode);

            while (resultSet.next()) {
                System.out.print(resultSet.getString("menu_name") + " ");
                System.out.print(resultSet.getString("menu_price") + " ");
                System.out.println();
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(statement);
            close(resultSet);
            close(connection);
        }
    }
}
