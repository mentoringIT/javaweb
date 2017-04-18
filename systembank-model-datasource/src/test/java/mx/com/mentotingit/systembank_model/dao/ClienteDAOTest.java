package mx.com.mentotingit.systembank_model.dao;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import mx.com.mentoringit.model.dao.ClienteDAO;
import mx.com.mentoringit.model.dto.ClienteDTO;

public class ClienteDAOTest {

	@Test
	public void testAgregar() {

		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setNombre("Ernesto");
		clienteDTO.setApaterno("Lopez");
		clienteDTO.setAmaterno("Juarez");
		clienteDTO.setEdad(33);
		clienteDTO.setIdBanco(6);

		try {
			assertTrue(new ClienteDAO().agregar(clienteDTO));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Ignore
	public void testListar() {
		try {
			assertTrue(new ClienteDAO().listar().size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
