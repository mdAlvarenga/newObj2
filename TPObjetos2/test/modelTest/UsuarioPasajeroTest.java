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
import model.UsuarioPasajero;


public class UsuarioPasajeroTest {

	private UsuarioPasajero usuario;
	private String unaCiudad;
	private Habitacion habitacion1;
	private Habitacion habitacion2;
	private Hotel hotel1;
	private Hotel hotel2;
	private DateTime fechaDesde;
	private DateTime fechaHasta;
	private DateTime otraFechaDesde;
	private DateTime otraFechaHasta;
	private Rango unRango;

	@Before
	public void setUp(){
		
		this.fechaDesde = new DateTime(2015,9,9,0,0);
		this.fechaHasta = new DateTime(2015,9,30,0,0);
		this.unRango = new Rango(this.fechaDesde, this.fechaHasta);
		
		Precio unPrecio = new Precio(new Double(200.0), this.unRango);
		
		List<Precio> precios = new ArrayList<Precio>();
		precios.add(unPrecio);
		
		this.usuario = new UsuarioPasajero();
		this.unaCiudad = "QUILMES";

		this.hotel1 = new Hotel("AAA", "BUENOS_AIRES", new ArrayList<Habitacion>(), 
				new ArrayList<Servicio>(), "unaCategoria", new DateTime(), new DateTime());
		
		this.habitacion1 = new Habitacion(1, "simple", new ArrayList<Servicio>(), 
				new ArrayList<Reserva>(), this.hotel1, precios);
		
		this.hotel2 = new Hotel("BBB", "QUILMES", new ArrayList<Habitacion>(), 
				new ArrayList<Servicio>(), "unaCategoria", new DateTime(), new DateTime());
		
		this.habitacion2 = new Habitacion(2, "simple", new ArrayList<Servicio>(), 
				new ArrayList<Reserva>(), this.hotel2, new ArrayList<Precio>());
		
		this.habitacion1.reservar(fechaDesde, fechaHasta, this.usuario);
		this.habitacion2.reservar(fechaDesde, fechaHasta, this.usuario);
		
		this.otraFechaDesde = new DateTime(2016,2,9,0,0);
		this.otraFechaHasta = new DateTime(2016,3,9,0,0);	
		
		this.habitacion1.reservar(otraFechaDesde, otraFechaHasta, this.usuario);
		this.habitacion2.reservar(otraFechaDesde, otraFechaHasta, this.usuario);

		//se agregan habitaciones a hoteles
		List<Habitacion> aux = new ArrayList<Habitacion>();
		aux.add(habitacion1);
		this.hotel1.setHabitaciones(aux);
		
		List<Habitacion> aux2 = new ArrayList<Habitacion>();
		aux2.add(habitacion2);
		this.hotel2.setHabitaciones(aux2);

	}
	
	@Test
	public void testTodasLasReservasDeUnUsuario(){
		
		assertEquals(usuario.todasLasReservas().size(), 4);
	}
	
	@Test
	public void testReservasFuturasDeUnUsuario(){
		
		assertEquals(usuario.reservasFuturas().size(), 2);
	}
	
	@Test
	public void testReservasDeUnaCiudadDeUnUsuario(){
		
		assertEquals(usuario.reservasDeUnaCiudad(unaCiudad).size(), 2);
	}

	@Test
	public void testCiudadesEnLasQueTieneReservasUnUsuario(){
		
		assertEquals(usuario.ciudadesConReserva().size(),2);
	}
	
	@Test
	public void testUsuarioCancelaReserva(){
		
		this.usuario.cancelarReserva(this.usuario.todasLasReservas().get(1));
		assertEquals(this.usuario.todasLasReservas().size(), 3);
		
		//verify(mockHabitacion2, times(1)).cancelaSiPodes(mockReserva1);
		//verify(mockHabitacion1, times(1)).cancelaSiPodes(mockReserva1);
	}

	// FALTA LA MODIFICACION DE LA RESERVA
}
