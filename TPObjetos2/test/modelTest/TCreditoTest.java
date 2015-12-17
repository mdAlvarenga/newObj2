package modelTest;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import model.Banco;
import model.Marca;
import model.TCredito;
public class TCreditoTest {

	protected TCredito tarjeta;
	@Mock protected Banco banco;
	@Mock protected Marca marca;
	protected DateTime fechaVenc;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		fechaVenc = new DateTime("2017-08-05"); 
		tarjeta = new TCredito(banco, marca, 456789, fechaVenc, 987);		
	}
	
	@Test
	public void testeoLaCorrectaCreacionDeLaTarjetaDeCredito(){
		assertEquals(tarjeta.getBanco(), banco);
		assertEquals(tarjeta.getCodigoseguridad(), 987);
		assertEquals(tarjeta.getFvencimiento(), new DateTime("2017-08-05"));
		assertEquals(tarjeta.getMarca(), marca);
		assertEquals(tarjeta.getNumero(), 456789);
	}
}