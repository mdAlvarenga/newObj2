package clasesSinTest;

public class UsuarioHotelero extends Usuario{
	private String cuit;

	public UsuarioHotelero(String unNombre, String unApellido, String unMail, String unTelefono, String unCuit){	
		super(unNombre, unApellido, unMail, unTelefono);
		this.setCuit(unCuit);
	}
	
	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
}
