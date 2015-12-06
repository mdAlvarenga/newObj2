package model;

import java.util.List;

public class SistemaHotelero {
	List<Hotel> listaDeHoteles;
	List<Usuario> listaDeUsuarios; 
	List<Reserva> listaDeReservas;
	IServidor servidor;
	
	
	public SistemaHotelero(List<Hotel> listaDeHoteles, List<Usuario> listaDeUsuarios,
							List<Reserva> listaDeReservas, IServidor servidor) {
		this.setHoteles(listaDeHoteles);
		this.setUsuarios(listaDeUsuarios);
		this.setReservas(listaDeReservas);
		this.setServidor(servidor);
	}

	public List<Hotel> getListaDeHoteles() {
		return listaDeHoteles;
	}

	public List<Usuario> getListaDeUsuarios() {
		return listaDeUsuarios;
	}

	public List<Reserva> getListaDeReservas() {
		return listaDeReservas;
	}

	public IServidor getServidor() {
		return servidor;
	}

	private void setReservas(List<Reserva> listaDeReservas) {
		this.listaDeReservas = listaDeReservas;
	}

	private void setUsuarios(List<Usuario> listaDeUsuarios) {
		this.listaDeUsuarios = listaDeUsuarios;
	}

	private void setHoteles(List<Hotel> listaDeHoteles) {
		this.listaDeHoteles = listaDeHoteles;
	}

	private void setServidor(IServidor servidor) {
		this.servidor = servidor;
	}

	public void agregarReserva(Reserva unaReserva) {
		this.getListaDeReservas().add(unaReserva);
	}

	public void agregarHotel(Hotel unHotel) {
		this.getListaDeHoteles().add(unHotel);
	}

	public void agregarUsuario(Usuario unUsuario) {
		this.getListaDeUsuarios().add(unUsuario);
	}

	public List<Hotel> buscarHotelesPorFiltros(FiltroBusqueda filtro) {
		return filtro.buscar(this.getListaDeHoteles());
	}

	public List<Habitacion> filtrarHabitaciones(FiltroBusquedaAntesTDD filtro, Hotel hotel) {
		return filtro.buscarHabitaciones(hotel);
	}

	public Object filtrarHabitaciones(FiltroBusqueda primerFiltro, Hotel hotelBoca) {
		// TODO Auto-generated method stub
		return null;
	}


}
