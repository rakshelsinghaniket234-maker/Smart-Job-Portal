package com.task.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionPool {

    private static Connection conn;

    public static Connection connectDB() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/smart_job_portal",
                    "root",
                    "YOUR_PASSWORD"
            );

            System.out.println("Database Connected");
            System.out.println("Database : " + conn.getCatalog());

        } catch (Exception e) {

            e.printStackTrace();

        }

        return conn;
    }

    public static Connection getConnection() {

        return connectDB();
    }
}
