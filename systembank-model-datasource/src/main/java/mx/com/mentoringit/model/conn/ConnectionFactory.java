package mx.com.mentoringit.model.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class ConnectionFactory {

	private static ConnectionFactory instance;
	private Connection conn;
	private DataSource ds;
	private String user;
	private String url;
	private String pwd;

	public ConnectionFactory() {

	}
	
//	private ConnectionFactory() {
//		url = "jdbc:mysql://localhost:3306/systembank";
//		user = "root";
//		pwd = "root";
//
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//	}

	public void close(PreparedStatement ps, ResultSet rs) {
		try {
			if (ps != null) {
				ps.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {

		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

//	public static ConnectionFactory getInstance() {
//
//		if (instance == null) {
//			instance = new ConnectionFactory();
//		}
//		return instance;
//	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public DataSource getDs() {
		return ds;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
	}
}