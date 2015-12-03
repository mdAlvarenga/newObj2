package model;

public class Servicio {
	
	private String nombre;
	private String descripcion;
	private double precio;
	
	public Servicio(String nom, String des, double precio){
		this.nombre = nom;
		this.descripcion = des;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	

}
