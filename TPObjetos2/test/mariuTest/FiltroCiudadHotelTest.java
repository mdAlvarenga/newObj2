package mariuTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.FiltroCiudadHotel;
import model.FiltroCompuesto;

public class FiltroCiudadHotelTest extends FiltroBusquedaSetUp {

	/**
	 * Caso de test: 0 hoteles
	 * resultado esperado: la busqueda no trae hoteles
	 */
	@Test
	public void testFiltroHotelPorCiudadConNingunHotel() {
		
		this.filtroCiudadHotel = new FiltroCiudadHotel(this.avellaneda);
		
		this.listaDeFiltros.add(this.filtroCiudadHotel);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultado = this.sutBuscador.buscar(listaDeHoteles);

		assertEquals(0, resultado.size());
		
	}

	/**
	 * Caso de test: 1 hotel
	 * resultado esperado: la busqueda trae el hotel
	 */
	@Test
	public void testFiltroHotelPorCiudadConUnHotel() {
		
		this.listaDeHoteles.add(hotel1);
		this.filtroCiudadHotel = new FiltroCiudadHotel(this.avellaneda);
		
		this.listaDeFiltros.add(this.filtroCiudadHotel);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultado = this.sutBuscador.buscar(listaDeHoteles);

		assertEquals(1, resultado.size());
		
	}
	
	/**
	 * Caso de test: existen dos hoteles, uno en la ciudad buscada
	 * resultado esperado: la busqueda trae un hotel
	 */
	@Test
	public void testFiltroHotelPorCiudadConDosHotel() {
		
		this.listaDeHoteles.add(hotel1);
		this.listaDeHoteles.add(hotel2);
		this.filtroCiudadHotel = new FiltroCiudadHotel(this.quilmes);
		
		this.listaDeFiltros.add(this.filtroCiudadHotel);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultado = this.sutBuscador.buscar(listaDeHoteles);

		assertEquals(1, resultado.size());
		
	}
	
	/**
	 * Caso de test: existen dos hoteles, ninguno en la ciudad buscada
	 * resultado esperado: la busqueda trae un hotel
	 */
	@Test
	public void testFiltroHotelPorCiudadConDosHotelEnOtraCiudad() {
		
		this.listaDeHoteles.add(hotel3);
		this.listaDeHoteles.add(hotel2);
		this.filtroCiudadHotel = new FiltroCiudadHotel(this.avellaneda);
		
		this.listaDeFiltros.add(this.filtroCiudadHotel);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultado = this.sutBuscador.buscar(listaDeHoteles);

		assertEquals(0, resultado.size());
		
	}
}