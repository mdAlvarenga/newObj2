package model;

import java.util.Observable;
import java.util.Observer;

import nadaTesteable.Correo;
import nadaTesteable.IServidor;

public class GestorCorreo implements Observer{
	private IServidor servidor;

	public IServidor getServidor() {
		return servidor;
	}

	public GestorCorreo(IServidor servidor){
		this.servidor = servidor;
	}
	public void update(Observable arg0, Object arg1) {
		String mailHotelero = ((BodyMailBuilder) arg1).mailHotelero();
		String mailPasajero = ((BodyMailBuilder) arg1).mailPasajero();
		String cuerpoMensaje = ((BodyMailBuilder) arg1).buildBody();
		Correo correoParaDuenio = new Correo(mailHotelero, "Datos de Nueva Reserva Hotelera!", cuerpoMensaje);
		Correo correoParaPasajero = new Correo(mailPasajero, "Felicitaciones por la Reserva que realizaste!", cuerpoMensaje);
		this.getServidor().enviarCorreo(correoParaDuenio);
		this.getServidor().enviarCorreo(correoParaPasajero);
	}
}
