package marcosTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class SistemaHoteleroTest extends SistemaHoteleroSetUp{
	
	@Test
	public void cuandoPidoReservasConInicioEnNDiasDeLaHoteleraGilMeRetornaReservasFuturasEnNDiasHotelero() {	
		when(this.gestor.ReservasInicioEnNFuturosDiasHotelero(this.hoteleraGil, 3))
				.thenReturn(this.reservasFuturasEnNDiasHotelero);
		assertEquals(this.sutSistemaHotelero
						.ReservasInicioEnNFuturosDiasHotelero(this.hoteleraGil, 3),this.reservasFuturasEnNDiasHotelero);
	}
	
	@Test
	public void cuandoPidoTodasLasReservasFuturasDeLosHotelesDeGilMeRetornareservasFuturasHotelero() {	
		when(this.gestor.ReservasFuturasDeHotelero(this.hoteleraGil)).thenReturn(this.reservasFuturasHotelero);
		assertEquals(this.sutSistemaHotelero.ReservasFuturasDeHotelero(this.hoteleraGil),this.reservasFuturasHotelero);
	}
	
	@Test
	public void cuandoPidoTodasLasReservasActualesDeLosHotelesDeSmithMeRetornareservasActualesHotelero() {	
		when(this.gestor.ReservasActualesDeHotelero(this.hoteleroSmith)).thenReturn(this.reservasActualesHotelero);
		assertEquals(this.sutSistemaHotelero
						.todasReservasActualesDeHotelero(this.hoteleroSmith),this.reservasActualesHotelero);
	}
	
	@Test
	public void cuandoPidoTodasReservasFuturasDeAgusMeRetornaReservasFuturas() {	
		when(this.gestor.todasReservasFuturasDePasajero(this.pasajeroAgustin)).thenReturn(this.reservasFuturas);
		assertEquals(this.sutSistemaHotelero.todasReservasFuturasDePasajero(this.pasajeroAgustin),this.reservasFuturas);
	}
	
	@Test
	public void cuandoPidoTodasLasCiudadesDondeReservoMariMeRetornaCiudadesVisitoMari() {	
		when(this.gestor.ciudadesDondePasajeroTieneReserva(this.pasajeraMari)).thenReturn(this.ciudadesVisitoMari);
		assertEquals(this.sutSistemaHotelero.ciudadesConReservaDePasajero(this.pasajeraMari),this.ciudadesVisitoMari);
	}
	
	@Test
	public void cuandoPidoTodasReservasDeUsuarioMeRetornaTodasReservas() {	
		when(this.gestor.todasReservasDePasajero(this.pasajeraMari)).thenReturn(this.todasReservas);
		assertEquals(this.sutSistemaHotelero.todasReservasDePasajero(this.pasajeraMari),this.todasReservas);
	}
	
	@Test
	public void cuandoBuscoReservasDeUsuarioPorCiudadMeRetornaPrimerasReservas() {	
		when(this.gestor.reservaDePasajeroParaCiudad(this.pasajeroAgustin,this.madrid))
				.thenReturn(this.primerasReservas);
		assertEquals(this.sutSistemaHotelero
						.reservaDePasajeroParaCiudad(this.pasajeroAgustin, this.madrid),this.primerasReservas);
	}
	
	
	@Test
	public void cuandoBuscoHabitacionesEnLosHotelesFiltradosDelPrimerFiltroMeRetornaListaHabitaciones1() {	
		when(this.primerFiltro.buscarHabitaciones(this.hotelBoca)).thenReturn(this.listaHabitacionesPrimerFiltro);
		assertEquals(this.sutSistemaHotelero
						.filtrarHabitaciones(this.primerFiltro,this.hotelBoca),this.listaHabitacionesPrimerFiltro);
	}
	
	@Test
	public void cuandoBuscoHabitacionesEnLosHotelesDelSegundoFiltroMeRetornaListaHabitaciones2() {
		when(this.segundoFiltro.buscarHabitaciones(this.hotelColonial)).thenReturn(this.listaHabitacionesSegundoFiltro);
		assertEquals(this.sutSistemaHotelero
						.filtrarHabitaciones(this.segundoFiltro,this.hotelColonial),this.listaHabitacionesSegundoFiltro);
	}
	
	@Test
	public void cuandoBuscoHotelesConElSegundoFiltroRetornaLista2() {
		when(this.segundoFiltro.buscar(this.listaDeHoteles)).thenReturn(this.listaHotelesSegundoFiltro);
		when(this.gestor.getHoteles()).thenReturn(this.listaDeHoteles);	
		assertEquals(this.sutSistemaHotelero.buscarHotelesPorFiltros(this.segundoFiltro)
																		,this.listaHotelesSegundoFiltro);
	}
	
	@Test
	public void cuandoBuscoHotelesConElPrimerFiltroRetornaLista1() {
		when(this.primerFiltro.buscar(this.listaDeHoteles)).thenReturn(this.listaHotelesPrimerFiltro);
		when(this.gestor.getHoteles()).thenReturn(this.listaDeHoteles);
		assertEquals(this.sutSistemaHotelero.buscarHotelesPorFiltros(this.primerFiltro),this.listaHotelesPrimerFiltro);
	}
	
	@Test
	public void cuandoPidoElSizeDeLaListaDeReservasMeRetorna2() {
		when(this.gestor.getReservas()).thenReturn(this.listaDeReservas);
		assertEquals(this.sutSistemaHotelero.getGestor().getReservas().size(),2);
	}
	
	@Test
	public void cuandoAgregoUnaReservaElSizeDeLaListaDeReservasMeRetorna3() {
		this.sutSistemaHotelero.agregarReserva(this.tercerReserva,habitacionBianchi,hotelBoca);
		verify(this.gestor).agregarReserva(this.tercerReserva,habitacionBianchi,hotelBoca);
	}

	@Test
	public void cuandoPidoElSizeDeLaListaDeHotelesMeRetorna1() {
		when(this.gestor.getHoteles()).thenReturn(this.listaDeHoteles);
		assertEquals(this.sutSistemaHotelero.getGestor().getHoteles().size(),1);
	}
	
	@Test
	public void cuandoAgregoUnHotelElSizeDeLaListaDeHotelesMeRetorna2() {
		this.sutSistemaHotelero.agregarHotel(this.hotelBoca);
		verify(this.gestor).agregarHotel(this.hotelBoca);
	}
	
	@Test
	public void cuandoPidoElSizeDeLaListaDeUsuariosMeRetorna2() {
		assertEquals(this.sutSistemaHotelero.getListaDeUsuarios().size(),2);
	}
	
	@Test
	public void cuandoAgregoUnUsuarioElSizeDeLaListaDeUsuariosMeRetorna3() {
		this.sutSistemaHotelero.agregarUsuario(this.pasajeroMarcos);
		assertEquals(this.sutSistemaHotelero.getListaDeUsuarios().size(),3);
	}
}
