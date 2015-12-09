package mariuTest;

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
	public void testObtengoHotelTodosLosFiltrosSinDisponibilidad() {
		
		this.listaDeHoteles.add(hotel1);
		this.listaDeHabitacionesHotel1.add(hab1);
		
		this.filtroNombreHotel = new FiltroNombreHotel("hotel1");
		this.listaDeFiltros.add(this.filtroNombreHotel);

		this.filtroRango = new FiltroRango(this.rango);
		this.listaDeFiltros.add(this.filtroRango);

		this.filtroCiudadHotel = new FiltroCiudadHotel(avellaneda);
		this.listaDeFiltros.add(this.filtroCiudadHotel);
		
		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(1);
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);

		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		resultado = sutBuscador.buscar(listaDeHoteles);

		assertEquals(1, resultado.size());
		
	}
	
	
}
