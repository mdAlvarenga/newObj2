package model;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import nadaTesteable.Categoria;
import nadaTesteable.Ciudad;
import nadaTesteable.Correo;
import nadaTesteable.Direccion;
import nadaTesteable.IFormaDePago;
import nadaTesteable.Pais;
import nadaTesteable.Servicio;
import nadaTesteable.Telefono;
import nadaTesteable.UsuarioHotelero;

public class Hotel {
	private String nombreHotel;
	private Ciudad ciudad;
	private List<Habitacion> habitaciones;
	private List<Servicio> servicios;
	private Categoria categoria;
	private DateTime checkIn;
	private DateTime checkOut;
	private UsuarioHotelero hotelero;
	private Pais pais;
	private Direccion direccion;
	private Telefono telefono;
	private Correo mail;
	private List<IFormaDePago> formasDePago;
	
	public Hotel(String unNombreDeHotel, Ciudad unaCiudad, List<Habitacion> unasHabitaciones, 
				 List<Servicio> unosServicios, Categoria unaCategoria, DateTime unCheckIn, 
				 DateTime unCheckOut, UsuarioHotelero unHotelero, Pais unPais,
				 Direccion unaDireccion, Telefono unTelefono, Correo unMail, 
				 List<IFormaDePago> unosMediosDePago) {

		// INICIALIZO LISTAS
		habitaciones	= new ArrayList<Habitacion>();
		servicios 		= new ArrayList<Servicio>();
		formasDePago 	= new ArrayList<IFormaDePago>();
		
		// INICIALIZO VARIABLES DE INSTANCIA
		formasDePago.addAll(unosMediosDePago);		
		habitaciones.addAll(unasHabitaciones);
		servicios.addAll(unosServicios);
		nombreHotel = unNombreDeHotel;
		ciudad 		= unaCiudad;
		categoria 	= unaCategoria;
		checkIn 	= unCheckIn;
		checkOut 	= unCheckOut;
		hotelero 	= unHotelero;
		pais 		= unPais;
		direccion 	= unaDireccion;
		telefono 	= unTelefono;
		mail 		= unMail;
	}
	
	public List<Reserva> reservasDentroDeFecha(DateTime unaFecha){
		List<Reserva> reservas = new ArrayList<Reserva>();
		Rango unDiaEnRango = new Rango(unaFecha, unaFecha);
		for(Habitacion habitacion: habitaciones){
			if (!habitacion.disponibilidadPara(unDiaEnRango)){
				reservas.add(habitacion.getReservasParaFecha(unaFecha));
			}
		}
		return reservas;
	}

	public List<Reserva> reservasConFechaMayorA(DateTime unaFecha) {

		List<Reserva> reservas = new ArrayList<Reserva>();
		
		for(Habitacion h: this.habitaciones){
				reservas.addAll(h.reservasConFechaMayorA(unaFecha));
		}
		return reservas;
	}

	public boolean tieneHabitacionQueCumpleCapacidad(int unaCapacidad) {
		boolean tieneHabitacionQueCumpleCapacidad = false;
		for (Habitacion habitacion : this.getHabitaciones()) {
			tieneHabitacionQueCumpleCapacidad = tieneHabitacionQueCumpleCapacidad || 
			(habitacion.getCapacidadMaxima() >= unaCapacidad); 
		}
		return tieneHabitacionQueCumpleCapacidad;
	}
	
	//Getters
	public String getNombre() {
		return nombreHotel;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}
	
	public List<Servicio> getServicios() {
		return servicios;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
	public DateTime getCheckIn() {
		return checkIn;
	}

	public DateTime getCheckOut() {
		return checkOut;
	}

	public Pais getPais() {
		return pais;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public Telefono getTelefono() {
		return telefono;
	}

	public  Correo getMail() {
		return mail;
	}

	public List<IFormaDePago> getFormasDePago() {
		return formasDePago;
	}	
	
	public UsuarioHotelero getHotelero() {
		return this.hotelero;
	}
	
	public String nombreCiudad() {
		return this.getCiudad().getNombre();
	}

	public void agregarReservaEnHabitacion(Habitacion unaHabitacion,
			Reserva unaReserva) {		
	}
		
}
