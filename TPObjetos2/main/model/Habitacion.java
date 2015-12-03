package model;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class Habitacion {
	/*
	 * CONSIDERACIONES DE LA CLASE: En la lista de precios, los rangos no se solapan.
	 */
	private int capacidadMaxima;
	private String baseDoble;
	private List<Servicio> servicios;
	private List<Reserva> reservas;
	private Hotel hotelPertenece;
	private List<Precio> preciosPorFechas;
	
	public Habitacion(int unaCapacidad, String unaBase, List<Servicio> servicios, 
						List<Reserva> reservas, Hotel hotel, List<Precio> precios) {
		
		this.setCapacidadMaxima(unaCapacidad);
		this.setBaseDobleOSimple(unaBase);
		this.setServicios(servicios);
		this.setReservas(reservas);
		this.setHotelPertenece(hotel);
		this.setPrecios(precios);
	}

	public boolean disponibilidadPara(DateTime fechaDesde, DateTime fechaHasta) {
		boolean ret = true;
		Rango rangoAConsultar = new Rango(fechaDesde, fechaHasta);
		for (Reserva r : this.getReservas()) {
			ret = ret & !(r.ocupadaEn(rangoAConsultar)); 
		}
		return ret;
	}

	public List<Reserva> reservasDeUnaCiudadDelUsuario(String unaCiudad, Usuario unUsuario) {
		List<Reserva> ret = new ArrayList<Reserva>();
		if (this.getHotelPertenece().getNombreCiudad().equals(unaCiudad)){
			ret.addAll(this.reservasDelUsuario(unUsuario));
		}
		return ret;
	}

	public List<Reserva> reservasDelUsuario(Usuario unUsuario) {
		List<Reserva> ret = new ArrayList<Reserva>();
		for (Reserva reserva : this.getReservas()) {
			if (reserva.getUsuarioQueReserva().equals(unUsuario)){
				ret.add(reserva);
			}
		}
		return ret;
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

	public void reservar(DateTime fechaDesde, DateTime fechaHasta, Usuario unUsuario) {
		Rango r = new Rango(fechaDesde,fechaHasta);
		Double monto = this.calcularMonto(r);
		Reserva reserva = new Reserva(r,monto,unUsuario);
		this.getReservas().add(reserva);
	}

	private Double calcularMonto(Rango unRango){
		Double ret = 0.0;
		for (Precio precio : this.getPrecios()) {
			if(unRango.intercepta(precio.getRango())){
				ret = ret + precio.calcularMontoPara(unRango);
			}
		}
		return ret;
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

	public Hotel getHotelPertenece() {
		return hotelPertenece;
	}

	public void setHotelPertenece(Hotel hotelPertenece) {
		this.hotelPertenece = hotelPertenece;
	}
	
	public List<Precio> getPrecios() {
		return preciosPorFechas;
	}

	public void setPrecios(List<Precio> precios) {
		this.preciosPorFechas = precios;
	}
}
