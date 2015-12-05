package model;

public class Ciudad {

	private String nombreCiudad;

	public Ciudad(String unNombre) {
		this.setNombreCiudad(unNombre);
	}

	private void setNombreCiudad(String unNombre) {
		this.nombreCiudad = unNombre;
		
	}

	public String getNombre() {
		return this.nombreCiudad;
	}

}
