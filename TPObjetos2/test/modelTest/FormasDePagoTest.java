package modelTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.joda.time.DateTime;

import model.Banco;
import model.Efectivo;
import model.FormaDePago;
import model.Hotel;
import model.Marca;
import model.TCredito;
import model.TDebito;

public class FormasDePagoTest {

	@Mock private Hotel hotel;
	private FormaDePago efectivo;
	private FormaDePago tdebito;
	private FormaDePago tcredito;
	private Banco santander;
	private Marca Visa;
	private Marca Mastercard;
	
	@Before
	public void setUp() throws Exception {

		this.hotel = Mockito.mock(Hotel.class);
		
		this.santander = new Banco("Santander");
		this.Visa = new Marca("Visa");
		this.Mastercard = new Marca("Mastercard");
		
		this.efectivo = new Efectivo("dolares");
		this.tdebito = new TDebito(this.santander, 1234566789, new DateTime(2019,10,10,0,0), 625);
		this.tcredito = new TCredito(this.santander, this.Visa, 1234566789, new DateTime(2019,10,10,0,0), 249);
			
	}

	@Test
	public void test() {

		fail("Not yet implemented");
	}

}
