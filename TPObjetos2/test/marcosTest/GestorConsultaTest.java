package marcosTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class GestorConsultaTest extends GestorConsultaSetUp{
//public void agregarReserva(Reserva unaReserva, Habitacion unaHabitacion, Hotel unHotel);	
	@Test 
	public void cuandoAgregoUnaReservaElSizeDeLasReservasCambiaA7(){
		//verify(hotelBoca).agregarReservaEnHabitacion(habitacionBoca2, nuevaReserva);
		sutGestor.agregarReserva(nuevaReserva, habitacionBoca2, hotelBoca);
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

/*

public void agregarHotel(Hotel unHotel);
public List<Reserva> ReservasActualesDeHotelero(UsuarioHotelero unHotelero);
public List<Reserva> ReservasFuturasDeHotelero(UsuarioHotelero unHotelero);
public List<Reserva> ReservasInicioEnNFuturosDiasHotelero(UsuarioHotelero unHotelero, int i);
*/

/*
when(hotelBoca.getCiudad()).thenReturn(this.puntaCana);
when(hotelColonial.getCiudad()).thenReturn(this.florianopolis);
when(this.res1.getUsuarioQueReserva()).thenReturn(pasajeraMariu);
when(this.res1.fechaDeReservaPosteriorA(DateTime.now())).thenReturn(true);
when(this.res2.getUsuarioQueReserva()).thenReturn(pasajeroAgustin);
when(this.res2.fechaDeReservaPosteriorA(DateTime.now())).thenReturn(false);
when(hotelBoca.getHabitaciones()).thenReturn(this.listhabitaciones);
when(hotelColonial.getHabitaciones()).thenReturn(this.listhabitaciones);
when(habitacionTevez.reservasDelUsuario(this.pasajeraMariu)).thenReturn(this.listaReservas);
*/
