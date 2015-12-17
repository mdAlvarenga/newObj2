package modelTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import model.Categoria;
import model.Ciudad;
import model.Correo;
import model.Direccion;
import model.Habitacion;
import model.Hotel;
import model.IFormaDePago;
import model.Pais;
import model.Servicio;
import model.TCredito;
import model.TDebito;
import model.Telefono;
import model.UsuarioHotelero;

public class GettersDelHotelTest {

	private Hotel hotel;
	private DateTime mockCheckIn;
	@Mock private Ciudad mockCiudad;
	@Mock private Categoria mockCategoria;
	private List<Servicio> mockListServicios;
	@Mock private Pais mockPais;
	@Mock private Direccion mockDireccion;
	@Mock private Telefono mockTelefono;
	@Mock private Correo mockMail;
	private DateTime mockCheckOut;
	private List<Habitacion> mockListHabitaicones;
	@Mock private UsuarioHotelero mockHotelero;
	private ArrayList<IFormaDePago> mockListFormasDePago;
	@Mock private Servicio servicio1;
	@Mock private Servicio servicio2;
	@Mock private TCredito medio1;
	@Mock private TDebito medio2;
	@Mock private Habitacion habitacion1;
	@Mock private Habitacion habitacion2;

	@Before
	public void setUp(){
		
		MockitoAnnotations.initMocks(this);	
		
		// inicializo listas
		mockListServicios = new ArrayList<Servicio>();
		mockListFormasDePago = new ArrayList<IFormaDePago>();
		mockListHabitaicones = new ArrayList<Habitacion>();
		
		mockCheckIn = new DateTime();
		mockListServicios.add(servicio1);
		mockListServicios.add(servicio2);
		mockCheckOut = new DateTime();
		mockListFormasDePago.add(medio1);
		mockListFormasDePago.add(medio2);
		mockListHabitaicones.add(habitacion1);
		mockListHabitaicones.add(habitacion2);

		hotel = new Hotel("HOTELTEST", mockCiudad, mockListHabitaicones, 
						  mockListServicios, mockCategoria, mockCheckIn, 
						  mockCheckOut, mockHotelero, mockPais, mockDireccion, 
						  mockTelefono, mockMail, mockListFormasDePago);
	}
	@Test
	public void testNombreHotel(){
		assertEquals(hotel.getNombre(), "HOTELTEST");
	}
	
	@Test
	public void testPaisHotel(){
		assertSame(hotel.getPais(), mockPais);
	}

	@Test
	public void testCiudadHotel(){
		assertSame(hotel.getCiudad(), mockCiudad);
	}
	
	@Test
	public void testDireccionHotel(){
		assertSame(hotel.getDireccion(), mockDireccion);
	}

	@Test
	public void testTelefonoHotel(){
		assertSame(hotel.getTelefono(), mockTelefono);
	}

	@Test
	public void testMailHotel(){
		assertSame(hotel.getMail(), mockMail);
	}
	
	@Test
	public void testCategoriaHotel(){
		assertSame(hotel.getCategoria(), mockCategoria);
	}

	@Test
	public void testServiciosHotel(){
		assertEquals(hotel.getServicios(), mockListServicios);
	}
	
	@Test
	public void testCheckInHotel(){
		assertSame(hotel.getCheckIn(), mockCheckIn);
	}
	
	@Test
	public void testCheckOutHotel(){
		assertSame(hotel.getCheckOut(), mockCheckOut);
	}

	@Test
	public void testMediosDePagoHotel(){
		assertEquals(hotel.getFormasDePago(), mockListFormasDePago);
	}
	
	@Test
	public void testHabitacionesHotel(){
		assertEquals(hotel.getHabitaciones(), mockListHabitaicones);
	}
	
	@Test
	public void testHoteleroHotel(){
		assertSame(hotel.getHotelero(), mockHotelero);
	}
	
}
