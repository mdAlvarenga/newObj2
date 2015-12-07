package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import antesDeTDD.FiltroBusquedaAntesTDD;

public class FiltroCompuesto extends FiltroBusqueda{
	List<FiltroBusqueda> listaDeFiltros;
	
	public FiltroCompuesto(List<FiltroBusqueda> l) {
		this.setListaDeFiltros(l);
	}
	
	@Override
	public List<Habitacion> buscarHabitaciones(Hotel hotel) {
		List<Habitacion> ret = new ArrayList<Habitacion>();
		for (FiltroBusqueda f : this.getListaDeFiltros()) {
			if (f.buscarHabitaciones(hotel).isEmpty()){
				return new ArrayList<Habitacion>();
			}
			ret.addAll(f.buscarHabitaciones(hotel));
		}
		return ret;
	}

	@Override
	public List<Hotel> buscar(List<Hotel> lHoteles) {
		Set<Hotel> res = new HashSet<Hotel>();
		List<Hotel> resultado = new ArrayList<Hotel>();
		
		for (FiltroBusqueda f : this.getListaDeFiltros()) {
			if (f.buscar(lHoteles).isEmpty()){
				return resultado; 
			}
			res.addAll(f.buscar(lHoteles));	
		}
		resultado.addAll(res);
		return resultado;
	}

	//Getters and Setters
	public List<FiltroBusqueda> getListaDeFiltros() {
		return listaDeFiltros;
	}

	public void setListaDeFiltros(List<FiltroBusqueda> listaDeFiltros) {
		this.listaDeFiltros = listaDeFiltros;
	}
}