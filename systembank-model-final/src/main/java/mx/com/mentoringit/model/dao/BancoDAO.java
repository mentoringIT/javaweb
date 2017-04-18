package mx.com.mentoringit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import mx.com.mentoringit.model.conn.ConnectionFactory;
import mx.com.mentoringit.model.dto.BancoDTO;
import mx.com.mentoringit.model.interfaces.IBanco;

public class BancoDAO implements IBanco {

	private Connection conn;

	@Override
	public ArrayList<BancoDTO> listarBanco() throws Exception {
		conn = ConnectionFactory.getInstance().getConnection();
		String select = "select * from banco";
		PreparedStatement preparedStatement = conn.prepareStatement(select);
		
		ResultSet rs =  preparedStatement.executeQuery(select);
		
		ArrayList<BancoDTO> bancos = new ArrayList<BancoDTO>();
		
		while (rs.next()) {
			BancoDTO bancoDTO = new BancoDTO();
			bancoDTO.setIdBanco(rs.getInt("idBanco"));
			bancoDTO.setNombre(rs.getString("nombre"));
			
			bancos.add(bancoDTO);
			
		}
		
		ConnectionFactory.getInstance().close(preparedStatement, rs);
		
		
		return bancos;
	}

	
	
}
