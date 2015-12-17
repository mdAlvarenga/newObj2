package modelTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import model.Servicio;
public class ServicioTest {

	protected Servicio servicio;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		servicio = new Servicio("Sauna","Un completo tour dentro de nuestros exclusivos saunas",500.0);
	}
	
	@Test
	public void testeoLaCorrectaCreacionDelServicio(){
		assertEquals(servicio.getPrecio(), 500.0, 0.1);
		assertEquals(servicio.getNombre(), "Sauna");
		assertNotNull(servicio.getDescripcion());
	}
}
