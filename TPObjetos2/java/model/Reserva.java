package model;

import org.joda.time.DateTime;

import model.Rango;
import model.Usuario;

public class Reserva {
	private Usuario usuarioQueReserva;
	private Rango rangoDeReserva;
	private Double importeDeReserva;

	public Reserva(Rango unRango, Double unMonto, Usuario usuario) {
		this.rangoDeReserva = unRango;
		this.importeDeReserva = unMonto;
		this.usuarioQueReserva = usuario;
	}

	public Usuario getUsuarioQueReserva() {
		return usuarioQueReserva;
	}

	public void setUsuarioQueReserva(Usuario usuarioQueReserva) {
		this.usuarioQueReserva = usuarioQueReserva;
	}

	public boolean ocupadaEn(Rango unRangoConsulta) {
		
		return this.rangoDeReserva.intercepta(unRangoConsulta);
	}

	public Object getMonto() {
		return this.importeDeReserva;
	}

	public boolean fechaDeReservaPosteriorA(DateTime unaFecha) {
		
		Rango rango = new Rango(unaFecha, unaFecha);
		return rangoDeReserva.intercepta(rango);
	}

}
