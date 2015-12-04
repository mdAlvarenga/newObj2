package model;

import java.util.List;

public abstract class FiltroBusqueda {
	/*
	 * El Propósito de aplicar este patron de diseño(composite), es para poder componer los 
	 * parámetros de busqueda con filtros simples y en nuestro caso, es excluyente que se 
	 * cumplan todos los filtros solcitados.
	 */
	public abstract List<Hotel> buscar(List<Hotel> lHoteles);
	public abstract List<Habitacion> buscarHabitaciones(Hotel hotel);
}
