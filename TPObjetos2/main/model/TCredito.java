package model;

import org.joda.time.DateTime;

public class TCredito implements FormaDePago {

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

	int getNumero() {
		return numero;
	}

	Banco getBanco() {
		return banco;
	}

	DateTime getFvencimiento() {
		return fvencimiento;
	}

	Marca getMarca() {
		return marca;
	}

	int getCodigoseguridad() {
		return codigoseguridad;
	}

}
