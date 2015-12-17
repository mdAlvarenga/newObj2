package model;

import org.joda.time.DateTime;

public class TCredito implements IFormaDePago {

	private int numero;
	private Banco banco;
	private DateTime fvencimiento;
	private Marca marca;
	private int codigoseguridad;

	public TCredito(Banco unBanco, Marca unaMarca, int unNumero, DateTime unaFVencimiento, int unCodSeguridad) {
		this. banco = unBanco;
		this.marca = unaMarca;
		this.numero = unNumero;
		this.fvencimiento = unaFVencimiento;
		this.codigoseguridad = unCodSeguridad;
	}

	public int getNumero() {
		return numero;
	}

	public Banco getBanco() {
		return banco;
	}

	public DateTime getFvencimiento() {
		return fvencimiento;
	}

	public Marca getMarca() {
		return marca;
	}

	public int getCodigoseguridad() {
		return codigoseguridad;
	}

}

