package model;

import java.util.List;

public abstract class FiltroBusqueda {

	abstract public List<Habitacion> buscarHabitaciones(Hotel unHotel);

	abstract public List<Hotel> buscar(List<Hotel> listaDeHoteles);

}
