package modelTest;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import model.Rango;

public class RangoTest {
	public Rango rangoConsultado;
	public Rango rangoInterceptantePorUltimosDias;
	public Rango rangoInterceptantePorPimerosDias;
	public Rango rangoCompletamenteInterceptanteMenor;
	public Rango rangoCompletamenteInterceptanteMayor;
	public Rango rangoNoInterceptante;
	public DateTime unaFecha;
	private DateTime otraFecha;
	
	@Before
	public void setUp(){
		
		// Declaro variables temporales
		DateTime fechaDesde;
		DateTime fechaHasta;
		
		// Rango Consultado
		fechaDesde = new DateTime(2015,10,10,0,0);
		fechaHasta = new DateTime(2015,11,11,0,0);
		rangoConsultado = new Rango(fechaDesde, fechaHasta);
		
		// Rango Interceptante que sus ultimos dias le pegan a los primeros del consultado
		fechaDesde = new DateTime(2015,9,9,0,0);
		fechaHasta = new DateTime(2015,10,15,0,0);
		rangoInterceptantePorUltimosDias = new Rango(fechaDesde, fechaHasta);
		
		// Rango Interceptante que sus primeros dias le pegan a los ultimos del consultado
		fechaDesde = new DateTime(2015,11,5,0,0);
		fechaHasta = new DateTime(2015,11,20,0,0);
		rangoInterceptantePorPimerosDias = new Rango(fechaDesde, fechaHasta);

		// Rango Interceptante que cae en el medio
		fechaDesde = new DateTime(2015,10,15,0,0);
		fechaHasta = new DateTime(2015,11,5,0,0);
		rangoCompletamenteInterceptanteMenor = new Rango(fechaDesde, fechaHasta);

		// Rango Interceptante que es mayor por fecha desde y hasta
		fechaDesde = new DateTime(2015,10,5,0,0);
		fechaHasta = new DateTime(2015,11,15,0,0);
		rangoCompletamenteInterceptanteMayor = new Rango(fechaDesde, fechaHasta);
		
		// Rango que cae fuera del consultado
		fechaDesde = new DateTime(2015,12,10,0,0);
		fechaHasta = new DateTime(2015,12,15,0,0);
		rangoNoInterceptante = new Rango(fechaDesde, fechaHasta);
		
		// Fecha Rango Fecha de Inicio Mayor
			unaFecha = new DateTime(2015,10,9,0,0);
			
		// Fecha Rango Fecha de Inicio Menor
			otraFecha = new DateTime(2015,10,15,0,0);
		
	}
	@Test
	public void testRangoInterceptantePorUltimosDias() {
		
		assertTrue(rangoConsultado.intercepta(rangoInterceptantePorUltimosDias));
	}
	
	@Test
	public void testRangoInterceptantePorPimerosDias() {
		
		assertTrue(rangoConsultado.intercepta(rangoInterceptantePorPimerosDias));
	}

	@Test
	public void testRangoCompletamenteInterceptanteMenor() {
		
		assertTrue(rangoConsultado.intercepta(rangoCompletamenteInterceptanteMenor));
	}
	
	@Test
	public void testRangoCompletamenteInterceptanteMayor(){
		assertTrue(rangoConsultado.intercepta(rangoCompletamenteInterceptanteMayor));
	}

	@Test
	public void testRangoNoInterceptante() {
		
		assertFalse(rangoConsultado.intercepta(rangoNoInterceptante));
	}
	
	@Test
	public void testRangoFechaInicioMayorAUnaFecha(){
		
		assertTrue(rangoConsultado.fechaDeReservaPosteriorA(unaFecha));
	}
	
	@Test
	public void testRangoFechaInicioMenorAOtraFecha(){
		
		assertFalse(rangoConsultado.fechaDeReservaPosteriorA(otraFecha));
	}
	
	@Test
	public void testCantidadDeDiasQueInterceptan(){
		assertEquals(rangoConsultado.cantDeDiasQueInterceptan(rangoNoInterceptante), 0);
		assertEquals(rangoConsultado.cantDeDiasQueInterceptan(rangoInterceptantePorPimerosDias), 9);
		assertEquals(rangoConsultado.cantDeDiasQueInterceptan(rangoInterceptantePorUltimosDias), 5);
		assertEquals(rangoConsultado.cantDeDiasQueInterceptan(rangoCompletamenteInterceptanteMenor), 21);
		assertEquals(rangoConsultado.cantDeDiasQueInterceptan(rangoCompletamenteInterceptanteMayor), 32);
	}

	@Test
	public void testCantidadDeDiasQueInterceptanPorFechaDesdeMenorYFechaHastaMenor(){
		assertEquals(rangoConsultado.cantidadDeDiasQueInterceptanPorFechaDesdeMenorYFechaHastaMenor(rangoInterceptantePorUltimosDias), 5);
	}

	@Test
	public void testCantidadDeDiasQueInterceptanPorFechaDesdeMayorYFechaHastaMenor(){
		assertEquals(rangoConsultado.cantidadDeDiasQueInterceptanPorFechaDesdeMayorYFechaHastaMenor(rangoCompletamenteInterceptanteMenor), 21);
	}
	
	@Test
	public void testCantidadDeDiasQueInterceptanPorFechaDesdeMayorYFechaHastaMayor(){
		assertEquals(rangoConsultado.cantidadDeDiasQueInterceptanPorFechaDesdeMayorYFechaHastaMayor(rangoInterceptantePorPimerosDias),9);
	}
	
	@Test
	public void testCantidadDeDiasQueInterceptanPorFechaDesdeMenorYFechaHastaMayor(){
		assertEquals(rangoConsultado.cantidadDeDiasQueInterceptanPorFechaDesdeMenorYFechaHastaMayor(rangoCompletamenteInterceptanteMayor), 32);
	}
	
	@Test
	public void testEvaluarCondicionYRetornarCantidadDeDias(){
		DateTime d1 = new DateTime(2015,12,1,0,0);
		DateTime d2 = new DateTime(2015,12,3,0,0);
		assertEquals(rangoConsultado.evaluarCondicionYRetornarCantidadDeDias(true, true, d1, d2), 2);
		assertEquals(rangoConsultado.evaluarCondicionYRetornarCantidadDeDias(true, false, d1, d2), 0);
		assertEquals(rangoConsultado.evaluarCondicionYRetornarCantidadDeDias(false, true, d1, d2), 0);
		assertEquals(rangoConsultado.evaluarCondicionYRetornarCantidadDeDias(false, false, d1, d2), 0);
	}
	
	@Test
	public void diasQueInterceptan(){
		DateTime d1 = new DateTime(2015,12,1,0,0);
		DateTime d2 = new DateTime(2015,12,3,0,0);
		assertEquals(rangoConsultado.diasQueInterceptan(d1, d2), 2);
	}

}
