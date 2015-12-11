package otrosTests;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import nadaTesteable.Banco;
import nadaTesteable.Marca;
import nadaTesteable.TDebito;
public class TDebitoTest {

	protected TDebito tarjeta;
	@Mock protected Banco banco;
	@Mock protected Marca marca;
	protected DateTime fechaVenc;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		fechaVenc = new DateTime("2017-08-05"); 
		tarjeta = new TDebito(banco, 123456, fechaVenc, 986);		
	}
	
	@Test
	public void testeoLaCorrectaCreacionDeLaTarjetaDeDebito(){
		assertEquals(tarjeta.getBanco(), banco);
		assertEquals(tarjeta.getCodigoseguridad(), 986);
		assertEquals(tarjeta.getFvencimiento(), new DateTime("2017-08-05"));
		assertEquals(tarjeta.getNumero(), 123456);
	}
}