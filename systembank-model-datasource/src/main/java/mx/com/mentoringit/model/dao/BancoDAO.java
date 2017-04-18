package mx.com.mentoringit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import mx.com.mentoringit.model.dto.BancoDTO;
import mx.com.mentoringit.model.interfaces.IBanco;

public class BancoDAO implements IBanco {

	private Connection conn;
	private DataSource ds;
	

	private PreparedStatement preparedStatement;
	private ResultSet rs;

	@Override
	public ArrayList<BancoDTO> listarBanco() throws Exception {
		conn = ds.getConnection();
		String select = "select * from banco;";
		preparedStatement = conn.prepareStatement(select);

		rs = preparedStatement.executeQuery();

		ArrayList<BancoDTO> bancos = new ArrayList<BancoDTO>();

		while (rs.next()) {

			BancoDTO BancoDTO = new BancoDTO();

			BancoDTO.setNombre(rs.getString("nombre"));
			BancoDTO.setIdBanco(rs.getInt("idbanco"));

			bancos.add(BancoDTO);
		}
		close();
		return bancos;
	}
	public DataSource getDs() {
		return ds;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
	}
	private void close() throws SQLException {
		if (conn != null) {
			conn.close();
		}
		if (rs != null) {
			rs.close();
		}
		if (preparedStatement != null) {
			preparedStatement.close();
		}
	}
}