package model;

import java.util.ArrayList;
import java.util.List;

public class SistemaHoteleroAntesDeTDD {
	private List<Hotel> hoteles;
	private List<Usuario> Usuarios;
	private List<Reserva> reservas; 
	private IServidor servidor;

	public SistemaHoteleroAntesDeTDD(List<Hotel> hoteles, List<Usuario> usuarios, List<Reserva> reservas, 
							IServidor unServidor){
		this.setHoteles(hoteles);
		this.setUsuarios(usuarios);
		
		this.setServidor(unServidor);
	}
	
	public void agregarUsuario(Usuario unUsuario){
		this.getUsuarios().add(unUsuario);
	}
	
	public void agregarHotel(Hotel unHotel){
		this.getHoteles().add(unHotel);
	}
	
	public void agregarReserva(Reserva unaReserva) {
		this.getReservas().add(unaReserva);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<Hotel> buscarHotelesFiltrados(FiltroBusquedaAntesTDD filtros){
		return filtros.buscar(this.getHoteles());	
	}
	
	public List<Habitacion> buscarHabitacionesFiltradas(FiltroBusquedaAntesTDD filtros, 
															List<Hotel> hoteles){
		List<Habitacion> ret = new ArrayList<Habitacion>();
		for (Hotel hotel: hoteles) {
			ret.addAll(filtros.buscarHabitaciones(hotel));
		}
		return ret;
	}
	
	public void reservar(UsuarioPasajero unUsuario, Habitacion unaHabitacion, Rango unRango){
		unaHabitacion.reservar(unRango, unUsuario);
		String body = this.buildBodyMail(unUsuario, unaHabitacion, unRango);
		this.enviarCorreo(unUsuario.getEmail(),"Datos de la reserva que realizaste!", body);
		this.notificarAHotelero(unaHabitacion, body);
	}
	
	public Double calcularCostoAproximadoPara(Habitacion unaHabitacion, Rango unRango){
		return 0.0;
	}
	
	private String buildBodyMail(UsuarioPasajero aUser, Habitacion aRoom, Rango arank){
		
		Usuario duenio = aRoom.duenioHotel();
		//aca armar el cuerpo del mail con info necesaria para una reserva
		
		return "";
	}
	
	private void notificarAHotelero(Habitacion unaHabitacion, String body){
		
	}
	
	private void enviarCorreo(String to, String subject, String body){
		Correo correo = new Correo(to,subject,body);
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

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	
}