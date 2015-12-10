package nadaTesteable;

import java.util.ArrayList;
import java.util.List;

public class Direccion {

	private List<String> entreCalles;
	private Integer numero;
	private String calle;

	public Direccion(Integer unNumero, String unaCalle, String unaEntreCalle, String otraEntreCalle) {
		entreCalles = new ArrayList<String>(2);
		numero = unNumero;
		calle = unaCalle;
		entreCalles.add(unaEntreCalle);
		entreCalles.add(otraEntreCalle);
	}

	public Object getNumero() {
		return numero;
	}

	public Object getCalle() {
		return calle;
	}

	public List<String> getEntreCalles() {
		return entreCalles;
	}

}
