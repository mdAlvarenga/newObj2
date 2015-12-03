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

	public boolean intercepta(Rango unRango) {
		/**
		 * Este metodo evalua si el rango recibido por parametro intercepta en algun
		 * instante al rango receptor
		 */

		return (unRango.getFechaDesde().isBefore(this.fechaHasta))
					&(unRango.getFechaHasta().isAfter(this.fechaDesde));
		
	}
	
	public int cantidadDeDiasQueIntercepta(Rango unRango){
		if (this.getFechaDesde().isBefore(unRango.getFechaDesde())){
			
		}
	}

	private DateTime getFechaHasta() {

		return this.fechaHasta;
	}

	private DateTime getFechaDesde() {
		return this.fechaDesde;
	}

	public boolean fechaDeReservaPosteriorA(DateTime unaFecha) {
		
		return this.fechaDesde.isAfter(unaFecha);
	}

}
