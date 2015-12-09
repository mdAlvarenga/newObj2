package model;

import java.util.List;

public abstract class FiltroBusqueda {

	public List<Habitacion> buscarHabitaciones(Hotel unHotel) {
		return null;
	}

	abstract public List<Hotel> buscar(List<Hotel> listaDeHoteles);

}
