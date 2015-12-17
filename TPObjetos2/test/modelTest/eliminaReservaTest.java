package modelTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import model.Categoria;
import model.GestorConsulta;
import model.Habitacion;
import model.Hotel;
import model.IFormaDePago;
import model.Precio;
import model.Rango;
import model.Reserva;
import model.Servicio;
import model.Telefono;
import model.UsuarioHotelero;
import model.UsuarioPasajero;

public class eliminaReservaTest{
	
	private Hotel unHotel;
	private Habitacion unaHabitacion;
	private Reserva unaReserva;
	private GestorConsulta gestor;
	
	private List<Hotel> listaHoteles;
	private List<Reserva> listaReserva;
	private List<Habitacion> listahabitaciones;

	// Se testea la eliminacion de reserva. Se utiliza integramente TDD
	
	@Before
	public void setUp() throws Exception {

		this.unaReserva = new Reserva(new Rango(null, null), 
				null, 
				new UsuarioPasajero(null, null, null, new Telefono(null, null, null, null), 0));
		
		this.listaReserva = new ArrayList<Reserva>();
		this.listaReserva.add(this.unaReserva);
		
		this.unaHabitacion = new Habitacion(null, 0, null, new ArrayList<Servicio>(), 
				this.listaReserva, new ArrayList<Precio>(), null);
		
		this.listahabitaciones = new ArrayList<Habitacion>();
		this.listahabitaciones.add(this.unaHabitacion);
		
		this.unHotel = new Hotel(null, null, this.listahabitaciones, new ArrayList<Servicio>(), 
				new Categoria(new Integer(1)), new DateTime(), new DateTime(), 
				new UsuarioHotelero(null, null, null, new Telefono(null, null, null, null), null), 
				null, null, null, null, new ArrayList<IFormaDePago>());
		
		this.listaHoteles = new ArrayList<Hotel>();
		this.listaHoteles.add(this.unHotel);

		this.gestor = new GestorConsulta(this.listaReserva, this.listaHoteles);

	}

	@Test
	public void cancelarReservatest() {
				
		assertEquals(this.unaHabitacion.getReservas().size(), 1);
		this.gestor.cancelarReserva(this.unaReserva, this.unaHabitacion);
		assertEquals(this.unaHabitacion.getReservas().size(), 0);
	}

}
