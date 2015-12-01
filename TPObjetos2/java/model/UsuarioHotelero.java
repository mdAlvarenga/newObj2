package model;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class UsuarioHotelero extends Usuario {
	private String cuit;
	private List<Hotel> hoteles;

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public List<Reserva> reservasActuales() {
		DateTime hoy = new DateTime();
		List<Reserva> reservasActuales = new ArrayList<Reserva>();
		for(Hotel hotel:this.hoteles){
			reservasActuales.addAll(hotel.reservasDentroDeFecha(hoy));
		}
		return reservasActuales;
	}
	
	public UsuarioHotelero(){
		
		hoteles = new ArrayList<Hotel>();
	}

	public List<Reserva> reservasFuturas() {
		DateTime hoy = new DateTime();
		List<Reserva> reservasFuturas = new ArrayList<Reserva>();
		for(Hotel hotel:this.hoteles){
			reservasFuturas.addAll(hotel.reservasDentroDeFecha(hoy));
		}
		return reservasFuturas;
		
	}
}
