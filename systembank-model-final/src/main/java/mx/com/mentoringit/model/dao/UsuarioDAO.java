package mx.com.mentoringit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mx.com.mentoringit.model.conn.ConnectionFactory;
import mx.com.mentoringit.model.dto.UsuarioDTO;
import mx.com.mentoringit.model.interfaces.IUsuario;

public class UsuarioDAO implements IUsuario{
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	@Override
	public UsuarioDTO buscar(UsuarioDTO usuario) throws Exception {
		
		String select = "select * from login where usuario = ? "
						+ " and password = ?";
		
		conn = ConnectionFactory.getInstance().getConnection();
		// compilamos el query y lo almacenamos en un objeto de tipo prepareStatement
		ps = conn.prepareStatement(select);
		ps.setString(1, usuario.getUsuario());
		ps.setString(2, usuario.getPassword());
		
		rs = ps.executeQuery();

		UsuarioDTO user = null;
		
		while (rs.next()){
			user = new UsuarioDTO();
			user.setNombre(rs.getString("nombre"));
			user.setApaterno(rs.getString("apaterno"));
			
		}
		
		return user;
	}

}
