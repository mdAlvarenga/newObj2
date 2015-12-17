package modelTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.FiltroCantidadHuespedes;
import model.FiltroCompuesto;

public class FiltroCantidadHuespedesTest extends FiltroBusquedaSetUp{

	/**
	 * Caso de test: ningun hotel cargado en el sistema
	 * resultado esperado: la busqueda no trae hoteles
	 */
	@Test
	public void testFiltroCantidadHuespedesConNingunHotel() {
		
		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(2);
		
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultado = this.sutBuscador.buscar(listaDeHoteles);

		assertEquals(0, resultado.size());
		
	}
	
	/**
	 * Caso de test: existe en el sistema un hotel con una habitacion con la
	 * cantidad de huespedes solicitada
	 * resultado esperado: la busqueda retorna ese hotel
	 */
	@Test
	public void testFiltroCantidadHuespedesUnHotelOK() {
		
		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(2);
		this.listaDeHoteles.add(hotel1);
		
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultado = this.sutBuscador.buscar(listaDeHoteles);

		assertEquals(1, resultado.size());
		
	}
	
	/**
	 * Caso de test: existe en el sistema un hotel con una habitacion con la
	 * cantidad de huespedes distinta a la solicitada
	 * resultado esperado: la busqueda no retorna hoteles
	 */
	@Test
	public void testFiltroCantidadHuespedesUnHotelNOOK() {
		
		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(2);
		this.listaDeHoteles.add(hotel2);
		
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultado = this.sutBuscador.buscar(listaDeHoteles);

		assertEquals(0, resultado.size());
		
	}
	
	/**
	 * Caso de test: existe en el sistema dos hoteles, ambos cumplen
	 * la cantidad solicitada
	 * resultado esperado: la busqueda retorna a los dos hoteles
	 */
	@Test
	public void testFiltroCantidadHuespedesDocHotelesDosOK() {
		
		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(2);
		this.listaDeHoteles.add(hotel1);
		this.listaDeHoteles.add(hotel3);
		
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultado = this.sutBuscador.buscar(listaDeHoteles);

		assertEquals(2, resultado.size());
		
	}
	
	/**
	 * Caso de test: existe en el sistema dos hoteles, ambos no cumplen
	 * la cantidad solicitada
	 * resultado esperado: la busqueda no retorna hoteles
	 */
	@Test
	public void testFiltroCantidadHuespedesDosHotelesDosNOOK() {
		
		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(1);
		this.listaDeHoteles.add(hotel1);
		this.listaDeHoteles.add(hotel3);
		
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultado = this.sutBuscador.buscar(listaDeHoteles);

		assertEquals(0, resultado.size());
		
	}
	
	/**
	 * Caso de test: existe en el sistema dos hoteles, ambos no cumplen
	 * la cantidad solicitada
	 * resultado esperado: la busqueda no retorna hoteles
	 */
	@Test
	public void testFiltroCantidadHuespedesTresHotelesDosNOOK() {
		
		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(1);
		this.listaDeHoteles.add(hotel1);
		this.listaDeHoteles.add(hotel2);
		this.listaDeHoteles.add(hotel3);
		
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultado = this.sutBuscador.buscar(listaDeHoteles);

		assertEquals(1, resultado.size());
		
	}
	
	
	/**
	 * Caso de test: un hotel con una habitacion que no cumple con la capacidad solicitada
	 * resultado esperado: la busqueda no retorna habitaciones
	 */
	@Test
	public void testFiltroCantidadHuespedesUnaHabitacionNOOK() {
		
		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(4);

		this.listaDeHabitacionesHotel1.add(this.hab1);
		
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultadoHab = this.sutBuscador.buscarHabitaciones(this.hotel1);

		assertEquals(this.resultadoHab.size(), 0);
		
	}
	
	/**
	 * Caso de test: un hotel con una habitacion que  cumple con la capacidad solicitada
	 * resultado esperado: la busqueda retorna la habitacion
	 */
	@Test
	public void testFiltroCantidadHuespedesUnaHabitacionOK() {
		
		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(1);

		this.listaDeHabitacionesHotel1.add(this.hab1);
		
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultadoHab = this.sutBuscador.buscarHabitaciones(this.hotel1);

		assertEquals(this.resultadoHab.size(), 1);
		
	}
	
	/**
	 * Caso de test: un hotel con dos habitaciones tienen ambas la capacidad buscada
	 * resultado esperado: la busqueda retorna las dos habitaciones
	 */
	@Test
	public void testFiltroCantidadHuespedesDosHabitacionOK() {
		
		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(1);

		this.listaDeHabitacionesHotel1.add(this.hab1);
		this.listaDeHabitacionesHotel1.add(this.hab2);
		
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultadoHab = this.sutBuscador.buscarHabitaciones(this.hotel1);

		assertEquals(this.resultadoHab.size(), 2);
		
	}
	
	/**
	 * Caso de test: un hotel con dos habitaciones tienen ambas distinta capacidad a la buscada
	 * resultado esperado: la busqueda no retorna habitaciones
	 */
	@Test
	public void testFiltroCantidadHuespedesDosHabitacionNOOK() {
		
		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(5);

		this.listaDeHabitacionesHotel1.add(this.hab1);
		this.listaDeHabitacionesHotel1.add(this.hab2);
		
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultadoHab = this.sutBuscador.buscarHabitaciones(this.hotel1);

		assertEquals(this.resultadoHab.size(), 0);
		
	}
		
	/**
	 * Caso de test: un hotel con tres habitaciones, dostienen igual capacidad a la buscada
	 * resultado esperado: la busqueda retorna hab1 y hab2
	 */
	@Test
	public void testFiltroCantidadHuespedesTRESHabitacionNOOK() {
		
		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(2);

		this.listaDeHabitacionesHotel1.add(this.hab1);
		this.listaDeHabitacionesHotel1.add(this.hab2);
		this.listaDeHabitacionesHotel1.add(this.hab3);
		
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultadoHab = this.sutBuscador.buscarHabitaciones(this.hotel1);

		assertEquals(this.resultadoHab.size(), 2);
		
	}
}
