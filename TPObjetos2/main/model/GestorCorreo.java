package model;

import java.util.Observable;
import java.util.Observer;

import clasesSinTest.BodyMailBuilder;
import clasesSinTest.Correo;
import clasesSinTest.IServidor;

public class GestorCorreo implements Observer{
	private IServidor servidor;

	public IServidor getServidor() {
		return servidor;
	}

	public void setServidor(IServidor servidor) {
		this.servidor = servidor;
	}

	public void update(Observable arg0, Object arg1) {
		String mailHotelero = ((BodyMailBuilder) arg1).getMailHotelero();
		String mailPasajero = ((BodyMailBuilder) arg1).getMailPasajero();
		String cuerpoMensaje = ((BodyMailBuilder) arg1).getBody();
		Correo correoParaDuenio = new Correo(mailHotelero, "Datos de Nueva Reserva Hotelera!", cuerpoMensaje);
		Correo correoParaPasajero = new Correo(mailPasajero, "Datos tu Reserva Hotelera!", cuerpoMensaje);
		this.getServidor().enviarCorreo(correoParaDuenio);
		this.getServidor().enviarCorreo(correoParaPasajero);
	}
}
