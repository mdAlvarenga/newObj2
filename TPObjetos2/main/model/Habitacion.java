package model;

import java.util.List;

import org.joda.time.DateTime;

public class Habitacion {
	
	private int capacidadMaxima;
	private String baseDoble;
	private List<Servicio> servicios;
	private List<Reserva> reservas;
	
	public Habitacion(int unaCapacidad, String unaBase, List<Servicio> servicios, 
						List<Reserva> reservas) {
		this.setCapacidadMaxima(unaCapacidad);
		this.setBaseDobleOSimple(unaBase);
		this.setServicios(servicios);
		this.setReservas(reservas);
	}

	public boolean disponibilidadPara(DateTime fechaDesde, DateTime fechaHasta) {
		boolean ret = true;
		Rango rangoAConsultar = new Rango(fechaDesde, fechaHasta);
		for (Reserva r : reservas) {
			ret = ret & !(r.ocupadaEn(rangoAConsultar)); 
		}
		return ret;
	}

	public List<Reserva> reservasDeUnaCiudadDelUsuario(String unaCiudad, Usuario unUsuario) {
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
	
		
	}


	
	/*Getters and Setters
	 **/
	public String getBaseDobleOSimple() {
		return this.baseDoble;
	}

	public void setBaseDobleOSimple(String baseDobleOSimple) {
		this.baseDoble = baseDobleOSimple;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	public int getCapacidadMaxima() {
		return this.capacidadMaxima;
	}
}
