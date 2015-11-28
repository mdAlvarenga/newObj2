package model;

import java.util.ArrayList;
import java.util.List;

public class FiltroCompuesto extends FiltroBusqueda{
	List<FiltroBusqueda> listaDeFiltros;
	
	public FiltroCompuesto(List<FiltroBusqueda> l) {
		this.setListaDeFiltros(l);
	}

	@Override
	public List<Hotel> buscar(List<Hotel> lHoteles) {
		List<Hotel> res = new ArrayList<Hotel>();
		
		for (FiltroBusqueda f : this.getListaDeFiltros()) {
			res.addAll(f.buscar(lHoteles));
		}
		return res;
	}

	public List<FiltroBusqueda> getListaDeFiltros() {
		return listaDeFiltros;
	}

	public void setListaDeFiltros(List<FiltroBusqueda> listaDeFiltros) {
		this.listaDeFiltros = listaDeFiltros;
	}
}