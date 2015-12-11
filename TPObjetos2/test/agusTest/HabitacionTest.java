package agusTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import model.Habitacion;
import model.Hotel;
import model.Precio;
import model.Rango;
import model.Reserva;
import nadaTesteable.Servicio;
import nadaTesteable.Usuario;
import nadaTesteable.UsuarioPasajero;

public class HabitacionTest {
	
	private Habitacion habitacion;
	private String ciudad;
	private UsuarioPasajero usuario;
	private String otraCiudad;
	private Hotel unHotel;
	private Hotel unHotel2;
	private Habitacion habitacion2;
	private DateTime fechaDesde_marzo;
	private DateTime fechaHasta_abril;
	private DateTime fechaDesde_oct;
	private DateTime fechaHasta_nov;
	private DateTime fechaDesde_ene;
	private DateTime fechaHasta_feb;
	private Rango oct_nov;
	private Rango ene_feb;
	private Rango marzo_abril;
	private Rango rango2;
	private Rango rango1;
	
	
	@Before
	public void setUp(){
		
		
	}

	@Test
	public void testCapacidadMaxima(){
	
		assertEquals(habitacion.getCapacidadMaxima(), 10);
	}
	
	@Test
	public void testDisponibilidadPara(){
		
		DateTime hoy = new DateTime();
		DateTime pasadoManiana = new DateTime();
		pasadoManiana.plusDays(2);
		rango2 = new Rango(hoy, pasadoManiana);
		assertTrue(habitacion.disponibilidadPara(rango2));
	}
	
	@Test
	public void testReservasDelUsuario(){
		
		assertEquals(habitacion.reservasDelUsuario(this.usuario).size(), 2);
	}
	
	@Test
	public void testReservasFuturasDelUsuario(){
		
		assertEquals(habitacion.reservasFuturasDelUsuario(this.usuario).size(), 1);
	}

	@Test	
	public void testDisponibilidadPara(Rango unRango) {
		assertTrue(habitacion.disponibilidadPara(rango1));
	}
	
	@Test
	public void testReservasConFechaMayorA(){
		assertEquals(habitacion.reservasConFechaMayorA(fechaHoy));
	}
	
	@Test
	public void testAgregarReserva(){
		habitacion.agragarReserva(mockReservaAgregar);
		assertEquals(habitacion.getReservas().size(), 5);
		assertTrue(habitacion.getReservas().contains(mockReservaAgregar));
	}

	@Test
	public void testCalcularUnMonto(){
		assertEquals(habitacion.calcularMonto(rango1).intValue(), 100);
	}
	
	@Test
	public void testGetReservasParaFecha(){
		habitacion.getReservasParaFecha(fecha1, mockListReservas);
		assertTrue(mockListReservas.contains(mockReserva1));
	}
	
	@Test
	public void testCancelaSiPodes() {
		habitacion.cancelaSiPodes(mockResva2);
		assertFalse(habitacion.getReservas().contains(mockReserva2));
	}
}
