package model;

import java.util.List;

public abstract class FiltroBusqueda {

	public List<Habitacion> buscarHabitaciones(Hotel hotelBoca) {
		return null;
	}

	abstract public List<Hotel> buscar(List<Hotel> listaDeHoteles);

}
