package jehan.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ConnectDatabase class manages the connection to the MySQL database.
 */
public class ConnectDatabase {
    public Connection connection;

    // Database URL, username, and password
    private final String URL = "jdbc:mysql://localhost:3306/payroll_database";
    private final String USERNAME = "root";
    private final String PASSWORD = "Johanten222001";
	
    public String username;
    public String password;

    /**
     * Establishes a connection to the MySQL database.
     */
    public void createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
