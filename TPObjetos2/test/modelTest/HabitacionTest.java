package modelTest;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Test;

import model.Habitacion;

public class HabitacionTest {
	
	private Habitacion habitacion;
	private Object ciudad;
	private Object usuario;
	private Object otraCiudad;

	@Test
	public void testCapacidadMaxima(){
	
		assertEquals(habitacion.getCapacidadMaxima(), 10);
	}
	
	@Test
	public void testDisponibilidadPara(){
		
		DateTime hoy = new DateTime();
		DateTime pasadoManiana = new DateTime();
		pasadoManiana.plusDays(2);
		
		assertTrue(habitacion.disponibilidadPara(hoy, pasadoManiana));
	}
	
	@Test
	public void testReservasDeUnaCiudadDelUsuario(){
		
		assertEquals(habitacion.reservasDeUnaCiudadDeUnUsuario(ciudad, usuario).size(), 2);
		assertEquals(habitacion.reservasDeUnaCiudadDeUnUsuario(otraCiudad, usuario).size(), 0);
	}
	
	@Test
	public void testReservasDelUsuario(){
		
		assertEquals(habitacion.reservasDelUsuario(usuario).size(), 2);
	}
	
	@Test
	public void testReservasFuturasDelUsuario(){
		
		assertEquals(habitacion.reservasFuturasDelUsuario().size(), 1);
	}
	
	@Test
	public void testCiudadDelHotelDondeEstas(){
		
		assertEquals(habitacion.ciudadDelHotelDondeEstas(), ciudad);
	}
}
