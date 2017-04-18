package mx.com.mentoringit.systembank_model.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import mx.com.mentoringit.model.dao.ClienteDAO;
import mx.com.mentoringit.model.dto.ClienteDTO;

public class ClienteDAOTest {

	@Test
	public void testAgregar() {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setNombre("Luis");
		clienteDTO.setApaterno("Tellez");
		clienteDTO.setAmaterno("Leon");
		clienteDTO.setEdad(43);
		clienteDTO.setIdBanco(1);
		
		try {
			assertTrue(new ClienteDAO().agregar(clienteDTO));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//@Test
	public void testListar() {
		
		try {
			assertTrue(new ClienteDAO().listar().size() > 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
