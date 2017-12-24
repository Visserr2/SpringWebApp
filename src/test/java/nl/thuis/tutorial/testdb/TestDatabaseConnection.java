package nl.thuis.tutorial.testdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDatabaseConnection {

	// setup connection variables
	private static String USER = "springstudent";
	private static String PASSWORD = "springstudent";
	private static String JDBC_URL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
	private static String DRIVER = "com.mysql.jdbc.Driver";

	public static void main(String[] args) {
		Connection conn = null;

		try {
			// get connection to database
			System.out.println("Connecting to database: " + JDBC_URL);
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			System.out.println("Database connected");

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
