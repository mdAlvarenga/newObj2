package model;

import java.util.List;

import org.joda.time.DateTime;

public class Hotel {
	/*CONSIDERACIONES DE LA CLASE:
	 *		Dudas con formas de pago. No hay necesidad de hacerlas clases, pero por otro lado, 
	 *			seria mucho mas entendible y escalable el sistema. 
	 **/
	private String nombreHotel;
	private String nombreCiudad;
	private List<Habitacion> habitaciones;
	private List<Servicio> servicios;
	private String categoria;
	private DateTime checkIn;
	private DateTime checkOut;
	
	public Hotel(String unNombre, String unaCiudad, List<Habitacion> habitaciones, 
					List<Servicio> servicios, String unaCategoria, DateTime checkIn, DateTime checkOut) {
		
		this.setNombreHotel(unNombre);
		this.setNombreCiudad(unaCiudad);
		this.setHabitaciones(habitaciones);
		this.setServicios(servicios);
		this.setCategoria(unaCategoria);
		this.setCheckIn(checkIn);
		this.setCheckOut(checkOut);
		
	}
	
	public List<Reserva> reservasDentroDeFecha(DateTime unaFecha) {
		return null;
	}

	public List<Reserva> reservasConFechaMayorA(DateTime unaFecha) {
		return null;
	}

	/*Getters and setters
	 */

	public String getNombreHotel() {
		return nombreHotel;
	}

	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}

	public String getNombreCiudad() {
		return nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}
	
	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public DateTime getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(DateTime checkIn) {
		this.checkIn = checkIn;
	}

	public DateTime getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(DateTime checkOut) {
		this.checkOut = checkOut;
	}
}
