package agusTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import model.Habitacion;
import model.Hotel;
import model.Precio;
import model.Rango;
import model.Reserva;
import nadaTesteable.Servicio;
import nadaTesteable.UsuarioPasajero;

public class HabitacionTest {
	
	private Habitacion habitacion;
	private String ciudad;
	private UsuarioPasajero usuario;
	private String otraCiudad;
	private Hotel unHotel;
	private Hotel unHotel2;
	private Habitacion habitacion2;
	private DateTime fechaDesde_marzo;
	private DateTime fechaHasta_abril;
	private DateTime fechaDesde_oct;
	private DateTime fechaHasta_nov;
	private DateTime fechaDesde_ene;
	private DateTime fechaHasta_feb;
	private Rango oct_nov;
	private Rango ene_feb;
	private Rango marzo_abril;
	private Rango rango2;
	
	
	@Before
	public void setUp(){
		
		this.usuario = new UsuarioPasajero(ciudad, ciudad, ciudad, ciudad, 3365);

		this.fechaDesde_oct= new DateTime(2015,10,10,0,0);
		this.fechaHasta_nov = new DateTime(2015,11,11,0,0);
		
		this.fechaDesde_ene = new DateTime(2015,01,10,0,0);
		this.fechaHasta_feb = new DateTime(2015,02,11,0,0);
		
		this.fechaDesde_marzo = new DateTime(2016,03,10,0,0);
		this.fechaHasta_abril = new DateTime(2016,04,11,0,0);
		
		oct_nov = new Rango(this.fechaDesde_oct, this.fechaHasta_nov);
		ene_feb= new Rango(this.fechaDesde_ene, this.fechaHasta_feb);
		marzo_abril= new Rango(this.fechaDesde_marzo,this.fechaHasta_abril);
		
		this.habitacion = new Habitacion(10, "simple", new ArrayList<Servicio>(), 
				new ArrayList<Reserva>(), new ArrayList<Precio>());
		
		this.habitacion.reservar(this.oct_nov, this.usuario);
		
		this.habitacion.reservar(this.marzo_abril, this.usuario);
		
		this.habitacion2 = new Habitacion(10, "simple", new ArrayList<Servicio>(), 
				new ArrayList<Reserva>(), new ArrayList<Precio>());
		
		this.habitacion2.reservar(this.ene_feb, this.usuario);
		
	}

	@Test
	public void testCapacidadMaxima(){
	
		assertEquals(habitacion.getCapacidadMaxima(), 10);
	}
	
	@Test
	public void testDisponibilidadPara(){
		
		DateTime hoy = new DateTime();
		DateTime pasadoManiana = new DateTime();
		pasadoManiana.plusDays(2);
		rango2 = new Rango(hoy, pasadoManiana);
		assertTrue(habitacion.disponibilidadPara(rango2));
	}
	
	@Test
	public void testReservasDeUnaCiudadDelUsuario(){
		
		assertEquals(habitacion.reservasDeUnaCiudadDelUsuario(this.ciudad, this.usuario).size(), 2);
		assertEquals(habitacion2.reservasDeUnaCiudadDelUsuario(this.otraCiudad, this.usuario).size(), 1);
	}
	
	@Test
	public void testReservasDelUsuario(){
		
		assertEquals(habitacion.reservasDelUsuario(this.usuario).size(), 2);
	}
	
	@Test
	public void testReservasFuturasDelUsuario(){
		
		assertEquals(habitacion.reservasFuturasDelUsuario(this.usuario).size(), 1);
	}
	
	@Test
	public void testCiudadDelHotelDondeEstas(){
		
		assertEquals(habitacion.ciudadDelHotelDondeEstas(), this.ciudad);
		assertEquals(habitacion2.ciudadDelHotelDondeEstas(), this.otraCiudad);
	}
}
