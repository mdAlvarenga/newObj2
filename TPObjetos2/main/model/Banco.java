package model;

public class Banco {

	private String nombre;

	public Banco(String unNombre) {
		this.setNombre(unNombre);
	}
	
	public void setNombre(String unNombre){
		this.nombre = unNombre;
	}

	public String getNombre() {
		return nombre;
	}

}
