package br.edu.nassau.pweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao {

	public Connection getConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/pweb";
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, "root", "");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
}
