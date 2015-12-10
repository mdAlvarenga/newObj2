package agusTest;

import org.joda.time.DateTime;
import org.junit.Test;

import model.Habitacion;
import model.Hotel;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class HotelTest {
	
	private DateTime fechaDeHoy;
	private Hotel hotel;
	private Habitacion habitacion1;
	private Habitacion habitacion2;

	@Test
	public void testReservasDentroDeFecha() {
//		assertEquals(hotel.reservasDentroDeFecha(fechaDeHoy).size(), 2);
//		verify(habitacion1, atLeastOnce()).getReservasParaFecha(fechaDeHoy);
//		verify(habitacion2, atLeastOnce()).getReservasParaFecha(fechaDeHoy);
	}
	
	public void testReservasConFechaMayorA() {
	/*public List<Reserva> reservasConFechaMayorA(DateTime unaFecha) {

		List<Reserva> reservas = new ArrayList<Reserva>();
		
		for(Habitacion h: this.habitaciones){
				reservas.addAll(h.reservasConFechaMayorA(unaFecha));
		}
		return reservas;
	*/
	}

	public void testTieneHabitacionQueCumpleCapacidad() {
	/*public boolean tieneHabitacionQueCumpleCapacidad(int unaCapacidad) {
		boolean ret = false;
		for (Habitacion hab : this.getHabitaciones()) {
			ret = ret || (hab.getCapacidadMaxima() >= unaCapacidad); 
		}
		return ret;
	*/
	}

	public void testHabitacionNoTieneReservaEnFecha() {
	/*public boolean habitacionNoTieneReservaEnFecha(Habitacion unaHabitacion,Reserva unaReserva) {
		//ya sabes agus, aca recorres las habitaciones y me retornas si NO ESTA RESERVADA, true :D
		// TODO Auto-generated method stub
		return false;
	*/
	}		

}
