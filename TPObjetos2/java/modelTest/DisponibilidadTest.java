package modelTest;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import model.Disponibilidad;
import model.Rango;
import model.Reserva;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

public class DisponibilidadTest {
	Disponibilidad disp;
	Rango rango1;
	@Before
	public void setupReserva(){

		// RESERVA 1
		DateTime fechaDesde = new DateTime(2015,10,10,0,0);
		DateTime fechaHasta = new DateTime(2015,11,11,0,0);
		rango1 = new Rango(fechaDesde, fechaHasta);
		Double totalReserva = 200.0;
		Reserva reserva1 = new Reserva(rango1, totalReserva);
		
		// RESERVA 2
		fechaDesde = new DateTime(2015,11,12,0,0);
		fechaHasta = new DateTime(2015,12,12,0,0);
		Rango rango2 = new Rango(fechaDesde, fechaHasta);
		totalReserva = 200.0;
		Reserva reserva2 = new Reserva(rango2, totalReserva);

		// LISTA DE RESERVAS
		List<Reserva> reservas = new ArrayList<Reserva>();
			
		// DISPONIBILIDAD
		disp = new Disponibilidad();
	}
		
	@Test
	public void testReserva() {
		assertTrue(disp.rangoDisponibleParaUnaFecha(rango1));		
	}

}
