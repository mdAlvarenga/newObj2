package model;

public class Precio {
	private double valor;
	private Rango rango;
	
	public Precio(Double unValor, Rango unRango){
		this.valor = unValor;
		this.rango = unRango;
	}

	public double calcularMontoPara(Rango unRango) {
		return (this.getMonto() * unRango.cantDeDiasQueInterceptan(this.getRango()));
	}

	//Getters and Setters
	public double getMonto() {
		return valor;
	}

	public Rango getRango() {
		return rango;
	}
}
