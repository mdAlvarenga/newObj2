	package modelTest.old;

	import static org.junit.Assert.*;
	import static org.mockito.Mockito.when;

	import java.util.ArrayList;
	import java.util.List;

	import org.joda.time.DateTime;
	import org.junit.Before;
	import org.junit.Test;
	import org.mockito.Mockito;

	import model.Habitacion;
	import model.Hotel;
	import model.Reserva;
	import model.UsuarioHotelero;

	public class UsuarioHoteleroMockitoTest {
/*
		private UsuarioHotelero usuario;
		private Reserva mockReserva1;
		private Reserva mockReserva2;
		private Reserva mockReserva3;
		private Reserva mockReserva4;
		private Habitacion mockHabitacion1;
		private Habitacion mockHabitacion2;
		private Hotel mockHotel1;
		private Hotel mockHotel2;

		@Before
		public void setUp(){
			
			usuario = new UsuarioHotelero(null, null, null, null, null);
			DateTime hoy = new DateTime();
			List<Reserva> listaDeMockReservas1 = new ArrayList<Reserva>();
			List<Reserva> listaDeMockReservas2 = new ArrayList<Reserva>();
			List<Reserva> listaDeMockReservas3 = new ArrayList<Reserva>();
			List<Reserva> listaDeMockReservas4 = new ArrayList<Reserva>();

			mockReserva1 = Mockito.mock(Reserva.class);
			mockReserva2 = Mockito.mock(Reserva.class);
			mockReserva3 = Mockito.mock(Reserva.class);
			mockReserva4 = Mockito.mock(Reserva.class);
			
			
			listaDeMockReservas1.add(mockReserva1);
			listaDeMockReservas1.add(mockReserva2);
			listaDeMockReservas2.add(mockReserva3);
			listaDeMockReservas2.add(mockReserva4);
			listaDeMockReservas3.add(mockReserva4);

	/*		
			mockHabitacion1 = Mockito.mock(Habitacion.class);
			when(mockHabitacion1.reservasDelUsuario(usuario)).thenReturn(listaDeMockReservas1);
			when(mockHabitacion1.reservasFuturasDelUsuario(usuario)).thenReturn(listaDeMockReservas1);
			when(mockHabitacion1.reservasDeUnaCiudadDelUsuario(unaCiudad, usuario)).thenReturn(listaDeMockReservas3);
			when(mockHabitacion1.ciudadDelHotelDondeEstas()).thenReturn("BUENOS_AIRES");
			
			mockHabitacion2 = Mockito.mock(Habitacion.class);
			when(mockHabitacion2.reservasDelUsuario(usuario)).thenReturn(listaDeMockReservas2);
			when(mockHabitacion2.reservasFuturasDelUsuario(usuario)).thenReturn(listaDeMockReservas4);
			when(mockHabitacion2.reservasDeUnaCiudadDelUsuario(unaCiudad, usuario)).thenReturn(listaDeMockReservas4);
			when(mockHabitacion2.ciudadDelHotelDondeEstas()).thenReturn("QUILMES");
	

			mockHotel1 = Mockito.mock(Hotel.class);
			when(mockHotel1.reservasDentroDeFecha(hoy)).thenReturn(listaDeMockReservas1);
			
			mockHotel2 = Mockito.mock(Hotel.class);
			when(mockHotel2.reservasDentroDeFecha(hoy)).thenReturn(listaDeMockReservas2);
			

		}
		
		@Test
		public void testReservasActuales(){
			
			assertEquals(usuario.reservasActuales().size(), 4);
		}
		
		@Test
		public void testReservasFuturas(){
			
			assertEquals(usuario.reservasFuturas().size(), 2);
		}

		@Test
		public void testReservasDentroDeNDiasFuturos(){
			
			assertEquals(usuario.reservasDentroDeNDiasFuturos(4).size(), 1);
		}
		*/
	}

