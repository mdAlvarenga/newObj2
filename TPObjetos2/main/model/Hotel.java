package model;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class Hotel {
	/*CONSIDERACIONES DE LA CLASE:
	 *		Dudas con formas de pago. No hay necesidad de hacerlas clases, pero por otro lado, 
	 *			seria mucho mas entendible y escalable el sistema. 
	 **/
	private String nombreHotel;
	private Ciudad ciudad;
	private List<Habitacion> habitaciones;
	private List<Servicio> servicios;
	private String categoria;
	private DateTime checkIn;
	private DateTime checkOut;
	
	public Hotel(String unNombre, Ciudad unaCiudad, List<Habitacion> habitaciones, 
					List<Servicio> servicios, String unaCategoria, DateTime checkIn, DateTime checkOut) {
		
		this.setNombreHotel(unNombre);
		this.setCiudad(unaCiudad);
		this.setHabitaciones(habitaciones);
		this.setServicios(servicios);
		this.setCategoria(unaCategoria);
		this.setCheckIn(checkIn);
		this.setCheckOut(checkOut);		
	}
	
	public List<Reserva> reservasDentroDeFecha(DateTime unaFecha) {

		List<Reserva> reservas = new ArrayList<Reserva>();
		
		for(Habitacion h: this.habitaciones){
			if (!h.disponibilidadPara(unaFecha, unaFecha)){
				reservas.add(h.getReservaParaFecha(unaFecha));
			}
		}
		return reservas;
	}

	public List<Reserva> reservasConFechaMayorA(DateTime unaFecha) {

		List<Reserva> reservas = new ArrayList<Reserva>();
		
		for(Habitacion h: this.habitaciones){
				reservas.addAll(h.reservasConFechaMayorA(unaFecha));
		}
		return reservas;
	}

	//Getters and setters
	public String getNombreHotel() {
		return nombreHotel;
	}

	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad unaCiudad) {
		this.ciudad = unaCiudad;
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
