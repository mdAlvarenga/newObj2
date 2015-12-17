package modelTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.FiltroCompuesto;
import model.FiltroRango;

public class FiltroRangoTest extends FiltroBusquedaSetUp{
	
	/**
	 * Caso de test: ningun hotel cargado en el sistema
	 * resultado esperado: la busqueda no trae hoteles
	 */
	@Test
	public void testFiltroRangoConNingunHotel() {
		
		this.filtroRango = new FiltroRango(this.rango);
		
		this.listaDeHoteles.add(hotel1);
		
		this.listaDeFiltros.add(this.filtroRango);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultado = this.sutBuscador.buscar(listaDeHoteles);

		assertEquals(0, resultado.size());
		
	}
	
	/**
	 * Caso de test: tenemos un hotel con una habitacion con disponibilidad para ese rango
	 * resultado esperado: la busqueda retorna el hotel en cuestion
	 */
	@Test
	public void testFiltroRangoConUnHotelUnaHabitacionConDisponibilidad() {
		
		this.filtroRango = new FiltroRango(this.rango);
		
		this.listaDeHoteles.add(hotel1);
		this.listaDeHabitacionesHotel1.add(hab1);
		
		this.listaDeFiltros.add(this.filtroRango);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultado = this.sutBuscador.buscar(listaDeHoteles);

		assertEquals(1, resultado.size());
		
	}

	/**
	 * Caso de test: tenemos un hotel con una habitacion sin disponibilidad para ese rango
	 * resultado esperado: la busqueda no retorna hoteles
	 */
	@Test
	public void testFiltroRangoConUnHotelUnaHabitacionSinDisponibilidad() {
		
		this.filtroRango = new FiltroRango(this.rango);
		
		this.listaDeHoteles.add(hotel1);
		this.listaDeHabitacionesHotel1.add(hab2);
		
		this.listaDeFiltros.add(this.filtroRango);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultado = this.sutBuscador.buscar(listaDeHoteles);

		assertEquals(0, resultado.size());
		
	}
	
	/**
	 * Caso de test: existen dos hoteles y ninguno tiene disponibilidad
	 * resultado esperado: la busqueda no retorna hoteles
	 */
	@Test
	public void testFiltroRangoConDosHotelesDosHabitacionSinDisponibilidad() {
		
		this.filtroRango = new FiltroRango(this.rango);
		
		this.listaDeHoteles.add(hotel1);
		this.listaDeHoteles.add(hotel2);
		this.listaDeHabitacionesHotel1.add(hab2);
		this.listaDeHabitacionesHotel2.add(hab3);
		
		this.listaDeFiltros.add(this.filtroRango);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultado = this.sutBuscador.buscar(listaDeHoteles);

		assertEquals(0, resultado.size());
		
	}
	
	/**
	 * Caso de test: existen dos hoteles, uno tiene disponibilidad y el otro no
	 * resultado esperado: retorna solo un hotel
	 */
	@Test
	public void testFiltroRangoConDosHotelesDosHabitacionUnoConDisponibilidad() {
		
		this.filtroRango = new FiltroRango(this.rango);
		
		this.listaDeHoteles.add(hotel1);
		this.listaDeHoteles.add(hotel2);
		this.listaDeHabitacionesHotel1.add(hab1);
		this.listaDeHabitacionesHotel2.add(hab3);
		
		this.listaDeFiltros.add(this.filtroRango);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultado = this.sutBuscador.buscar(listaDeHoteles);

		assertEquals(1, resultado.size());
		
	}
	
	/**
	 * Caso de test: un hotel tiene una habitacion pero se encuentra fuera de rango
	 * resultado esperado: no retorna habitaciones
	 */
	@Test
	public void testFiltroRangoUnaHabitacionFueraDeRango() {
		
		this.filtroRango = new FiltroRango(this.rango);
		
		this.listaDeHabitacionesHotel1.add(hab2);
		
		this.listaDeFiltros.add(this.filtroRango);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultadoHab = this.sutBuscador.buscarHabitaciones(hotel1);

		assertEquals(0, resultadoHab.size());
		
	}
	
	/**
	 * Caso de test: un hotel tiene una habitacion tiene disponibilidad en el rango
	 * resultado esperado: retorna una habitacion
	 */
	@Test
	public void testFiltroRangoUnaHabitacionDeRangoOK() {
		
		this.filtroRango = new FiltroRango(this.rango);
		
		this.listaDeHabitacionesHotel1.add(hab1);
		
		this.listaDeFiltros.add(this.filtroRango);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultadoHab = this.sutBuscador.buscarHabitaciones(hotel1);

		assertEquals(1, resultadoHab.size());
		
	}
	
	/**
	 * Caso de test: un hotel tiene dos habitaciones una esta disponible en
	 * el rango solicitado, la otra no
	 * resultado esperado: retorna una habitacion
	 */
	@Test
	public void testFiltroRangoDosHabitacionUnaConRangoOK() {
		
		this.filtroRango = new FiltroRango(this.rango);
		
		this.listaDeHabitacionesHotel1.add(hab1);
		this.listaDeHabitacionesHotel1.add(hab2);
		
		this.listaDeFiltros.add(this.filtroRango);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultadoHab = this.sutBuscador.buscarHabitaciones(hotel1);

		assertEquals(1, resultadoHab.size());
		
	}
}
