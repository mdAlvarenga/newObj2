package modelTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import model.Hotel;
import model.Reserva;
import model.UsuarioHotelero;

public class UsuarioHoteleroTest {

	private UsuarioHotelero usuario;
	private Reserva mockReserva1;
	private Reserva mockReserva2;
	private Reserva mockReserva3;
	private Reserva mockReserva4;
	private Hotel mockHotel1;
	private Hotel mockHotel2;
	private DateTime hoy;
	private List<Reserva> listaDeMockReservas1;
	private List<Reserva> listaDeMockReservas2;
	private List<Reserva> listaDeMockReservas3;
	private List<Reserva> listaDeMockReservas4;

	@Before
	public void setUp(){
		
		usuario = new UsuarioHotelero();
		hoy = new DateTime();
		listaDeMockReservas1 = new ArrayList<Reserva>();
		listaDeMockReservas2 = new ArrayList<Reserva>();
		listaDeMockReservas3 = new ArrayList<Reserva>();
		listaDeMockReservas4 = new ArrayList<Reserva>();

		mockReserva1 = Mockito.mock(Reserva.class);
		mockReserva2 = Mockito.mock(Reserva.class);
		mockReserva3 = Mockito.mock(Reserva.class);
		mockReserva4 = Mockito.mock(Reserva.class);
		
		
		listaDeMockReservas1.add(mockReserva1);
		listaDeMockReservas1.add(mockReserva2);
		listaDeMockReservas2.add(mockReserva3);
		listaDeMockReservas2.add(mockReserva4);
		listaDeMockReservas3.add(mockReserva4);

		mockHotel1 = Mockito.mock(Hotel.class);
		when(mockHotel1.reservasDentroDeFecha(hoy)).thenReturn(listaDeMockReservas1);
		when(mockHotel1.reservasConFechaMayorA(hoy)).thenReturn(listaDeMockReservas3);		
		when(mockHotel1.reservasConFechaMayorA(hoy.plusDays(4))).thenReturn(listaDeMockReservas3);
		
		mockHotel2 = Mockito.mock(Hotel.class);
		when(mockHotel2.reservasDentroDeFecha(hoy)).thenReturn(listaDeMockReservas2);
		when(mockHotel2.reservasConFechaMayorA(hoy)).thenReturn(listaDeMockReservas3);		
		when(mockHotel2.reservasConFechaMayorA(hoy.plusDays(4))).thenReturn(listaDeMockReservas4);
		
		usuario.nuevoHotel(mockHotel1);
		usuario.nuevoHotel(mockHotel2);
	}
	
	@Test
	public void testAgregaHotel(){
		
		assertEquals(listaDeMockReservas1.size(), 2);
		assertEquals(listaDeMockReservas2.size(), 2);
		assertEquals(usuario.getHoteles().size(), 2);
	}	
	@Test
	public void testReservasActuales(){
		
		assertEquals(usuario.reservasActuales().size(), 4);
	}
	
	@Test
	public void testReservasFuturas(){
		
		assertEquals(usuario.reservasFuturas().size(), 2);
	}

	@Test
	public void testReservasDentroDeNDiasFuturos(){
		
		assertEquals(usuario.reservasDentroDeNDiasFuturos(4).size(), 1);
	}
	
}
