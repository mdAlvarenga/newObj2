package modelTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import model.Rango;
import model.Reserva;
import model.Usuario;
import model.UsuarioPasajero;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

public class ReservaTest {
	public Rango rangoConsulta;
	public Reserva reserva;
	public DateTime fechaTest;
	public Usuario pasajero;
	
	@Before
	public void setupReserva(){

	// RESERVA
		DateTime fechaDesde = new DateTime(2015,10,10,0,0);
		DateTime fechaHasta = new DateTime(2015,11,11,0,0);
		Rango rango = new Rango(fechaDesde, fechaHasta);
		Double totalReserva = 200.0;
		pasajero = new UsuarioPasajero();
		reserva = new Reserva(rango, totalReserva, pasajero);
		
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
		
		assertEquals(reserva.getMonto(), 200.0);
	}

	@Test
	public void testReservaConFechaDeIngresoPosterior(){
		
		assertTrue(reserva.fechaDeReservaPosteriorA(fechaTest));
	}

}
