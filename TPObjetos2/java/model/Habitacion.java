package model;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class Habitacion {
	
	private int capacidadMaxima;
	private List<Reserva> reservas;
	
	public Habitacion(int cm){
		this.capacidadMaxima = cm;
		this.reservas = new ArrayList<Reserva>();
	}
	
	public int getCapacidadMaxima() {
		return this.capacidadMaxima;
	}
	
	public List<Reserva> getReservas(){
		return this.reservas;
	}

	public boolean disponibilidadPara(DateTime fechaDesde, DateTime fechaHasta) {
		
		Rango rango = new Rango(fechaDesde, fechaHasta);
		boolean aux = true;
		
		for(Reserva r: this.reservas){
			// si esta ocupada, entonces no hay disponibilidad
			if (r.ocupadaEn(rango)){
				aux = false;
				break;
			}
		}
		return aux;
	}
	
	public void reservar(DateTime fechaDesde, DateTime fechaHasta, Double unMonto){
		Rango rango = new Rango(fechaDesde, fechaHasta);
		Reserva nuevaReserva = new Reserva(rango, unMonto);
		this.reservas.add(nuevaReserva);
		
		//HAY QUE MANDAR EL MAIL
		
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
}
