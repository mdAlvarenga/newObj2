package model;

public class BodyMailBuilder {

	private Reserva reserva;
	private Habitacion habitacion;
	private Hotel hotel;
	
	public BodyMailBuilder(Reserva unaReserva, Habitacion unaHabitacion, Hotel unHotel){
		this.reserva = unaReserva;
		this.habitacion = unaHabitacion;
		this.hotel = unHotel;
	}
	
	public String buildBody(){
		String nombrePasajero = this.reserva.getUsuarioQueReserva().getNombre();
		String apellidoPasajero = this.reserva.getUsuarioQueReserva().getApellido();
		String codPaisP = this.reserva.getUsuarioQueReserva().getTelefono()
								.getCodigoDePais().toString();
		String codAreaP = this.reserva.getUsuarioQueReserva().getTelefono()
								.getCodigoDePais().toString();
		String codLocalP = this.reserva.getUsuarioQueReserva().getTelefono()
								.getCodigoLocal().toString();
		String telefonoP = "+" + codPaisP + " " + codAreaP + " " + codLocalP  
								   + this.reserva.getUsuarioQueReserva().getTelefono()
								   		.getNumeroAbonado().toString();
		String mailP = this.reserva.getUsuarioQueReserva().getEmail();
			
		String fechaDesde = this.reserva.getRangoDeReserva().getFechaDesde().toString();
		String fechaHasta = this.reserva.getRangoDeReserva().getFechaHasta().toString();
		String costo = this.reserva.getImporteDeReserva().toString();
		String nombreHotel = this.hotel.getNombre();
		String ciudadHotel = this.hotel.nombreCiudad();
		String codPais = this.hotel.getTelefono().getCodigoDePais().toString();
		String codArea = this.hotel.getTelefono().getCodigoDePais().toString();
		String codLocal = this.hotel.getTelefono().getCodigoLocal().toString();
		String telefonoHotel = "+" + codPais + " " + codArea + " " + codLocal  
								   + this.hotel.getTelefono().getNumeroAbonado().toString();
		String numeroHabitacion = this.habitacion.getNombreONumero();
		int categoria = this.hotel.getCategoria().getCantidadEstrellas();
		String checkIn = this.hotel.getCheckIn().toString();
		String checkOut = this.hotel.getCheckOut().toString();
		
		String nombreHotelero = this.hotel.getHotelero().getNombre();
		String apellidoHotelero = this.hotel.getHotelero().getApellido();
		String codPaisH = this.hotel.getHotelero().getTelefono()
				.getCodigoDePais().toString();
		String codAreaH = this.hotel.getHotelero().getTelefono()
				.getCodigoDePais().toString();
		String codLocalH = this.hotel.getHotelero().getTelefono()
				.getCodigoLocal().toString();
		String telefonoH = "+" + codPaisH + " " + codAreaH + " " + codLocalH  
				   + this.hotel.getHotelero().getTelefono().getNumeroAbonado().toString();
		String mailH = this.hotel.getHotelero().getEmail();
				
		String body = "------------------------------------------------------\n"
				+"DATOS DEL PASAJERO\n"
				+"  Nombre y apellido: " + nombrePasajero +" "+ apellidoPasajero + "\n" 
				+ "  Telefono de contacto: " + telefonoP + "\n"
				+ "  Email de contacto: " + mailP + "\n"
				+ "------------------------------------------------------\n"
				+"DATOS DE LA RESERVA\n"
				+ "  Nombre de hotel: " + nombreHotel + " (" + ciudadHotel + ")" + "\n"
				+ "  Telefono de Hotel: " + telefonoHotel + "\n"
				+ "  Categoria: " + categoria + "Estrellas"  + "\n"
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
		return body;	
	}

	public String mailHotelero() {
		return this.hotel.getHotelero().getEmail();
	}

	public String mailPasajero() {
		return this.reserva.getUsuarioQueReserva().getEmail();
	}
}
