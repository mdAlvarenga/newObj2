package model;

import java.util.List;

public class GestorDeReservas {
	
	protected List<Reserva> reservas;
	protected List<Hotel> hoteles;
	
	public GestorDeReservas(List<Reserva> res, List<Hotel> hs){
		this.reservas = res;
		this.hoteles = hs;
	}

}
