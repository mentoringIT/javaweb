package mx.com.mentoringit.systembank_model.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import mx.com.mentoringit.model.dao.UsuarioDAO;
import mx.com.mentoringit.model.dto.UsuarioDTO;
import mx.com.mentoringit.model.interfaces.IUsuario;

public class UsuarioDAOTest {

	@Test
	public void testBuscar() {
		IUsuario usuarioDAO = new UsuarioDAO();
		UsuarioDTO usuario = new UsuarioDTO();
		
		try {
			usuario.setUsuario("roberto");
			usuario.setPassword("1234");
			assertNotNull(usuarioDAO.buscar(usuario));
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}

}
