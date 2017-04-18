package mx.com.mentoringit.systembank_model.conn;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import mx.com.mentoringit.model.conn.ConnectionFactory;

public class ConnectionFactoryTest {

	@Test
	public void testGetConnection() {
		assertNotNull(ConnectionFactory.getInstance().getConnection());
	}

	@Test
	public void testGetInstance() {
		assertNotNull(ConnectionFactory.getInstance());
	}

}
