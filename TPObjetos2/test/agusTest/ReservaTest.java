package agusTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import model.Rango;
import model.Reserva;
import nadaTesteable.UsuarioPasajero;

public class ReservaTest {

	private Rango rangoConsulta;
	private Reserva reserva;
	private DateTime fechaTest;
	private UsuarioPasajero unUsuario;
	
	@Before
	public void setupReserva(){
		
		this.unUsuario = new UsuarioPasajero(null, null, null, null, 456);

	// RESERVA
		DateTime fechaDesde = new DateTime(2015,10,10,0,0);
		DateTime fechaHasta = new DateTime(2015,11,11,0,0);
		Rango rango = new Rango(fechaDesde, fechaHasta);
		Double totalReserva = new Double(200.0);
		reserva = new Reserva(rango, totalReserva, this.unUsuario);

		
	//RANGO DE CONSULTA
		fechaDesde = new DateTime(2015,9,9,0,0);
		fechaHasta = new DateTime(2015,9,30,0,0);		
		rangoConsulta = new Rango(fechaDesde, fechaHasta);
		
	// FECHA DE TEST
		fechaTest = new DateTime(2015,10,9,0,0);
	}
	
	@Test
	public void testReservaOcupadaEnUnRango() {
		
		assertFalse(reserva.ocupadaEn(rangoConsulta));
	}
	
	@Test
	public void testMontoDeLaReserva(){
		
		assertEquals(reserva.getImporteDeReserva(), new Double(200.0));
	}

	@Test
	public void testReservaConFechaDeIngresoPosterior(){
		
		assertTrue(reserva.fechaDeReservaPosteriorA(fechaTest));
	}
	
	@Test
	public void testGetUsuarioQueReserva(){
		
		assertSame(this.unUsuario, reserva.getUsuarioQueReserva());
	}

}
