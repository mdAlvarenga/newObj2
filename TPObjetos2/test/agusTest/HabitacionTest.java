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
	private ArrayList<Servicio> listaServicios;
	@Mock private UsuarioPasajero mockUsuario;
	private Rango rango2;
	@Mock private Reserva mockReservaAgregar;
	private DateTime fecha1;
	private DateTime hoy;
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
		listaServicios = new ArrayList<Servicio>();
		Servicio servicio = Mockito.mock(Servicio.class);
		listaServicios.add(servicio);
		servicio = Mockito.mock(Servicio.class);
		listaServicios.add(servicio);
		
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
									listaServicios, 
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

		String format = new DateTime().toString("yyyy-MM-dd");
		hoy = new DateTime(format);
	
		rango2 = new Rango(fecha1, fecha1);
				
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
		when(mockReserva1.ocupadaEn(mockRango1)).thenReturn(false);
		when(mockReserva2.ocupadaEn(mockRango1)).thenReturn(false);
		when(mockReserva3.ocupadaEn(mockRango1)).thenReturn(false);
		when(mockReserva4.ocupadaEn(mockRango1)).thenReturn(false);
		assertTrue(habitacion.disponibilidadPara(mockRango1));
	}
	
	@Test
	public void testNoHayDisponibilidadPara(){		
		when(mockReserva1.ocupadaEn(rango2)).thenReturn(true);
		when(mockReserva2.ocupadaEn(rango2)).thenReturn(true);
		when(mockReserva3.ocupadaEn(rango2)).thenReturn(true);
		when(mockReserva4.ocupadaEn(rango2)).thenReturn(true);
		assertFalse(habitacion.disponibilidadPara(rango2));
	}
	
	@Test
	public void testNoHayDisponibilidadParaUnRango(){		
		when(mockReserva1.ocupadaEn(rango2)).thenReturn(false);
		when(mockReserva2.ocupadaEn(rango2)).thenReturn(false);
		when(mockReserva3.ocupadaEn(rango2)).thenReturn(false);
		when(mockReserva4.ocupadaEn(rango2)).thenReturn(true);
		assertFalse(habitacion.disponibilidadPara(rango2));
	}
		
	@Test
	public void testReservasDelUsuario(){
		assertEquals(habitacion.reservasDelUsuario(mockUsuario).size(), 2);
	}
	
	@Test
	public void testReservasFuturasDelUsuario(){
		when(mockReserva1.fechaDeReservaPosteriorA(hoy)).thenReturn(true);
		when(mockReserva2.fechaDeReservaPosteriorA(hoy)).thenReturn(true);
		when(mockReserva3.fechaDeReservaPosteriorA(hoy)).thenReturn(false);
		when(mockReserva4.fechaDeReservaPosteriorA(hoy)).thenReturn(false);
		assertEquals(habitacion.reservasFuturasDelUsuario(this.mockUsuario).size(), 2);
	}
	
	@Test
	public void testReservasConFechaMayorA(){
		when(mockReserva1.fechaDeReservaPosteriorA(hoy)).thenReturn(true);
		when(mockReserva2.fechaDeReservaPosteriorA(hoy)).thenReturn(true);
		when(mockReserva3.fechaDeReservaPosteriorA(hoy)).thenReturn(false);
		when(mockReserva4.fechaDeReservaPosteriorA(hoy)).thenReturn(false);
		assertEquals(habitacion.reservasConFechaMayorA(hoy).size(), 2);
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
	public void testCancelaSiPodes() {
		habitacion.cancelaSiPodes(mockReserva2);
		assertFalse(habitacion.getReservas().contains(mockReserva2));
	}
	
	@Test
	public void testGetReservasParaFecha(){
		List<Reserva> reservas = new ArrayList<Reserva>();
		reservas = habitacion.getReservasParaFecha(fecha1);
		assertTrue(reservas.contains(mockReserva1));
		assertEquals(reservas.size(), 4);
	}
	
	@Test
	public void testGetServicios(){
		assertSame(listaServicios,habitacion.getServicios());
	}
	
	@Test
	public void testGetNombreONumero(){
		assertSame("111",habitacion.getNombreONumero());
	}
	
	@Test
	public void testGetCamaMatrimonial(){
		assertTrue(habitacion.getCamaMatrimonial());
	}
	
	@Test
	public void testGetBaseDoble(){
		assertSame("Simple", habitacion.getBaseDoble());
	}
}
