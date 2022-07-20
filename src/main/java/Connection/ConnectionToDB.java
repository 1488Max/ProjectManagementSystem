package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDB {


    private static String dbUrl = "jdbc:mysql://localhost:3306/projectdb";
    private static String dbUser = "admin";
    private static String dbPass = "admin";



    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(dbUrl,dbUser,dbPass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
