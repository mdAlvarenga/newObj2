package gestorSegunMarcos;

import java.util.List;
import java.util.Observable;

import model.Ciudad;
import model.FiltroBusqueda;
import model.Habitacion;
import model.Hotel;
import model.IServidor;
import model.Reserva;
import model.Usuario;
import model.UsuarioPasajero;

public class SistemaHotelero extends Observable{
	private List<Usuario> listaDeUsuarios; 
	private GestorConsultas gestor;
	//private GestorCorreo gestorCorreo;
	
	
	public SistemaHotelero(List<Usuario> listaDeUsuarios, GestorConsultas gestor) {
		this.setUsuarios(listaDeUsuarios);
		//this.setGestorCorreo(gestorCorreo);
		this.setGestor(gestor); 
	}

	public void agregarReserva(Reserva unaReserva) {
		this.getGestor().agregarReserva(unaReserva);
		setChanged();
		notifyObservers(this);
		//Aca debe haber tipo un observer con el mail asi envia los mails correspondientes.
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

	private void setUsuarios(List<Usuario> listaDeUsuarios) {
		this.listaDeUsuarios = listaDeUsuarios;
	}

	/*public GestorCorreo getGestorCorreo() {
		return gestorCorreo;
	}
	
	private void setGestorCorreo(GestorCorreo gestorCorreo) {
		this.gestorCorreo = gestorCorreo;
	}*/

}
