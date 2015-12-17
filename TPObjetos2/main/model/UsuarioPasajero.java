package model;

public class UsuarioPasajero extends Usuario {
	private int dni;
	
	public UsuarioPasajero(String unNombre, String unApellido, String unMail, Telefono unTelefono,
							int dni){	
		super(unNombre, unApellido, unMail, unTelefono);
		this.setDni(dni);
	}

	//Getters and Setters
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

}
