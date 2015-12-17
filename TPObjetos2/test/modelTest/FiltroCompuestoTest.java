package modelTest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import model.FiltroCantidadHuespedes;
import model.FiltroCiudadHotel;
import model.FiltroCompuesto;
import model.FiltroNombreHotel;
import model.FiltroRango;

public class FiltroCompuestoTest extends FiltroBusquedaSetUp{

	/**
	 * Caso de test: existe un hotel que cumple con todas las condiciones
	 * resultado esperado: se retorna el hotel
	 */
	@Test
	public void testObtengoHotelTodosLosFiltrosConDisponibilidad() {
		
		this.listaDeHoteles.add(hotel1);
		this.listaDeHabitacionesHotel1.add(hab1);
		
		this.filtroNombreHotel = new FiltroNombreHotel("hotel1");
		this.listaDeFiltros.add(this.filtroNombreHotel);

		this.filtroCiudadHotel = new FiltroCiudadHotel(avellaneda);
		this.listaDeFiltros.add(this.filtroCiudadHotel);
		
		this.filtroRango = new FiltroRango(this.rango);
		this.listaDeFiltros.add(this.filtroRango);

		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(2);
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);

		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		resultado = sutBuscador.buscar(listaDeHoteles);

		assertEquals(1, resultado.size());
		
	}
	
	/**
	 * Caso de test: existe un hotel pero no cumple con ningun criterio de busqueda
	 * resultado esperado: no retorna hoteles
	 */
	@Test
	public void testObtengoHotelTodosLosFiltrosSinDisponibilidad() {
		
		this.listaDeHoteles.add(hotel1);
		this.listaDeHabitacionesHotel1.add(hab1);
		
		this.filtroNombreHotel = new FiltroNombreHotel("hotel2");
		this.listaDeFiltros.add(this.filtroNombreHotel);

		this.filtroCiudadHotel = new FiltroCiudadHotel(quilmes);
		this.listaDeFiltros.add(this.filtroCiudadHotel);
		
		this.filtroRango = new FiltroRango(this.rango);
		this.listaDeFiltros.add(this.filtroRango);

		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(5);
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);

				
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		resultado = sutBuscador.buscar(listaDeHoteles);

		assertEquals(0, resultado.size());
		
	}
	
	/**
	 * Caso de test: existe un hotel, solo un filtro no cumple con lo buscado
	 * resultado esperado: no retorna hoteles
	 */
	@Test
	public void testObtengoHotelTodosLosFiltrosSinDisponibilidad2() {
		
		this.listaDeHoteles.add(hotel1);
		this.listaDeHabitacionesHotel1.add(hab1);
		
		this.filtroNombreHotel = new FiltroNombreHotel("hotel1");
		this.listaDeFiltros.add(this.filtroNombreHotel);

		this.filtroCiudadHotel = new FiltroCiudadHotel(avellaneda);
		this.listaDeFiltros.add(this.filtroCiudadHotel);
		
		this.filtroRango = new FiltroRango(this.rango);
		this.listaDeFiltros.add(this.filtroRango);

		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(3);
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);

		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		resultado = sutBuscador.buscar(listaDeHoteles);
		
		assertEquals(0, resultado.size());
		
	}

	/**
	 * Caso de test: existen dos hoteles, uno cumple con lo pedido el otro no
	 * resultado esperado: retorna hotel1
	 */
	@Test
	public void testObtengoHotelTodosLosFiltrosDosHotelesUnoConDisponibilidad(){
		
		this.listaDeHoteles.add(hotel1);
		this.listaDeHoteles.add(hotel2);
		this.listaDeHabitacionesHotel1.add(hab1);
		
		this.filtroNombreHotel = new FiltroNombreHotel("hotel1");
		this.listaDeFiltros.add(this.filtroNombreHotel);

		this.filtroCiudadHotel = new FiltroCiudadHotel(avellaneda);
		this.listaDeFiltros.add(this.filtroCiudadHotel);
		
		this.filtroRango = new FiltroRango(this.rango);
		this.listaDeFiltros.add(this.filtroRango);

		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(2);
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);

		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		resultado = sutBuscador.buscar(listaDeHoteles);
		
		assertEquals(1, resultado.size());
		
	}

	/**
	 * Caso de test: existen tres hoteles, dos cumplen con lo pedido el otro no
	 * resultado esperado: retorna hotel1 y hotel4
	 */
	@Test
	public void testObtengoHotelTodosLosFiltrosTresHotelesDosConDisponibilidad(){
		
		this.listaDeHoteles.add(hotel1);
		this.listaDeHoteles.add(hotel4);
		this.listaDeHoteles.add(hotel2);
		this.listaDeHabitacionesHotel1.add(hab1);
		
		this.filtroNombreHotel = new FiltroNombreHotel("hotel1");
		this.listaDeFiltros.add(this.filtroNombreHotel);

		this.filtroCiudadHotel = new FiltroCiudadHotel(avellaneda);
		this.listaDeFiltros.add(this.filtroCiudadHotel);
		
		this.filtroRango = new FiltroRango(this.rango);
		this.listaDeFiltros.add(this.filtroRango);

		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(2);
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);

		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		resultado = sutBuscador.buscar(listaDeHoteles);
		
		assertEquals(2, resultado.size());
		
	}
	
	/**
	 * Caso de test: pruebo la busqueda de hoteles sin filtros
	 * resultado esperado: retorna todos los hoteles cargados en el sistema
	 */
	@Test
	public void testFiltroCompuestoSinFIltros(){
		
		this.listaDeHoteles.add(hotel1);
		this.listaDeHoteles.add(hotel4);
		this.listaDeHoteles.add(hotel2);
		this.listaDeHabitacionesHotel1.add(hab1);
		
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		resultado = sutBuscador.buscar(listaDeHoteles);
		
		assertEquals(3, resultado.size());
		
	}

	
	/**
	 * Caso de test: pruebo la busqueda de habitaciones sin filtros
	 * resultado esperado: la busqueda retorna todas las habitaciones
	 */
	@Test
	public void testFiltroCompuestoSinFiltros() {
		
		this.listaDeHoteles.add(hotel1);
		this.listaDeHabitacionesHotel1.add(hab1);
		this.listaDeHabitacionesHotel1.add(hab2);
		this.listaDeHabitacionesHotel1.add(hab3);

		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultadoHab = this.sutBuscador.buscarHabitaciones(this.hotel1);

		assertEquals(this.resultadoHab.size(), 3);
		
	}

	/**
	 * Caso de test: un hotel con una habitacion que no cumple con la busqueda
	 * resultado esperado: la busqueda no retorna habitaciones
	 */
	@Test
	public void testFiltroCompuestoUnaHabitacionNOOK() {
		
		this.listaDeHoteles.add(hotel1);
		this.listaDeHabitacionesHotel1.add(hab1);
		
		this.filtroNombreHotel = new FiltroNombreHotel("hotel1");
		this.listaDeFiltros.add(this.filtroNombreHotel);

		this.filtroCiudadHotel = new FiltroCiudadHotel(avellaneda);
		this.listaDeFiltros.add(this.filtroCiudadHotel);
		
		this.filtroRango = new FiltroRango(this.rango);
		this.listaDeFiltros.add(this.filtroRango);

		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(5);
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);

		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultadoHab = this.sutBuscador.buscarHabitaciones(this.hotel1);

		assertEquals(this.resultadoHab.size(), 0);
		
	}


	/**
	 * Caso de test: un hotel con una habitacion que cumple con la busqueda
	 * resultado esperado: la busqueda retorna esa habitacion
	 */
	@Test
	public void testFiltroCompuestoUnaHabitacionOK() {
		
		this.listaDeHoteles.add(hotel1);
		this.listaDeHabitacionesHotel1.add(hab1);

		this.filtroNombreHotel = new FiltroNombreHotel("hotel1");
		this.listaDeFiltros.add(this.filtroNombreHotel);

		this.filtroCiudadHotel = new FiltroCiudadHotel(avellaneda);
		this.listaDeFiltros.add(this.filtroCiudadHotel);

		this.filtroRango = new FiltroRango(this.rango);
		this.listaDeFiltros.add(this.filtroRango);

		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(2);
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);

		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		this.resultadoHab = this.sutBuscador.buscarHabitaciones(this.hotel1);

		assertEquals(this.resultadoHab.size(), 1);
		
	}

	
}
