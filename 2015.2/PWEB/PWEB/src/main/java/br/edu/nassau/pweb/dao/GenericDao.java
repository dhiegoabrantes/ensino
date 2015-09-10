package br.edu.nassau.pweb.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class GenericDao {

	protected Connection conn;

	protected void openConn(){
		try {
			if(conn != null || conn.isClosed()){
				conn = new ConnectionFactory().getConnection();
			}
		} catch (SQLException e) {
			conn = new ConnectionFactory().getConnection();
		}
	}
	
	protected void closeConn(){
		try {
			if( conn != null && !conn.isClosed() )
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
