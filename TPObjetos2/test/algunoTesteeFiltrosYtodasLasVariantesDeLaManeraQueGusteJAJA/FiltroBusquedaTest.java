package algunoTesteeFiltrosYtodasLasVariantesDeLaManeraQueGusteJAJA;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import clasesSinTest.Ciudad;
import clasesSinTest.Servicio;
import clasesSinTest.UsuarioPasajero;
import model.FiltroBusqueda;
import model.FiltroCantidadHuespedes;
import model.FiltroCiudadHotel;
import model.FiltroCompuesto;
import model.FiltroNombreHotel;
import model.FiltroRango;
import model.Habitacion;
import model.Hotel;
import model.Precio;
import model.Rango;
import model.Reserva;

public class FiltroBusquedaTest extends FiltroBusquedaSetUp{
	
	
	/**
	 * Busqueda simple SOLO por nombre de hotel
	 */
	@Test
	public void testObtengoHotelPorNombre() {
		
		//se crea y arma la escructura de busqueda
		this.filtroNombreHotel = new FiltroNombreHotel("AAA");
		this.listaDeFiltros.add(this.filtroNombreHotel);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		
		resultado = sutBuscador.buscar(listaDeHoteles);

		assertEquals(1, resultado.size());
		
	}
	
	/**
	 * Busqueda simple SOLO por nombre de ciudad
	 */
	@Test
	public void testObtengoHotelPorCiudad() {
		
		//se crea y arma la escructura de busqueda
		this.filtroCiudadHotel = new FiltroCiudadHotel(bernal);
		this.listaDeFiltros.add(this.filtroCiudadHotel);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		
		resultado = sutBuscador.buscar(listaDeHoteles);

		assertEquals(1, resultado.size());
		
	}
	
	
	/**
	 * Busqueda simple SOLO por cantidad de huespedes
	 */
	@Test
	public void testObtengoHotelPorCantidadHuespedes() {
		
		//se crea y arma la escructura de busqueda
		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(4);
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		
		resultado = sutBuscador.buscar(listaDeHoteles);

		assertEquals(1, resultado.size());
		
	}

	/**
	 * Busqueda simple SOLO por rango de fechas
	 * Disponibilidad OK
	 */
	@Test
	public void testObtengoHotelPorRango() {
		
		// Rango Consultado
		DateTime fechaDesde = new DateTime("2015-10-10");
		DateTime fechaHasta = new DateTime("2015-11-11");
		otroRango = new Rango(fechaDesde, fechaHasta);
		//se crea y arma la escructura de busqueda
		this.filtroRango = new FiltroRango(otroRango);
		this.listaDeFiltros.add(this.filtroRango);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		
		resultado = sutBuscador.buscar(listaDeHoteles);

		assertEquals(1, resultado.size());
		
	}
	
	/**
	 * Busqueda simple SOLO por rango de fechas
	 * Disponibilidad NOK
	 */
	@Test
	public void testObtengoHotelPorRangoNoDisponible() {
		
		// Rango Consultado
		DateTime fechaDesde = new DateTime(2015,9,9,0,0);
		DateTime fechaHasta = new DateTime(2015,9,30,0,0);
		nuevoRango = new Rango(fechaDesde, fechaHasta);
		//se crea y arma la escructura de busqueda
		this.filtroRango = new FiltroRango(nuevoRango);
		this.listaDeFiltros.add(this.filtroRango);
		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		
		resultado = sutBuscador.buscar(listaDeHoteles);

		assertEquals(0, resultado.size());
		
	}

	/**
	 * Busqueda compleja donde utilizo todos los filtros juntos
	 * Disponibilidad NO OK por todas las condiciones
	 */
	@Test
	public void testObtengoHotelTodosLosFiltros() {
		
		// Rango Consultado
		DateTime fechaDesde = new DateTime(2015,9,9,0,0);
		DateTime fechaHasta = new DateTime(2015,9,30,0,0);
		qRango = new Rango(fechaDesde, fechaHasta);
		//se crea y arma la escructura de busqueda
		this.filtroNombreHotel = new FiltroNombreHotel("CCC");
		this.listaDeFiltros.add(this.filtroNombreHotel);
		
		this.filtroRango = new FiltroRango(qRango);
		this.listaDeFiltros.add(this.filtroRango);
		
		this.filtroCiudadHotel = new FiltroCiudadHotel(wilde);
		this.listaDeFiltros.add(this.filtroCiudadHotel);
		
		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(5);
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);

		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		
		resultado = sutBuscador.buscar(listaDeHoteles);

		assertEquals(0, resultado.size());
		
	}
	
	/**
	 * Busqueda compleja donde utilizo todos los filtros juntos
	 * Disponibilidad OK
	 */
	@Test
	public void testObtengoHotelTodosLosFiltrosConDisponibilidad() {
		
		// Rango Consultado
		DateTime fechaDesde = new DateTime(2015,10,10,0,0);
		DateTime fechaHasta = new DateTime(2015,11,11,0,0);
		eRango = new Rango(fechaDesde, fechaHasta);
		//se crea y arma la escructura de busqueda
		this.filtroNombreHotel = new FiltroNombreHotel("AAA");
		this.listaDeFiltros.add(this.filtroNombreHotel);

		this.filtroRango = new FiltroRango(eRango);
		this.listaDeFiltros.add(this.filtroRango);

		this.filtroCiudadHotel = new FiltroCiudadHotel(quilmes);
		this.listaDeFiltros.add(this.filtroCiudadHotel);
		
		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(1);
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);

		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		resultado = sutBuscador.buscar(listaDeHoteles);

		assertEquals(1, resultado.size());
		
	}

	/**
	 * Busqueda compleja donde utilizo todos los filtros juntos
	 * Disponibilidad NO OK solo por una condiciòn
	 */
	@Test
	public void testObtengoHotelTodosLosFiltrosSinDisponibilidad() {
		
		// Rango Consultado
		DateTime fechaDesde = new DateTime(2015,10,10,0,0);
		DateTime fechaHasta = new DateTime(2015,11,11,0,0);
		wRango = new Rango(fechaDesde, fechaHasta);
		//se crea y arma la escructura de busqueda
		this.filtroNombreHotel = new FiltroNombreHotel("AAA");
		this.listaDeFiltros.add(this.filtroNombreHotel);

		this.filtroRango = new FiltroRango(wRango);
		this.listaDeFiltros.add(this.filtroRango);

		this.filtroCiudadHotel = new FiltroCiudadHotel(avellaneda);
		this.listaDeFiltros.add(this.filtroCiudadHotel);
		
		this.filtroCantidadHuespedes = new FiltroCantidadHuespedes(1);
		this.listaDeFiltros.add(this.filtroCantidadHuespedes);

		this.sutBuscador = new FiltroCompuesto(listaDeFiltros);
		resultado = sutBuscador.buscar(listaDeHoteles);

		assertEquals(0, resultado.size());
		
	}
	
}
