package mariuTest;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import model.FiltroBusqueda;
import model.FiltroCompuesto;
import model.Habitacion;
import model.Hotel;
import model.Precio;
import model.Rango;
import model.Reserva;

import org.joda.time.DateTime;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import clasesSinTest.Ciudad;
import clasesSinTest.Servicio;
import clasesSinTest.UsuarioPasajero;

public abstract class FiltroBusquedaSetUp {
	
	@Mock protected Hotel hotel1;
	@Mock protected Hotel hotel2;
	@Mock protected Hotel hotel3;
	@Mock protected Habitacion hab1;
	@Mock protected Habitacion hab2;
	@Mock protected Ciudad quilmes;
	@Mock protected Ciudad avellaneda;
	
	//@Mock private Habitacion hab3;
	//@Mock private Habitacion hab4;
	
	protected List<Hotel> resultado;
	protected List<Hotel> listaDeHoteles;
//	
//	private List<Habitacion> listaDeHabitacionesHotel1;
//	private List<Habitacion> listaDeHabitacionesHotel2;
//	
	protected List<FiltroBusqueda> listaDeFiltros;
//	
	protected FiltroBusqueda sutBuscador;
	protected FiltroBusqueda filtroNombreHotel;
	protected FiltroBusqueda filtroCiudadHotel;
//	private FiltroBusqueda filtroCantidadHuespedes;
//	private FiltroBusqueda filtroRango;
//	
//	@Mock private Rango rango;
//	@Mock private Rango otroRango;
//	@Mock private Rango nuevoRango;
//	@Mock private DateTime fechaDesde;
//	@Mock private DateTime fechaHasta;
//	


	
	
	@Before
	public void setUp(){
		
		MockitoAnnotations.initMocks(this);
		this.hotel1 = Mockito.mock(Hotel.class);
		this.hotel2 = Mockito.mock(Hotel.class);
		this.hotel3 = Mockito.mock(Hotel.class);
		
		this.hab1 = Mockito.mock(Habitacion.class);
		this.hab2 = Mockito.mock(Habitacion.class);
		
		this.quilmes = Mockito.mock(Ciudad.class);
		this.avellaneda = Mockito.mock(Ciudad.class);
		
		this.listaDeHoteles = new ArrayList<Hotel>();
		this.resultado = new ArrayList<Hotel>();
		this.listaDeFiltros = new ArrayList<FiltroBusqueda>();
		
		when(this.hotel1.getNombreHotel()).thenReturn("hotel1");
		when(this.hotel2.getNombreHotel()).thenReturn("hotel2");
		
		when(this.hotel1.nombreCiudad()).thenReturn("avellaneda");
		when(this.avellaneda.getNombre()).thenReturn("avellaneda");

		when(this.hotel2.nombreCiudad()).thenReturn("quilmes");
		when(this.quilmes.getNombre()).thenReturn("quilmes");
		
		when(this.hotel3.nombreCiudad()).thenReturn("quilmes");

	}
}