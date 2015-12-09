package marcosTest;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import model.Precio;
import model.Rango;
public class PrecioTest {
	
	protected Precio sutPrecio;
	@Mock protected Rango rango;
	@Mock protected Rango otroRango;
		
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
			
		when(this.otroRango.cantDeDiasQueInterceptan(rango)).thenReturn(5);
		sutPrecio = new Precio(150.0, rango);
	}
		
	@Test 
	public void cuandoCalculoElMontoPara5DiasRetorna750(){
		assertEquals(sutPrecio.calcularMontoPara(otroRango), 750.0, 00.1);
	}	
		
}
