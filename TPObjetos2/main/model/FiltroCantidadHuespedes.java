package model;

import java.util.ArrayList;
import java.util.List;

public class FiltroCantidadHuespedes extends FiltroBusquedaAntesTDD {
	private int cantDePasajeros;
	
	public FiltroCantidadHuespedes(int cantABuscar){
		this.setCantDePasajeros(cantABuscar);
		 
	}

	@Override
	public List<Habitacion> buscarHabitaciones(Hotel hotel) {
		
		List<Habitacion> res = new ArrayList<Habitacion>();
		for (Habitacion h : hotel.getHabitaciones()) {
			if (h.getCapacidadMaxima() >= this.getCantDePasajeros()){
				res.add(h);
			}
		}
		return res;
	}
	
	@Override
	public List<Hotel> buscar(List<Hotel> hoteles) {		
		List<Hotel> res = new ArrayList<Hotel>();
		
		for (Hotel h : hoteles) {
			if (h.tieneHabitacionQueCumpleCapacidad(this.getCantDePasajeros())){
				res.add(h);
			}
		}
		return res;
	}

	//Getters and Setters
	private void setCantDePasajeros(int cantABuscar) {
		this.cantDePasajeros = cantABuscar;
	}
	
	private int getCantDePasajeros() {
		return this.cantDePasajeros;
	}
}
