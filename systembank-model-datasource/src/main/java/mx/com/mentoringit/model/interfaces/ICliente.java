package mx.com.mentoringit.model.interfaces;

import java.util.ArrayList;

import mx.com.mentoringit.model.dto.ClienteDTO;

public interface ICliente {

	boolean agregar(ClienteDTO clienteDTO) throws Exception;
	boolean eliminar(int idCliente) throws Exception;
	ClienteDTO buscar(int idCliente) throws Exception;
	ArrayList<ClienteDTO> listar()throws Exception;
	
}