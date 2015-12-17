package modelTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import model.BodyMailBuilder;
import model.Categoria;
import model.Ciudad;
import model.Habitacion;
import model.Hotel;
import model.Rango;
import model.Reserva;
import model.Telefono;
import model.UsuarioHotelero;
import model.UsuarioPasajero;

public class BodyMailBuilderTest {
	protected BodyMailBuilder sutBodyMailBuilder;
	@Mock protected Reserva unaReserva;
	@Mock protected Habitacion unaHabitacion;
	@Mock protected Hotel unHotel;
	@Mock protected Ciudad madrid;
	@Mock protected UsuarioHotelero hotelero;
	@Mock protected Telefono telefonoMessi;
	@Mock protected Telefono telefonoHotel;
	@Mock protected Telefono telefonoHotelero;
	@Mock protected Rango rango;
	@Mock protected UsuarioPasajero pasajero;
	@Mock protected Categoria categoria;	
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		when(unaReserva.getUsuarioQueReserva()).thenReturn(pasajero);
		
		when(pasajero.getNombre()).thenReturn("Lionel");
		when(pasajero.getApellido()).thenReturn("Messi");
		when(pasajero.getTelefono()).thenReturn(telefonoMessi);
		when(telefonoMessi.getCodigoDePais()).thenReturn(54);
		when(telefonoMessi.getCodigoDeArea()).thenReturn(011);
		when(telefonoMessi.getCodigoLocal()).thenReturn(11);
		when(telefonoMessi.getNumeroAbonado()).thenReturn(425514546);
		when(pasajero.getEmail()).thenReturn("messi@gmail.com");
		
		when(unaReserva.getRangoDeReserva()).thenReturn(rango);
		when(rango.getFechaDesde()).thenReturn(new DateTime("2015-06-01"));
		when(rango.getFechaHasta()).thenReturn(new DateTime("2015-07-15"));
		
		when(unaReserva.getImporteDeReserva()).thenReturn(557456.56);
		
		when(unHotel.getNombre()).thenReturn("Shangai Resorts");
		when(unHotel.nombreCiudad()).thenReturn("Shangai");
		when(unHotel.getCategoria()).thenReturn(categoria);
		when(categoria.getCantidadEstrellas()).thenReturn(6);
		when(unHotel.getTelefono()).thenReturn(telefonoHotel);
		when(telefonoHotel.getCodigoDePais()).thenReturn(96);
		when(telefonoHotel.getCodigoDeArea()).thenReturn(22);
		when(telefonoHotel.getCodigoLocal()).thenReturn(333);
		when(telefonoHotel.getNumeroAbonado()).thenReturn(789546);
		when(unHotel.getCheckIn()).thenReturn(DateTime.now());
		when(unHotel.getCheckOut()).thenReturn(DateTime.now().plus(45));

		when(madrid.getNombre()).thenReturn("Madrid");
		when(unHotel.getHotelero()).thenReturn(hotelero);
		when(hotelero.getEmail()).thenReturn("hotelero@gmail.com");
		when(hotelero.getNombre()).thenReturn("Shuan");
		when(hotelero.getApellido()).thenReturn("Xi");
		when(hotelero.getTelefono()).thenReturn(telefonoHotelero);
		when(telefonoHotelero.getCodigoDePais()).thenReturn(104);
		when(telefonoHotelero.getCodigoDeArea()).thenReturn(2);
		when(telefonoHotelero.getCodigoLocal()).thenReturn(78);
		when(telefonoHotelero.getNumeroAbonado()).thenReturn(14589746);
		
		when(unaHabitacion.getNombreONumero()).thenReturn("Penhouse");		
				
		sutBodyMailBuilder = new BodyMailBuilder(unaReserva, unaHabitacion, unHotel);
		
	}

	@Test
	public void verificoQueElBodyMailConstruyaBien(){
		System.out.println(sutBodyMailBuilder.buildBody());
		when(unaHabitacion.getNombreONumero()).thenReturn("Penhouse");
		
	}
	
	@Test
	public void testeoQueHoteleroRecibaElMensajeGetMailDelHotelero(){
		assertEquals(sutBodyMailBuilder.mailHotelero(), "hotelero@gmail.com");
	}
	
	@Test
	public void testeoQuePasajeroRecibaElMensajeGetMailDelPasajero(){
		assertEquals(sutBodyMailBuilder.mailPasajero(), "messi@gmail.com");
	}
	
}
