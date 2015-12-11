package model;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import nadaTesteable.Servicio;
import nadaTesteable.Usuario;

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
	private Boolean camaMatrimonial;
	
	public Habitacion(String numeroONombre, int unaCapacidad, String unaBase, List<Servicio> unServicios, 
						List<Reserva> unasReservas, List<Precio> unosPrecios, Boolean esCamaMatrimonial) {
		
		capacidadMaxima 	= unaCapacidad;
		baseDoble 			= unaBase;
		servicios 			= unServicios;
		reservas 			= unasReservas;
		preciosPorFechas 	= unosPrecios;
		nombreONumero		= numeroONombre;
		camaMatrimonial 	= esCamaMatrimonial;
	}
	
	public boolean disponibilidadPara(Rango unRango) {
		boolean ret = true;
		for (Reserva r : this.getReservas()) {
			ret = ret & !(r.ocupadaEn(unRango)); 
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
	
	public void getReservasParaFecha(DateTime unaFecha, List<Reserva> reservas){
		Rango rangoAConsultar = new Rango(unaFecha, unaFecha);		
		for (Reserva reserva : this.getReservas()) {
			if (!reserva.ocupadaEn(rangoAConsultar)){
				reservas.add(reserva);
			}
		}
	}
	
	public void cancelaSiPodes(Reserva unaReserva) {
		this.reservas.remove(unaReserva);
		
	}
	
	//Getters
	public String getBaseDobleOSimple() {
		return this.baseDoble;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public int getCapacidadMaxima() {
		return this.capacidadMaxima;
	}
	
	public List<Precio> getPrecios() {
		return preciosPorFechas;
	}

	public String getNombreONumero() {
		return nombreONumero;
	}
	
	public Boolean getCamaMatrimonial(){
		return camaMatrimonial;
	}
}
