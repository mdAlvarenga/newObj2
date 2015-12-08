package model;

import org.joda.time.DateTime;

import clasesSinTest.Usuario;
import model.Rango;

public class Reserva {
	private Usuario usuarioQueReserva;
	private Rango rangoDeReserva;
	private Double importeDeReserva;

	public Reserva(Rango unRango, Double unMonto, Usuario unUsuario) {
		this.setRangoDeReserva(unRango);
		this.setImporteDeReserva(unMonto);
		this.setUsuarioQueReserva(unUsuario);
	}

	public boolean ocupadaEn(Rango unRangoConsulta) {
		
		return this.getRangoDeReserva().intercepta(unRangoConsulta);
	}

	public boolean fechaDeReservaPosteriorA(DateTime unaFecha) {
		
		return this.getRangoDeReserva().fechaDeReservaPosteriorA(unaFecha);
	}
	
	//Getters and Setters
	public Double getImporteDeReserva() {
		return importeDeReserva;
	}

	public void setImporteDeReserva(Double importeDeReserva) {
		this.importeDeReserva = importeDeReserva;
	}
	
	public Rango getRangoDeReserva() {
		return rangoDeReserva;
	}

	public void setRangoDeReserva(Rango rangoDeReserva) {
		this.rangoDeReserva = rangoDeReserva;
	}
	
	public Usuario getUsuarioQueReserva() {
		return usuarioQueReserva;
	}

	public void setUsuarioQueReserva(Usuario usuarioQueReserva) {
		this.usuarioQueReserva = usuarioQueReserva;
	}

}
