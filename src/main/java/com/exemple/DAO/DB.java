package com.exemple.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
        private static final String URL = "jdbc:mysql://monorail.proxy.rlwy.net:37344/railway";
        private static final String USERNAME = "root";
        private static final String PASSWORD = "lrBXdgcoCbfGZvUSlluQbrMXFZmxJVVs";

        public static Connection getConnection() {
            Connection connection = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException e) {
            } catch (SQLException e) {
            }
            return connection;
        }

        public static void closeConnection(Connection connection) {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
        }
}
