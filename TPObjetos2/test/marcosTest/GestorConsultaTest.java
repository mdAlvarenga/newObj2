package marcosTest;

import static org.mockito.Mockito.when;

import org.joda.time.DateTime;

public class GestorConsultaTest extends GestorConsultaSetUp{

}
when(hotelBoca.getCiudad()).thenReturn(this.puntaCana);
when(hotelColonial.getCiudad()).thenReturn(this.florianopolis);
when(this.res1.getUsuarioQueReserva()).thenReturn(pasajeraMariu);
when(this.res1.fechaDeReservaPosteriorA(DateTime.now())).thenReturn(true);
when(this.res2.getUsuarioQueReserva()).thenReturn(pasajeroAgustin);
when(this.res2.fechaDeReservaPosteriorA(DateTime.now())).thenReturn(false);

when(hotelBoca.getHabitaciones()).thenReturn(this.listhabitaciones);
when(hotelColonial.getHabitaciones()).thenReturn(this.listhabitaciones);

when(habitacionTevez.reservasDelUsuario(this.pasajeraMariu)).thenReturn(this.listaReservas);
