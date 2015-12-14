package agusTest;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import model.Habitacion;
import model.Hotel;
import nadaTesteable.Categoria;
import nadaTesteable.Ciudad;
import nadaTesteable.Correo;
import nadaTesteable.Direccion;
import nadaTesteable.IFormaDePago;
import nadaTesteable.Pais;
import nadaTesteable.Servicio;
import nadaTesteable.Telefono;
import nadaTesteable.UsuarioHotelero;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class HotelTest {
	
	private DateTime fechaDeHoy;
	private Hotel hotel;
	@Mock private Habitacion habitacion1;
	@Mock private Habitacion habitacion2;
	@Mock private Habitacion habitacion3;
	@Mock private Habitacion habitacion4;
	private List<Habitacion> mockListHabitaciones;
	private List<Servicio> mockListServicios;
	private ArrayList<IFormaDePago> mockListFormasDePago;
	@Mock private Ciudad ciudad;
	@Mock private Categoria categoria;
	private DateTime checkout;
	@Mock private UsuarioHotelero hotelero;
	@Mock private Pais pais;
	@Mock private Direccion direccion;
	@Mock private Telefono telefono;
	@Mock private Correo correo;
	private DateTime checkin;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);		
		checkin = new DateTime();
		checkout = new DateTime();
		fechaDeHoy = new DateTime(2015,12,10,0,0);
		
		mockListHabitaciones = new ArrayList<Habitacion>();
		mockListServicios = new ArrayList<Servicio>();
		mockListFormasDePago = new ArrayList<IFormaDePago>();
		
		mockListHabitaciones.add(habitacion1);
		mockListHabitaciones.add(habitacion2);
		mockListHabitaciones.add(habitacion3);
		mockListHabitaciones.add(habitacion4);
				
		hotel = new Hotel("unhotel", 
						  ciudad, 
						  mockListHabitaciones, 
						  mockListServicios, 
						  categoria, 
						  checkin, 
						  checkout,
						  hotelero,
						  pais, 
						  direccion, 
						  telefono, 
						  correo,
						  mockListFormasDePago);
		
		//when(habitacion1.getReservasParaFecha())
	}

	@Test
	public void testReservasDentroDeFecha() {
		assertEquals(hotel.reservasDentroDeFecha(fechaDeHoy).size(), 2);
	}
	
	@Test
	public void testReservasConFechaMayorA() {
		assertEquals(hotel.reservasConFechaMayorA(fechaDeHoy).size(), 2);
		verify(habitacion1, atLeastOnce()).reservasConFechaMayorA(fechaDeHoy);
		verify(habitacion2, atLeastOnce()).reservasConFechaMayorA(fechaDeHoy);
		verify(habitacion3, atLeastOnce()).reservasConFechaMayorA(fechaDeHoy);
		verify(habitacion4, atLeastOnce()).reservasConFechaMayorA(fechaDeHoy);
			}

	@Test
	public void testTieneHabitacionQueCumpleCapacidad() {
		assertTrue(hotel.tieneHabitacionQueCumpleCapacidad(4));
		verify(habitacion1, atLeastOnce()).getCapacidadMaxima();
		verify(habitacion2, atLeastOnce()).getCapacidadMaxima();
		verify(habitacion3, atLeastOnce()).getCapacidadMaxima();
		verify(habitacion4, atLeastOnce()).getCapacidadMaxima();
	}
}
