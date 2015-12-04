package model;

import org.joda.time.DateTime;
import org.joda.time.Days;

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

	public int cantDeDiasQueInterceptan(Rango unRango) {
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
		Rango r1 = new Rango(new DateTime("2015-10-03"),new DateTime("2015-10-15"));
		Rango rNointerceptaNada = new Rango(new DateTime("2015-09-21"),new DateTime("2015-09-23"));
		Rango intercetanDosDias= new Rango(new DateTime("2015-10-13"),new DateTime("2015-10-23"));
		Rango intercetanTresDias= new Rango(new DateTime("2015-09-20"),new DateTime("2015-10-06"));
		Rango cincoDiasDentro= new Rango(new DateTime("2015-09-20"),new DateTime("2015-10-06"));
		

		//int d = r1.cantDeDiasQueInterceptan(rNointerceptaNada);
		//int d = r1.cantDeDiasQueInterceptan(intercetanDosDias);
		//int d = r1.cantDeDiasQueInterceptan(intercetanTresDias);
		int d = r1.cantDeDiasQueInterceptan(cincoDiasDentro);
		
		//System.out.println(r1.intercepta(r3));
		//System.out.println(d.getDays());
		System.out.println(d);
		
	}

}
