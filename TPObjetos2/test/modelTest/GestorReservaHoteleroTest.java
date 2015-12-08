package modelTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import model.Habitacion;
import model.Hotel;
import model.IServidor;
import model.Reserva;
import model.SistemaHotelero;
import model.Usuario;
import model.UsuarioHotelero;
import model.UsuarioPasajero;

public class GestorReservaHoteleroTest {
	
	private SistemaHotelero sh;
	@Mock private UsuarioPasajero felipe;
	@Mock private UsuarioHotelero bruno;
	@Mock private Reserva res1;
	@Mock private Reserva res2;
	@Mock private Hotel hotel1;
	@Mock private Hotel hotel2;
	@Mock private Habitacion habitacion1;
	@Mock private Habitacion habitacion2;
	private List<Reserva> listReservas;
	private List<Hotel> listHotel;
	@Mock private IServidor server;
	private List<Usuario> users;
	private List<Habitacion> listhabitaciones;
	private DateTime hoy;
	private List<Reserva> listReservasConUnicaReserva;
	private List<Reserva> listReservasConUnicaReserva2;

	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
		this.felipe = new UsuarioPasajero(null, null, null, null, 0);
		this.bruno = new UsuarioHotelero(null, null, null, null, null);
		
		this.hotel1 = Mockito.mock(Hotel.class);
		this.hotel2 = Mockito.mock(Hotel.class);
		this.hoy = new DateTime();
		
		this.res1 = Mockito.mock(Reserva.class);
		this.res2 = Mockito.mock(Reserva.class);

		this.listHotel = new ArrayList<Hotel>();
		this.listReservas = new ArrayList<Reserva>();
		this.listReservasConUnicaReserva = new ArrayList<Reserva>();
		this.listReservasConUnicaReserva2 = new ArrayList<Reserva>();
		this.listhabitaciones = new ArrayList<Habitacion>();
		this.users = new ArrayList<Usuario>();
		
		this.users.add(felipe);
		this.users.add(bruno);
		
		this.habitacion1 = Mockito.mock(Habitacion.class);
		this.habitacion2 = Mockito.mock(Habitacion.class);
		this.listhabitaciones.add(habitacion1);
		this.listhabitaciones.add(habitacion2);
				
		this.listHotel.add(hotel1);
		this.listHotel.add(hotel2);
		
		this.listReservas.add(res1);
		this.listReservas.add(res2);
		
		when(hotel1.getHotelero()).thenReturn(this.bruno);
		when(hotel2.getHotelero()).thenReturn(this.bruno);
		
		this.sh = new SistemaHotelero(listHotel, users, listReservas, server);

	}

	// ADMINISTRACION DE Hoteleros --------------------------------------------------
	@Test
	public void cuandoUsuarioHoteleroPideSusReservasActuales(){
		
		this.listReservasConUnicaReserva.add(this.res2);
		when(hotel1.reservasDentroDeFecha(hoy)).thenReturn(this.listReservasConUnicaReserva);
		
		assertEquals(this.sh.todasReservasActualesDeHotelero(this.bruno).size(),1);
	}
	
	@Test
	public void cuandoUsuarioHoteleroPideReservasFuturas(){
		
		this.listReservasConUnicaReserva2.add(res1);
		when(hotel2.reservasConFechaMayorA(hoy)).thenReturn(this.listReservasConUnicaReserva2);
		
		assertEquals(this.sh.ReservasFuturasDeHotelero(this.bruno).size(),1);
	}

	@Test
	public void cuandoUsuarioHoteleroPideReservasInicioEnNFuturosDias(){
		
		DateTime fechaFutura = new DateTime();
		fechaFutura.plusDays(3);
		
		this.listReservasConUnicaReserva2.add(res1);
		when(hotel2.reservasConFechaMayorA(fechaFutura)).thenReturn(this.listReservasConUnicaReserva2);
		
		assertEquals(this.sh.ReservasInicioEnNFuturosDiasHotelero(this.bruno, 3).size(),1);
		
	}
}
