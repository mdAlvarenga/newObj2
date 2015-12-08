package mariuTest;

import java.util.ArrayList;
import java.util.List;

import model.FiltroBusqueda;
import model.Habitacion;
import model.Hotel;
import model.Precio;
import model.Rango;
import model.Reserva;

import org.joda.time.DateTime;
import org.junit.Before;

import clasesSinTest.Ciudad;
import clasesSinTest.Servicio;
import clasesSinTest.UsuarioPasajero;

public class FiltroBusquedaSetUp {
	private FiltroBusqueda sutBuscador;
	private Hotel hotel1;
	private Hotel hotel2;
	private Habitacion hab1;
	private Habitacion hab2;
	private Habitacion hab3;
	private Habitacion hab4;
	
	private List<Hotel> resultado;
	private List<Hotel> listaDeHoteles;
	
	private List<Habitacion> listaDeHabitacionesHotel1;
	private List<Habitacion> listaDeHabitacionesHotel2;
	
	private List<FiltroBusqueda> listaDeFiltros;
	
	private FiltroBusqueda filtroNombreHotel;
	private FiltroBusqueda filtroCiudadHotel;
	private FiltroBusqueda filtroCantidadHuespedes;
	private FiltroBusqueda filtroRango;
	
	private Rango rango;
	private DateTime fechaDesde;
	private DateTime fechaHasta;
	
	private UsuarioPasajero pasajero;
	private Ciudad quilmes;
	private Ciudad bernal;
	private Ciudad wilde;
	private Ciudad avellaneda;
	private Rango otroRango;
	private Rango nuevoRango;
	private Rango qRango;
	private Rango eRango;
	private Rango wRango;
	@Before
	public void setUp(){
		
	}
}
