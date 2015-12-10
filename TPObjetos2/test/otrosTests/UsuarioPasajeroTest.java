package otrosTests;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import nadaTesteable.Telefono;
import nadaTesteable.UsuarioPasajero;
public class UsuarioPasajeroTest {

	protected UsuarioPasajero usuario;
	@Mock protected Telefono telefono;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		usuario = new UsuarioPasajero("Carlos", "Tevez", "tvz@gmail.com", telefono, 3656478);
	}
	
	@Test
	public void testeoLaCorrectaCreacionDelUsuarioHotelero(){
		assertEquals(usuario.getNombre(), "Carlos");
		assertEquals(usuario.getApellido(), "Tevez");
		assertEquals(usuario.getEmail(), "tvz@gmail.com");
		assertEquals(usuario.getTelefono(), telefono);
		assertEquals(usuario.getDni(), 3656478);		
	}
}