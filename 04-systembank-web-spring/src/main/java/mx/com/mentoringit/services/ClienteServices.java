package mx.com.mentoringit.services;

import java.util.ArrayList;

import mx.com.mentoringit.interfaces.IClienteService;
import mx.com.mentoringit.model.dto.ClienteDTO;
import mx.com.mentoringit.model.interfaces.ICliente;

public class ClienteServices implements IClienteService {

	private ICliente clienteDAO;

	public ClienteServices(ICliente clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	@Override
	public ArrayList<ClienteDTO> listarClientes() throws Exception {

		return clienteDAO.listar();
	}

	public ICliente getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ICliente clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	@Override
	public boolean eliminarCliente(int idCliente) throws Exception {
		return clienteDAO.eliminar(idCliente);
	}

	@Override
	public ClienteDTO buscarCliente(int idCliente) throws Exception {
		return clienteDAO.buscar(idCliente);
	}

	@Override
	public boolean guardarCliente(ClienteDTO clienteDTO) throws Exception {
		return clienteDAO.agregar(clienteDTO);
	}

}