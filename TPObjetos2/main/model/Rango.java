package model;

import org.joda.time.DateTime;
import org.joda.time.Days;

import model.Rango;

public class Rango {
	private DateTime fechaDesde;
	private DateTime fechaHasta;

	public Rango(DateTime fechaDesde, DateTime fechaHasta) {
		this.setFechaDesde(fechaDesde);
		this.setFechaHasta(fechaHasta);
	}

	public boolean intercepta(Rango unRango) {
		/**
		 * Este metodo evalua si el rango recibido por parametro intercepta en algun
		 * instante al rango receptor
		 */
		return (unRango.getFechaDesde().isBefore(this.getFechaHasta()))
					&(unRango.getFechaHasta().isAfter(this.getFechaDesde()));
	}

	public int cantDeDiasQueInterceptan(Rango unRango) {
		/**
		 * Sin todos los feos if, no se me ocurrio otra manera mas elegante.
		 * retorna la cantidad de dias que interceptan unRango y this(Rango)
		 */
		if (unRango.getFechaDesde().isAfter(this.getFechaHasta()) || 
				unRango.getFechaHasta().isBefore(this.getFechaDesde())){
			return 0;
		}

		if (unRango.getFechaDesde().isAfter(this.getFechaDesde()) & 
				unRango.getFechaHasta().isBefore(this.getFechaHasta())){
			Days d = Days.daysBetween(unRango.getFechaDesde(),unRango.getFechaHasta());
			return d.getDays();
		}
		
		if (unRango.getFechaDesde().isBefore(this.getFechaHasta()) & 
				unRango.getFechaHasta().isAfter(this.getFechaHasta())){
			Days d = Days.daysBetween(unRango.getFechaDesde(),this.getFechaHasta());
			return d.getDays();
		}
		
		if (unRango.getFechaDesde().isBefore(this.getFechaHasta()) & 
				unRango.getFechaHasta().isAfter(this.getFechaHasta())){
			Days d = Days.daysBetween(unRango.getFechaDesde(),this.getFechaHasta());
			return d.getDays();
		}
		
		if (unRango.getFechaDesde().isBefore(this.getFechaDesde()) & 
				unRango.getFechaHasta().isAfter(this.getFechaDesde())){
			Days d = Days.daysBetween(this.getFechaDesde(),unRango.getFechaHasta());
			return d.getDays();
		}
		
		//unRango = i f
		//this = ix fx
		// <   isBefore
		// >   isAfter
		//i > fx or f< ix  entonces fuera del rango. o sea 0.
		return 0;
	}
	
	public boolean fechaDeReservaPosteriorA(DateTime unaFecha) {
		
		return this.getFechaDesde().isAfter(unaFecha);
	}
	
	//Getters and Setters
	private DateTime getFechaHasta() {

		return this.fechaHasta;
	}

	private DateTime getFechaDesde() {
		return this.fechaDesde;
	}
	
	public void setFechaDesde(DateTime fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public void setFechaHasta(DateTime fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
}
