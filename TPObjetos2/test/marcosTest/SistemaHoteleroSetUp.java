package marcosTest;

import java.util.ArrayList;

import model.FiltroBusqueda;
import model.GestorConsulta;
import model.Habitacion;
import model.Hotel;
import model.Reserva;
import model.SistemaHotelero;
import nadaTesteable.Ciudad;
import nadaTesteable.IServidor;
import nadaTesteable.Usuario;
import nadaTesteable.UsuarioHotelero;
import nadaTesteable.UsuarioPasajero;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public abstract class SistemaHoteleroSetUp {

	protected SistemaHotelero sutSistemaHotelero;
	protected ArrayList<Hotel> listaDeHoteles;
	protected ArrayList<Hotel>listaHotelesPrimerFiltro;
	protected ArrayList<Hotel>listaHotelesSegundoFiltro;
	protected ArrayList<Usuario> listaDeUsuarios;
	protected ArrayList<Reserva> listaDeReservas;
	protected ArrayList<Habitacion> listaHabitacionesPrimerFiltro;
	protected ArrayList<Habitacion> listaHabitacionesSegundoFiltro;
	protected ArrayList<Reserva> primerasReservas;
	protected ArrayList<Reserva> todasReservas;
	protected ArrayList<Reserva> reservasFuturas;
	protected ArrayList<Ciudad> ciudadesVisitoMari;
	protected ArrayList<Reserva> reservasActualesHotelero;
	protected ArrayList<Reserva> reservasFuturasHotelero;
	protected ArrayList<Reserva> reservasFuturasEnNDiasHotelero;
	
	protected @Mock UsuarioPasajero pasajeroMarcos;
	protected @Mock UsuarioPasajero pasajeroAgustin;
	protected @Mock UsuarioPasajero pasajeraMari;
	protected @Mock UsuarioHotelero hoteleroSmith;
	protected @Mock UsuarioHotelero hoteleraGil;
	protected @Mock IServidor servidor;
	protected @Mock Hotel hotelBoca;
	protected @Mock Hotel hotelColonial;
	protected @Mock Hotel hotelSheraton;
	protected @Mock Hotel hotelInternacional;
	protected @Mock Habitacion habitacionBianchi;
	protected @Mock Habitacion habitacionPalermo;
	protected @Mock Habitacion habitacionColonia17;
	protected @Mock Reserva primerReserva;
	protected @Mock Reserva segundaReserva;
	protected @Mock Reserva tercerReserva;
	protected @Mock FiltroBusqueda primerFiltro;
	protected @Mock FiltroBusqueda segundoFiltro;
	protected @Mock Ciudad madrid;
	protected @Mock GestorConsulta gestor;

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
