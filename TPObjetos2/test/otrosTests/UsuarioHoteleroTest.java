package otrosTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import nadaTesteable.Telefono;
import nadaTesteable.UsuarioHotelero;
public class UsuarioHoteleroTest {

	protected UsuarioHotelero usuario;
	@Mock protected Telefono telefono;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		usuario = new UsuarioHotelero("Carlos", "Tevez", "tvz@gmail.com", telefono, "34-5678-7");
	}
	
	@Test
	public void testeoLaCorrectaCreacionDelUsuarioHotelero(){
		assertEquals(usuario.getNombre(), "Carlos");
		assertEquals(usuario.getApellido(), "Tevez");
		assertEquals(usuario.getEmail(), "tvz@gmail.com");
		assertEquals(usuario.getTelefono(), telefono);
		assertEquals(usuario.getCuit(), "34-5678-7");
		
	}
}
