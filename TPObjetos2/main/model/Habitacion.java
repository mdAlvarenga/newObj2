package model;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import clasesSinTest.Servicio;
import clasesSinTest.Usuario;
import clasesSinTest.UsuarioPasajero;

public class Habitacion {
	/*
	 * CONSIDERACIONES DE LA CLASE: En la lista de precios, los rangos no se solapan.
	 */
	private String nombreONumero;
	private int capacidadMaxima;
	private String baseDoble;
	private List<Servicio> servicios;
	private List<Reserva> reservas;
	private List<Precio> preciosPorFechas;
	
	public Habitacion(String numeroONombre, int unaCapacidad, String unaBase, List<Servicio> servicios, 
						List<Reserva> reservas, List<Precio> precios) {
		
		this.setCapacidadMaxima(unaCapacidad);
		this.setBaseDobleOSimple(unaBase);
		this.setServicios(servicios);
		this.setReservas(reservas);
		this.setPrecios(precios);
		this.setNombreONumero(numeroONombre);
	}

	public boolean disponibilidadPara(Rango unRango) {
		boolean ret = true;
		for (Reserva r : this.getReservas()) {
			ret = ret & !(r.ocupadaEn(unRango)); 
		}
		return ret;
	}

	public List<Reserva> reservasDeUnaCiudadDelUsuario(String unaCiudad, Usuario unUsuario) {
		List<Reserva> ret = new ArrayList<Reserva>();
		/*if (this.getHotelPertenece().getNombreCiudad().equals(unaCiudad)){
			ret.addAll(this.reservasDelUsuario(unUsuario));
		}*/
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

	public List<Reserva> reservasFuturasDelUsuario(Usuario unUsuario) {
		
		List<Reserva> ret = new ArrayList<Reserva>();
		for (Reserva reserva : this.getReservas()) {
			if (reserva.fechaDeReservaPosteriorA(new DateTime())
					& reserva.getUsuarioQueReserva().equals(unUsuario)){
				ret.add(reserva);
			}
		}
		return ret;
	}
	
	
	public List<Reserva> reservasConFechaMayorA(DateTime unaFecha) {
		
		List<Reserva> ret = new ArrayList<Reserva>();
		for (Reserva reserva : this.getReservas()) {
			if (reserva.fechaDeReservaPosteriorA(unaFecha)){
				ret.add(reserva);
			}
		}
		return ret;
	}

	public void agregarReserva(Reserva unaReserva) {
		this.getReservas().add(unaReserva);
	}

	public Double calcularMonto(Rango unRango){
		Double ret = 0.0;
		for (Precio precio : this.getPrecios()) {
			if(unRango.intercepta(precio.getRango())){
				ret = ret + precio.calcularMontoPara(unRango);
			}
		}
		return ret;
	}
	
	public Reserva getReservaParaFecha(DateTime unaFecha){
		
		Reserva reservaFinal = null;
		Rango rangoAConsultar = new Rango(unaFecha, unaFecha);
		
		for (Reserva r : this.getReservas()) {
			if (r.ocupadaEn(rangoAConsultar)){
				reservaFinal = r;
				break;
			}
		}
		return reservaFinal;
	}
	

	// si la reserva no llega a existir, esto explota
	public void cancelaSiPodes(Reserva unaReserva) {
		this.reservas.remove(unaReserva);
		
	}
	
	//Getters and Setters
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
	
	public List<Precio> getPrecios() {
		return preciosPorFechas;
	}

	public void setPrecios(List<Precio> precios) {
		this.preciosPorFechas = precios;
	}

	public String getNombreONumero() {
		return nombreONumero;
	}

	public void setNombreONumero(String nombreONumero) {
		this.nombreONumero = nombreONumero;
	}
}
