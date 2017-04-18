package mx.com.mentoringit.model.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionFactory {
	private static ConnectionFactory instance;
	private Connection conn;
	private String user;
	private String url;
	private String pwd;

	final Logger logger = LogManager.getLogger(ConnectionFactory.class);

	private ConnectionFactory() {

		url = "jdbc:mysql://localhost:3306/sistemabancario";
		user = "root";
		pwd = "root";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

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
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			logger.debug(" obtener conexion: " + " url: " + url + " usr: " + user
					+ " error:\n" + e);
		}

		return conn;
	}

	public static ConnectionFactory getInstance() {
		if (instance == null) {
			instance = new ConnectionFactory();
		}
		return instance;
	}
}
