package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FiltroCompuesto extends FiltroBusqueda{
	List<FiltroBusqueda> listaDeFiltros;
	
	public FiltroCompuesto(List<FiltroBusqueda> l) {
		this.setListaDeFiltros(l);
	}

	@Override
	public List<Hotel> buscar(List<Hotel> lHoteles) {
		
		// para evitar hoteles repetidos
		Set<Hotel> res = new HashSet<Hotel>();
		
		for (FiltroBusqueda f : this.getListaDeFiltros()) {
			// si uno solo de los filtros no cumple, ya 
			//no puedo retornar resultados positivos en la busqueda
			if (f.buscar(lHoteles).size() == 0){
				res.removeAll(res);
				break;
			}else{
				res.addAll(f.buscar(lHoteles));
			}
		}
		
		//chanchada para retornar una lista y no cambiar la interfaz, por las dudas
		List<Hotel> resultado = new ArrayList<Hotel>();
		resultado.addAll(res);
		
		return resultado;
	}

	public List<FiltroBusqueda> getListaDeFiltros() {
		return listaDeFiltros;
	}

	public void setListaDeFiltros(List<FiltroBusqueda> listaDeFiltros) {
		this.listaDeFiltros = listaDeFiltros;
	}
}