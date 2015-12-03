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

	public Double cantDeDiasQueInterceptan(Rango unRango) {
		if (unRango.getFechaDesde().isBefore(this.fechaHasta))
		this.getFechaDesde();
		this.getFechaHasta();
		rango.getFechaDesde();
		rango.getFechaHasta();
		
		return null;
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

	public static void main(String [] args){
		Rango r1 = new Rango(new DateTime("2015-10-01"),new DateTime("2015-10-20"));
		Rango r2 = new Rango(new DateTime("2015-11-01"),new DateTime("2015-11-20"));
		Rango r3 = new Rango(new DateTime("2015-09-19"),new DateTime("2015-11-02"));
		
		System.out.println(r1.intercepta(r3));
	}

}
