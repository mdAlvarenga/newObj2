package noBorrarAunTest;

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

import clasesSinTest.Ciudad;
import clasesSinTest.IServidor;
import clasesSinTest.Usuario;
import clasesSinTest.UsuarioPasajero;
import model.GestorConsulta;
import model.Habitacion;
import model.Hotel;
import model.Reserva;
import model.SistemaHotelero;

public class GestorReservaPasajeroTest {
	
	private SistemaHotelero sh;
	@Mock private UsuarioPasajero felipe;
	@Mock private Reserva res1;
	@Mock private Reserva res2;
	@Mock private Hotel hotel1;
	@Mock private Hotel hotel2;
	@Mock private Habitacion habitacion1;
	@Mock private Habitacion habitacion2;
	@Mock private List<Reserva> listReservas;
	@Mock private List<Hotel> listHotel;
	@Mock private Ciudad puntaCana;
	@Mock private Ciudad florianopolis;
	@Mock private IServidor server;
	@Mock private List<Usuario> users;
	@Mock private List<Ciudad> listCiudades;
	@Mock private ArrayList<Habitacion> listhabitaciones;
	private DateTime hoy;

	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
		this.felipe = new UsuarioPasajero(null, null, null, null, 0);
		this.puntaCana = new Ciudad("PuntaCana", "RepublicaDominicana");
		this.florianopolis = new Ciudad("florianopolis", "Brasil");
		
		this.hotel1 = Mockito.mock(Hotel.class);
		when(hotel1.getCiudad()).thenReturn(this.puntaCana);
		
		this.hotel2 = Mockito.mock(Hotel.class);
		when(hotel2.getCiudad()).thenReturn(this.florianopolis);
		
		this.hoy = new DateTime();
		
		this.res1 = Mockito.mock(Reserva.class);
		when(this.res1.getUsuarioQueReserva()).thenReturn(felipe);
		when(this.res1.fechaDeReservaPosteriorA(hoy)).thenReturn(true);

		this.res2 = Mockito.mock(Reserva.class);
		when(this.res2.getUsuarioQueReserva()).thenReturn(felipe);
		when(this.res2.fechaDeReservaPosteriorA(hoy)).thenReturn(false);
		
		this.listHotel = new ArrayList<Hotel>();
		this.listReservas = new ArrayList<Reserva>();
		this.listCiudades = new ArrayList<Ciudad>();
		this.listhabitaciones = new ArrayList<Habitacion>();
		this.users = new ArrayList<Usuario>();
		
		this.users.add(felipe);
		
		this.habitacion1 = Mockito.mock(Habitacion.class);
		this.habitacion2 = Mockito.mock(Habitacion.class);
		this.listhabitaciones.add(habitacion1);
		this.listhabitaciones.add(habitacion2);
		
		when(hotel1.getHabitaciones()).thenReturn(this.listhabitaciones);
		when(hotel2.getHabitaciones()).thenReturn(this.listhabitaciones);
		
		this.listHotel.add(hotel1);
		this.listHotel.add(hotel2);
		
		this.listReservas.add(res1);
		this.listReservas.add(res2);
		
		this.listCiudades.add(puntaCana);
		this.listCiudades.add(florianopolis);
		
		
		when(habitacion1.reservasDelUsuario(this.felipe)).thenReturn(this.listReservas);
		GestorConsulta gestor = Mockito.mock(GestorConsulta.class);
		 
		this.sh = new SistemaHotelero(users, gestor);

	}

	// ADMINISTRACION DE PASAJEROS ---------------------------------------------------------
	@Test
	public void cuandoUsuarioPasajeroPideTodasSusReservas(){

		assertEquals(this.sh.todasReservasDePasajero(this.felipe),this.listReservas);
		assertEquals(this.sh.todasReservasDePasajero(this.felipe).size(),2);

	}
	
	@Test
	public void cuandoUsuarioPasajeroPideReservasFuturas(){
		assertEquals(this.sh.todasReservasFuturasDePasajero(this.felipe).size(),1);
	}
	
	@Test
	public void cuandoUsuarioPasajeroPideReservasENnUnaCiudadParticular(){
		List<Reserva> res = new ArrayList<Reserva>();
		res.add(res1);
		res.add(res2);
		assertEquals(this.sh.reservaDePasajeroParaCiudad(this.felipe, this.puntaCana),res);
	}

	@Test
	public void cuandoUsuarioPasajeroPideCiudadesDeSusReservas(){
		assertEquals(this.sh.ciudadesConReservaDePasajero(felipe),this.listCiudades);
	}


}
