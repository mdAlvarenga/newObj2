package modelTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.Marca;
public class MarcaTest {

	protected Marca marca;
	
	@Before
	public void setUp(){
		marca = new Marca("Visa");
	}
	
	@Test
	public void testeoLaCorrectaCreacionDelCorreo(){
		assertEquals(marca.getNombre(), "Visa");
	}
}