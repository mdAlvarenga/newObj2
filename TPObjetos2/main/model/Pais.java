package model;

public class Pais {

	private String nombre;
	private String codigo;

	public Pais(String unCodigoDePais, String unNombreDePais) {
		codigo = unCodigoDePais;
		nombre = unNombreDePais;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

}
