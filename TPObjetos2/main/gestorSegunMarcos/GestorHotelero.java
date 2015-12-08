package gestorSegunMarcos;

import java.util.ArrayList;
import java.util.List;

import model.*;

import org.joda.time.DateTime;

public class GestorHotelero extends GestorDeReservas{

	public GestorHotelero(List<Reserva> listaDeReservas, List<Hotel> listaDeHoteles) {
		super(listaDeReservas, listaDeHoteles);
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
		for(Hotel hotel:this.hoteles){
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
		List<Reserva> reservasActuales = new ArrayList<Reserva>();
		for(Hotel hotel:this.hoteles){
			if (hotel.getHotelero().equals(unHotelero))
				reservasActuales.addAll(hotel.reservasConFechaMayorA(hoy));
		}
		return reservasActuales;
	}

	/**
	 * Se busca y devuelve las reservas realizadas en los hoteles
	 * (parte del enunciado "Administracion de Hoteles")
	 * @param unHotelero
	 * @param i 
	 * @return lista de reservas
	 */
	public List<Reserva> ReservasInicioEnNFuturosDiasHotelero(UsuarioHotelero unHotelero, int i) {
		List<Reserva> res = new ArrayList<Reserva>();
		
		DateTime fechaFutura = new DateTime();
		fechaFutura.plusDays(i);
		
		for(Hotel hotel:this.hoteles){
			if (hotel.getHotelero().equals(unHotelero))
				res.addAll(hotel.reservasConFechaMayorA(fechaFutura));
		}
		return res;
	}
}

