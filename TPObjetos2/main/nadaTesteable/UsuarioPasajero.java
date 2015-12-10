package nadaTesteable;

public class UsuarioPasajero extends Usuario {
	/*
	 * Consideraciones de la clase: modelamos los datos de la tarjeta de credito pero quedan null
	 * a la espera de que se necesite, aunque no sea optimo.
	 */
	private int dni;
	
	//private String datosTarjetaDeCredito; //Modelar las formas d pago y la marca de la tarjeta

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
