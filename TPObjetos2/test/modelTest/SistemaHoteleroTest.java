package modelTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import model.FiltroBusqueda;
import model.FiltroNombreHotel;
import model.Habitacion;
import model.Hotel;
import model.Precio;
import model.Rango;
import model.Reserva;
import model.Servicio;
import model.SistemaHotelero;
import model.Usuario;
import model.UsuarioPasajero;

public class SistemaHoteleroTest {

	private SistemaHotelero sh;
	private Hotel hotel1;
	private Hotel hotel2;
	private Habitacion hab1;
	private Habitacion hab2;
	private Habitacion hab3;
	private Habitacion hab4;
	
	private UsuarioPasajero pasajero1;
	private UsuarioPasajero pasajero2;
	
	private DateTime fechaDesde;
	private DateTime fechaHasta;
	private ArrayList<Habitacion> listaDeHabitacionesHotel1;
	private ArrayList<Habitacion>  listaDeHabitacionesHotel2;
	private ArrayList<Hotel> listaDeHoteles;
	private FiltroBusqueda filtroNombreHotel;
	
	private Rango rangoConsultado;

	@Before
	public void setUp() throws Exception {
		
		this.pasajero1 = new UsuarioPasajero(null, null, null, null, 4);
		this.pasajero2 = new UsuarioPasajero(null, null, null, null, 4);
				
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
		this.rangoConsultado = new Rango(fechaDesde, fechaHasta);
		this.hab1.reservar(this.rangoConsultado, this.pasajero1);
		this.hab2.reservar(this.rangoConsultado, this.pasajero2);
		this.hab3.reservar(this.rangoConsultado, this.pasajero1);	
		this.hab4.reservar(this.rangoConsultado, this.pasajero2);
		
		//se arman listas de habitaciones
		this.listaDeHabitacionesHotel1 = new ArrayList<Habitacion>();
		this.listaDeHabitacionesHotel1.add(hab1);
		this.listaDeHabitacionesHotel1.add(hab2);
		
		this.listaDeHabitacionesHotel2 = new ArrayList<Habitacion>();
		this.listaDeHabitacionesHotel2.add(hab3);
		this.listaDeHabitacionesHotel2.add(hab4);
		
		//se agregan habitaciones a hoteles
		this.hotel1.setHabitaciones(this.listaDeHabitacionesHotel1);
		this.hotel2.setHabitaciones(this.listaDeHabitacionesHotel2);
		
		this.listaDeHoteles = new ArrayList<Hotel>();
		
		this.listaDeHoteles.add(this.hotel1);
		this.listaDeHoteles.add(this.hotel2);	
		
		this.sh = new SistemaHotelero(new ArrayList<Hotel>(), new ArrayList<Usuario>(), null);
		this.sh.agregarHotel(this.hotel1);
		this.sh.agregarUsuario(this.pasajero1);

	}

	@Test
	public void agregarUsuarioTest() {
		this.sh.agregarUsuario(pasajero2);
		assertEquals(this.sh.getUsuarios().size(),2);
		
	}
	
	@Test
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
	}

}
