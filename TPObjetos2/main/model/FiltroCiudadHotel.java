package model;

import java.util.ArrayList;
import java.util.List;

import clasesPorCompletitud.Ciudad;

public class FiltroCiudadHotel extends FiltroBusqueda{
	private Ciudad ciudadABuscar;
	
	public FiltroCiudadHotel(Ciudad unaCiudad){
		this.setCiudadABuscar(unaCiudad);
	}
	
	@Override
	public List<Habitacion> buscarHabitaciones(Hotel hotel) {
		List<Habitacion> res = new ArrayList<Habitacion>();
		if (hotel.nombreCiudad().equalsIgnoreCase(this.nombreCiudadABuscar())){
			res.addAll(hotel.getHabitaciones());
		}
		return res;	
	}
	
	@Override
	public List<Hotel> buscar(List<Hotel> hoteles) {
		List<Hotel> res = new ArrayList<Hotel>();
		
		for (Hotel h : hoteles) {
			if (h.nombreCiudad().equalsIgnoreCase(this.nombreCiudadABuscar())){
				res.add(h);
			}
		}
		return res;	
	}

	private String nombreCiudadABuscar() {
		return this.getCiudadABuscar().getNombre();
	}

	//Getters and Setters
	private Ciudad getCiudadABuscar() {
		return this.ciudadABuscar;
	}
	
	private void setCiudadABuscar(Ciudad ciudad) {
		this.ciudadABuscar = ciudad;
	}
}
