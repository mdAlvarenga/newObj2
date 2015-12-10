package marcosTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.joda.time.DateTime;
import org.junit.Test;

public class GestorConsultaTest extends GestorConsultaSetUp{		
	
	@Test 
	public void 
		verificaTantoLlamadasComoNoLlamadasAMetodosDeDistintosHotelesCuandoReservoParaNFuturosDias(){
		
		sutGestor.ReservasInicioEnNFuturosDiasHotelero(hoteleraGil, 5);
		String format = hoy.plusDays(5).toString("yyyy-MM-dd");
		DateTime fechaComparacion= new DateTime(format);
		verify(hotelParis).reservasConFechaMayorA(fechaComparacion);
		verify(hotelIntercontinental).reservasConFechaMayorA(fechaComparacion);
		verify(hotelRosario).reservasConFechaMayorA(fechaComparacion);
		verify(hotelBoca, times(0)).reservasConFechaMayorA(fechaComparacion);
		verify(hotelColonial, times(0)).reservasConFechaMayorA(fechaComparacion);
	}
	
	@Test 
	public void cuandoPidoLasReservasFuturasDelHoteleroSmithVerificaLlamadoAMetodoDeHotel2Veces(){
		sutGestor.ReservasFuturasDeHotelero(hoteleroSmith);
		verify(hotelBoca).reservasConFechaMayorA(hoy);
		verify(hotelColonial).reservasConFechaMayorA(hoy);
	}
	
	@Test 
	public void cuandoPidoLasReservasActualesDeLaHoteleraGilVerificaLlamadoAMetodoDeHotel2Veces(){
		sutGestor.ReservasActualesDeHotelero(hoteleraGil);
		verify(hotelRosario).reservasDentroDeFecha(hoy);
		verify(hotelParis).reservasDentroDeFecha(hoy);
	}

	@Test 
	public void cuandoAgregoUnHotelElSizeDeLosHotelesCambiaA6(){
		sutGestor.agregarHotel(nuevoHotel);
		assertEquals(sutGestor.getHoteles().size(),6);	
	}
	
	@Test 
	public void cuandoIntentoagregarUnaReservaNoSePuedePorqueNoHayDisponibilidadParaLaFecha(){
		when(habitacionBoca2.disponibilidadPara(reservaQueFalla.getRangoDeReserva())).thenReturn(false);
		sutGestor.agregarReserva(reservaQueFalla, habitacionBoca2, hotelBoca);
		verify(hotelBoca, never()).agregarReservaEnHabitacion(habitacionBoca2, nuevaReserva);
	}
	
	@Test 
	public void agregoUnaReservaElSizeDeLasReservasCambiaA7SeVerificaElLlamadoAUnaFuncionEnHotel(){
		when(habitacionBoca2.disponibilidadPara(nuevaReserva.getRangoDeReserva())).thenReturn(true);
		sutGestor.agregarReserva(nuevaReserva, habitacionBoca2, hotelBoca);
		verify(hotelBoca).agregarReservaEnHabitacion(habitacionBoca2, nuevaReserva);
		assertEquals(sutGestor.getReservas().size(),7);	
	}
	
	@Test //Si falla es por el tema del instante de tiempo que testea cuando instancia un DateTime 
	public void cuandoPidoLasReservasFuturasDeMariuMeRetornaUnaListaConUnaReservaFutura(){
		assertTrue(sutGestor.todasReservasFuturasDePasajero(pasajeraMariu).contains(resFutura));
	}
	
	@Test 
	public void cuandoPidoLasCiudadesDondeMaariuReservoMeRetornaCiudadesMariu(){
		assertEquals(sutGestor.ciudadesDondePasajeroTieneReserva(pasajeraMariu), ciudadesMariu);
	}
	
	@Test 
	public void cuandoPidoLasCiudadesDondeAgusReservoMeRetornaCiudadesAgus(){
		assertEquals(sutGestor.ciudadesDondePasajeroTieneReserva(pasajeroAgustin), ciudadesAgus);
	}
	
	@Test 
	public void cuandoPidoLasReservasParaMariuMeRetornaLaListaConReserva1(){
		assertTrue(sutGestor.reservaDePasajeroParaCiudad(pasajeraMariu, rosario).contains(resMari1));
	}
	
	@Test 
	public void cuandoPidoLasReservasParaAgustinMeRetornaLaListaConReserva1(){
		assertTrue(sutGestor.reservaDePasajeroParaCiudad(pasajeroAgustin, paris).contains(resAgus1));
	}
	
	@Test
	public void cuandoPidoSizeDeListaDeHotelesMeRetorna5() {	
		assertEquals(this.sutGestor.getHoteles().size(), 5);					
	}
	
	@Test
	public void cuandoPidoSizeDeListaReservasMeRetorna6() {	
		assertEquals(this.sutGestor.getReservas().size(), 6);					
	}
	
	@Test
	public void cuandoPidoSizeDeTodasReservasDePasajeroAgustinMeRetorna3() {	
		assertEquals(this.sutGestor.todasReservasDePasajero(pasajeroAgustin).size(), 3);			
	}
	
	@Test
	public void cuandoPidoSizeDeTodasReservasDePasajeraMariMeRetorna3() {	
		assertEquals(this.sutGestor.todasReservasDePasajero(pasajeraMariu).size(), 3);			
	}


}