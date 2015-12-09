package agusTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Direccion;

public class DireccionTest {
	
	private Direccion direccion;

	@Before
	public void setUp(){
		direccion = new Direccion(123, "CALLEFALSA", "ENTRECALLE1", "ENTRECALLE2");
	}

	@Test
	public void testNumero(){
		assertEquals(direccion.getNumero(), 123);
	}
	
	@Test
	public void testCalle(){
		assertEquals(direccion.getCalle(), "CALLEFALSA");
	}
	
	@Test
	public void testEntreCalles(){
		assertEquals(direccion.getEntreCalles().get(0), "ENTRECALLE1");
		assertEquals(direccion.getEntreCalles().get(1), "ENTRECALLE2");
	}
}
