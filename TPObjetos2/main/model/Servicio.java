package model;

public class Servicio {
	
	private String nombre;
	private String descripcion;
	private Double precio;
	
	public Servicio(String nom, String des, double precio){
		this.setNombre(nom);
		this.setDescripcion(des);
		this.setPrecio(precio);
	}

	//Getters and Setters
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
