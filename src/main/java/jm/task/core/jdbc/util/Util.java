package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private static final String URL = "jdbc:mySQL://localhost:3306/newdb?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        Connection connection = null;
        try {
           // Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}


//    public Connect(String comand) {
//        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement()) {
//           ResultSet resultSet;
//            statement.execute(comand);
//        } catch (SQLException e) {
//            System.out.println("Ошибка SQL");
//        }
//        return ResultSet;
//    }

