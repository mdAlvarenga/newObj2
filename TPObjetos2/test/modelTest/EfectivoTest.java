package modelTest;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import model.Efectivo;
import model.IMoneda;
public class EfectivoTest {

	protected Efectivo efectivo;
		
	@Mock protected IMoneda moneda;
	
	@Before
	public void setUp(){
		
		this.efectivo = new Efectivo(this.moneda);
	}
	
	@Test
	public void testeoLaCorrectaCreacionDelEfectivo(){
		assertEquals(this.efectivo.getMoneda(), this.moneda);
	}
}
