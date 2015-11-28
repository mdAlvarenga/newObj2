package model;

import java.util.ArrayList;
import java.util.List;

public class FiltroCantidadHuespedes extends FiltroBusqueda {
	private int cantDePasajeros;
	
	public FiltroCantidadHuespedes(int cantABuscar){
		this.setCantDePasajeros(cantABuscar);
	}

	@Override
	public List<Hotel> buscar(List<Hotel> hoteles) {
		List<Hotel> res = new ArrayList<Hotel>();
		
		for (Hotel h : hoteles) {
			if (this.tieneHabitacionQueCumpleCapacidad(h)){
				res.add(h);
			}
		}
		return res;
	}
	
	private boolean tieneHabitacionQueCumpleCapacidad(Hotel h) {
		boolean ret = false;
		for (Habitacion hab : h.getHabitaciones()) {
			ret = ret || hab.getCapacidadMaxima() >= this.getCantDePasajeros(); 
		}
		return ret;
	}

	private void setCantDePasajeros(int cantABuscar) {
		this.cantDePasajeros = cantABuscar;
	}
	
	private int getCantDePasajeros() {
		return this.cantDePasajeros;
	}

}
