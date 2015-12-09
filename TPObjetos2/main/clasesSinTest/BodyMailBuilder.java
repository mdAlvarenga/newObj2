package clasesSinTest;

import model.Habitacion;
import model.Hotel;
import model.Reserva;

public class BodyMailBuilder {

	private String body;
	private String mailHotelero;
	private String mailPasajero;
	
	public void buildBodyMail(Reserva unaReserva, Habitacion unaHabitacion, Hotel unHotel){
		String nombrePasajero = unaReserva.getUsuarioQueReserva().getNombre();
		String apellidoPasajero = unaReserva.getUsuarioQueReserva().getApellido();
		String telefonoU = unaReserva.getUsuarioQueReserva().getTelefono();
		String mailU = unaReserva.getUsuarioQueReserva().getEmail();
		
		this.setMailPasajero(mailU);
		
		String fechaDesde = unaReserva.getRangoDeReserva().getFechaDesde().toString();
		String fechaHasta = unaReserva.getRangoDeReserva().getFechaHasta().toString();
		String costo = unaReserva.getImporteDeReserva().toString();
		String nombreHotel = unHotel.getNombre();
		String ciudadHotel = unHotel.nombreCiudad();
		String numeroHabitacion = unaHabitacion.getNombreONumero();
		String categoria = unHotel.getCategoria();
		String checkIn = unHotel.getCheckIn().toString();
		String checkOut = unHotel.getCheckOut().toString();
		
		String nombreHotelero = unHotel.getHotelero().getNombre();
		String apellidoHotelero = unHotel.getHotelero().getApellido();
		String telefonoH = unHotel.getHotelero().getTelefono();
		String mailH = unHotel.getHotelero().getEmail();
		
		this.setMailHotelero(mailH);
		
		String body = "------------------------------------------------------\n"
				+"DATOS DEL PASAJERO\n"
				+"  Nombre y apellido: " + nombrePasajero +" "+ apellidoPasajero + "\n" 
				+ "  Telefono de contacto: " + telefonoU + "\n"
				+ "  Email de contacto: " + mailU + "\n"
				+ "------------------------------------------------------\n"
				+"DATOS DE LA RESERVA\n"
				+ "  Nombre de hotel: " + nombreHotel + " (" + ciudadHotel + ")" + "\n"
				+ "  Categoria: " + categoria + "\n"
				+ "  Habitacion numero: " + numeroHabitacion + "\n"
				+ "  Fecha de ingreso: " + fechaDesde + "\n"
				+ "  Fecha de egreso: " + fechaHasta + "\n"
				+ "  CheckIn: " + checkIn + "\n"
				+ "  CheckOut: " + checkOut + "\n"
				+ "\n"
				+ "  Costo de la reserva: " + costo + "\n"
				+"------------------------------------------------------\n"
				+"DATOS DE HOTELERO\n"
				+"  Nombre y apellido: " + nombreHotelero +" "+ apellidoHotelero + "\n" 
				+ "  Telefono de contacto: " + telefonoH + "\n"
				+ "  Email de contacto: " + mailH + "\n"
				+ "------------------------------------------------------\n";
	
		this.setBody(body);
		
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getMailHotelero() {
		return mailHotelero;
	}

	public void setMailHotelero(String mailHotelero) {
		this.mailHotelero = mailHotelero;
	}

	public String getMailPasajero() {
		return mailPasajero;
	}

	public void setMailPasajero(String mailPasajero) {
		this.mailPasajero = mailPasajero;
	}
}
