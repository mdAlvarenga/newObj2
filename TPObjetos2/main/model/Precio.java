package model;

public class Precio {
	private Double valor;
	private Rango rango;
	
	public Precio(Double unValor, Rango unRango){
		this.setMonto(unValor);
		this.setRango(unRango);
	}
	
	public Double getMonto() {
		return valor;
	}

	public void setMonto(Double valor) {
		this.valor = valor;
	}

	public Rango getRango() {
		return rango;
	}

	public void setRango(Rango rango) {
		this.rango = rango;
	}

	public Double calcularMontoPara(Rango unRango) {
		return (this.getMonto() * unRango.cantDeDiasQueInterceptan(this.getRango()));
	}
}
