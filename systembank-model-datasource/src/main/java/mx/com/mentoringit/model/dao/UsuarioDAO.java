package mx.com.mentoringit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import mx.com.mentoringit.model.dto.UsuarioDTO;
import mx.com.mentoringit.model.interfaces.IUsuario;

public class UsuarioDAO implements IUsuario {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	private DataSource ds;

	@Override
	public UsuarioDTO buscar(UsuarioDTO usuario) throws Exception {

		String select = "select * from login where usuario = ? "
				+ " and password = ?";

		conn = ds.getConnection();
		ps = conn.prepareStatement(select);
		ps.setString(1, usuario.getUsuario());
		ps.setString(2, usuario.getPassword());

		rs = ps.executeQuery();

		UsuarioDTO user = null;

		while (rs.next()) {

			user = new UsuarioDTO();

			user.setNombre(rs.getString("nombre"));
			user.setApaterno(rs.getString("apaterno"));
		}
		close();
		return user;
	}

	private void close() throws SQLException {
		if (conn != null) {
			conn.close();
		}
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
	}

	public DataSource getDs() {
		return ds;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
	}
}
