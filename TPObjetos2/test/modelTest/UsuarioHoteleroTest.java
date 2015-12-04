package modelTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import model.Habitacion;
import model.Hotel;
import model.Precio;
import model.Rango;
import model.Reserva;
import model.Servicio;
import model.UsuarioHotelero;
import model.UsuarioPasajero;

public class UsuarioHoteleroTest {

	private UsuarioPasajero usuarioPasajero;
	private DateTime fechaDesde;
	private DateTime fechaHasta;
	private Rango unRango;
	private Hotel hotel1;
	private Habitacion habitacion1;
	private Hotel hotel2;
	private Habitacion habitacion2;
	private UsuarioHotelero usuarioHotelero;
	private DateTime otraFechaDesde;
	private DateTime otraFechaHasta;

	@Before
	public void setUp(){
		
		this.usuarioHotelero = new UsuarioHotelero(null);
		this.usuarioPasajero = new UsuarioPasajero(467);

		// para la reserva actual
		this.fechaDesde = new DateTime(2015,9,9,0,0);
		this.fechaHasta = new DateTime(2015,12,30,0,0);
		this.unRango = new Rango(this.fechaDesde, this.fechaHasta);
		
		Precio unPrecio = new Precio(new Double(200.0), this.unRango);
		
		List<Precio> precios = new ArrayList<Precio>();
		precios.add(unPrecio);
		
		this.hotel1 = new Hotel("AAA", "BUENOS_AIRES", new ArrayList<Habitacion>(), 
				new ArrayList<Servicio>(), "unaCategoria", new DateTime(), new DateTime());
		
		this.habitacion1 = new Habitacion(1, "simple", new ArrayList<Servicio>(), 
				new ArrayList<Reserva>(), this.hotel1, precios);
		
		this.hotel2 = new Hotel("BBB", "QUILMES", new ArrayList<Habitacion>(), 
				new ArrayList<Servicio>(), "unaCategoria", new DateTime(), new DateTime());
		
		this.habitacion2 = new Habitacion(2, "simple", new ArrayList<Servicio>(), 
				new ArrayList<Reserva>(), this.hotel2, new ArrayList<Precio>());
		
		this.habitacion1.reservar(fechaDesde, fechaHasta, this.usuarioPasajero);
		this.habitacion2.reservar(fechaDesde, fechaHasta, this.usuarioPasajero);
		
		//para la reserva futura
		this.otraFechaDesde = new DateTime(2016,2,9,0,0);
		this.otraFechaHasta = new DateTime(2016,3,9,0,0);	
		
		this.habitacion1.reservar(otraFechaDesde, otraFechaHasta, this.usuarioPasajero);
		this.habitacion2.reservar(otraFechaDesde, otraFechaHasta, this.usuarioPasajero);

		List<Habitacion> aux = new ArrayList<Habitacion>();
		aux.add(habitacion1);
		this.hotel1.setHabitaciones(aux);
		
		List<Habitacion> aux2 = new ArrayList<Habitacion>();
		aux2.add(habitacion2);
		this.hotel2.setHabitaciones(aux2);

		this.usuarioHotelero.nuevoHotel(hotel1);
		this.usuarioHotelero.nuevoHotel(hotel2);
	}
	
	@Test
	public void testAgregaHotel(){
		
		assertEquals(this.usuarioHotelero.getHoteles().size(), 2);
	}	
	@Test
	public void testReservasActuales(){
		
		assertEquals(this.usuarioHotelero.reservasActuales().size(), 2);
	}
	
	@Test
	public void testReservasFuturas(){
		
		assertEquals(this.usuarioHotelero.reservasFuturas().size(), 2);
	}

	@Test
	public void testReservasDentroDeNDiasFuturos(){
		
		assertEquals(this.usuarioHotelero.reservasDentroDeNDiasFuturos(4).size(), 2);
	}
	
}
