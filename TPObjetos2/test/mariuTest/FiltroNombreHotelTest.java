package mariuTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;

import model.FiltroCompuesto;
import model.FiltroNombreHotel;

public class FiltroNombreHotelTest extends FiltroBusquedaSetUp{

	/**
	 * Caso de test: 0 hoteles
	 * resultado esperado: la busqueda no trae hoteles
	 */
	@Test
	public void testFiltroHotelPorNombreConNingunHotel() {
		
		this.filtroNombreHotel = new FiltroNombreHotel("hotel3");
		
		this.listaDeFiltros.add(this.filtroNombreHotel);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultado = this.sutBuscador.buscar(listaDeHoteles);

		assertEquals(0, resultado.size());
		
	}
	
	/**
	 * Caso de test: tengo un hotel con nombre distinto al buscado
	 * resultado esperado: la busqueda no trae hoteles
	 */
	@Test
	public void testFiltroUnHotelDistintoNombreAlBuscado() {
		
		this.listaDeHoteles.add(hotel1);
		
		this.filtroNombreHotel = new FiltroNombreHotel("hotel3");
		
		this.listaDeFiltros.add(this.filtroNombreHotel);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultado = this.sutBuscador.buscar(listaDeHoteles);

		assertEquals(0, resultado.size());
		
	}
	
	/**
	 * Caso de test:tengo un hotel con el nombre buscado
	 * resultado esperado: la busqueda trae al hotel
	 */
	@Test
	public void testFiltroUnHotelConNombreBuscado() {
		
		this.listaDeHoteles.add(hotel1);
		
		this.filtroNombreHotel = new FiltroNombreHotel("hotel1");

		this.listaDeFiltros.add(this.filtroNombreHotel);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultado = this.sutBuscador.buscar(listaDeHoteles);

		assertEquals(1, resultado.size());
		
	}
	
	/**
	 * Caso de test:tengo dos hoteles,uno de ellos con el nombre buscado
	 * resultado esperado: la busqueda trae un hotel
	 */
	@Test
	public void testFiltroDosHotelesUnoSoloConNombreBuscado() {
		
		this.listaDeHoteles.add(hotel1);
		this.listaDeHoteles.add(hotel2);
		
		this.filtroNombreHotel = new FiltroNombreHotel("hotel1");
		
		this.listaDeFiltros.add(this.filtroNombreHotel);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultado = this.sutBuscador.buscar(listaDeHoteles);

		assertEquals(1, resultado.size());
		
	}
	
	/**
	 * Caso de test: tengo dos hoteles, ninguno con el nombre buscado
	 * resultado esperado: la busqueda no trae resultados
	 */
	@Test
	public void testFiltroDosHotelesNingunoConNombreBuscado() {
		
		this.listaDeHoteles.add(hotel1);
		this.listaDeHoteles.add(hotel2);
		
		this.filtroNombreHotel = new FiltroNombreHotel("hotel3");
		
		this.listaDeFiltros.add(this.filtroNombreHotel);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultado = this.sutBuscador.buscar(listaDeHoteles);

		assertEquals(0, resultado.size());
		
	}
	
	/**
	 * Caso de test: tengo dos hoteles, ninguno con el nombre buscado
	 * resultado esperado: la busqueda trae ambos hoteles
	 */
	@Test
	public void testFiltroDosHotelesAmbosConNombreBuscado() {
		
		when(this.hotel3.getNombreHotel()).thenReturn("hotel1");
		
		this.listaDeHoteles.add(hotel1);
		this.listaDeHoteles.add(hotel2);
		this.listaDeHoteles.add(hotel3);
		
		this.filtroNombreHotel = new FiltroNombreHotel("hotel1");
		
		this.listaDeFiltros.add(this.filtroNombreHotel);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultado = this.sutBuscador.buscar(listaDeHoteles);

		assertEquals(2, resultado.size());
		
	}
}