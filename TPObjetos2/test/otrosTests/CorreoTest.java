package otrosTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import nadaTesteable.Correo;
import nadaTesteable.Pais;
public class CorreoTest {

	protected Correo correo;
	@Mock protected Pais espania;
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		correo = new Correo("abcd@gmail.com","URGENTE","Esto es una prueba");
	}
	
	@Test
	public void testeoLaCorrectaCreacionDelCorreo(){
		assertEquals(correo.getTo(), "abcd@gmail.com");
		assertEquals(correo.getSubject(), "URGENTE");
		assertEquals(correo.getBody(), "Esto es una prueba");
	}
}

