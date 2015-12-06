package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FiltroCompuesto extends FiltroBusquedaAntesTDD{
	List<FiltroBusquedaAntesTDD> listaDeFiltros;
	
	public FiltroCompuesto(List<FiltroBusquedaAntesTDD> l) {
		this.setListaDeFiltros(l);
	}
	
	@Override
	public List<Habitacion> buscarHabitaciones(Hotel hotel) {
		List<Habitacion> ret = new ArrayList<Habitacion>();
		for (FiltroBusquedaAntesTDD f : this.getListaDeFiltros()) {
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
		
		for (FiltroBusquedaAntesTDD f : this.getListaDeFiltros()) {
			if (f.buscar(lHoteles).isEmpty()){
				return resultado; 
			}
			res.addAll(f.buscar(lHoteles));	
		}
		resultado.addAll(res);
		return resultado;
	}

	//Getters and Setters
	public List<FiltroBusquedaAntesTDD> getListaDeFiltros() {
		return listaDeFiltros;
	}

	public void setListaDeFiltros(List<FiltroBusquedaAntesTDD> listaDeFiltros) {
		this.listaDeFiltros = listaDeFiltros;
	}
}