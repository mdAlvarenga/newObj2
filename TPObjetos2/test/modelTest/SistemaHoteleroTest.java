package modelTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import model.FiltroBusqueda;
import model.FiltroNombreHotel;
import model.Habitacion;
import model.Hotel;
import model.IServidor;
import model.Precio;
import model.Rango;
import model.Reserva;
import model.Servicio;
import model.SistemaHotelero;
import model.SistemaHoteleroAntesDeTDD;
import model.Usuario;
import model.UsuarioHotelero;
import model.UsuarioPasajero;

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

		sutSistemaHotelero = new SistemaHotelero(listaDeHoteles, listaDeUsuarios, listaDeReservas, servidor);
		
		//when(sutSistemaHotelero.getUsuarios().size()).thenReturn(2);
		//when(habitacionBianchi.getCapacidadMaxima()).thenReturn(2);
		when(primerFiltro.buscar(listaDeHoteles)).thenReturn(listaHotelesPrimerFiltro);
		
	}
	
	@Test
	public void nuevo() {
		assertEquals(sutSistemaHotelero.buscarHotelesPorFiltros(primerFiltro),listaHotelesPrimerFiltro);
	}
	
	/////////////////////////////////////////////////////
	@Test
	public void cuandoBuscoHotelesConElPrimerFiltroRetornaLista1() {
		assertEquals(sutSistemaHotelero.buscarHotelesPorFiltros(primerFiltro),listaHotelesPrimerFiltro);
	}
	
	@Test
	public void cuandoPidoElSizeDeLaListaDeReservasMeRetorna2() {
		assertEquals(sutSistemaHotelero.getListaDeReservas().size(),2);
	}
	
	@Test
	public void cuandoAgregoUnaReservaElSizeDeLaListaDeReservasMeRetorna3() {
		sutSistemaHotelero.agregarReserva(tercerReserva);
		assertEquals(sutSistemaHotelero.getListaDeReservas().size(),3);
	}

	@Test
	public void cuandoPidoElSizeDeLaListaDeHotelesMeRetorna1() {
		assertEquals(sutSistemaHotelero.getListaDeHoteles().size(),1);
	}
	
	@Test
	public void cuandoAgregoUnHotelElSizeDeLaListaDeHotelesMeRetorna2() {
		sutSistemaHotelero.agregarHotel(hotelBoca);
		assertEquals(sutSistemaHotelero.getListaDeHoteles().size(),2);
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
	public void agregarHotelTest() {
		this.sh.agregarHotel(hotel2);
		assertEquals(this.sh.getHoteles().size(),2);
	}

	@Test
	public void buscarHotelesFiltradosTest() {
		this.filtroNombreHotel = new FiltroNombreHotel("AAA");
		assertEquals(this.sh.buscarHotelesFiltrados(this.filtroNombreHotel).size(),1);
		
	}
	

	@Test
	public void buscarHabitacionesFiltradasTest() {
		
		this.filtroNombreHotel = new FiltroNombreHotel("AAA");
		assertEquals(this.sh.buscarHabitacionesFiltradas(this.filtroNombreHotel,this.listaDeHoteles).size(),1);

	}
	
	@Test
	public void reservarTest() {
		
		// el pasajero 1 tiene 2 reservas
		assertEquals(this.pasajero1.todasLasReservas().size(),2);
		
		//el mismo usuario realiza otra reserva
		DateTime fechaDesde = new DateTime(2016,10,9,0,0);
		DateTime fechaHasta = new DateTime(2016,10,30,0,0);	
		Rango rango = new Rango(fechaDesde, fechaHasta);
		this.hab1.reservar(rango, this.pasajero1);
		
		// ahora deberia tener 3 reservas
		assertEquals(this.pasajero1.todasLasReservas().size(),3);
	}

	@Test
	public void enviarCorreoTest() {
		fail("Not yet implemented");
	}*/

	/*
	 * listaDeHabitacionesHotelBoca = new ArrayList<Habitacion>();
		listaDeHabitacionesHotelColonial = new ArrayList<Habitacion>();
		
		listaDeHabitacionesHotelBoca.add(habitacionBianchi);
		listaDeHabitacionesHotelBoca.add(habitacionPalermo);
		listaDeHabitacionesHotelBoca.add(habitacionTevez);
		listaDeHabitacionesHotelColonial.add(habitacionColonia10);
		listaDeHabitacionesHotelColonial.add(habitacionColonia17);
		listaDeHabitacionesHotelColonial.add(habitacionColonia20);

	 */
}
