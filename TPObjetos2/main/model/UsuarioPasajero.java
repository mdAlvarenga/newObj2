package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UsuarioPasajero extends Usuario {
	/*
	 * Consideraciones de la clase: modelamos los datos de la tarjeta de credito pero quedan null
	 * a la espera de que se necesite, aunque no sea optimo.
	 */
	private int dni;
	
	//private String datosTarjetaDeCredito; //Modelar las formas d pago y la marca de la tarjeta

	public UsuarioPasajero(String unNombre, String unApellido, String unMail, String unTelefono,
							int dni){	
		super(unNombre, unApellido, unMail, unTelefono);
		this.setDni(dni);
	}

	public List<Reserva> todasLasReservas() {
		List<Reserva> resultado = new ArrayList<Reserva>();

		return resultado;
	}

	public List<Reserva> reservasFuturas() {
		
		//for(Habitacion habitacion : this.getHabitaciones()){
			
		//reservasFuturas.addAll(habitacion.reservasFuturasDelUsuario(this));
		//}
		List<Reserva> resultado = new ArrayList<Reserva>();
		
		return resultado;
	}

	public List<Reserva> reservasDeUnaCiudad(String unaCiudad) {
		
		//Set<Reserva> reservasDeUnaCiudad = new HashSet<Reserva>();
		//for(Habitacion habitacion : this.getHabitaciones()){
			//reservasDeUnaCiudad.addAll(habitacion.reservasDeUnaCiudadDelUsuario(unaCiudad, this));
		//}
		List<Reserva> resultado = new ArrayList<Reserva>();
		//resultado.addAll(reservasDeUnaCiudad);
		return resultado;		
	}

	public List<String> ciudadesConReserva() {

		List<String> resultado = new ArrayList<String>();
		
		return resultado;		
	}

	public void agregarHabitacionReservada(Habitacion unaHabitacion) {
		
	}

	public void cancelarReserva(Reserva unaReserva) {
		
	}
	
	//Getters and Setters
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

}
