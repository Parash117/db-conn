package config;

import util.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection connect() {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(Constants.url, Constants.username, Constants.password);
            System.out.println("Connected to the MySQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

}
