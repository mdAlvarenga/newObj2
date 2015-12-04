package model;

import java.util.ArrayList;
import java.util.List;

public class FiltroCiudadHotel extends FiltroBusqueda {
	private String ciudadABuscar;
	
	public FiltroCiudadHotel(String ciudad){
		this.setCiudadABuscar(ciudad);
	}

	@Override
	public List<Habitacion> buscarHabitaciones(Hotel hotel) {
		return new ArrayList<Habitacion>();
	}
	
	@Override
	public List<Hotel> buscar(List<Hotel> hoteles) {
		List<Hotel> res = new ArrayList<Hotel>();
		
		for (Hotel h : hoteles) {
			if (h.getNombreCiudad().equalsIgnoreCase(this.getCiudadABuscar())){
				res.add(h);
			}
		}
		return res;	
	}

	//Getters and Setters
	private String getCiudadABuscar() {
		return this.ciudadABuscar;
	}
	
	private void setCiudadABuscar(String ciudad) {
		this.ciudadABuscar = ciudad;
	}
}
