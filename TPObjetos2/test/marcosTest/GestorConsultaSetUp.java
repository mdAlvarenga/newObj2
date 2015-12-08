package marcosTest;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import model.GestorConsulta;
import model.Habitacion;
import model.Hotel;
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
	private GestorConsulta gestor;
	@Mock private UsuarioPasajero pasajeroAgustin;
	@Mock private UsuarioPasajero pasajeraMariu;
	@Mock private UsuarioHotelero hoteleraGil;
	@Mock private UsuarioHotelero hoteleroSmith;
	@Mock private Reserva res1;
	@Mock private Reserva res2;
	@Mock private Hotel hotelBoca;
	@Mock private Hotel hotelColonial;
	@Mock private Habitacion habitacionTevez;
	@Mock private Habitacion habitacionColonia23;
	@Mock private Ciudad puntaCana;
	@Mock private Ciudad florianopolis;
	@Mock private List<Usuario> users;
	@Mock private List<Ciudad> listCiudades;
	
	@Mock private List<Hotel> listaHoteles;
	
	@Mock private List<Reserva> listaReservas;
	
	@Mock private ArrayList<Habitacion> listhabitaciones;

	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
		gestor = new GestorConsulta(listaReservas, listaHoteles);
	}
}
