package model;

import java.util.List;

public class SistemaHotelero{
	private List<Usuario> listaDeUsuarios; 
	private GestorConsulta gestor;
	
	public SistemaHotelero(List<Usuario> listaDeUsuarios, GestorConsulta gestor) {
		this.setUsuarios(listaDeUsuarios);
		this.setGestor(gestor); 
	}

	public void agregarReserva(Reserva unaReserva, Habitacion unaHabitacion, Hotel paraUnHotel) {
		this.getGestor().agregarReserva(unaReserva, unaHabitacion, paraUnHotel);
		
	}

	public void agregarHotel(Hotel unHotel) {
		this.getGestor().agregarHotel(unHotel);
	}

	public void agregarUsuario(Usuario unUsuario) {
		this.getListaDeUsuarios().add(unUsuario);
	}

	public List<Hotel> buscarHotelesPorFiltros(FiltroBusqueda filtro) {
		return filtro.buscar(this.getGestor().getHoteles());
	}

	public List<Habitacion> filtrarHabitaciones(FiltroBusqueda filtro, Hotel hotel) {
		return filtro.buscarHabitaciones(hotel);
	}

	public List<Reserva> todasReservasDePasajero(UsuarioPasajero unUsuario) {
		return this.getGestor().todasReservasDePasajero(unUsuario);
	}

	public List<Reserva> reservaDePasajeroParaCiudad(UsuarioPasajero unPasajero, Ciudad unaCiudad) {
		return this.getGestor().reservaDePasajeroParaCiudad(unPasajero, unaCiudad);
	}

	public List<Ciudad> ciudadesConReservaDePasajero(UsuarioPasajero unPasajero) {
		return this.getGestor().ciudadesDondePasajeroTieneReserva(unPasajero);
	}

	public List<Reserva> todasReservasFuturasDePasajero(UsuarioPasajero unPasajero) {
		return this.getGestor().todasReservasFuturasDePasajero(unPasajero);
	}

	public List<Reserva> todasReservasActualesDeHotelero(UsuarioHotelero unHotelero) {
		return this.getGestor().ReservasActualesDeHotelero(unHotelero);
	}
	public List<Reserva> ReservasFuturasDeHotelero(UsuarioHotelero unHotelero) {
		return this.getGestor().ReservasFuturasDeHotelero(unHotelero);
	}

	public List<Reserva> ReservasInicioEnNFuturosDiasHotelero(UsuarioHotelero unHotelero, int i) {
		return this.getGestor().ReservasInicioEnNFuturosDiasHotelero(unHotelero, i);
	}

	public GestorConsulta getGestor() {
		return gestor;
	}

	public void setGestor(GestorConsulta gestor) {
		this.gestor = gestor;
	}
	
	public List<Usuario> getListaDeUsuarios() {
		return listaDeUsuarios;
	}

	private void setUsuarios(List<Usuario> listaDeUsuarios) {
		this.listaDeUsuarios = listaDeUsuarios;
	}
	
}
