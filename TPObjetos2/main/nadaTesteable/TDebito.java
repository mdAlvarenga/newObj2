package nadaTesteable;

import org.joda.time.DateTime;

public class TDebito implements IFormaDePago {

	private Banco banco;
	private Object numero;
	private DateTime fvencimiento;
	private int codigoseguridad;

	public TDebito(Banco unBanco, int unNumero, DateTime unaFVencimiento, int unCodSeguridad) {
		this. banco = unBanco;
		this.numero = unNumero;
		this.fvencimiento = unaFVencimiento;
		this.codigoseguridad = unCodSeguridad;
	}

	Banco getBanco() {
		return banco;
	}

	Object getNumero() {
		return numero;
	}

	DateTime getFvencimiento() {
		return fvencimiento;
	}

	int getCodigoseguridad() {
		return codigoseguridad;
	}
}
