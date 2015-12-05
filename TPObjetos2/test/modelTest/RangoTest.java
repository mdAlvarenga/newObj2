package modelTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import model.Rango;

public class RangoTest {
	public Rango rangoConsultado;
	public Rango rangoInterceptantePorUltimosDias;
	public Rango rangoInterceptantePorPimerosDias;
	public Rango rangoCompletamenteInterceptante;
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
		rangoCompletamenteInterceptante = new Rango(fechaDesde, fechaHasta);

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
	public void testRangoCompletamenteInterceptante() {
		
		assertTrue(rangoConsultado.intercepta(rangoCompletamenteInterceptante));
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

	public static void main (String [] args){
		System.out.println(new DateTime("11:23:44"));
	}
			
}
