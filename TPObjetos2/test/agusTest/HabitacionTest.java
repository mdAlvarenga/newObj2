package agusTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

import model.Habitacion;
import model.Precio;
import model.Rango;
import model.Reserva;
import nadaTesteable.Servicio;
import nadaTesteable.Usuario;
import nadaTesteable.UsuarioPasajero;

public class HabitacionTest {
	
	private Habitacion habitacion;
	@Mock private UsuarioPasajero mockUsuario;
	private Rango rango2;
	@Mock private Reserva mockReservaAgregar;
	private DateTime fecha1;
	private DateTime fecha2;
	@Mock private Reserva mockReserva1;
	@Mock private Reserva mockReserva2;
	@Mock private Reserva mockReserva3;
	@Mock private Reserva mockReserva4;
	@Mock private Precio mockPrecio1;
	@Mock private Precio mockPrecio2;
	@Mock private Precio mockPrecio3;
	@Mock private Precio mockPrecio4;
	@Mock private Rango mockRango1;
	@Mock private Usuario otroUsuario;

	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		fecha1 = new DateTime();
		ArrayList<Servicio> mockListServicios = new ArrayList<Servicio>();
		Servicio servicio = Mockito.mock(Servicio.class);
		mockListServicios.add(servicio);
		servicio = Mockito.mock(Servicio.class);
		mockListServicios.add(servicio);
		
		List<Reserva> mockListReservas = new ArrayList<Reserva>();
		mockListReservas.add(mockReserva1);
		mockListReservas.add(mockReserva2);
		mockListReservas.add(mockReserva3);
		mockListReservas.add(mockReserva4);
		
		List<Precio> mockListPrecios = new ArrayList<Precio>();
		mockListPrecios.add(mockPrecio1);
		mockListPrecios.add(mockPrecio2);
		mockListPrecios.add(mockPrecio3);
		mockListPrecios.add(mockPrecio4);		
		
		habitacion = new Habitacion("111", 
									4, 
									"Simple", 
									mockListServicios, 
									mockListReservas, 
									mockListPrecios,
									true);
				
		when(mockReserva1.ocupadaEn(mockRango1)).thenReturn(false);
		when(mockReserva2.ocupadaEn(mockRango1)).thenReturn(false);
		when(mockReserva3.ocupadaEn(mockRango1)).thenReturn(false);
		when(mockReserva4.ocupadaEn(mockRango1)).thenReturn(false);
		
		when(mockReserva1.getUsuarioQueReserva()).thenReturn(mockUsuario);
		when(mockReserva2.getUsuarioQueReserva()).thenReturn(mockUsuario);
		when(mockReserva3.getUsuarioQueReserva()).thenReturn(otroUsuario);
		when(mockReserva4.getUsuarioQueReserva()).thenReturn(otroUsuario);

		when(mockReserva1.fechaDeReservaPosteriorA(new DateTime())).thenReturn(true);
		when(mockReserva2.fechaDeReservaPosteriorA(new DateTime())).thenReturn(true);
		when(mockReserva3.fechaDeReservaPosteriorA(new DateTime())).thenReturn(false);
		when(mockReserva4.fechaDeReservaPosteriorA(new DateTime())).thenReturn(false);

		when(mockReserva1.fechaDeReservaPosteriorA(fecha2)).thenReturn(true);
		when(mockReserva2.fechaDeReservaPosteriorA(fecha2)).thenReturn(true);
		when(mockReserva3.fechaDeReservaPosteriorA(fecha2)).thenReturn(false);
		when(mockReserva4.fechaDeReservaPosteriorA(fecha2)).thenReturn(false);

		rango2 = new Rango(fecha1, fecha1);
		when(mockReserva1.ocupadaEn(rango2)).thenReturn(true);
		when(mockReserva2.ocupadaEn(rango2)).thenReturn(false);
		when(mockReserva3.ocupadaEn(rango2)).thenReturn(false);
		when(mockReserva4.ocupadaEn(rango2)).thenReturn(false);
		
		when(mockPrecio1.calcularMontoPara(mockRango1)).thenReturn(100.00);
		when(mockPrecio2.calcularMontoPara(mockRango1)).thenReturn(0.00);
		when(mockPrecio3.calcularMontoPara(mockRango1)).thenReturn(0.00);
		when(mockPrecio4.calcularMontoPara(mockRango1)).thenReturn(0.00);	
		
		when(mockPrecio1.getRango()).thenReturn(mockRango1);
		when(mockPrecio2.getRango()).thenReturn(rango2);
		when(mockPrecio3.getRango()).thenReturn(rango2);
		when(mockPrecio4.getRango()).thenReturn(rango2);
		
		when(mockRango1.intercepta(mockRango1)).thenReturn(true);
		when(mockRango1.intercepta(rango2)).thenReturn(false);		
	}

	@Test
	public void testCapacidadMaxima(){
		assertEquals(habitacion.getCapacidadMaxima(), 4);
	}
	
	@Test
	public void testDisponibilidadPara(){		
		assertTrue(habitacion.disponibilidadPara(mockRango1));
	}
	
	@Test
	public void testReservasDelUsuario(){
		assertEquals(habitacion.reservasDelUsuario(mockUsuario).size(), 2);
	}
	
	@Test
	public void testReservasFuturasDelUsuario(){		
		assertEquals(habitacion.reservasFuturasDelUsuario(this.mockUsuario).size(), 2);
	}
	
	@Test
	public void testReservasConFechaMayorA(){
		assertEquals(habitacion.reservasConFechaMayorA(fecha2).size(), 2);
	}
	
	@Test
	public void testAgregarReserva(){
		habitacion.agregarReserva(mockReservaAgregar);
		assertEquals(habitacion.getReservas().size(), 5);
		assertTrue(habitacion.getReservas().contains(mockReservaAgregar));
	}

	@Test
	public void testCalcularUnMonto(){
		assertEquals(habitacion.calcularMonto(mockRango1).intValue(), 100);
	}
	
	@Test
	public void testGetReservasParaFecha(){
		List<Reserva> reservas = new ArrayList<Reserva>();
		habitacion.getReservasParaFecha(fecha1, reservas);
		assertTrue(reservas.contains(mockReserva1));
	}
	
	@Test
	public void testCancelaSiPodes() {
		habitacion.cancelaSiPodes(mockReserva2);
		assertFalse(habitacion.getReservas().contains(mockReserva2));
	}
}
