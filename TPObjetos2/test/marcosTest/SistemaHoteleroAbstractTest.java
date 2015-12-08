package marcosTest;

import java.util.ArrayList;
import model.FiltroBusqueda;
import model.GestorConsulta;
import model.Habitacion;
import model.Hotel;
import model.Rango;
import model.Reserva;
import model.SistemaHotelero;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import clasesSinTest.Ciudad;
import clasesSinTest.IServidor;
import clasesSinTest.Usuario;
import clasesSinTest.UsuarioHotelero;
import clasesSinTest.UsuarioPasajero;

public abstract class SistemaHoteleroAbstractTest {

	SistemaHotelero sutSistemaHotelero;
	ArrayList<Hotel> listaDeHoteles;
	ArrayList<Hotel>listaHotelesPrimerFiltro;
	ArrayList<Hotel>listaHotelesSegundoFiltro;
	ArrayList<Usuario> listaDeUsuarios;
	ArrayList<Reserva> listaDeReservas;
	ArrayList<Habitacion> listaHabitacionesPrimerFiltro;
	ArrayList<Habitacion> listaHabitacionesSegundoFiltro;
	ArrayList<Reserva> primerasReservas;
	ArrayList<Reserva> todasReservas;
	ArrayList<Reserva> reservasFuturas;
	ArrayList<Ciudad> ciudadesVisitoMari;
	ArrayList<Reserva> reservasActualesHotelero;
	ArrayList<Reserva> reservasFuturasHotelero;
	ArrayList<Reserva> reservasFuturasEnNDiasHotelero;
	
	@Mock UsuarioPasajero pasajeroMarcos;
	@Mock UsuarioPasajero pasajeroAgustin;
	@Mock UsuarioPasajero pasajeraMari;
	@Mock UsuarioHotelero hoteleroSmith;
	@Mock UsuarioHotelero hoteleraGil;
	@Mock Rango unRango;
	@Mock IServidor servidor;
	@Mock Hotel hotelBoca;
	@Mock Hotel hotelColonial;
	@Mock Hotel hotelSheraton;
	@Mock Hotel hotelInternacional;
	@Mock Hotel h;
	@Mock Habitacion habitacionBianchi;
	@Mock Habitacion habitacionTevez;
	@Mock Habitacion habitacionPalermo;
	@Mock Habitacion habitacionColonia10;
	@Mock Habitacion habitacionColonia17;
	@Mock Habitacion habitacionColonia20;
	@Mock Reserva primerReserva;
	@Mock Reserva segundaReserva;
	@Mock Reserva tercerReserva;
	@Mock FiltroBusqueda primerFiltro;
	@Mock FiltroBusqueda segundoFiltro;
	@Mock Ciudad madrid;
	@Mock Ciudad paris;
	@Mock Ciudad rosario;
	
	@Mock GestorConsulta gestor;

	@Before
	public void setUp(){
	    MockitoAnnotations.initMocks(this);
	    		
		listaDeReservas = new ArrayList<Reserva>();
		listaDeReservas.add(primerReserva);
		listaDeReservas.add(segundaReserva);
		
		listaDeHoteles = new ArrayList<Hotel>();
		listaDeHoteles.add(hotelBoca);
		
		listaHotelesPrimerFiltro = new ArrayList<Hotel>();
		listaHotelesPrimerFiltro.add(hotelBoca);
		listaHotelesPrimerFiltro.add(hotelInternacional);
		
		listaHotelesSegundoFiltro = new ArrayList<Hotel>();
		listaHotelesSegundoFiltro.add(hotelSheraton);
		
		listaDeUsuarios = new ArrayList<Usuario>();
		listaDeUsuarios.add(pasajeraMari);
		listaDeUsuarios.add(pasajeroAgustin);

		listaHabitacionesPrimerFiltro = new ArrayList<Habitacion>();
		listaHabitacionesPrimerFiltro.add(habitacionBianchi);
		listaHabitacionesPrimerFiltro.add(habitacionPalermo);
		
		listaHabitacionesSegundoFiltro = new ArrayList<Habitacion>();
		listaHabitacionesSegundoFiltro.add(habitacionColonia17);
		
		primerasReservas = new ArrayList<Reserva>();
		todasReservas = new ArrayList<Reserva>();
		reservasFuturas = new ArrayList<Reserva>();
		ciudadesVisitoMari = new ArrayList<Ciudad>();
		
		reservasActualesHotelero = new ArrayList<Reserva>();
		reservasFuturasHotelero = new ArrayList<Reserva>();
		reservasFuturasEnNDiasHotelero = new ArrayList<Reserva>();
		
		sutSistemaHotelero = new SistemaHotelero(listaDeUsuarios, gestor);
		
	}
}
