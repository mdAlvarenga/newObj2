package modelTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Telefono;

public class TelefonoTest {

	private Telefono telefono;

	@Before
	public void setUp(){
		telefono = new Telefono(94, 11, 4221, 1515);
	}
	
	@Test
	public void testCodigoDePais(){
		assertEquals(telefono.getCodigoDePais().intValue(), 94);
	}
	
	@Test
	public void testCodigoDeArea(){
		assertEquals(telefono.getCodigoDeArea().intValue(), 11);
	}
	
	@Test
	public void testCodigoLocal(){
		assertEquals(telefono.getCodigoLocal().intValue(), 4221);
	}
	
	@Test
	public void testNumeroAbonado(){
		assertEquals(telefono.getNumeroAbonado().intValue(), 1515);
	}
}
