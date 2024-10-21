package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	    private static final String URL = "jdbc:mysql://localhost:3306/bus_booking_db";
	    private static final String USER = "root";
	    private static final String PASSWORD = "manish"; // Your MySQL password

	    public static Connection getConnection() {
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(URL, USER, PASSWORD);
	            System.out.println("Connected to the database successfully.");
	        } catch (SQLException e) {
	            System.out.println("Error connecting to database: " + e.getMessage());
	        }
	        return conn;
	    }
	}


