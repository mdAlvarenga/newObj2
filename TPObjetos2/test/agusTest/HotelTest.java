package agusTest;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import clasesPorCompletitud.Ciudad;
import clasesPorCompletitud.Servicio;
import clasesPorCompletitud.UsuarioHotelero;
import model.Categoria;
import model.Direccion;
import model.Habitacion;
import model.Hotel;
import model.Mail;
import model.MedioDePago;
import model.Pais;
import model.Telefono;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class HotelTest {
	
	private DateTime fechaDeHoy;
	private Hotel hotel;
	private Habitacion habitacion1;
	private Habitacion habitacion2;
	private Habitacion habitacion3;
	private Habitacion habitacion4;
	private List<Habitacion> mockListHabitaciones;
	private List<Servicio> mockListServicios;
	private List<MedioDePago> mockListMediosDePago;
	
	@Before
	public void setUp(){
		fechaDeHoy = new DateTime(2015,12,10,0,0);
		habitacion1 = any(Habitacion.class);
		habitacion2 = any(Habitacion.class);
		habitacion3 = any(Habitacion.class);
		habitacion4 = any(Habitacion.class);
		
		mockListHabitaciones = new ArrayList<Habitacion>();
		mockListServicios = new ArrayList<Servicio>();
		mockListMediosDePago = new ArrayList<MedioDePago>();
		
		mockListHabitaciones.add(habitacion1);
		mockListHabitaciones.add(habitacion2);
		mockListHabitaciones.add(habitacion3);
		mockListHabitaciones.add(habitacion4);
		
		
		hotel = new Hotel("unhotel", 
						  any(Ciudad.class), 
						  mockListHabitaciones, 
						  mockListServicios, 
						  any(Categoria.class), 
						  any(DateTime.class), 
						  any(DateTime.class),
						  any(UsuarioHotelero.class),
						  any(Pais.class), 
						  any(Direccion.class), 
						  any(Telefono.class), 
						  any(Mail.class),
						  mockListMediosDePago);
	}

	@Test
	public void testReservasDentroDeFecha() {
		assertEquals(hotel.reservasDentroDeFecha(fechaDeHoy).size(), 2);
		verify(habitacion1, atLeastOnce()).getReservasParaFecha(fechaDeHoy);
		verify(habitacion2, atLeastOnce()).getReservasParaFecha(fechaDeHoy);
		verify(habitacion3, atLeastOnce()).getReservasParaFecha(fechaDeHoy);
		verify(habitacion4, atLeastOnce()).getReservasParaFecha(fechaDeHoy);		
	}
	
	@Test
	public void testReservasConFechaMayorA() {
		assertEquals(hotel.reservasConFechaMayorA(fechaDeHoy).size(), 2);
		verify(habitacion1, atLeastOnce()).reservasConFechaMayorA(fechaDeHoy);
		verify(habitacion2, atLeastOnce()).reservasConFechaMayorA(fechaDeHoy);
		verify(habitacion3, atLeastOnce()).reservasConFechaMayorA(fechaDeHoy);
		verify(habitacion4, atLeastOnce()).reservasConFechaMayorA(fechaDeHoy);
			}

	public void testTieneHabitacionQueCumpleCapacidad() {
		assertTrue(hotel.tieneHabitacionQueCumpleCapacidad(4));
		verify(habitacion1, atLeastOnce()).getCapacidadMaxima();
		verify(habitacion2, atLeastOnce()).getCapacidadMaxima();
		verify(habitacion3, atLeastOnce()).getCapacidadMaxima();
		verify(habitacion4, atLeastOnce()).getCapacidadMaxima();
	}
}
