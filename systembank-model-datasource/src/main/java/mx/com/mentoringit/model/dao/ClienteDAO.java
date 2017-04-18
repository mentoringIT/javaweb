package mx.com.mentoringit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import mx.com.mentoringit.model.dto.ClienteDTO;
import mx.com.mentoringit.model.interfaces.ICliente;

public class ClienteDAO implements ICliente {

	private Connection conn;
	private ResultSet rs;
	private PreparedStatement preparedStatement;
	private DataSource ds;

	@Override
	public boolean agregar(ClienteDTO clienteDTO) throws Exception {

		conn = ds.getConnection();
		String insert = "INSERT INTO cliente (nombre,apaterno,amaterno,edad,idBanco)"
				+ " VALUES (?,?,?,?,?)";

		String update = "update cliente set nombre = ?," + " apaterno= ?,"
				+ " amaterno = ? ," + " edad = ? ," + " idBanco= ? "
				+ " where idcliente = ? ";

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
		close();
		return result > 0;
	}

	@Override
	public ArrayList<ClienteDTO> listar() throws Exception {
		conn = ds.getConnection();
		String select = "select * from cliente;";
		preparedStatement = conn.prepareStatement(select);

		rs = preparedStatement.executeQuery();

		ArrayList<ClienteDTO> clientes = new ArrayList<ClienteDTO>();

		while (rs.next()) {

			ClienteDTO clienteDTO = new ClienteDTO();

			clienteDTO.setNombre(rs.getString("nombre"));
			clienteDTO.setAmaterno(rs.getString("amaterno"));
			clienteDTO.setApaterno(rs.getString("apaterno"));
			clienteDTO.setEdad(rs.getInt("edad"));
			clienteDTO.setIdBanco(rs.getInt("idbanco"));
			clienteDTO.setIdCliente(rs.getInt("idcliente"));

			clientes.add(clienteDTO);
		}

		close();
		return clientes;
	}

	@Override
	public boolean eliminar(int idCliente) throws Exception {
		conn = ds.getConnection();
		String delete = "delete from cliente where idcliente = ? ";

		preparedStatement = conn.prepareStatement(delete);
		preparedStatement.setInt(1, idCliente);

		int result = preparedStatement.executeUpdate();
		close();
		return result > 0;
	}

	@Override
	public ClienteDTO buscar(int idCliente) throws Exception {
		conn = ds.getConnection();
		String select = "select * from cliente where idcliente = ? ";
		preparedStatement = conn.prepareStatement(select);
		preparedStatement.setInt(1, idCliente);

		rs = preparedStatement.executeQuery();

		ArrayList<ClienteDTO> clientes = new ArrayList<ClienteDTO>();

		while (rs.next()) {

			ClienteDTO clienteDTO = new ClienteDTO();

			clienteDTO.setNombre(rs.getString("nombre"));
			clienteDTO.setAmaterno(rs.getString("amaterno"));
			clienteDTO.setApaterno(rs.getString("apaterno"));
			clienteDTO.setEdad(rs.getInt("edad"));
			clienteDTO.setIdBanco(rs.getInt("idbanco"));
			clienteDTO.setIdCliente(rs.getInt("idcliente"));

			clientes.add(clienteDTO);
		}

		close();
		return clientes.get(0);
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

	public DataSource getDs() {
		return ds;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
	}

}
