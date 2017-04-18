package mx.com.mentoringit.interfaces;

import java.util.ArrayList;

import mx.com.mentoringit.model.dto.ClienteDTO;

public interface IClienteService {

		public ArrayList<ClienteDTO> listarClientes() throws Exception;
		public boolean eliminarCliente(int idCliente) throws Exception;
		
		public boolean guardarCliente(ClienteDTO clienteDTO) throws Exception;
		
		public ClienteDTO buscarCliente(int idCliente) throws Exception;
}