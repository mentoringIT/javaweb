package mx.com.mentotingit.systembank_model.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import mx.com.mentoringit.model.dao.BancoDAO;

public class BancoDAOTest {

	@Test
	public void testListarBanco() {
		try {
			assertTrue(new BancoDAO().listarBanco().size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}