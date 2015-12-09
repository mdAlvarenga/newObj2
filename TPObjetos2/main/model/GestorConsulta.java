package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.joda.time.DateTime;

import clasesPorCompletitud.Ciudad;
import clasesPorCompletitud.UsuarioHotelero;
import clasesPorCompletitud.UsuarioPasajero;

public class GestorConsulta extends Observable{
	protected List<Reserva> reservas;
	protected List<Hotel> hoteles;
	
	public List<Reserva> getReservas() {
		return reservas;
	}

	public List<Hotel> getHoteles() {
		return hoteles;
	}
	
	public GestorConsulta(List<Reserva> res, List<Hotel> hs){
		this.reservas = res;
		this.hoteles = hs;
	}
	
	/**
	 * Para un pasajero en particular retorna todas las reservas que estan cargadas en el sistema
	 * (parte del enunciado "Administracion de pasajeros")
	 * @param UsuarioPasajero
	 * @return lista de reservas
	 */
	public List<Reserva> todasReservasDePasajero(UsuarioPasajero unUsuario) {
		List<Reserva> resul = new ArrayList<Reserva>();
		for(Reserva r: this.getReservas()){
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
		for(Hotel h: this.getHoteles()){
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

	/**
	 * Para un pasajero en particular retorna todas las ciudades donde el pasajero tiene reservas
	 * (parte del enunciado "Administracion de pasajeros")
	 * @param unPasajero
	 * @return lista de ciudades
	 */
	public List<Ciudad> ciudadesDondePasajeroTieneReserva(UsuarioPasajero unPasajero) {
		List<Ciudad> resul = new ArrayList<Ciudad>();
		for(Hotel h: this.hoteles){
			if (!this.buscarReservas(unPasajero, h.getHabitaciones()).isEmpty())
				resul.add(h.getCiudad());
		}
		return resul;
	}

	/**
	 * Para un pasajero busca las reservas que tenga a partir del dia de hoy (sin incluirlo)
	 * (parte del enunciado "Administracion de pasajeros")
	 * @param unPasajero
	 * @return lista de reservas
	 */
	public List<Reserva> todasReservasFuturasDePasajero(UsuarioPasajero unPasajero) {
		List<Reserva> resul = new ArrayList<Reserva>();
		DateTime hoy = new DateTime();
		for(Reserva r: this.getReservas()){
			boolean esUsuario = r.getUsuarioQueReserva().equals(unPasajero);
			boolean reservaEsPosterior = r.fechaDeReservaPosteriorA(hoy);
			if ( esUsuario && reservaEsPosterior)
				resul.add(r);
		}
		return resul;
	}

	public void agregarReserva(Reserva unaReserva, Habitacion unaHabitacion, Hotel unHotel) {
		//ACA ME PARECE QUE DEBERIA VERIFICAR QUE SE PUEDA RESERVAR
		this.getReservas().add(unaReserva);
		for(Hotel h: this.getHoteles()){
			boolean igual = h.equals(unHotel); 
			if (igual){
				h.agregarReservaEnHabitacion(unaHabitacion, unaReserva);
			}
		}
		BodyMailBuilder body = new BodyMailBuilder(unaReserva, unaHabitacion, unHotel);
		setChanged();
		notifyObservers(body);
	}
	
	public void agregarHotel(Hotel unHotel) {
		this.getHoteles().add(unHotel);		
	}

	/**
	 * Busca una lista de reservas donde los pasajeros se encuentren en el hotel actualmente
	 * (parte del enunciado "Administracion de Hoteles")
	 * @param unPasajero
	 * @return listado de reservas
	 */
	public List<Reserva> ReservasActualesDeHotelero(UsuarioHotelero unHotelero) {
		DateTime hoy = new DateTime();
		List<Reserva> reservasActuales = new ArrayList<Reserva>();
		for(Hotel hotel:this.getHoteles()){
			if (hotel.getHotelero().equals(unHotelero))
				reservasActuales.addAll(hotel.reservasDentroDeFecha(hoy));
		}
		return reservasActuales;
	}

	/**
	 * Se buscan fechas de ingreso que sean posteriores a la fecha actual
	 * (parte del enunciado "Administracion de Hoteles")
	 * @param unHotelero
	 * @return lista de reservas
	 */
	public List<Reserva> ReservasFuturasDeHotelero(UsuarioHotelero unHotelero) {
		DateTime hoy = new DateTime();
		List<Reserva> reservasFuturas = new ArrayList<Reserva>();
		for(Hotel hotel:this.getHoteles()){
			if (hotel.getHotelero().equals(unHotelero))
				reservasFuturas.addAll(hotel.reservasConFechaMayorA(hoy));
		}
		return reservasFuturas;
	}
	
	/**
	 * Se busca y devuelve las reservas realizadas en los hoteles
	 * (parte del enunciado "Administracion de Hoteles")
	 * @param unHotelero
	 * @param i 
	 * @return lista de reservas
	 */
	public List<Reserva> ReservasInicioEnNFuturosDiasHotelero(UsuarioHotelero unHotelero, int nDias){
		List<Reserva> reservasInicioEnNDias = new ArrayList<Reserva>();
		DateTime hoy = new DateTime().toDateTime();
		DateTime fechaFutura = hoy.plusDays(nDias);
		for(Hotel hotel:this.getHoteles()){
			if (hotel.getHotelero().equals(unHotelero))
				reservasInicioEnNDias.addAll(hotel.reservasConFechaMayorA(fechaFutura));
		}
		return reservasInicioEnNDias;
	}
}
