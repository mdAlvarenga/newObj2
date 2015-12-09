package marcosTest;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import model.GestorConsulta;
import model.Habitacion;
import model.Hotel;
import model.Rango;
import model.Reserva;
import model.SistemaHotelero;

import org.joda.time.DateTime;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import clasesSinTest.Ciudad;
import clasesSinTest.IServidor;
import clasesSinTest.Usuario;
import clasesSinTest.UsuarioHotelero;
import clasesSinTest.UsuarioPasajero;

public class GestorConsultaSetUp {
	protected GestorConsulta sutGestor;
	protected DateTime fechaDesdeReserva1Agus;
	protected DateTime fechaHastaReserva1Agus;
	protected DateTime fechaDesdeReserva2Agus;
	protected DateTime fechaHastaReserva2Agus;
	protected DateTime fechaDesdeReserva3Agus;
	protected DateTime fechaHastaReserva3Agus;
	protected DateTime fechaDesdeReserva1Mari;
	protected DateTime fechaHastaReserva1Mari;
	protected DateTime fechaDesdeReserva2Mari;
	protected DateTime fechaHastaReserva2Mari;
	
	protected List<Usuario> users;
	protected List<Hotel> listaHoteles;
	protected List<Reserva> listaReservas;
	
	protected ArrayList<Habitacion> habitacionesColonial;
	protected ArrayList<Habitacion> habitacionesIntercontinental;
	protected ArrayList<Habitacion> habitacionesBoca;
	protected ArrayList<Habitacion> habitacionesParis;
	protected ArrayList<Habitacion> habitacionesRosario;
	
	protected ArrayList<Ciudad> ciudadesMariu;
	protected ArrayList<Ciudad> ciudadesAgus;
		
	@Mock protected UsuarioPasajero pasajeroAgustin;
	@Mock protected UsuarioPasajero pasajeraMariu;
	@Mock protected UsuarioHotelero hoteleraGil;
	@Mock protected UsuarioHotelero hoteleroSmith;
	
	@Mock protected Hotel hotelBoca;
	@Mock protected Hotel hotelColonial;
	@Mock protected Hotel hotelIntercontinental;
	@Mock protected Hotel hotelRosario;
	@Mock protected Hotel hotelParis;
	
	@Mock protected Habitacion habitacionBoca1;
	@Mock protected Habitacion habitacionBoca2;
	@Mock protected Habitacion habitacionColonia1;
	@Mock protected Habitacion habitacionColonia2;
	@Mock protected Habitacion habitacionInter1;
	@Mock protected Habitacion habitacionInter2;
	@Mock protected Habitacion habitacionRosario1;
	@Mock protected Habitacion habitacionRosario2;
	@Mock protected Habitacion habitacionParis1;
	@Mock protected Habitacion habitacionParis2;
	
	@Mock protected Ciudad buenosAires;
	@Mock protected Ciudad cordoba;
	@Mock protected Ciudad rosario;
	@Mock protected Ciudad newYork;
	@Mock protected Ciudad paris;
	
	@Mock protected Rango rangoReserva1Agus;
	@Mock protected Rango rangoReserva2Agus;
	@Mock protected Rango rangoReserva3Agus;
	@Mock protected Rango rangoReserva1Mari;
	@Mock protected Rango rangoReserva2Mari;
	
	@Mock protected Reserva resAgus1;
	@Mock protected Reserva resAgus2;
	@Mock protected Reserva resAgus3;
	@Mock protected Reserva resMari1;
	@Mock protected Reserva resMari2;
	@Mock protected Reserva resFutura;
	
	protected List<Reserva> reservasAgusHabBoca1;
	protected ArrayList<Reserva> reservasAgusHabParis1;
	protected ArrayList<Reserva> reservasAgusHabCol1;
	protected ArrayList<Reserva> reservasMariHabParis2;
	protected List<Reserva> reservasMariHabRosario1;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		listaReservas = new ArrayList<Reserva>();
		users = new ArrayList<Usuario>();
		listaHoteles = new ArrayList<Hotel>();
		when(this.hotelBoca.getCiudad()).thenReturn(this.buenosAires);
		when(this.hotelColonial.getCiudad()).thenReturn(this.cordoba);
		when(this.hotelIntercontinental.getCiudad()).thenReturn(this.newYork);
		when(this.hotelParis.getCiudad()).thenReturn(this.paris);
		when(this.hotelRosario.getCiudad()).thenReturn(this.rosario);
	
		fechaDesdeReserva1Agus = new DateTime("2015-05-05"); 
		fechaHastaReserva1Agus = new DateTime("2015-05-10");
		fechaDesdeReserva2Agus = new DateTime("2015-07-14");
		fechaHastaReserva2Agus = new DateTime("2015-07-30");
		fechaDesdeReserva3Agus = new DateTime("2015-08-20");
		fechaHastaReserva3Agus = new DateTime("2015-09-20");
		fechaDesdeReserva1Mari = new DateTime("2015-12-15");
		fechaHastaReserva1Mari = new DateTime("2016-02-15");
		fechaDesdeReserva2Mari = new DateTime("2015-04-15");
		fechaHastaReserva2Mari = new DateTime("2015-05-30");
		
		when(this.rangoReserva1Agus.getFechaDesde()).thenReturn(this.fechaDesdeReserva1Agus);
		when(this.rangoReserva1Agus.getFechaHasta()).thenReturn(this.fechaHastaReserva1Agus);
		when(this.rangoReserva2Agus.getFechaDesde()).thenReturn(this.fechaDesdeReserva2Agus);
		when(this.rangoReserva2Agus.getFechaHasta()).thenReturn(this.fechaHastaReserva2Agus);
		when(this.rangoReserva3Agus.getFechaDesde()).thenReturn(this.fechaDesdeReserva3Agus);
		when(this.rangoReserva3Agus.getFechaHasta()).thenReturn(this.fechaHastaReserva3Agus);
		when(this.rangoReserva1Mari.getFechaDesde()).thenReturn(this.fechaDesdeReserva1Mari);
		when(this.rangoReserva1Mari.getFechaHasta()).thenReturn(this.fechaHastaReserva1Mari);
		when(this.rangoReserva2Mari.getFechaDesde()).thenReturn(this.fechaDesdeReserva2Mari);
		when(this.rangoReserva2Mari.getFechaHasta()).thenReturn(this.fechaHastaReserva2Mari);
		
		when(this.resAgus1.getUsuarioQueReserva()).thenReturn(this.pasajeroAgustin);
		when(this.resAgus2.getUsuarioQueReserva()).thenReturn(this.pasajeroAgustin);
		when(this.resAgus3.getUsuarioQueReserva()).thenReturn(this.pasajeroAgustin);
		when(this.resMari1.getUsuarioQueReserva()).thenReturn(this.pasajeraMariu);
		when(this.resMari2.getUsuarioQueReserva()).thenReturn(this.pasajeraMariu);
		when(this.resFutura.getUsuarioQueReserva()).thenReturn(this.pasajeraMariu);
		DateTime hoy = DateTime.now();
		when(this.resFutura.fechaDeReservaPosteriorA(hoy)).thenReturn(true);
	
		ciudadesAgus = new ArrayList<Ciudad>();
		ciudadesMariu = new ArrayList<Ciudad>();
		
		ciudadesAgus.add(buenosAires);
		ciudadesAgus.add(cordoba);
		ciudadesAgus.add(paris);
		ciudadesMariu.add(paris);
		ciudadesMariu.add(rosario);
		
		habitacionesBoca = new ArrayList<Habitacion>();
		habitacionesColonial = new ArrayList<Habitacion>();
		habitacionesIntercontinental = new ArrayList<Habitacion>();
		habitacionesParis = new ArrayList<Habitacion>();
		habitacionesRosario = new ArrayList<Habitacion>();
		
		habitacionesBoca.add(habitacionBoca1);
		habitacionesBoca.add(habitacionBoca2);
		habitacionesColonial.add(habitacionColonia1);
		habitacionesColonial.add(habitacionColonia2);
		habitacionesIntercontinental.add(habitacionInter1);
		habitacionesIntercontinental.add(habitacionInter2);
		habitacionesParis.add(habitacionParis1);
		habitacionesParis.add(habitacionParis2);
		habitacionesRosario.add(habitacionRosario1);
		habitacionesRosario.add(habitacionRosario2);
		
		reservasAgusHabBoca1 = new ArrayList<Reserva>();
		reservasAgusHabBoca1.add(resAgus2);
		
		reservasAgusHabParis1 = new ArrayList<Reserva>();
		reservasAgusHabParis1.add(resAgus1);
		
		reservasAgusHabCol1 = new ArrayList<Reserva>();
		reservasAgusHabCol1.add(resAgus3);
		
		reservasMariHabRosario1 = new ArrayList<Reserva>();
		reservasMariHabRosario1.add(resMari1);
		
		reservasMariHabParis2 = new ArrayList<Reserva>();
		reservasMariHabParis2.add(resMari2);
		
		when(this.habitacionBoca1.reservasDelUsuario(pasajeroAgustin)).thenReturn(reservasAgusHabBoca1);
		when(this.habitacionParis1.reservasDelUsuario(pasajeroAgustin)).thenReturn(reservasAgusHabParis1);
		when(this.habitacionColonia1.reservasDelUsuario(pasajeroAgustin)).thenReturn(reservasAgusHabCol1);
		when(this.habitacionRosario1.reservasDelUsuario(pasajeraMariu)).thenReturn(reservasMariHabRosario1);
		when(this.habitacionParis2.reservasDelUsuario(pasajeraMariu)).thenReturn(reservasMariHabParis2);
		
		when(this.hotelBoca.getHabitaciones()).thenReturn(this.habitacionesBoca);
		when(this.hotelColonial.getHabitaciones()).thenReturn(this.habitacionesColonial);
		when(this.hotelIntercontinental.getHabitaciones()).thenReturn(this.habitacionesIntercontinental);
		when(this.hotelParis.getHabitaciones()).thenReturn(this.habitacionesParis);
		when(this.hotelRosario.getHabitaciones()).thenReturn(this.habitacionesRosario);
		
		when(this.hotelColonial.getHabitaciones()).thenReturn(this.habitacionesColonial);
		when(this.hotelIntercontinental.getHabitaciones()).thenReturn(this.habitacionesIntercontinental);
		when(this.hotelParis.getHabitaciones()).thenReturn(this.habitacionesParis);
		when(this.hotelRosario.getHabitaciones()).thenReturn(this.habitacionesRosario);
		
		listaReservas.add(resAgus1);
		listaReservas.add(resAgus2);
		listaReservas.add(resAgus3);
		listaReservas.add(resMari1);
		listaReservas.add(resMari2);
		listaReservas.add(resFutura);
		
		listaHoteles.add(hotelBoca);
		listaHoteles.add(hotelColonial);
		listaHoteles.add(hotelIntercontinental);
		listaHoteles.add(hotelParis);
		listaHoteles.add(hotelRosario);
		
		sutGestor = new GestorConsulta(listaReservas, listaHoteles);
	}
}