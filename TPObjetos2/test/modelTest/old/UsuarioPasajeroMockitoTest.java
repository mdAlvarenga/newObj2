package modelTest.old;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import model.Habitacion;
import model.Reserva;
import model.UsuarioPasajero;


public class UsuarioPasajeroMockitoTest {

	private UsuarioPasajero usuario;
	private String unaCiudad;
	private Habitacion mockHabitacion1;
	private Habitacion mockHabitacion2;
	private Reserva mockReserva1;
	private Reserva mockReserva3;
	private Reserva mockReserva2;
	private Reserva mockReserva4;

	@Before
	public void setUp(){
		
		usuario = new UsuarioPasajero(unaCiudad, unaCiudad, unaCiudad, unaCiudad, 0);
		unaCiudad = "UnaCiudad";
		
		List<Reserva> listaDeMockReservas1 = new ArrayList<Reserva>();
		List<Reserva> listaDeMockReservas2 = new ArrayList<Reserva>();
		List<Reserva> listaDeMockReservas3 = new ArrayList<Reserva>();
		List<Reserva> listaDeMockReservas4 = new ArrayList<Reserva>();

		mockReserva1 = Mockito.mock(Reserva.class);
		mockReserva2 = Mockito.mock(Reserva.class);
		mockReserva3 = Mockito.mock(Reserva.class);
		mockReserva4 = Mockito.mock(Reserva.class);
		
		
		listaDeMockReservas1.add(mockReserva1);
		listaDeMockReservas1.add(mockReserva2);
		listaDeMockReservas2.add(mockReserva3);
		listaDeMockReservas2.add(mockReserva4);
		listaDeMockReservas3.add(mockReserva4);
		
		mockHabitacion1 = Mockito.mock(Habitacion.class);
		when(mockHabitacion1.reservasDelUsuario(usuario)).thenReturn(listaDeMockReservas1);
		when(mockHabitacion1.reservasFuturasDelUsuario(usuario)).thenReturn(listaDeMockReservas1);
		when(mockHabitacion1.reservasDeUnaCiudadDelUsuario(unaCiudad, usuario)).thenReturn(listaDeMockReservas3);
		when(mockHabitacion1.ciudadDelHotelDondeEstas()).thenReturn("BUENOS_AIRES");
		
		mockHabitacion2 = Mockito.mock(Habitacion.class);
		when(mockHabitacion2.reservasDelUsuario(usuario)).thenReturn(listaDeMockReservas2);
		when(mockHabitacion2.reservasFuturasDelUsuario(usuario)).thenReturn(listaDeMockReservas4);
		when(mockHabitacion2.reservasDeUnaCiudadDelUsuario(unaCiudad, usuario)).thenReturn(listaDeMockReservas4);
		when(mockHabitacion2.ciudadDelHotelDondeEstas()).thenReturn("QUILMES");
		
		usuario.agregarHabitacionReservada(mockHabitacion1);
		usuario.agregarHabitacionReservada(mockHabitacion2);
		
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
		
		assertEquals(usuario.reservasDeUnaCiudad(unaCiudad).size(), 1);
	}

	@Test
	public void testCiudadesEnLasQueTieneReservasUnUsuario(){
		
		assertEquals(usuario.ciudadesConReserva().size(),2);
	}
	
	@Test
	public void testUsuarioCancelaReserva(){
		
		usuario.cancelarReserva(mockReserva1);
		verify(mockHabitacion2, times(1)).cancelaSiPodes(mockReserva1);
		verify(mockHabitacion1, times(1)).cancelaSiPodes(mockReserva1);
	}
	
	// FALTA LA MODIFICACION DE LA RESERVA
}
