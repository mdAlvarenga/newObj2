package marcosTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import noBorrarAun.*;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import clasesSinTest.Ciudad;
import clasesSinTest.IServidor;
import clasesSinTest.Servicio;
import clasesSinTest.Usuario;
import clasesSinTest.UsuarioHotelero;
import clasesSinTest.UsuarioPasajero;
import model.FiltroBusqueda;
import model.GestorConsulta;
import model.Habitacion;
import model.Hotel;
import model.Precio;
import model.Rango;
import model.Reserva;
import model.SistemaHotelero;

//////////////////////////////
//import model.SistemaHotelero;
public class SistemaHoteleroTest {

	private SistemaHotelero sutSistemaHotelero;
	private ArrayList<Habitacion> listaDeHabitacionesHotelBoca;
	private ArrayList<Habitacion>  listaDeHabitacionesHotelColonial;
	private DateTime desdeMarzo2015;
	private DateTime hastaMarzo2015;
	private DateTime desdeJunio2015;
	private DateTime hastaJunio2015;
	private Rango rangoMarzo;
	private Rango rangoJunio;
	private ArrayList<Hotel> listaDeHoteles;
	private ArrayList<Hotel>listaHotelesPrimerFiltro;
	private ArrayList<Hotel>listaHotelesSegundoFiltro;
	private ArrayList<Usuario> listaDeUsuarios;
	private ArrayList<Reserva> listaDeReservas;
	private ArrayList<Habitacion> listaHabitacionesPrimerFiltro;
	private ArrayList<Habitacion> listaHabitacionesSegundoFiltro;
	private ArrayList<Reserva> primerasReservas;
	private ArrayList<Reserva> todasReservas;
	private ArrayList<Reserva> reservasFuturas;
	private ArrayList<Ciudad> ciudadesVisitoMari;
	
	@Mock UsuarioPasajero pasajeroMarcos;
	@Mock UsuarioPasajero pasajeroAgustin;
	@Mock UsuarioPasajero pasajeraMari;
	@Mock UsuarioHotelero unUsuarioHoteleto;
	@Mock UsuarioHotelero otroUsuarioHoteleto;
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
	    
		desdeMarzo2015 = new DateTime("2015-03-02");
		hastaMarzo2015 = new DateTime("2015-03-15");
		desdeJunio2015 = new DateTime("2015-06-16");
		hastaJunio2015 = new DateTime("2015-06-30");
		rangoMarzo = new Rango(desdeMarzo2015, hastaMarzo2015);
		rangoJunio = new Rango(desdeJunio2015, hastaJunio2015);
		
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
		
		
		//sutSistemaHotelero = new SistemaHotelero(listaDeHoteles, listaDeUsuarios, listaDeReservas, servidor);
		sutSistemaHotelero = new SistemaHotelero(listaDeUsuarios, gestor);
		
		//hotelBoca = Mockito.mock(Hotel.class);
		
		//verify(mockedList, times(2)).add("twice");
		
	}
	
	@Test
	public void cuandoReservo() {	
		when(gestor.todasReservasFuturasDePasajero(pasajeroAgustin)).thenReturn(reservasFuturas);
		assertEquals(sutSistemaHotelero.todasReservasFuturasDePasajero(pasajeroAgustin),reservasFuturas);
	}
	
	@Test
	public void cuandoPidoTodasReservasFuturasDeAgusMeRetornaReservasFuturas() {	
		when(gestor.todasReservasFuturasDePasajero(pasajeroAgustin)).thenReturn(reservasFuturas);
		assertEquals(sutSistemaHotelero.todasReservasFuturasDePasajero(pasajeroAgustin),reservasFuturas);
	}
	
	@Test
	public void cuandoPidoTodasLasCiudadesDondeReservoMariMeRetornaCiudadesVisitoMari() {	
		when(gestor.ciudadesDondePasajeroTieneReserva(pasajeraMari)).thenReturn(ciudadesVisitoMari);
		assertEquals(sutSistemaHotelero.ciudadesConReservaDePasajero(pasajeraMari),ciudadesVisitoMari);
	}
	
	@Test
	public void cuandoPidoTodasReservasDeUsuarioMeRetornaTodasReservas() {	
		when(gestor.todasReservasDePasajero(pasajeraMari)).thenReturn(todasReservas);
		assertEquals(sutSistemaHotelero.todasReservasDePasajero(pasajeraMari),todasReservas);
	}
	
	@Test
	public void cuandoBuscoReservasDeUsuarioPorCiudadMeRetornaPrimerasReservas() {	
		when(gestor.reservaDePasajeroParaCiudad(pasajeroAgustin, madrid)).thenReturn(primerasReservas);
		assertEquals(sutSistemaHotelero.reservaDePasajeroParaCiudad(pasajeroAgustin, madrid),primerasReservas);
	}
	
	
	@Test
	public void cuandoBuscoHabitacionesEnLosHotelesFiltradosDelPrimerFiltroMeRetornaListaHabitaciones1() {	
		when(primerFiltro.buscarHabitaciones(hotelBoca)).thenReturn(listaHabitacionesPrimerFiltro);
		assertEquals(sutSistemaHotelero.filtrarHabitaciones(primerFiltro, hotelBoca),listaHabitacionesPrimerFiltro);
	}
	
	@Test
	public void cuandoBuscoHabitacionesEnLosHotelesDelSegundoFiltroMeRetornaListaHabitaciones2() {
		when(segundoFiltro.buscarHabitaciones(hotelColonial)).thenReturn(listaHabitacionesSegundoFiltro);
		assertEquals(sutSistemaHotelero
						.filtrarHabitaciones(segundoFiltro,hotelColonial),listaHabitacionesSegundoFiltro);
	}
	
	@Test
	public void cuandoBuscoHotelesConElSegundoFiltroRetornaLista2() {
		when(segundoFiltro.buscar(listaDeHoteles)).thenReturn(listaHotelesSegundoFiltro);
		when(gestor.getHoteles()).thenReturn(listaDeHoteles);	
		assertEquals(sutSistemaHotelero.buscarHotelesPorFiltros(segundoFiltro),listaHotelesSegundoFiltro);
	}
	
	@Test
	public void cuandoBuscoHotelesConElPrimerFiltroRetornaLista1() {
		when(primerFiltro.buscar(listaDeHoteles)).thenReturn(listaHotelesPrimerFiltro);
		when(gestor.getHoteles()).thenReturn(listaDeHoteles);
		assertEquals(sutSistemaHotelero.buscarHotelesPorFiltros(primerFiltro),listaHotelesPrimerFiltro);
	}
	
	@Test
	public void cuandoPidoElSizeDeLaListaDeReservasMeRetorna2() {
		when(gestor.getReservas()).thenReturn(listaDeReservas);
		assertEquals(sutSistemaHotelero.getGestor().getReservas().size(),2);
	}
	
	@Test
	public void cuandoAgregoUnaReservaElSizeDeLaListaDeReservasMeRetorna3() {
		sutSistemaHotelero.agregarReserva(tercerReserva);
		verify(gestor).agregarReserva(tercerReserva);
	}

	@Test
	public void cuandoPidoElSizeDeLaListaDeHotelesMeRetorna1() {
		when(gestor.getHoteles()).thenReturn(listaDeHoteles);
		assertEquals(sutSistemaHotelero.getGestor().getHoteles().size(),1);
	}
	
	@Test
	public void cuandoAgregoUnHotelElSizeDeLaListaDeHotelesMeRetorna2() {
		sutSistemaHotelero.agregarHotel(hotelBoca);
		verify(gestor).agregarHotel(hotelBoca);
	}
	
	@Test
	public void cuandoPidoElSizeDeLaListaDeUsuariosMeRetorna2() {
		assertEquals(sutSistemaHotelero.getListaDeUsuarios().size(),2);
	}
	
	@Test
	public void cuandoAgregoUnUsuarioElSizeDeLaListaDeUsuariosMeRetorna3() {
		sutSistemaHotelero.agregarUsuario(pasajeroMarcos);
		assertEquals(sutSistemaHotelero.getListaDeUsuarios().size(),3);
	}

	/*@Test
	public void enviarCorreoTest() {
		fail("Not yet implemented");
	}*/

}
