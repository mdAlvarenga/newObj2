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
import model.Reserva;
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
	@Mock private Reserva nuevaReserva;
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
	private List<Reserva> mockListReservasVacia;
	private List<Reserva> mockListReservasConReservas1;
	private List<Reserva> mockListReservasConReservas2;
	
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
		
		when(ciudad.getNombre()).thenReturn("Rosario");
		
		when(habitacion1.getCapacidadMaxima()).thenReturn(1);
		when(habitacion2.getCapacidadMaxima()).thenReturn(1);
		when(habitacion3.getCapacidadMaxima()).thenReturn(4);
		when(habitacion4.getCapacidadMaxima()).thenReturn(1);
		
		mockListReservasVacia = new ArrayList<Reserva>();
		mockListReservasConReservas1 = new ArrayList<Reserva>();
		mockListReservasConReservas2 = new ArrayList<Reserva>();
		Reserva reserva1 = Mockito.mock(Reserva.class);
		Reserva reserva2 = Mockito.mock(Reserva.class);
		Reserva reserva3 = Mockito.mock(Reserva.class);
		Reserva reserva4 = Mockito.mock(Reserva.class);
		mockListReservasConReservas1.add(reserva1);
		mockListReservasConReservas1.add(reserva2);
		mockListReservasConReservas2.add(reserva3);
		mockListReservasConReservas2.add(reserva4);
		
		when(habitacion1.getReservasParaFecha(fechaDeHoy)).thenReturn(mockListReservasVacia);
		when(habitacion2.getReservasParaFecha(fechaDeHoy)).thenReturn(mockListReservasVacia);
		when(habitacion3.getReservasParaFecha(fechaDeHoy)).thenReturn(mockListReservasConReservas1);
		when(habitacion4.getReservasParaFecha(fechaDeHoy)).thenReturn(mockListReservasConReservas2);

		when(habitacion1.reservasConFechaMayorA(fechaDeHoy)).thenReturn(mockListReservasConReservas2);
		when(habitacion2.reservasConFechaMayorA(fechaDeHoy)).thenReturn(mockListReservasVacia);
		when(habitacion3.reservasConFechaMayorA(fechaDeHoy)).thenReturn(mockListReservasConReservas1);
		when(habitacion4.reservasConFechaMayorA(fechaDeHoy)).thenReturn(mockListReservasVacia);

	}

	@Test
	public void testReservasDentroDeFecha() {
		assertEquals(hotel.reservasDentroDeFecha(fechaDeHoy).size(), 4);
	}
	
	@Test
	public void testReservasConFechaMayorA() {
		assertEquals(hotel.reservasConFechaMayorA(fechaDeHoy).size(), 4);
		verify(habitacion1, atLeastOnce()).reservasConFechaMayorA(fechaDeHoy);
		verify(habitacion2, atLeastOnce()).reservasConFechaMayorA(fechaDeHoy);
		verify(habitacion3, atLeastOnce()).reservasConFechaMayorA(fechaDeHoy);
		verify(habitacion4, atLeastOnce()).reservasConFechaMayorA(fechaDeHoy);
	}

	@Test
	public void testTieneHabitacionQueCumpleCapacidad() {
		assertTrue(hotel.tieneHabitacionQueCumpleCapacidad(4));
	}
	
	@Test
	public void testNombreDeCiudadEsRosario() {
		assertSame("Rosario", hotel.nombreCiudad());
	}
	
	@Test
	public void testAgregarReservaEnHabitacion() {
		hotel.agregarReservaEnHabitacion(habitacion1, nuevaReserva);
		verify(habitacion1).agregarReserva(nuevaReserva);
	}
}
