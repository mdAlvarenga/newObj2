package model;

public class Precio {
	private Double monto;
	private Rango rango;
	
	public Precio(Double unMonto, Rango unRango){
		this.setMonto(unMonto);
		this.setRango(unRango);
	}
	
	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Rango getRango() {
		return rango;
	}

	public void setRango(Rango rango) {
		this.rango = rango;
	}
}
