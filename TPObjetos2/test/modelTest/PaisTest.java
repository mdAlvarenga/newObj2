package modelTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Pais;

public class PaisTest {

	private Pais pais;

	@Before
	public void setUp(){
		pais = new Pais("ARG", "ARGENTINA");
	}
	@Test
	public void paisCodigoTest(){
		assertEquals(pais.getCodigo(), "ARG");
	}
	
	@Test
	public void paisNombreTest(){
		assertEquals(pais.getNombre(), "ARGENTINA");
	}

}