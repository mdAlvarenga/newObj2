package model;

import java.util.List;

import org.joda.time.DateTime;

public class Habitacion {
	public Habitacion(int i) {
		// TODO Auto-generated constructor stub
	}

	public int getCapacidadMaxima() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean disponibilidadPara(DateTime fechaDesde, DateTime fechaHasta) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Reserva> reservasDeUnaCiudadDelUsuario(String unaCiudad, Usuario unUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Reserva> reservasDelUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Reserva> reservasFuturasDelUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	public String ciudadDelHotelDondeEstas() {
		// TODO Auto-generated method stub
		return null;
	}

	public void cancelaSiPodes(Reserva unaReserva) {
		// TODO Auto-generated method stub
		
	}

	public List<Reserva> reservasDeUnaCiudadDeUnUsuario(Object ciudad, Object usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Reserva> reservasDelUsuario(Object usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Reserva> reservasFuturasDelUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

	public void reservar(DateTime fechaDesde, DateTime fechaHasta, Double double1, Usuario pasajero) {
		// TODO Auto-generated method stub
		
	}
}
