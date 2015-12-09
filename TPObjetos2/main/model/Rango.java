package model;

import org.joda.time.DateTime;
import org.joda.time.Days;

import model.Rango;

public class Rango {
	private DateTime fechaDesde;
	private DateTime fechaHasta;

	public Rango(DateTime unaFechaDesde, DateTime unaFechaHasta) {
		fechaDesde = unaFechaDesde;
		fechaHasta = unaFechaHasta;
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
	
		if(this.intercepta(unRango)){
			int ret;
			ret = this.cantidadDeDiasQueInterceptanPorFechaDesdeMenorYFechaHastaMenor(unRango);
			ret += this.cantidadDeDiasQueInterceptanPorFechaDesdeMayorYFechaHastaMenor(unRango);
			ret += this.cantidadDeDiasQueInterceptanPorFechaDesdeMayorYFechaHastaMayor(unRango);
			ret += this.cantidadDeDiasQueInterceptanPorFechaDesdeMenorYFechaHastaMayor(unRango);
			return ret;
		}
		else{
			return 0;
		}
	}
	
	public int cantidadDeDiasQueInterceptanPorFechaDesdeMenorYFechaHastaMenor(Rango unRango){
		return this.evaluarCondicionYRetornarCantidadDeDias((unRango.getFechaDesde().isBefore(fechaDesde)),
															(unRango.getFechaHasta().isBefore(fechaHasta)),
															 fechaDesde,
															 unRango.getFechaHasta());
	}

	public int cantidadDeDiasQueInterceptanPorFechaDesdeMayorYFechaHastaMenor(Rango unRango){
		return this.evaluarCondicionYRetornarCantidadDeDias((unRango.getFechaDesde().isAfter(fechaDesde)),
															(unRango.getFechaHasta().isBefore(fechaHasta)),
															 unRango.getFechaDesde(),
															 unRango.getFechaHasta());
	}

	public int cantidadDeDiasQueInterceptanPorFechaDesdeMayorYFechaHastaMayor(Rango unRango){
		return this.evaluarCondicionYRetornarCantidadDeDias((unRango.getFechaDesde().isAfter(fechaDesde)),
															(unRango.getFechaHasta().isAfter(fechaHasta)),
															fechaHasta, 
															 unRango.getFechaHasta());
	}
	
	public int cantidadDeDiasQueInterceptanPorFechaDesdeMenorYFechaHastaMayor(Rango unRango){
		return this.evaluarCondicionYRetornarCantidadDeDias((unRango.getFechaDesde().isBefore(fechaDesde)),
													 		(unRango.getFechaHasta().isAfter(fechaHasta)),
													 		 fechaDesde,
													 		 fechaHasta);
	}
	
	public int evaluarCondicionYRetornarCantidadDeDias(Boolean b1, Boolean b2, DateTime unaFechaDesde, DateTime unaFechaHasta){
		if(b1&&b2){
			return this.diasQueInterceptan(unaFechaDesde, unaFechaHasta);
		}
		return 0;
	}
	
	public int diasQueInterceptan(DateTime unaFechaDesde, DateTime unaFechaHasta){
		Days diasQueInterceptan= Days.daysBetween(unaFechaDesde, unaFechaHasta);
		return diasQueInterceptan.getDays();		
	}
	
	public boolean fechaDeReservaPosteriorA(DateTime unaFecha) {
		
		return this.getFechaDesde().isAfter(unaFecha);
	}
	
	public DateTime getFechaHasta() {
		return this.fechaHasta;
	}

	public DateTime getFechaDesde() {
		return this.fechaDesde;
	}
}
