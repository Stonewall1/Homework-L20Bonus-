package DBTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static Connection connection() throws SQLException {
        String host = "127.0.0.1";
        String port = "5432";
        String base = "postgres";
        String user = "postgres";
        String password = "root";
        String url = "jdbc:postgresql://" + host + ":" + port + "/" + base;
        return DriverManager.getConnection(url, user, password);
    }

    public static Connection getConnection() throws SQLException {
        return connection();
    }
}
