package model;

import org.joda.time.DateTime;

import model.Rango;
import model.Usuario;

public class Reserva {
	private Usuario usuarioQueReserva;
	private Rango rangoDeReserva;
	private Double importeDeReserva;

	public Reserva(Rango unRango, Double unMonto, Usuario unUsuario) {
		this.setRangoDeReserva(unRango);
		this.setImporteDeReserva(unMonto);
		this.setUsuarioQueReserva(unUsuario);
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

	public Rango getRangoDeReserva() {
		return rangoDeReserva;
	}

	public void setRangoDeReserva(Rango rangoDeReserva) {
		this.rangoDeReserva = rangoDeReserva;
	}

	public Double getImporteDeReserva() {
		return importeDeReserva;
	}

	public void setImporteDeReserva(Double importeDeReserva) {
		this.importeDeReserva = importeDeReserva;
	}

	public Object getMonto() {
		return this.importeDeReserva;
	}

	public boolean fechaDeReservaPosteriorA(DateTime unaFecha) {
		
		return rangoDeReserva.fechaDeReservaPosteriorA(unaFecha);
	}

}
