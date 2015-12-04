package modelTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import model.FiltroBusqueda;
import model.FiltroCantidadHuespedes;
import model.FiltroCiudadHotel;
import model.FiltroCompuesto;
import model.FiltroNombreHotel;
import model.FiltroRango;
import model.Habitacion;
import model.Hotel;
import model.Precio;
import model.Reserva;
import model.Servicio;
import model.UsuarioPasajero;


public class FiltroBusquedaTest {
	
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
	
	private DateTime fechaDesde;
	private DateTime fechaHasta;
	
	private UsuarioPasajero pasajero;
	
	@Before
	public void setUp(){
		
		this.pasajero = new UsuarioPasajero(null, null, null, null, 4);
		
		this.hotel1 = new Hotel("AAA", "Quilmes", new ArrayList<Habitacion>(), 
				new ArrayList<Servicio>(), "unaCategoria", new DateTime(), new DateTime());
		
		this.hotel2 = new Hotel("BBB", "Bernal", new ArrayList<Habitacion>(), 
				new ArrayList<Servicio>(), "unaCategoria", new DateTime(), new DateTime());
		
		this.hab1 = new Habitacion(1, "simple", new ArrayList<Servicio>(), 
				new ArrayList<Reserva>(), this.hotel1, new ArrayList<Precio>());
		
		this.hab2 = new Habitacion(2, "simple", new ArrayList<Servicio>(), 
				new ArrayList<Reserva>(), this.hotel1, new ArrayList<Precio>());
		
		this.hab3 = new Habitacion(3, "simple", new ArrayList<Servicio>(), 
				new ArrayList<Reserva>(), this.hotel2, new ArrayList<Precio>());
		
		this.hab4 = new Habitacion(4, "simple", new ArrayList<Servicio>(), 
				new ArrayList<Reserva>(), this.hotel2, new ArrayList<Precio>());

		//se crean reservas en todas las habitaciones para el mismo rango
		this.fechaDesde = new DateTime(2015,9,9,0,0);
		this.fechaHasta = new DateTime(2015,9,30,0,0);		
		this.hab1.reservar(fechaDesde, fechaHasta, this.pasajero);
		this.hab2.reservar(fechaDesde, fechaHasta, this.pasajero);
		this.hab3.reservar(fechaDesde, fechaHasta, this.pasajero);	
		this.hab4.reservar(fechaDesde, fechaHasta, this.pasajero);
		
		//se arman listas de habitaciones
		this.listaDeHabitacionesHotel1 = new ArrayList<Habitacion>();
		this.listaDeHabitacionesHotel1.add(hab1);
		this.listaDeHabitacionesHotel1.add(hab2);
		
		this.listaDeHabitacionesHotel2 = new ArrayList<Habitacion>();
		this.listaDeHabitacionesHotel2.add(hab3);
		this.listaDeHabitacionesHotel2.add(hab4);
		
		//se agregan habitaciones a hoteles
		this.hotel1.setHabitaciones(this.listaDeHabitacionesHotel1);
		this.hotel1.setHabitaciones(this.listaDeHabitacionesHotel2);
		
		this.listaDeHoteles = new ArrayList<Hotel>();
		
		this.listaDeHoteles.add(this.hotel1);
		this.listaDeHoteles.add(this.hotel2);

		this.listaDeFiltros = new ArrayList<FiltroBusqueda>();
		
	}
	
	/**
	 * Busqueda simple SOLO por nombre de hotel
	 */
	@Test
	public void testObtengoHotelPorNombre() {
		
		//se crea y arma la escructura de busqueda
		this.filtroNombreHotel = new FiltroNombreHotel("AAA");
		this.listaDeFiltros.add(this.filtroNombreHotel);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		
		resultado = sutBuscador.buscar(listaDeHoteles);

		assertEquals(1, resultado.size());
		
	}
	
	/**
	 * Busqueda simple SOLO por nombre de ciudad
	 */
	@Test
	public void testObtengoHotelPorCiudad() {
		
		//se crea y arma la escructura de busqueda
		this.filtroCiudadHotel = new FiltroCiudadHotel("Bernal");
		this.listaDeFiltros.add(this.filtroCiudadHotel);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		
		resultado = sutBuscador.buscar(listaDeHoteles);

		assertEquals(1, resultado.size());
		
	}
	
	
	/**
	 * Busqueda simple SOLO por cantidad de huespedes
	 */
	@Test
	public void testObtengoHotelPorCantidadHuespedes() {
		
		//se crea y arma la escructura de busqueda
		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(4);
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		
		resultado = sutBuscador.buscar(listaDeHoteles);

		assertEquals(1, resultado.size());
		
	}

	/**
	 * Busqueda simple SOLO por rango de fechas
	 * Disponibilidad OK
	 */
	@Test
	public void testObtengoHotelPorRango() {
		
		// Rango Consultado
		DateTime fechaDesde = new DateTime(2015,10,10,0,0);
		DateTime fechaHasta = new DateTime(2015,11,11,0,0);
		
		//se crea y arma la escructura de busqueda
		this.filtroRango = new FiltroRango(fechaDesde, fechaHasta);
		this.listaDeFiltros.add(this.filtroRango);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		
		resultado = sutBuscador.buscar(listaDeHoteles);

		assertEquals(1, resultado.size());
		
	}
	
	/**
	 * Busqueda simple SOLO por rango de fechas
	 * Disponibilidad NOK
	 */
	@Test
	public void testObtengoHotelPorRangoNoDisponible() {
		
		// Rango Consultado
		DateTime fechaDesde = new DateTime(2015,9,9,0,0);
		DateTime fechaHasta = new DateTime(2015,9,30,0,0);
		
		//se crea y arma la escructura de busqueda
		this.filtroRango = new FiltroRango(fechaDesde, fechaHasta);
		this.listaDeFiltros.add(this.filtroRango);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		
		resultado = sutBuscador.buscar(listaDeHoteles);

		assertEquals(0, resultado.size());
		
	}

	/**
	 * Busqueda compleja donde utilizo todos los filtros juntos
	 * Disponibilidad NO OK por todas las condiciones
	 */
	@Test
	public void testObtengoHotelTodosLosFiltros() {
		
		// Rango Consultado
		DateTime fechaDesde = new DateTime(2015,9,9,0,0);
		DateTime fechaHasta = new DateTime(2015,9,30,0,0);
		
		//se crea y arma la escructura de busqueda
		this.filtroNombreHotel = new FiltroNombreHotel("CCC");
		this.listaDeFiltros.add(this.filtroNombreHotel);
		
		this.filtroRango = new FiltroRango(fechaDesde, fechaHasta);
		this.listaDeFiltros.add(this.filtroRango);
		
		this.filtroCiudadHotel = new FiltroCiudadHotel("Wilde");
		this.listaDeFiltros.add(this.filtroCiudadHotel);
		
		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(5);
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);

		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		
		resultado = sutBuscador.buscar(listaDeHoteles);

		assertEquals(0, resultado.size());
		
	}
	
	/**
	 * Busqueda compleja donde utilizo todos los filtros juntos
	 * Disponibilidad OK
	 */
	@Test
	public void testObtengoHotelTodosLosFiltrosConDisponibilidad() {
		
		// Rango Consultado
		DateTime fechaDesde = new DateTime(2015,10,10,0,0);
		DateTime fechaHasta = new DateTime(2015,11,11,0,0);
		
		//se crea y arma la escructura de busqueda
		this.filtroNombreHotel = new FiltroNombreHotel("AAA");
		this.listaDeFiltros.add(this.filtroNombreHotel);

		this.filtroRango = new FiltroRango(fechaDesde, fechaHasta);
		this.listaDeFiltros.add(this.filtroRango);

		this.filtroCiudadHotel = new FiltroCiudadHotel("Quilmes");
		this.listaDeFiltros.add(this.filtroCiudadHotel);
		
		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(1);
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);

		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		resultado = sutBuscador.buscar(listaDeHoteles);

		assertEquals(1, resultado.size());
		
	}

	/**
	 * Busqueda compleja donde utilizo todos los filtros juntos
	 * Disponibilidad NO OK solo por una condiciòn
	 */
	@Test
	public void testObtengoHotelTodosLosFiltrosSinDisponibilidad() {
		
		// Rango Consultado
		DateTime fechaDesde = new DateTime(2015,10,10,0,0);
		DateTime fechaHasta = new DateTime(2015,11,11,0,0);
		
		//se crea y arma la escructura de busqueda
		this.filtroNombreHotel = new FiltroNombreHotel("AAA");
		this.listaDeFiltros.add(this.filtroNombreHotel);

		this.filtroRango = new FiltroRango(fechaDesde, fechaHasta);
		this.listaDeFiltros.add(this.filtroRango);

		this.filtroCiudadHotel = new FiltroCiudadHotel("Avellaneda");
		this.listaDeFiltros.add(this.filtroCiudadHotel);
		
		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(1);
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);

		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		resultado = sutBuscador.buscar(listaDeHoteles);

		assertEquals(0, resultado.size());
		
	}
	
}
