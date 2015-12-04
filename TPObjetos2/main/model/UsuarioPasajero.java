package model;

import java.util.ArrayList;
import java.util.List;

public class UsuarioPasajero extends Usuario {
	private int dni;
	private List<Habitacion> habitaciones;

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public List<Reserva> todasLasReservas() {
		List<Reserva> reservasDelUsuario = new ArrayList<Reserva>();
		for(Habitacion habitacion : this.getHabitaciones()){

			reservasDelUsuario.addAll(habitacion.reservasDelUsuario(this));
		}
		return reservasDelUsuario;
	}

	public List<Reserva> reservasFuturas() {
		List<Reserva> reservasFuturas = new ArrayList<Reserva>();
		for(Habitacion habitacion : this.getHabitaciones()){

			reservasFuturas.addAll(habitacion.reservasFuturasDelUsuario(this));
		}
		return reservasFuturas;
	}

	public List<Reserva> reservasDeUnaCiudad(String unaCiudad) {
		List<Reserva> reservasDeUnaCiudad = new ArrayList<Reserva>();
		for(Habitacion habitacion : this.getHabitaciones()){

			reservasDeUnaCiudad.addAll(habitacion.reservasDeUnaCiudadDelUsuario(unaCiudad, this));
		}
		return reservasDeUnaCiudad;		
	}

	public List<String> ciudadesConReserva() {
		List<String> ciudadesConReserva = new ArrayList<String>();
		for(Habitacion habitacion : this.getHabitaciones()){

			ciudadesConReserva.add(habitacion.ciudadDelHotelDondeEstas());
		}
		return ciudadesConReserva;		
	}

	public void agregarHabitacionReservada(Habitacion unaHabitacion) {
		this.getHabitaciones().add(unaHabitacion);
	}
	
	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public UsuarioPasajero(){
		
		habitaciones = new ArrayList<Habitacion>();
	}

	public void cancelarReserva(Reserva unaReserva) {
		for(Habitacion habitacion: this.getHabitaciones()){
			habitacion.cancelaSiPodes(unaReserva);
		}
	}
}
