package model;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class UsuarioHotelero extends Usuario {
	private String cuit;
	private List<Hotel> hoteles;

	public UsuarioHotelero(String unNombre, String unApellido, String unMail, String unTelefono,
								String unCuit){	
		super(unNombre, unApellido, unMail, unTelefono);
		this.setCuit(unCuit);
		this.setHoteles(new ArrayList<Hotel>());
	}
		
	public List<Reserva> reservasActuales() {
		DateTime hoy = new DateTime();
		List<Reserva> reservasActuales = new ArrayList<Reserva>();
		for(Hotel hotel:this.hoteles){
			reservasActuales.addAll(hotel.reservasDentroDeFecha(hoy));
		}
		return reservasActuales;
	}

	public List<Reserva> reservasFuturas() {
		DateTime hoy = new DateTime();
		return this.reservaConFechaMayorA(hoy);
	}

	public List<Reserva> reservasDentroDeNDiasFuturos(Integer nDiasFuturos) {
		DateTime fechaFutura = new DateTime();
		fechaFutura.plusDays(nDiasFuturos);
		return this.reservaConFechaMayorA(fechaFutura);
	}
	
	


	public List<Reserva> reservaConFechaMayorA(DateTime unaFecha){
		
		List<Reserva> reservasConFechaMayorA = new ArrayList<Reserva>();
		for(Hotel hotel:this.hoteles){
			reservasConFechaMayorA.addAll(hotel.reservasConFechaMayorA(unaFecha));
		}
		return reservasConFechaMayorA;
	}

	public void nuevoHotel(Hotel unHotel) {
		this.hoteles.add(unHotel);
	}
	
	
	//Getters and Setters
	public List<Hotel> getHoteles() {
		return this.hoteles;
	}
	
	public void setHoteles(List<Hotel> hoteles) {
		this.hoteles = hoteles;
	}
	
	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

}
