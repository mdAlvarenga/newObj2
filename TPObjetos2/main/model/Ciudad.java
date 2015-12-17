package model;

public class Ciudad {

	private String nombreCiudad;
	private Pais pais;

	public Ciudad(String unNombre, Pais unPais) {
		this.setNombreCiudad(unNombre);
		this.setPais(unPais);
	}

	private void setPais(Pais unPais) {
		this.pais = unPais;
		
	}

	private void setNombreCiudad(String unNombre) {
		this.nombreCiudad = unNombre;
		
	}

	public String getNombre() {
		return this.nombreCiudad;
	}


	public Pais getPais() {
		return this.pais;
	}
}
