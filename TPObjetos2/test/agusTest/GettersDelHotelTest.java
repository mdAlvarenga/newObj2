package agusTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import model.Habitacion;
import model.Hotel;
import nadaTesteable.Categoria;
import nadaTesteable.Ciudad;
import nadaTesteable.Correo;
import nadaTesteable.Direccion;
import nadaTesteable.IFormaDePago;
import nadaTesteable.Pais;
import nadaTesteable.Servicio;
import nadaTesteable.Telefono;
import nadaTesteable.UsuarioHotelero;

public class GettersDelHotelTest {

	private Hotel hotel;
	private DateTime mockCheckIn;
	private Ciudad mockCiudad;
	private Categoria mockCategoria;
	private List<Servicio> mockListServicios;
	private Pais mockPais;
	private Direccion mockDireccion;
	private Telefono mockTelefono;
	private Correo mockMail;
	private DateTime mockCheckOut;
	private List<Habitacion> mockListHabitaicones;
	private UsuarioHotelero mockHotelero;
	private ArrayList<IFormaDePago> mockListFormasDePago;

	@Before
	public void setUp(){
		
		MockitoAnnotations.initMocks(this);	
		
		// inicializo listas
		mockListServicios = new ArrayList<Servicio>();
		mockListFormasDePago = new ArrayList<IFormaDePago>();
		mockListHabitaicones = new ArrayList<Habitacion>();
		
		// variables temporales necesarias
		Servicio servicio1 = Mockito.any();
		Servicio servicio2 = Mockito.any();
		IFormaDePago medio1 = Mockito.any();
		IFormaDePago medio2 = Mockito.any();
		Habitacion habitacion1 = Mockito.any();
		Habitacion habitacion2 = Mockito.any();
		
		// variables de instancia
		mockCheckIn = Mockito.any();
		mockCiudad = Mockito.any();
		mockCategoria = Mockito.any();
		mockListServicios.add(servicio1);
		mockListServicios.add(servicio2);
		mockPais = Mockito.any();
		mockDireccion = Mockito.any();
		mockTelefono = Mockito.any();
		mockMail = Mockito.any();
		mockCheckOut = Mockito.any();
		mockListFormasDePago.add(medio1);
		mockListFormasDePago.add(medio2);
		mockListHabitaicones.add(habitacion1);
		mockListHabitaicones.add(habitacion2);
		mockHotelero = Mockito.any();		

		hotel = new Hotel("HOTELTEST", mockCiudad, mockListHabitaicones, 
						  mockListServicios, mockCategoria, mockCheckIn, 
						  mockCheckIn, mockHotelero, mockPais, mockDireccion, 
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
