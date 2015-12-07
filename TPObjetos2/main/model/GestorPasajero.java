package model;

import java.util.ArrayList;
import java.util.List;

public class GestorPasajero extends GestorDeReservas {

	public GestorPasajero(List<Reserva> res, List<Hotel> hs) {
		super(res, hs);
	}

	/**
	 * Para un pasajero en particular retorna todas las reservas que estan cargadas en el sistema
	 * (parte del enunciado "Administracion de pasajeros")
	 * @param UsuarioPasajero
	 * @return lista de reservas
	 */
	public List<Reserva> todasReservasDePasajero(UsuarioPasajero unUsuario) {
		List<Reserva> resul = new ArrayList<Reserva>();
		for(Reserva r: this.reservas){
			if (r.getUsuarioQueReserva().equals(unUsuario))
				resul.add(r);
		}
		return resul;
	}

	/**
	 * Para un pasajero en particular retorna todas las reservas para una ciudad particular
	 * (parte del enunciado "Administracion de pasajeros")
	 * @param unPasajero
	 * @param unaCiudad
	 * @return lista de reservas
	 */
	public List<Reserva> reservaDePasajeroParaCiudad(UsuarioPasajero unPasajero, Ciudad unaCiudad) {
		List<Reserva> resul = new ArrayList<Reserva>();
		for(Hotel h: this.hoteles){
			if (h.getCiudad().equals(unaCiudad)){
				resul.addAll(this.buscarReservas(unPasajero, h.getHabitaciones()));
			}
		}
		return resul;
	}

	private List<Reserva> buscarReservas(UsuarioPasajero unPasajero, List<Habitacion> habitaciones) {
		List<Reserva> resul = new ArrayList<Reserva>();
		for(Habitacion h: habitaciones){
			resul.addAll(h.reservasDelUsuario(unPasajero));
		}
		return resul;
	}

}
