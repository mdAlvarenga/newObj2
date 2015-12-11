package otrosTests;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import nadaTesteable.Ciudad;
import nadaTesteable.Pais;
public class CiudadTest {

	protected Ciudad ciudad;
	@Mock protected Pais espania;
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		ciudad = new Ciudad("Madrid", espania);
	}
	
	@Test
	public void testeoLaCorrectaCreacionDeLaCiudadYSusGetters(){
		assertEquals(ciudad.getNombre(), "Madrid");
		assertEquals(ciudad.getPais(), espania);
	}
}
