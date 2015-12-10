package nadaTesteable;

public abstract class Usuario {
	protected String nombre;
	protected String apellido;
	protected String email;
	protected Telefono telefono;
	
	public Usuario(String unNombre, String unApellido, String unMail, Telefono unTelefono){
		this.nombre = unNombre;
		this.apellido = unApellido;
		this.email = unMail;
		this.telefono = unTelefono;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEmail() {
		return email;
	}

	public Telefono getTelefono() {
		return telefono;
	}

}
