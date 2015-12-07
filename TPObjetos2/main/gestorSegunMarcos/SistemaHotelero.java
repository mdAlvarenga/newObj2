package gestorSegunMarcos;

import java.util.List;

import model.Ciudad;
import model.FiltroBusqueda;
import model.Habitacion;
import model.Hotel;
import model.IServidor;
import model.Reserva;
import model.Usuario;
import model.UsuarioPasajero;

public class SistemaHotelero {
	private List<Usuario> listaDeUsuarios; 
	private IServidor servidor;
	private GestorConsultas gestor;
	
	
	public SistemaHotelero(List<Usuario> listaDeUsuarios, IServidor servidor, GestorConsultas gestor) {
		this.setUsuarios(listaDeUsuarios);
		this.setServidor(servidor);
		this.setGestor(gestor); 
	}

	public void agregarReserva(Reserva unaReserva) {
		this.getGestor().agregarReserva(unaReserva);
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

	public GestorConsultas getGestor() {
		return gestor;
	}

	public void setGestor(GestorConsultas gestor) {
		this.gestor = gestor;
	}
	
	public List<Usuario> getListaDeUsuarios() {
		return listaDeUsuarios;
	}

	public IServidor getServidor() {
		return servidor;
	}

	private void setUsuarios(List<Usuario> listaDeUsuarios) {
		this.listaDeUsuarios = listaDeUsuarios;
	}

	private void setServidor(IServidor servidor) {
		this.servidor = servidor;
	}

}
