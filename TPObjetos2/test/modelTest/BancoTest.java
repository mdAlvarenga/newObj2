package modelTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Banco;

public class BancoTest {
	
	@Test
	public void testCreacionDeBanco(){
		Banco banco = new Banco("Banco Galicia");
		assertEquals(banco.getNombre(), "Banco Galicia");
	}
}