package model;

import java.util.Observable;
import java.util.Observer;

import clasesSinTest.Correo;
import clasesSinTest.IServidor;
import clasesSinTest.Usuario;

public class GestorCorreo implements Observer{
	private IServidor servidor;

	public IServidor getServidor() {
		return servidor;
	}

	public void setServidor(IServidor servidor) {
		this.servidor = servidor;
	}

	public void update(Observable arg0, Object arg1) {
		
		//String body = this.buildBodyMail(unUsuario, unaHabitacion, unRango);
		Correo correoParaDuenio = new Correo("to", "subject", "body");
		Correo correoParaPasajero = new Correo("to", "subject", "body");
		this.getServidor().enviarCorreo(correoParaDuenio);
		this.getServidor().enviarCorreo(correoParaPasajero);
	}
	
	private String buildBodyMail(Usuario unUsuario, Habitacion unaHabitacion, Rango unRango){
		//Usuario duenio = aRoom.duenioHotel();
		//aca armar el cuerpo del mail con info necesaria para una reserva	
		return "";
	}
}
