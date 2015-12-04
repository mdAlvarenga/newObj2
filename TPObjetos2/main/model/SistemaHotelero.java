package model;

import java.util.ArrayList;
import java.util.List;

public class SistemaHotelero {
	List<Hotel> hoteles;
	List<Usuario> Usuarios;
	IServidor servidor;

	public SistemaHotelero(List<Hotel> hoteles, List<Usuario> usuarios){
		this.setHoteles(hoteles);
		this.setUsuarios(usuarios);
	}
	
	public void agregarUsuario(Usuario unUsuario){
		this.getUsuarios().add(unUsuario);
	}
	
	public void agregarHotel(Hotel unHotel){
		this.getHoteles().add(unHotel);
	}
	
	public List<Hotel> buscarHotelesFiltrados(FiltroBusqueda filtros){
		return filtros.buscar(this.getHoteles());	
	}
	
	public List<Habitacion> buscarHabitacionesFiltradas(FiltroBusqueda filtros, 
															List<Hotel> hoteles){
		List<Habitacion> ret = new ArrayList<Habitacion>();
		for (Hotel hotel: hoteles) {
			ret.addAll(filtros.buscarHabitaciones(hotel));
		}
		return ret;
	}
	
	public void reservar(Usuario unUsuario, Habitacion unaHabitacion, Rango unRango){
		
	}
	private void enviarCorreo(String from, String to, String subject, String body){
		Correo correo = new Correo(from,to,subject,body);
		this.getServidor().enviar(correo);
	}

	//Getters and Setters
	public List<Hotel> getHoteles() {
		return hoteles;
	}

	public void setHoteles(List<Hotel> hoteles) {
		this.hoteles = hoteles;
	}

	public List<Usuario> getUsuarios() {
		return Usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		Usuarios = usuarios;
	}
	
	public IServidor getServidor() {
		return servidor;
	}

	public void setServidor(IServidor servidor) {
		this.servidor = servidor;
	}
}