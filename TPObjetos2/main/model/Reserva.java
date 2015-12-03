package model;

import org.joda.time.DateTime;

import model.Rango;
import model.Usuario;

public class Reserva {
	private Usuario usuarioQueReserva;
	private Rango rangoDeReserva;
	private Double importeDeReserva;

	public Reserva(Rango unRango, Double unMonto) {
		this.rangoDeReserva = unRango;
		this.importeDeReserva = unMonto;
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
		
		return rangoDeReserva.fechaDeReservaPosteriorA(unaFecha);
	}

}
