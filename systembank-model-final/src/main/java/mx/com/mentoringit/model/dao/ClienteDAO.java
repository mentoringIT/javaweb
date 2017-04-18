package mx.com.mentoringit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import mx.com.mentoringit.model.conn.ConnectionFactory;
import mx.com.mentoringit.model.dto.ClienteDTO;
import mx.com.mentoringit.model.interfaces.ICliente;

public class ClienteDAO implements ICliente {

	private Connection conn;

	@Override
	public boolean agregar(ClienteDTO clienteDTO) throws Exception {
			conn = ConnectionFactory.getInstance().getConnection();
			String insert = "INSERT INTO cliente (nombre,apaterno,amaterno,edad,idBanco)" 
		               +" VALUES (?,?,?,?,?)";
			String update = "update cliente set nombre = ?,"
											+" apaterno = ?,"
											+" amaterno = ?,"
											+" edad = ?,"
											+" idbanco = ?"
											+" where idcliente = ? ";
			
			PreparedStatement preparedStatement = null;
			
			if (clienteDTO.getIdCliente() > 0) {
				preparedStatement = conn.prepareStatement(update);				
				preparedStatement.setInt(6, clienteDTO.getIdCliente());
			} else {
				preparedStatement = conn.prepareStatement(insert);
			}
			
			preparedStatement.setString(1, clienteDTO.getNombre());
			preparedStatement.setString(2, clienteDTO.getApaterno());
			preparedStatement.setString(3, clienteDTO.getAmaterno());
			preparedStatement.setInt(4, clienteDTO.getEdad());
			preparedStatement.setInt(5, clienteDTO.getIdBanco());
					
			int result = preparedStatement.executeUpdate();
			
			ConnectionFactory.getInstance().close(preparedStatement, null);
			
			
		return result > 0;
	}

	@Override
	public ArrayList<ClienteDTO> listar() throws Exception {
		conn = ConnectionFactory.getInstance().getConnection();
		String insert = "select * from cliente";
		PreparedStatement preparedStatement = conn.prepareStatement(insert);

		ResultSet rs = preparedStatement.executeQuery();
		
		ArrayList<ClienteDTO> clientes = new ArrayList<ClienteDTO>();

		while (rs.next()) {
			ClienteDTO clienteDTO = new ClienteDTO();
			clienteDTO.setNombre(rs.getString("nombre"));
			clienteDTO.setApaterno(rs.getString("apaterno"));
			clienteDTO.setAmaterno(rs.getString("amaterno"));
			clienteDTO.setEdad(rs.getInt("edad"));
			clienteDTO.setIdBanco(rs.getInt("idBanco"));
			clienteDTO.setIdCliente(rs.getInt("idCliente"));
			clientes.add(clienteDTO);
			
			
		}
		
		ConnectionFactory.getInstance().close(preparedStatement, rs);
		
		return clientes;
	}

	@Override
	public boolean eliminar(int idCliente) throws Exception {
		conn = ConnectionFactory.getInstance().getConnection();
		String delete = "DELETE FROM cliente where idcliente = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(delete);
		
		preparedStatement.setInt(1, idCliente);
		
		int result = preparedStatement.executeUpdate();
		
		ConnectionFactory.getInstance().close(preparedStatement, null);
		
		return result > 0;
	}

	@Override
	public ClienteDTO buscar(int idCliente) throws Exception {
		conn = ConnectionFactory.getInstance().getConnection();
		String insert = "select * from cliente where idcliente = ?";
		
		
		PreparedStatement preparedStatement = conn.prepareStatement(insert);
		
		preparedStatement.setInt(1, idCliente);

		ResultSet rs = preparedStatement.executeQuery();
		
		ArrayList<ClienteDTO> clientes = new ArrayList<ClienteDTO>();

		while (rs.next()) {
			ClienteDTO clienteDTO = new ClienteDTO();
			clienteDTO.setNombre(rs.getString("nombre"));
			clienteDTO.setApaterno(rs.getString("apaterno"));
			clienteDTO.setAmaterno(rs.getString("amaterno"));
			clienteDTO.setEdad(rs.getInt("edad"));
			clienteDTO.setIdBanco(rs.getInt("idBanco"));
			clienteDTO.setIdCliente(rs.getInt("idCliente"));
			clientes.add(clienteDTO);
			
			
		}
		
		ConnectionFactory.getInstance().close(preparedStatement, rs);
		
		return clientes.get(0);	}

}
