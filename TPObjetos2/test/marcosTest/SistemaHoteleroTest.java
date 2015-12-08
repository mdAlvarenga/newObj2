package marcosTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class SistemaHoteleroTest extends SistemaHoteleroAbstractTest{
	
	@Test
	public void cuandoPidoReservasConInicioEnNDiasDeLaHoteleraGilMeRetornaReservasFuturasEnNDiasHotelero() {	
		when(gestor.ReservasInicioEnNFuturosDiasHotelero(hoteleraGil, 3)).thenReturn(reservasFuturasEnNDiasHotelero);
		assertEquals(sutSistemaHotelero.ReservasInicioEnNFuturosDiasHotelero(hoteleraGil, 3),reservasFuturasEnNDiasHotelero);
	}
	
	@Test
	public void cuandoPidoTodasLasReservasFuturasDeLosHotelesDeGilMeRetornareservasFuturasHotelero() {	
		when(gestor.ReservasFuturasDeHotelero(hoteleraGil)).thenReturn(reservasFuturasHotelero);
		assertEquals(sutSistemaHotelero.ReservasFuturasDeHotelero(hoteleraGil),reservasFuturasHotelero);
	}
	
	@Test
	public void cuandoPidoTodasLasReservasActualesDeLosHotelesDeSmithMeRetornareservasActualesHotelero() {	
		when(gestor.ReservasActualesDeHotelero(hoteleroSmith)).thenReturn(reservasActualesHotelero);
		assertEquals(sutSistemaHotelero.todasReservasActualesDeHotelero(hoteleroSmith),reservasActualesHotelero);
	}
	
	@Test
	public void cuandoPidoTodasReservasFuturasDeAgusMeRetornaReservasFuturas() {	
		when(gestor.todasReservasFuturasDePasajero(pasajeroAgustin)).thenReturn(reservasFuturas);
		assertEquals(sutSistemaHotelero.todasReservasFuturasDePasajero(pasajeroAgustin),reservasFuturas);
	}
	
	@Test
	public void cuandoPidoTodasLasCiudadesDondeReservoMariMeRetornaCiudadesVisitoMari() {	
		when(gestor.ciudadesDondePasajeroTieneReserva(pasajeraMari)).thenReturn(ciudadesVisitoMari);
		assertEquals(sutSistemaHotelero.ciudadesConReservaDePasajero(pasajeraMari),ciudadesVisitoMari);
	}
	
	@Test
	public void cuandoPidoTodasReservasDeUsuarioMeRetornaTodasReservas() {	
		when(gestor.todasReservasDePasajero(pasajeraMari)).thenReturn(todasReservas);
		assertEquals(sutSistemaHotelero.todasReservasDePasajero(pasajeraMari),todasReservas);
	}
	
	@Test
	public void cuandoBuscoReservasDeUsuarioPorCiudadMeRetornaPrimerasReservas() {	
		when(gestor.reservaDePasajeroParaCiudad(pasajeroAgustin, madrid)).thenReturn(primerasReservas);
		assertEquals(sutSistemaHotelero.reservaDePasajeroParaCiudad(pasajeroAgustin, madrid),primerasReservas);
	}
	
	
	@Test
	public void cuandoBuscoHabitacionesEnLosHotelesFiltradosDelPrimerFiltroMeRetornaListaHabitaciones1() {	
		when(primerFiltro.buscarHabitaciones(hotelBoca)).thenReturn(listaHabitacionesPrimerFiltro);
		assertEquals(sutSistemaHotelero.filtrarHabitaciones(primerFiltro, hotelBoca),listaHabitacionesPrimerFiltro);
	}
	
	@Test
	public void cuandoBuscoHabitacionesEnLosHotelesDelSegundoFiltroMeRetornaListaHabitaciones2() {
		when(segundoFiltro.buscarHabitaciones(hotelColonial)).thenReturn(listaHabitacionesSegundoFiltro);
		assertEquals(sutSistemaHotelero
						.filtrarHabitaciones(segundoFiltro,hotelColonial),listaHabitacionesSegundoFiltro);
	}
	
	@Test
	public void cuandoBuscoHotelesConElSegundoFiltroRetornaLista2() {
		when(segundoFiltro.buscar(listaDeHoteles)).thenReturn(listaHotelesSegundoFiltro);
		when(gestor.getHoteles()).thenReturn(listaDeHoteles);	
		assertEquals(sutSistemaHotelero.buscarHotelesPorFiltros(segundoFiltro),listaHotelesSegundoFiltro);
	}
	
	@Test
	public void cuandoBuscoHotelesConElPrimerFiltroRetornaLista1() {
		when(primerFiltro.buscar(listaDeHoteles)).thenReturn(listaHotelesPrimerFiltro);
		when(gestor.getHoteles()).thenReturn(listaDeHoteles);
		assertEquals(sutSistemaHotelero.buscarHotelesPorFiltros(primerFiltro),listaHotelesPrimerFiltro);
	}
	
	@Test
	public void cuandoPidoElSizeDeLaListaDeReservasMeRetorna2() {
		when(gestor.getReservas()).thenReturn(listaDeReservas);
		assertEquals(sutSistemaHotelero.getGestor().getReservas().size(),2);
	}
	
	@Test
	public void cuandoAgregoUnaReservaElSizeDeLaListaDeReservasMeRetorna3() {
		sutSistemaHotelero.agregarReserva(tercerReserva);
		verify(gestor).agregarReserva(tercerReserva);
	}

	@Test
	public void cuandoPidoElSizeDeLaListaDeHotelesMeRetorna1() {
		when(gestor.getHoteles()).thenReturn(listaDeHoteles);
		assertEquals(sutSistemaHotelero.getGestor().getHoteles().size(),1);
	}
	
	@Test
	public void cuandoAgregoUnHotelElSizeDeLaListaDeHotelesMeRetorna2() {
		sutSistemaHotelero.agregarHotel(hotelBoca);
		verify(gestor).agregarHotel(hotelBoca);
	}
	
	@Test
	public void cuandoPidoElSizeDeLaListaDeUsuariosMeRetorna2() {
		assertEquals(sutSistemaHotelero.getListaDeUsuarios().size(),2);
	}
	
	@Test
	public void cuandoAgregoUnUsuarioElSizeDeLaListaDeUsuariosMeRetorna3() {
		sutSistemaHotelero.agregarUsuario(pasajeroMarcos);
		assertEquals(sutSistemaHotelero.getListaDeUsuarios().size(),3);
	}
}
