package model;

import java.util.ArrayList;
import java.util.List;

public class FiltroNombreHotel extends FiltroBusqueda {
	
	private String nombreDeHotelABuscar;
	
	public FiltroNombreHotel (String nombreABuscar){
		this.setNombreDeHotelABuscar(nombreABuscar);		
	}	
	
	@Override
	public List<Habitacion> buscarHabitaciones(Hotel hotel) {
		return new ArrayList<Habitacion>();
	}

	@Override
	public List<Hotel> buscar(List<Hotel> hoteles) {
		List<Hotel> res = new ArrayList<Hotel>();
	
		for (Hotel h : hoteles) {
			if (h.getNombreHotel().equals(this.getNombreDeHotelABuscar())){
				res.add(h);
			}
		}
		return res;
	}

	//Getters and Setters
	private String getNombreDeHotelABuscar() {
		return this.nombreDeHotelABuscar;
	}
	
	private void setNombreDeHotelABuscar(String nombreABuscar) {
		this.nombreDeHotelABuscar = nombreABuscar;
	}
}
