package noBorrarAun;

import java.util.List;

import model.Hotel;
import model.Reserva;

public class GestorDeReservas {
	
	protected List<Reserva> reservas;
	protected List<Hotel> hoteles;
	
	public GestorDeReservas(List<Reserva> res, List<Hotel> hs){
		this.reservas = res;
		this.hoteles = hs;
	}

}
