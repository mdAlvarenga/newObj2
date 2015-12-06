package model;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;;

public class FiltroRango extends FiltroBusquedaAntesTDD {
	private Rango rango;
	
	public FiltroRango(Rango unRango){
		this.setRango(unRango);
	}
	
	@Override
	public List<Habitacion> buscarHabitaciones(Hotel hotel) {
		List<Habitacion> res = new ArrayList<Habitacion>();
		for (Habitacion h : hotel.getHabitaciones()) {
			if (h.disponibilidadPara(this.getRango())){
				res.add(h);
			}
		}
		return res;
	}
		
	@Override
	public List<Hotel> buscar(List<Hotel> hoteles) {
		List<Hotel> res = new ArrayList<Hotel>();
		for (Hotel h : hoteles) {
			if (this.tieneHabitacionQueCumpleFechas(h)){
				res.add(h);
			}
		}
		return res;
	}
	
	private boolean tieneHabitacionQueCumpleFechas(Hotel h) {
		boolean ret = false;
		for (Habitacion hab : h.getHabitaciones()) {
			ret = ret || hab.disponibilidadPara(this.getRango()); 
		}
		return ret;
	}

	//Getters and Setters
	public Rango getRango() {
		return rango;
	}

	public void setRango(Rango rango) {
		this.rango = rango;
	}
}
