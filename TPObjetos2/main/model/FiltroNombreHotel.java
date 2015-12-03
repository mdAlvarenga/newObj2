package model;

import java.util.ArrayList;
import java.util.List;

public class FiltroNombreHotel extends FiltroBusqueda {
	
	private String nombreDeHotelABuscar;
	
	public FiltroNombreHotel (String nombreABuscar){
		this.setNombreDeHotelABuscar(nombreABuscar);		
	}
	
	private void setNombreDeHotelABuscar(String nombreABuscar) {
		this.nombreDeHotelABuscar = nombreABuscar;
	}

	@Override
	public List<Hotel> buscar(List<Hotel> hoteles) {
		List<Hotel> res = new ArrayList<Hotel>();
	
		for (Hotel h : hoteles) {
			if (h.getNombreHotel().equals(this.getNombreDeHotelABuscar())){
				res.add(h);
			}
		}
		return res;
	}

	private String getNombreDeHotelABuscar() {
		return this.nombreDeHotelABuscar;
	}

}
