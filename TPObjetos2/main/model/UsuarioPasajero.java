package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		Set<Reserva> reservasDelUsuario = new HashSet<Reserva>();

		for(Habitacion habitacion : this.getHabitaciones()){

			reservasDelUsuario.addAll(habitacion.reservasDelUsuario(this));
		}
		List<Reserva> resultado = new ArrayList<Reserva>();
		resultado.addAll(reservasDelUsuario);
		return resultado;
	}

	public List<Reserva> reservasFuturas() {
		Set<Reserva> reservasFuturas = new HashSet<Reserva>();
		for(Habitacion habitacion : this.getHabitaciones()){
			reservasFuturas.addAll(habitacion.reservasFuturasDelUsuario(this));
		}
		List<Reserva> resultado = new ArrayList<Reserva>();
		resultado.addAll(reservasFuturas);
		return resultado;
	}

	public List<Reserva> reservasDeUnaCiudad(String unaCiudad) {
		
		Set<Reserva> reservasDeUnaCiudad = new HashSet<Reserva>();
		for(Habitacion habitacion : this.getHabitaciones()){
			reservasDeUnaCiudad.addAll(habitacion.reservasDeUnaCiudadDelUsuario(unaCiudad, this));
		}
		List<Reserva> resultado = new ArrayList<Reserva>();
		resultado.addAll(reservasDeUnaCiudad);
		return resultado;		
	}

	public List<String> ciudadesConReserva() {

		Set<String> ciudadesConReserva = new HashSet<String>();
		
		for(Habitacion habitacion : this.getHabitaciones()){
			ciudadesConReserva.add(habitacion.ciudadDelHotelDondeEstas());
		}
		
		List<String> resultado = new ArrayList<String>();
		resultado.addAll(ciudadesConReserva);
		
		return resultado;		
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
