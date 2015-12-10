package mariuTest;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import clasesPorCompletitud.Ciudad;
import model.FiltroBusqueda;
import model.Habitacion;
import model.Hotel;
import model.Rango;

public abstract class FiltroBusquedaSetUp {
	
	@Mock protected Hotel hotel1;
	@Mock protected Hotel hotel2;
	@Mock protected Hotel hotel3;
	@Mock protected Hotel hotel4;
	@Mock protected Habitacion hab1;
	@Mock protected Habitacion hab2;
	@Mock protected Habitacion hab3;
	@Mock protected Ciudad quilmes;
	@Mock protected Ciudad avellaneda;
	@Mock protected Rango rango;
	@Mock protected Rango otroRango;

	protected List<Hotel> resultado;
	protected List<Habitacion> resultadoHab;
	protected List<Hotel> listaDeHoteles;	
	protected List<Habitacion> listaDeHabitacionesHotel1;
	protected List<Habitacion> listaDeHabitacionesHotel2;

	protected List<FiltroBusqueda> listaDeFiltros;	
	protected FiltroBusqueda sutBuscador;
	protected FiltroBusqueda filtroNombreHotel;
	protected FiltroBusqueda filtroCiudadHotel;
	protected  FiltroBusqueda filtroCantidadHuespedes;
	protected FiltroBusqueda filtroRango;
	
	@Before
	public void setUp(){
		
		MockitoAnnotations.initMocks(this);
		this.hotel1 = Mockito.mock(Hotel.class);
		this.hotel2 = Mockito.mock(Hotel.class);
		this.hotel3 = Mockito.mock(Hotel.class);
		this.hotel4 = Mockito.mock(Hotel.class);
		
		this.hab1 = Mockito.mock(Habitacion.class);
		this.hab2 = Mockito.mock(Habitacion.class);
		
		this.quilmes = Mockito.mock(Ciudad.class);
		this.avellaneda = Mockito.mock(Ciudad.class);
		
		this.rango = Mockito.mock(Rango.class);
		this.otroRango = Mockito.mock(Rango.class);
		
		this.listaDeHoteles = new ArrayList<Hotel>();
		this.resultado = new ArrayList<Hotel>();
		this.listaDeFiltros = new ArrayList<FiltroBusqueda>();
		this.listaDeHabitacionesHotel1 = new ArrayList<Habitacion>() ;
		this.listaDeHabitacionesHotel2 = new ArrayList<Habitacion>() ;
		
		when(this.hotel1.getNombre()).thenReturn("hotel1");
		when(this.hotel2.getNombre()).thenReturn("hotel2");
		
		when(this.hotel1.nombreCiudad()).thenReturn("avellaneda");
		when(this.avellaneda.getNombre()).thenReturn("avellaneda");
		when(this.hotel2.nombreCiudad()).thenReturn("quilmes");
		when(this.quilmes.getNombre()).thenReturn("quilmes");
		when(this.hotel3.nombreCiudad()).thenReturn("quilmes");

		
		when(this.hotel1.tieneHabitacionQueCumpleCapacidad(2)).thenReturn(true);
		when(this.hotel2.tieneHabitacionQueCumpleCapacidad(2)).thenReturn(false);
		when(this.hotel2.tieneHabitacionQueCumpleCapacidad(1)).thenReturn(true);
		when(this.hotel3.tieneHabitacionQueCumpleCapacidad(2)).thenReturn(true);
		when(this.hotel1.getHabitaciones()).thenReturn(this.listaDeHabitacionesHotel1);
		when(this.hab1.getCapacidadMaxima()).thenReturn(2);
		when(this.hab2.getCapacidadMaxima()).thenReturn(3);
		when(this.hab3.getCapacidadMaxima()).thenReturn(1);
		
		when(this.hotel2.getHabitaciones()).thenReturn(this.listaDeHabitacionesHotel2);
		when(this.hab1.disponibilidadPara(this.rango)).thenReturn(true);
		when(this.hab1.disponibilidadPara(this.otroRango)).thenReturn(false);
		when(this.hab2.disponibilidadPara(this.rango)).thenReturn(false);
		when(this.hab3.disponibilidadPara(this.rango)).thenReturn(false);
		
		when(this.hotel4.getNombre()).thenReturn("hotel1");
		when(this.hotel4.nombreCiudad()).thenReturn("avellaneda");
		when(this.hotel4.tieneHabitacionQueCumpleCapacidad(2)).thenReturn(true);
		when(this.hotel4.getHabitaciones()).thenReturn(this.listaDeHabitacionesHotel1);
		
	}
}