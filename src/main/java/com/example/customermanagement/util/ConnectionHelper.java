package com.example.customermanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/customer-management";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection connection;
    public static Connection getConnection(){
        try {
            if(connection == null || connection.isClosed()){
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
