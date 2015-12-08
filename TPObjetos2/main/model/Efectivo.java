package model;

public class Efectivo implements FormaDePago {

	private String moneda;

	public Efectivo(String unaMoneda) {
		this.moneda = unaMoneda;
	}

	String getMoneda() {
		return moneda;
	}

}
