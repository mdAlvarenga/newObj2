package model;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;;

public class FiltroRango extends FiltroBusqueda {
	private DateTime fechaDesde;
	private DateTime fechaHasta;
	
	public FiltroRango(DateTime fD, DateTime fH){
		this.setFechaDesde(fD);
		this.setFechaHasta(fH);
	}
	
	@Override
	public List<Hotel> buscar(List<Hotel> hoteles) {
		List<Hotel> res = new ArrayList<Hotel>();
		for (Hotel h : hoteles) {
			if (this.tieneHabitacionQueCumpleFechas(h)){
				res.add(h);
			}
		}
		return res;
	}
	
	private boolean tieneHabitacionQueCumpleFechas(Hotel h) {
		boolean ret = false;
		for (Habitacion hab : h.getHabitaciones()) {
			ret = ret || hab.disponibilidadPara(this.getFechaDesde(), this.getFechaHasta()); 
		}
		return ret;
	}

	//Getters and Setters
	public DateTime getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(DateTime fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public DateTime getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(DateTime fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

}
