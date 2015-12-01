package model;

import org.joda.time.DateTime;

import model.Rango;

public class Rango {
	private DateTime fechaDesde;
	private DateTime fechaHasta;

	public Rango(DateTime fechaDesde, DateTime fechaHasta) {
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
	}

	public boolean intercepta(Rango rangoIntercepta) {
		/**
		 * Este metodo evalua si el rango recibido por parametro intercepta en algun
		 * instante al rango receptor
		 */

		return (rangoIntercepta.getFechaDesde().isBefore(this.fechaHasta))&(rangoIntercepta.getFechaHasta().isAfter(this.fechaDesde));
		
	}

	private DateTime getFechaHasta() {

		return this.fechaHasta;
	}

	private DateTime getFechaDesde() {
		return this.fechaDesde;
	}

}
