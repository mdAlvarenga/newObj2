package model;

import org.joda.time.DateTime;

public class TDebito implements IFormaDePago {

	private Banco banco;
	private int numero;
	private DateTime fvencimiento;
	private int codigoseguridad;

	public TDebito(Banco unBanco, int unNumero, DateTime unaFVencimiento, int unCodSeguridad) {
		this. banco = unBanco;
		this.numero = unNumero;
		this.fvencimiento = unaFVencimiento;
		this.codigoseguridad = unCodSeguridad;
	}

	public Banco getBanco() {
		return banco;
	}

	public int getNumero() {
		return numero;
	}

	public DateTime getFvencimiento() {
		return fvencimiento;
	}

	public int getCodigoseguridad() {
		return codigoseguridad;
	}
}
