package model;

import java.util.List;

public class Hotel {
	private String nombreHotel;
	private String nombreCiudad;
	private List<Habitacion> habitaciones;
	
	public Object getNombreHotel() {
		return this.nombreHotel;
	}

	public String getNombreCiudad() {
		return this.nombreCiudad;
	}

	public List<Habitacion> getHabitaciones() {
		return this.habitaciones;
	}
	
	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}



	

}
