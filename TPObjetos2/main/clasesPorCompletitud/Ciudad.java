package clasesPorCompletitud;

public class Ciudad {

	private String nombreCiudad;
	private String pais;

	public Ciudad(String unNombre, String unPais) {
		this.setNombreCiudad(unNombre);
		this.setPais(unPais);
	}

	private void setPais(String unPais) {
		this.pais = unPais;
		
	}

	private void setNombreCiudad(String unNombre) {
		this.nombreCiudad = unNombre;
		
	}

	public String getNombre() {
		return this.nombreCiudad;
	}


	public String getPais() {
		return this.pais;
	}
}
